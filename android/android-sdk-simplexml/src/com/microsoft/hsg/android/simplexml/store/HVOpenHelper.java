package com.microsoft.hsg.android.simplexml.store;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class HVOpenHelper extends SQLiteOpenHelper {
	
	public static final String DBName = "hv";
	public static final int VERSION = 2;

	public HVOpenHelper(Context context) {
		super(context, DBName, null, VERSION);
	}	
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(HVDbSchema.DDL_CREATE_TABLE_THINGS);
		db.execSQL(HVDbSchema.DDL_CREATE_THINGS_THINGID_IDX);
		db.execSQL(HVDbSchema.DDL_CREATE_TABLE_VIEWS);
		db.execSQL(HVDbSchema.DDL_CREATE_TABLE_VIEW_THINGS);
		db.execSQL(HVDbSchema.DDL_CREATE_VIEW_THINGS_IDX);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL(HVDbSchema.DDL_DROP_TABLE_THINGS);
		db.execSQL(HVDbSchema.DDL_DROP_TABLE_VIEWS);
		db.execSQL(HVDbSchema.DDL_DROP_TABLE_VIEW_THINGS);
		onCreate(db);
	}

}
