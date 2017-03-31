package com.microsoft.hsg.android.simplexml.store;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;

public class HVContentProvider extends ContentProvider {
	
	// helper constants for use with the UriMatcher
	private static final int THING = 1;
	private static final int THING_LIST = 2;
	private static final int VIEW = 3;
	private static final int VIEW_LIST = 4;
	private static final int VIEW_THINGS_LIST = 5;

	private static final UriMatcher URI_MATCHER;
	
	private HVOpenHelper dbHelper = null;

	// prepare the UriMatcher
	static {
		URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);
		URI_MATCHER.addURI(HVContentContract.AUTHORITY, 
		      "records/*/views", 
		      VIEW_LIST);
		URI_MATCHER.addURI(HVContentContract.AUTHORITY, 
		      "records/*/views/*", 
		      VIEW);
		URI_MATCHER.addURI(HVContentContract.AUTHORITY, 
		      "records/*/views/*/things", 
		      VIEW_THINGS_LIST);
		URI_MATCHER.addURI(HVContentContract.AUTHORITY, 
		      "records/*/things", 
		      THING_LIST);
		URI_MATCHER.addURI(HVContentContract.AUTHORITY, 
		      "records/*/things/*", 
		      THING);
	}

	@Override
	public boolean onCreate() {
		dbHelper = new HVOpenHelper(getContext());
		return true;
	}

	@Override
	public Cursor query(
            Uri uri, 
            String[] projection,
            String selection, 
            String[] selectionArgs, 
            String sortOrder) {
	    switch (URI_MATCHER.match(uri)) {
	        case VIEW_LIST:
	        case VIEW:
	        	ViewProvider vp = new ViewProvider(getContext(), dbHelper);
	        	return vp.query(uri, projection, selection, selectionArgs, sortOrder);
            case VIEW_THINGS_LIST:
            	ViewThingsProvider tvp = new ViewThingsProvider(getContext(), dbHelper);
            	return tvp.query(uri, projection, selection, selectionArgs, sortOrder);
            case THING:
            	ThingProvider tp = new ThingProvider(getContext(), dbHelper);
            	return tp.query(uri, projection, selection, selectionArgs, sortOrder);
            default:
                throw new IllegalArgumentException(
	                "Unsupported URI: " + uri);
	   }
	}

	// TODO
	@Override
	public String getType(Uri uri) {
        switch (URI_MATCHER.match(uri)) {
            case THING_LIST:
//                return Things.CONTENT_TYPE;
                    /*
            case VIEW_LIST:
                    return Items.CONTENT_ITEM_TYPE;
                    */
            	return "something";
            default:
            	throw new IllegalArgumentException("Unsupported URI: " + uri);
        }
    }
	
	@Override
	public int bulkInsert(Uri uri, ContentValues[] values) {
        switch (URI_MATCHER.match(uri)) {
            case VIEW_THINGS_LIST:
            	ViewThingsProvider vtp = new ViewThingsProvider(getContext(), dbHelper);
            	return vtp.insertViewThings(uri, values);
            default:
                throw new IllegalArgumentException(
                    "Unsupported URI for bulkInsert: " + uri);
        }
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
        switch (URI_MATCHER.match(uri)) {
            case VIEW:
            	ViewProvider p = new ViewProvider(getContext(), dbHelper);
            	p.insert(uri, values);
            	break;
            default:
                throw new IllegalArgumentException(
                    "Unsupported URI for insert: " + uri);
        }
        
        return uri;
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
        switch (URI_MATCHER.match(uri)) {
	        case VIEW:
	        	ViewProvider p = new ViewProvider(getContext(), dbHelper);
	        	return p.delete(uri, selection, selectionArgs);
	        case VIEW_THINGS_LIST:
	        	ViewThingsProvider vtp = new ViewThingsProvider(getContext(), dbHelper);
	        	return vtp.delete(uri, selection, selectionArgs);
            default:
                throw new IllegalArgumentException(
                    "Unsupported URI for delete: " + uri);
        }
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
        switch (URI_MATCHER.match(uri)) {
	        case VIEW:
	        	ViewProvider p = new ViewProvider(getContext(), dbHelper);
	        	return p.update(uri, values, selection, selectionArgs);
            default:
                throw new IllegalArgumentException(
                    "Unsupported URI for update: " + uri);
        }
	}
}
