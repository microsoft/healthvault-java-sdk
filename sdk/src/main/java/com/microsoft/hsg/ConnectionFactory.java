/*
 *  Copyright (c) Microsoft Corporation
 *
 *	All rights reserved. 
 *
 *	MIT License
 *	Permission is hereby granted, free of charge, to any person obtaining a copy of this software
 *  and associated documentation files (the ""Software""), to deal in the Software without
 *  restriction, including without limitation the rights to use, copy, modify, merge, publish,
 *  distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom
 *  the Software is furnished to do so, subject to the following conditions:
 *
 *	The above copyright notice and this permission notice shall be included in all copies or
 *  substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED *AS IS*, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING
 *  BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 *  NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 *  DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
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
		return getConnection(appId);
	}

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
