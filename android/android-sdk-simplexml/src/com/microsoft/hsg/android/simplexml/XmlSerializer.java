package com.microsoft.hsg.android.simplexml;

import java.io.InputStream;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.Registry;
import org.simpleframework.xml.convert.RegistryStrategy;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.strategy.Strategy;
import org.simpleframework.xml.transform.RegistryMatcher;
import org.simpleframework.xml.transform.Transform;

import android.util.Log;

public class XmlSerializer {
	
	private static Serializer readSerializer;
	private static Serializer writeSerializer;
	
	public static <T> T read(Class<? extends T> type, InputStream istream) throws Exception {
        return getReadSerializer().read(type, istream, false);
	}
	
	public static <T> T read(Class<? extends T> type, String source) throws Exception {
        return getReadSerializer().read(type, source, false);
	}
	
	public static <T> T safeRead(Class<? extends T> type, String source ) {
		T ret = null;
		
		try {
			ret = read(type, source);
		} catch (Exception e) {
			Log.i("hv", "Unable to read xml: " + source);
		}
		
		return ret;
	}
	
	private static Serializer getReadSerializer() throws Exception {
		if (readSerializer == null) {
		Log.d("hv", "Begin Creating Serializer");
        RegistryMatcher matcher = new RegistryMatcher();
        matcher.bind(Date.class, new DateFormatTransformer());

        Registry registry = new Registry();
        registry.bind(String.class, SimpleXMLStringConverter.class);
        Strategy strategy = new RegistryStrategy(registry);

        Serializer s = new Persister(strategy, matcher);
		Log.d("hv", "Done Creating Serializer");
		
		readSerializer = s;
		}
        return readSerializer;
	}

	public static String safeWrite(Object obj) {
		String rv = null;
		
		try {
			rv = write(obj);
		} catch (Exception e) {
			Log.i("hv", "Could not write object: " + obj);
		}
		
		return rv;
	}
	
	public static String write(Object obj) throws Exception {
		Log.d("hv", "Beging Serializer Write");
		Serializer s;
		if (writeSerializer == null) {
			RegistryMatcher matcher = new RegistryMatcher();
			matcher.bind(Date.class, new DateFormatTransformer());

			writeSerializer = new Persister(matcher);
		}
		s = writeSerializer;
		
		StringWriter sw = new StringWriter(1024);
		s.write(obj, sw);
		String info = sw.toString();

		Log.d("hv", "End Serializer Write");

		return info;
	}

    public static class DateFormatTransformer implements Transform<Date> {
		private static DateFormat format = new SimpleDateFormat("yyyy-MM-d'T'HH:mm:ss");

		@Override
		public Date read(String value) throws Exception
		{
			return format.parse(value);
		}

		@Override
		public String write(Date value) throws Exception
		{
			return format.format(value);
		}
	}
}
