package com.microsoft.hsg.android.simplexml.store;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.microsoft.hsg.HVException;

public class DateFormatter {
	
	public static String toIsoString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        cal.add(
            Calendar.MILLISECOND,
            -1 * cal.getTimeZone().getOffset(cal.getTime().getTime()));
        return sdf.format(cal.getTime());
	}

	public Date fromIsoString(String serializedDate) {
		try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            return sdf.parse(serializedDate);
		} catch(Exception e) {
			throw new HVException(
                "Could not parse date: '" + serializedDate + "'",
                e);
		}
	}
	

}
