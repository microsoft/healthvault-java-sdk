package com.microsoft.hsg.android.simplexml.localvault;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;

import junit.framework.Assert;
import android.content.ContentValues;
import android.content.Context;
import android.content.Loader;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.net.Uri;
import android.util.Log;

import com.microsoft.hsg.HVException;
import com.microsoft.hsg.android.simplexml.HealthVaultApp;
import com.microsoft.hsg.android.simplexml.methods.getthings3.request.ThingRequestGroup2;
import com.microsoft.hsg.android.simplexml.methods.getthings3.response.ThingResponseGroup2;
import com.microsoft.hsg.android.simplexml.store.DateFormatter;
import com.microsoft.hsg.android.simplexml.store.HVContentContract;
import com.microsoft.hsg.android.simplexml.things.thing.AbstractThing;
import com.microsoft.hsg.android.simplexml.things.thing.Thing2;
import com.microsoft.hsg.android.simplexml.things.thing.ThingKey;
import com.microsoft.hsg.android.simplexml.things.thing.UnprocessedThingKeyInfo;
import com.microsoft.hsg.android.simplexml.things.types.types.PersonInfo;
import com.microsoft.hsg.android.simplexml.things.types.types.Record;
import com.microsoft.hsg.android.simplexml.things.types.weight.Weight;
import com.microsoft.hsg.android.simplexml.XmlSerializer;

public class SynchronizedView {
	
	private Context ctx;
	private Record record;
	private String name;
	private ThingRequestGroup2 query;
	private Date lastSyncDate;
	
	public static SynchronizedView getView(Context ctx, String name, Record record) {
		String appendedPath = "records/" + record.getId() + "/views/" + name;
		Uri contentUri = Uri.withAppendedPath(HVContentContract.CONTENT_URI, appendedPath);

		Cursor cursor = ctx.getContentResolver().query(
				contentUri,
			    new String[] { "query", "date_synced" },
			    null, null, null);

		SynchronizedView view = null;
		
		try {
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();

                String serializedQuery = cursor.getString(0);
                long syncDateMillis = cursor.getLong(1);
               
                view = new SynchronizedView(
                    ctx,
                    record,
                    name,
                    XmlSerializer.read(ThingRequestGroup2.class, serializedQuery),
                    new Date(syncDateMillis));
            }
		} catch (Exception e) {
			throw new HVException("Could not get View.", e);
		}
		
