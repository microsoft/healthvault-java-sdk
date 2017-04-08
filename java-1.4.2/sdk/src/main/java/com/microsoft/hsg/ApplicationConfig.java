/*
 * (c) Copyright Microsoft Corporation. 
 * This source is subject to the Microsoft Public License.
 * See http://www.microsoft.com/opensource/licenses.mspx#Ms-PL       
 */
package com.microsoft.hsg;

import java.io.IOException;
import java.util.Properties;

/**
 * Application Config is a simple configurator backed
 * by a properties file.  There are several helper
 * values for well known configurations.  Additional
 * values may be retrieved too.
 * 
 */
public class ApplicationConfig
{
	private static final String PROPS_FILE_NAME="/hv-application.properties";
	private static Properties properties;
	
	static
	{
		loadProperties();
	}
	
	/** The Constant APP_ID. */
	public static final String APP_ID = 
		getValue("app.id");
	
	/** The Constant HV_URL. */
	public static final String HV_URL = 
		getValue("healthvault.url");
	
	/** The Constant Transport_Timeout_Connection. */
	public static final int Transport_Timeout_Connection = 
		getIntValue("transport.timeout.connection",0);
	
	/** The Constant Transport_Timeout_Read. */
	public static final int Transport_Timeout_Read = 
		getIntValue("transport.timeout.read",0);  
	
	/** The Constant Keystore_Filename. */
	public static final String Keystore_Filename = 
		getValue("keystore.filename");
	
	/** The Constant Keystore_Keyname. */
	public static final String Keystore_Keyname = 
		getValue("keystore.keyname");
	
	/** The Constant Keystore_Password. */
	public static final String Keystore_Password = 
		getValue("keystore.password");
	
	
	/**
	 * Gets the value.
	 * 
	 * @param name the name
	 * 
	 * @return the value
	 */
	public static String getValue(String name)
	{
		return properties.getProperty(name);
	}
		
	/**
	 * Gets the int value.
	 * 
	 * @param name the name
	 * @param defaultValue the default value
	 * 
	 * @return the int value
	 */
	public static int getIntValue(String name, int defaultValue)
	{
		int returnValue = defaultValue;
		String value = properties.getProperty(name);
		if (value != null)
		{
			try
			{
				returnValue = Integer.parseInt(value);
			}
			catch(NumberFormatException nfe)
			{
			}
		}
		return returnValue;
	}
	
	/**
	 * Gets the value.
	 * 
	 * @param name the name
	 * @param defaultValue the default value
	 * 
	 * @return the value
	 */
	public static String getValue(String name, String defaultValue)
	{
		return properties.getProperty(name, defaultValue);
	}
	
	private static void loadProperties()
	{
		try
		{
			properties = new Properties();
			properties.load(ApplicationConfig.class.getResourceAsStream(PROPS_FILE_NAME));
		}
		catch(IOException ioe)
		{
			throw new HVSystemException("Could not load properties.", ioe);
		}
	}
	
}
