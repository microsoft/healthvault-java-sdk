package com.microsoft.hsg.android.simplexml.store;

import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.database.sqlite.SQLiteStatement;
import android.net.Uri;

public class ThingProvider {
	private HVOpenHelper dbHelper;
	private Context context;
	
	public ThingProvider(Context ctx, HVOpenHelper dbHelper) {
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
		String thingId = segments.get(3);
		
	    SQLiteQueryBuilder builder = new SQLiteQueryBuilder();
	    builder.setTables("things");
	    builder.appendWhere("thing_id = '" + thingId + "'");

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
		SQLiteDatabase sqlDb = dbHelper.getWritableDatabase();

		List<String> segments = uri.getPathSegments();
		String thingId = segments.get(1);

		String deleteThing = "delete from things where thing_id = ?";
        SQLiteStatement deleteThingStmt = sqlDb.compileStatement(deleteThing);

		deleteThingStmt.bindString(1, thingId);
		
		int rc = deleteThingStmt.executeUpdateDelete();
		
		getContext()
                .getContentResolver()
                .notifyChange(uri, null);
     
		return rc;
	}

	private Context getContext() {
		return context;
	}
}
