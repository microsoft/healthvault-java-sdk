/*
 * Copyright 2011 Microsoft Corp.
 * 
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.microsoft.hsg;

import java.io.IOException;
import java.net.URI;
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
		
		try
		{
    		HV_SHELL_URI = new URI(getValue("shell.url"));
    		HV_URI = new URI(getValue("healthvault.url"));
		}
		catch (Exception e)
		{
		    throw new HVException(e);
		}
	}
	
	/** The Constant APP_ID. */
	public static final String APP_ID = 
		getValue("app.id");

	/** Is this application aware of HV instances */
	public static final boolean IS_MULTI_INSTANCE_AWARE =
		getBooleanValue("app.isMultiInstanceAware", false);	
			
	/** The Constant HV_URL. */
	public static final URI HV_URI;
	
	public static final URI HV_SHELL_URI;
	
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
	
	public static boolean getBooleanValue(
			String name,
			boolean defaultValue)
	{
		boolean returnValue = defaultValue;
		String value = properties.getProperty(name);
		if (value != null)
		{
			returnValue = Boolean.parseBoolean(value);
		}
		return returnValue;
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
