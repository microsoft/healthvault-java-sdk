/*
 * (c) Copyright Microsoft Corporation. 
 * This source is subject to the Microsoft Public License.
 * See http://www.microsoft.com/opensource/licenses.mspx#Ms-PL       
 */
package com.microsoft.hsg;

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
	private static HashMap authenticatorMap = new HashMap();
	
	private static synchronized Authenticator getAuthenticator(String appId)
	{
		ApplicationAuthenticator authenticator = (ApplicationAuthenticator)authenticatorMap.get(appId);
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
	        Connection connection = new Connection();
	        connection.setTransport(getTransport());
	        connection.setAuthenticator(getAuthenticator(appId));
	        connection.authenticate();
	        
	        return connection;    
		} 
		catch (Exception e)
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
	
	private static Transport getTransport()
	throws Exception
	{
		int connectTimeout = ApplicationConfig.Transport_Timeout_Connection;
		int readTimeout = ApplicationConfig.Transport_Timeout_Read;
		String urlString = 	ApplicationConfig.HV_URL;
		
		URL url = new URL(urlString);
			
		URLConnectionTransport transport = new URLConnectionTransport();
		transport.setConnectionTimeout(connectTimeout);
		transport.setReadTimeout(readTimeout);
		transport.setUrl(url);
		
		return transport;
	}
		
	

}
