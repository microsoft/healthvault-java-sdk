package com.microsoft.hsg.android.simplexml.test;

import junit.framework.Assert;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.test.ProviderTestCase2;

import com.microsoft.hsg.android.simplexml.store.HVContentContract;
import com.microsoft.hsg.android.simplexml.store.HVContentProvider;

public class ContentProviderTest extends ProviderTestCase2<HVContentProvider> {

	public ContentProviderTest() {
		super(HVContentProvider.class, HVContentContract.AUTHORITY);
	}

	/*
	 * 
	 * Views 
	 * 
	 */
	public void testBadViewUri() throws Exception {
		ContentProvider provider = this.getProvider();

		ContentValues values = new ContentValues();
		values.put("query", "this is a test");
		values.put("date_synced", "1/1/1970");

		try
		{
			provider.insert(
					Uri.withAppendedPath(HVContentContract.CONTENT_URI, "records/42/views/43/this-semgment-is-bad"),
					values);
			Assert.fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			//ignore
		}
	}

	public void testInsert() {
		String query = "this is a test";
		String dateSynced = "1/1/1970";
		Uri uri = Uri.withAppendedPath(HVContentContract.CONTENT_URI, "records/42/views/43");
		
		insertQuery(uri, query, dateSynced);
		verifyQuery(uri, query, dateSynced);

	}
	
	public void testReplaceOnInsert() {
	    String query1 = "this is a test";
	    String query2 = "this is another test";
		String dateSynced = "1/1/1970";
		Uri uri = Uri.withAppendedPath(HVContentContract.CONTENT_URI, "records/42/views/43");

		insertQuery(uri, query1, dateSynced);
		verifyQuery(uri, query1, dateSynced);

		insertQuery(uri, query2, dateSynced);
		verifyQuery(uri, query2, dateSynced);
	}
	
	public void testUpdateQuery() {
	    String query1 = "this is a test";
	    String query2 = "this is another test";
		String dateSynced1 = "1/1/1970";
		String dateSynced2 = "1/1/1976";
		Uri uri = Uri.withAppendedPath(HVContentContract.CONTENT_URI, "records/42/views/43");

		insertQuery(uri, query1, dateSynced1);
		verifyQuery(uri, query1, dateSynced1);

		updateQuery(uri, query2, dateSynced2);
		verifyQuery(uri, query2, dateSynced2);
	}
	
	public void testDelete() {
		String query = "this is a test";
		String dateSynced = "1/1/1970";
		Uri uri = Uri.withAppendedPath(HVContentContract.CONTENT_URI, "records/42/views/43");
		
		insertQuery(uri, query, dateSynced);
		verifyQuery(uri, query, dateSynced);

		int rc = getProvider().delete(uri,  null,  null);
		Assert.assertEquals("Incorrect delete return code", 1,  rc);
	
		Cursor cursor = getProvider().query(
				uri,
				new String[] { "query" },
				null,
				null,
				null);
		
		Assert.assertEquals("Incorrect cursor count", 0, cursor.getCount());
	}
	
	private void updateQuery(Uri uri, String query, String date) {
		ContentValues values = new ContentValues();
		values.put("query", query);
		values.put("date_synced", date);

		getProvider().update(
		    Uri.withAppendedPath(HVContentContract.CONTENT_URI, "records/42/views/43"),
			values,
			null,
			null);
	}
	
	private void insertQuery(Uri uri, String query, String date) {
	    ContentValues values = new ContentValues();
		values.put("query", query);
		values.put("date_synced", "1/1/1970");

		getProvider().insert(
		    Uri.withAppendedPath(HVContentContract.CONTENT_URI, "records/42/views/43"),
			values);
	}
	
	private void verifyQuery(Uri uri, String expectedQuery, String expectedDate) {
		Cursor cursor = getProvider().query(
		    Uri.withAppendedPath(HVContentContract.CONTENT_URI, "records/42/views/43"),
		    new String[] { "query", "date_synced" },
		    null, null, null);

	    Assert.assertEquals(1,  cursor.getCount());
	        
	    cursor.moveToFirst();

	    Assert.assertEquals(expectedQuery, cursor.getString(0));
	    Assert.assertEquals(expectedDate, cursor.getString(1));
	}
	
	/*
	 * 
	 * BulkInsert
	 * 
	 */
	public void testSync() {
		String query = "MyQueryXML";
		String dateSynced = "1/1/1970";
		Uri uri = Uri.withAppendedPath(HVContentContract.CONTENT_URI, "records/42/views/43/things");
		
		insertQuery(uri, query, dateSynced);
		
		ContentValues[] values = new ContentValues[2];
		values[0] = new ContentValues();
		values[0].put("thing_xml", "my thing xml");
		values[0].put("effective_date", "1/1/1970");
		values[0].put("version_stamp", "11111111-1111-1111-1111-111111111111");
		values[0].put("thing_id", "22222222-2222-2222-2222-222222222222");
		
		values[1] = new ContentValues();
		values[1].put("effective_date", "1/1/1971");
		values[1].put("version_stamp", "11111111-1111-1111-1111-111111111112");
		values[1].put("thing_id", "22222222-2222-2222-2222-222222222223");
		
		getProvider().bulkInsert(uri,  values);
		
		Cursor cursor = getProvider().query(
				Uri.withAppendedPath(HVContentContract.CONTENT_URI, "/records/42/things/22222222-2222-2222-2222-222222222222"), 
				new String[] {"thing_xml"}, 
				null, null, null);
	
		Assert.assertEquals("Thing cursor size", 1, cursor.getCount());
		
		cursor = getProvider().query(
				Uri.withAppendedPath(HVContentContract.CONTENT_URI, "/records/42/views/43/things"), 
				new String[] {"thing_id"},
				null, null, null);
		Assert.assertEquals("Thing cursor size", 2, cursor.getCount());
		
	}
}
