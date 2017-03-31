package com.microsoft.hsg.android.simplexml.store;

import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.database.sqlite.SQLiteStatement;
import android.net.Uri;

public class ViewProvider {
	
	private HVOpenHelper dbHelper;
	private Context context;
	
	public ViewProvider(Context ctx, HVOpenHelper dbHelper) {
		this.context = ctx;
		this.dbHelper = dbHelper;
	}

	public Cursor query(
            Uri uri, 
            String[] projection,
            String selection, 
            String[] selectionArgs, 
            String sortOrder) {
		SQLiteDatabase db = dbHelper.getReadableDatabase();
	
		List<String> segments = uri.getPathSegments();
		String recordId = segments.get(1);
		String name = segments.size() == 4
				? segments.get(3)
                : null;

	    SQLiteQueryBuilder builder = new SQLiteQueryBuilder();
	    builder.setTables("views");
	    builder.appendWhere("record_id = '" + recordId + "'");
	    
	    if (name != null) {
	    	builder.appendWhere(" and name = '" + name + "'");
	    }

        Cursor cursor = 
	       builder.query(
               db, 
               projection, 
               selection, 
               selectionArgs,
               null, 
               null, 
               sortOrder);
        
        return cursor;
	}

	public Uri insert(Uri uri, ContentValues values) {
		SQLiteDatabase sqlDb = dbHelper.getWritableDatabase();
		
		List<String> segments = uri.getPathSegments();
		String recordId = segments.get(1);
		String name = segments.get(3);

        String insertView = "Insert or replace into views (record_id, name, query, date_synced) values(?,?,?,?)";

        SQLiteStatement insertViewStmt = sqlDb.compileStatement(insertView);

        insertViewStmt.bindString(1, recordId);
        insertViewStmt.bindString(2, name);
        insertViewStmt.bindString(3, values.getAsString("query"));
        insertViewStmt.bindString(4, values.getAsString("date_synced"));
        insertViewStmt.execute();
        
        getContext()
                .getContentResolver()
                .notifyChange(uri, null);
       
        return uri;
	}

	public int delete(Uri uri, String selection, String[] selectionArgs) {
		// TODO: Delete things not shared with other views
		
		SQLiteDatabase sqlDb = dbHelper.getWritableDatabase();

		List<String> segments = uri.getPathSegments();

		String recordId = segments.get(1);
		String name = segments.get(3);

		String deleteView = "delete from views where record_id = ? and name = ?";
        SQLiteStatement deleteViewStmt = sqlDb.compileStatement(deleteView);

		deleteViewStmt.bindString(1, recordId);
		deleteViewStmt.bindString(2, name);
		
		int rc = deleteViewStmt.executeUpdateDelete();
		
		getContext()
                .getContentResolver()
                .notifyChange(uri, null);

		return rc;
	}

	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		int updateCount = 0;

		SQLiteDatabase sqlDb = dbHelper.getWritableDatabase();

		List<String> segments = uri.getPathSegments();
		String recordId = segments.get(1);
		String name = segments.get(3);
	
		String updateView = "update views set query = ?, date_synced = ? where record_id = ? and name = ?";
        SQLiteStatement updateViewStmt = sqlDb.compileStatement(updateView);

		updateViewStmt.bindString(1, values.getAsString("query"));
		updateViewStmt.bindString(2, values.getAsString("date_synced"));
		updateViewStmt.bindString(3, recordId);
		updateViewStmt.bindString(4, name);
		
		updateCount = updateViewStmt.executeUpdateDelete();
	
		if (updateCount > 0) { 
		      getContext().getContentResolver().notifyChange(uri, null); 
		} 

		return updateCount; 
	}

	private Context getContext() {
		return context;
	}
}
