package com.microsoft.hsg.android.simplexml.store;

class HVDbSchema {
	
	static String TABLE_THINGS = "things";
	static String TABLE_VIEWS = "views";
	static String TABLE_VIEW_THINGS = "view_things";

	static String DDL_CREATE_TABLE_THINGS = 
			"CREATE TABLE things (" +
			"_id           INTEGER  PRIMARY KEY AUTOINCREMENT, \n" +
			"thing_id     TEXT,\n" +
			"version_stamp TEXT NOT NULL UNIQUE, \n" +
			"thing_xml     TEXT,\n" +
			"unique (thing_id) on conflict replace" +
			")";
	
	static String DDL_CREATE_THINGS_THINGID_IDX = 
			"create index ix_things_thing_id on things (thing_id)";
	
	static String DDL_DROP_TABLE_THINGS = 
			"DROP TABLE IF EXISTS THINGS";
	
	static String DDL_CREATE_TABLE_VIEWS = 
			"CREATE TABLE views (" +
			"_id           INTEGER  PRIMARY KEY AUTOINCREMENT, \n" +
			"record_id TEXT not null,\n" +
            "name	TEXT not null,\n" +
            "query	TEXT not null,\n" +
            "date_synced not null, \n" +
            "unique (record_id, name) on conflict replace" +
            ")";
	
	static String DDL_CREATE_VIEW_THINGS_IDX =
			"create index ix_views_record_id_name on views (record_id, name)";

	static String DDL_DROP_TABLE_VIEWS =
			"DROP TABLE IF EXISTS VIEWS";

	static String DDL_CREATE_TABLE_VIEW_THINGS = 
			"CREATE TABLE view_things (" +
			"_id           INTEGER  PRIMARY KEY AUTOINCREMENT, \n" +
			"record_id TEXT not null,\n" +
		    "view_name TEXT not null, \n" +
            "thing_id	TEXT not null, \n" +
            "unique (record_id, view_name, thing_id) on conflict replace" +
            ")";

	static String DDL_DROP_TABLE_VIEW_THINGS = 
			"DROP TABLE IF EXISTS VIEW_THINGS";

}