		return view;
	}
	
	public static SynchronizedView makeView(
			Context ctx, 
			Record record, 
			String name,
			ThingRequestGroup2 query) {

		try {
			String serializedQuery = XmlSerializer.write(query);
		    String appendedPath = "records/" + record.getId() + "/views/" + name;
		    Uri contentUri = Uri.withAppendedPath(HVContentContract.CONTENT_URI, appendedPath);
		   
		    ContentValues values = new ContentValues();
		    values.put("query", serializedQuery);
		    values.put("date_synced", "0");
		    
		    ctx.getContentResolver().insert(contentUri, values);
	
		    return new SynchronizedView(
		    		ctx,
		    		record,
		    		name,
		    		query,
		    		new Date(0));

		} catch(Exception e) {
			throw new HVException("Could not create SynchronizedView.", e);
		}
	}

	private SynchronizedView(
			Context ctx,
			Record record,
			String name,
			ThingRequestGroup2 query,
			Date lastSyncDate) {
		this.ctx = ctx;
		this.record = record;
		this.name = name;
		this.query = query;
		this.lastSyncDate = lastSyncDate;
	}
	
	public Date getLastSyncDate() {
		return lastSyncDate;
	}
	
	public String getName() {
		return name;
	}
	
	public ThingRequestGroup2 getQuery() {
		return query;
	}
	
	public Record getRecord() {
		return record;
	}

	private void updateView() {
		try
		{
            String serializedQuery = XmlSerializer.write(query);

            ContentValues values = new ContentValues();
            values.put("query", serializedQuery);
            values.put("date_synced", lastSyncDate.getTime());
                
            ctx.getContentResolver().update(
                    getContentViewUri(),
                    values,
                    null,
                    null);
		} catch(Exception e) {
			throw new HVException("Could not update view.", e);
		}
	}
	
	public void registerObserver(ContentObserver observer) {
		ctx.getContentResolver().registerContentObserver(
			this.getContentViewThingsUri(),
			false,
			observer);
	}
	
	public void unregisterObserver(ContentObserver observer) {
		ctx.getContentResolver().unregisterContentObserver(observer);
	}
	
	public void delete() {
		ctx.getContentResolver().delete(getContentViewUri(), null, null);
		ctx.getContentResolver().delete(
				Uri.withAppendedPath(getContentViewUri(), "things"),
				null, 
				null);
	}
	
	public AbstractThing getThingById(String thingId) {
		Cursor cursor = ctx.getContentResolver().query(
			Uri.withAppendedPath(HVContentContract.CONTENT_URI, "records/" + record.getId() + "/things/" + thingId),
			new String[] { "thing_xml" },
			null, null, null);
	
		AbstractThing data = null;
		
		if (cursor.moveToFirst()) {
			Thing2 thing = XmlSerializer.safeRead(Thing2.class, cursor.getString(0));
			data = thing.getData();
		}
		
		cursor.close();
	
		return data;
	}

	public List<String> getThingKeys(int maxSize) {
        Cursor cursor = ctx.getContentResolver().query(
        		getContentViewThingsUri(),
        		new String[] { "thing_id" },
        		null, null, "_id ASC");

        List<String> things = new ArrayList<String>(cursor.getCount());
		
        int idx = 0;
        if (cursor.moveToFirst()) {  
            do {  
                things.add(cursor.getString(0));
            } while (cursor.moveToNext() && ++idx < maxSize);  
        }
        cursor.close();

        return things;
	}
	
	public List<String> getThingKeys() {
		return getThingKeys(Integer.MAX_VALUE);
	}
	
	public Callable<Void> synchronizeAsync() {
        return new Callable<Void>() {
			@Override
			public Void call() throws Exception {
				synchronize();
				return null;
			}
		};
	}
	
	public void synchronize() throws Exception {
		ThingResponseGroup2 response = getThings();
		updateContentStore(getContentValuesForThings(response));
		
		int batchSize = 200;
		List<UnprocessedThingKeyInfo> keys = response.getUnprocessedThingKeyInfo();
		for(int i=0; i<keys.size(); i+=batchSize) {
			updateContentStore(getContentValuesForThings(
					getThingsForKeys(keys.subList(i, Math.min(i+batchSize, keys.size())))));
		}
		
		lastSyncDate = new Date();
		updateView();
	}
	
	private ThingResponseGroup2 getThingsForKeys(List<UnprocessedThingKeyInfo> keys) {
		return getRecord().getThings(getQueryWithKeys(keys));
	}

	private ThingRequestGroup2 getQueryWithKeys(List<UnprocessedThingKeyInfo> keys) {
		ThingRequestGroup2 query = new ThingRequestGroup2();
		query.setMax(Integer.MAX_VALUE);
		query.setMaxFull(Integer.MAX_VALUE);
		query.getFormat().getXml();
		
		for (UnprocessedThingKeyInfo key : keys) {
			query.getThingIdList().add(key.getThingId().getValue());
		}
		
		return query;
	}

	public ThingResponseGroup2 getThings() {
		return record.getThings(query);
	}
	
	private ContentValues[] getContentValuesForThings(ThingResponseGroup2 response) {
		ContentValues[] thingValues = new ContentValues[
        response.getThing().size() + response.getUnprocessedThingKeyInfo().size()];
		
		int idx = 0;

		for (Thing2 thing : response.getThing()) {
            ContentValues values = new ContentValues();

            values.put("thing_id", thing.getThingId().getValue());
            values.put("version_stamp", thing.getThingId().getVersionStamp());
            values.put("thing_xml", XmlSerializer.safeWrite(thing));
            
            thingValues[idx++] = values;
	    }

        for (UnprocessedThingKeyInfo keys : response.getUnprocessedThingKeyInfo()) {
            ContentValues values = new ContentValues();

            values.put("thing_id", keys.getThingId().getValue());
            values.put("version_stamp", keys.getThingId().getVersionStamp());
            
            thingValues[idx++] = values;
	    }
        
        return thingValues;
	}
	
	private void updateContentStore(ContentValues[] values) {
		ctx.getContentResolver().bulkInsert(
			getContentViewThingsUri(),
			values);
	}
	
	private Uri getContentViewUri() {
		String appendedPath = "records/" + record.getId() + "/views/" + name;
		return Uri.withAppendedPath(HVContentContract.CONTENT_URI, appendedPath);
	}

	private Uri getContentViewThingsUri() {
		String appendedPath = "records/" + record.getId() + "/views/" + name + "/things";
		return Uri.withAppendedPath(HVContentContract.CONTENT_URI, appendedPath);
	}
}
