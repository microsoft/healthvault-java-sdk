package com.microsoft.hsg.android.simplexml.store;

import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.database.sqlite.SQLiteStatement;
import android.net.Uri;
import android.util.Log;

public class ViewThingsProvider {
	
	private HVOpenHelper dbHelper;
	private Context context;
	
	public ViewThingsProvider(Context ctx, HVOpenHelper dbHelper) {
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
		String name = segments.get(3);

	    SQLiteQueryBuilder builder = new SQLiteQueryBuilder();
	    builder.setTables("view_things");
	    builder.appendWhere("record_id = '" + recordId + "'");
        builder.appendWhere(" and view_name = '" + name + "'");

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
	
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		// TODO: Delete things not shared with other views
		
		SQLiteDatabase sqlDb = dbHelper.getWritableDatabase();

		List<String> segments = uri.getPathSegments();

		String recordId = segments.get(1);
		String name = segments.get(3);

		String deleteView = "delete from view_things where record_id = ? and view_name = ?";
        SQLiteStatement deleteViewStmt = sqlDb.compileStatement(deleteView);

		deleteViewStmt.bindString(1, recordId);
		deleteViewStmt.bindString(2, name);
		
		int rc = deleteViewStmt.executeUpdateDelete();
		
		getContext()
                .getContentResolver()
                .notifyChange(uri, null);

		return rc;
	}

	int insertViewThings(Uri uri, ContentValues[] values) {
		
		// TODO: Verify view exists
		
        SQLiteDatabase sqlDB = dbHelper.getWritableDatabase();
 	
		List<String> segments = uri.getPathSegments();
		String recordId = segments.get(1);
		String name = segments.get(3);
       
        int i = 0;

        try {
            sqlDB.beginTransaction();

            String insertViewThings = "Insert or replace into view_things (_id, record_id, view_name, thing_id) values((select _id from view_things where view_name = ? and thing_id = ? and record_id = ?),?,?,?)";
            String insertThings = "Insert or replace into things (thing_id, version_stamp, thing_xml) values(?,?,?)";
            SQLiteStatement insertViewThingsStmt = sqlDB.compileStatement(insertViewThings);
            SQLiteStatement insertThingsStmt = sqlDB.compileStatement(insertThings);

            for (ContentValues value : values) {

                    insertViewThingsStmt.bindString(1, name);
                    insertViewThingsStmt.bindString(2, value.getAsString("thing_id"));
                    insertViewThingsStmt.bindString(3, recordId);
                    insertViewThingsStmt.bindString(4, recordId);
                    insertViewThingsStmt.bindString(5, name);
                    insertViewThingsStmt.bindString(6, value.getAsString("thing_id"));
                    insertViewThingsStmt.execute();
                    
                if (value.get("thing_xml") != null) {
                    insertThingsStmt.bindString(1, value.getAsString("thing_id"));
                    insertThingsStmt.bindString(2, value.getAsString("version_stamp"));
                    insertThingsStmt.bindString(3, value.getAsString("thing_xml"));
                    insertThingsStmt.execute();
                }
                
                if (++i%100 == 0) {
                        Log.d("hv", "Inserted 100 things");
                }
            }
            
            sqlDB.setTransactionSuccessful();
        } finally {
        	sqlDB.endTransaction();
        }

        Log.d("hv", "Done inserting " + i + " things.");

        getContext()
                .getContentResolver()
                .notifyChange(uri, null);

		return i;
	}

	private Context getContext() {
		return context;
	}
}