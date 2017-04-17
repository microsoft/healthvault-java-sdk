package com.microsoft.hsg.android.simplexml.store;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

public final class HVContentContract {

   public static final String AUTHORITY =  "com.microsoft.hsg.android.store"; 
   public static final Uri CONTENT_URI =  Uri.parse("content://" + AUTHORITY); 
   
   public static final class Things implements BaseColumns {
	   public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/things";
	   
	   public static final String THING_ID = "thing_id";
	   public static final String VERSION = "version_stamp";
	   public static final String THING_XML = "thing_xml";
   }
   
   public static final class Views implements BaseColumns {
	   public static final Uri CONTENT_URI = Uri.withAppendedPath(HVContentContract.CONTENT_URI, "views");
	   
	   public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/views";
	   
	   public static final String RECORD_ID = "record_id";
	   public static final String PERSON_ID = "person_id";
	   public static final String NAME = "name";
	   public static final String QUERY = "query";
	   public static final String SYNC_DATE = "date_synced";
   }

   public static final class ViewThings implements BaseColumns {
	   public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/viewthings";
	   
	   public static final String RECORD_ID = "record_id";
	   public static final String VIEW_NAME = "view_name";
	   public static final String THING_ID = "thing_id";
	   public static final String EFFECTIVE_DATE = "effective_date";
   }
}
