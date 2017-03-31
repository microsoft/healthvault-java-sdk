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

import java.net.URI;
import java.net.URL;
import java.util.HashMap;

/**
 * A factory for creating Connection objects.  This factory
 * is a helper to assemble Connection objects with their default
 * strategies.  
 */
public class ConnectionFactory
{
	private static String appId = ApplicationConfig.APP_ID;
	
	//TODO: make this an LRU and/or provide clean up methods
	private static HashMap<String, ApplicationAuthenticator> authenticatorMap
			= new HashMap<String, ApplicationAuthenticator>();
	
	private static synchronized Authenticator getAuthenticator(String appId)
	{
		ApplicationAuthenticator authenticator = authenticatorMap.get(appId);
		if (authenticator == null)
		{			
			String filename = ApplicationConfig.Keystore_Filename;
			String keyName = ApplicationConfig.Keystore_Keyname;
			String keyStorePassword = ApplicationConfig.Keystore_Password;
			DefaultPrivateKeyStore keyStore = new DefaultPrivateKeyStore();
			keyStore.setAlias(keyName);
			keyStore.setPassword(keyStorePassword);
			keyStore.setFilename(filename);
			
			authenticator = new ApplicationAuthenticator();
			authenticator.setSharedSecretGenerator(new DefaultSharedSecret());
			authenticator.setAppId(appId);
			authenticator.setKeyStore(keyStore);
			
			authenticatorMap.put(appId, authenticator);
		}
		return authenticator;
	}
	
	
	/**
	 * Gets the connection for the specified app id.  All connections
	 * from this factory use the same private key.  
	 * 
	 * @param appId the app id
	 * 
	 * @return the connection
	 */
	public static Connection getConnection(String appId)
	{
		try
		{
			return getConnection(appId, ApplicationConfig.HV_URI);
		}
		catch(Exception e)
		{
			throw new HVException(e);
		}
	}
	
	/**
	 * Gets a connection using the default app id.
	 * 
	 * @return the connection
	 */
	public static Connection getConnection()
	{
		return getConnection(appId);	}

	/**
	 * Gets a connection using the specified url for 
	 * HealthVault platform's endpoint.  
	 * 
	 * @param platform uri
	 * @return the connection
	 */
    public static Connection getConnection(
    		String appId, 
    		URI platform)
    {
    	try
		{
	        Connection connection = new Connection();
	        connection.setTransport(getTransport(platform));
	        connection.setAuthenticator(getAuthenticator(appId));
	        connection.authenticate();
	        
	        return connection;    
		} 
		catch (Exception e)
		{
			throw new HVException(e);
		}
    }
    
    public static Connection getConnectionForInstance(
            String appId,
            String instanceId ) 
    {
        URI platformURI = HVInstanceResolver
                .getInstanceResolver()
                .getInstanceForId(instanceId)
                .getPlatformUri();
        return getConnection(appId, platformURI);
    }
	
	private static Transport getTransport(URI platform)
	throws Exception
	{
		int connectTimeout = ApplicationConfig.Transport_Timeout_Connection;
		int readTimeout = ApplicationConfig.Transport_Timeout_Read;
		
		URL url = platform.toURL();
			
		URLConnectionTransport transport = new URLConnectionTransport();
		transport.setConnectionTimeout(connectTimeout);
		transport.setReadTimeout(readTimeout);
		transport.setUrl(url);
		
		return transport;
	}
}
