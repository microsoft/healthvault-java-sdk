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
package com.microsoft.hsg.android.simplexml;

import java.io.IOException;
import java.net.URL;

import com.microsoft.hsg.Authenticator;
import com.microsoft.hsg.Connection;
import com.microsoft.hsg.HVException;
import com.microsoft.hsg.Transport;
import com.microsoft.hsg.URLConnectionTransport;

/**
 * A factory for creating Connection objects.  This factory
 * is a helper to assemble Connection objects with their default
 * strategies.
 */
public class ConnectionFactory
{    
    /** The authenticator. */
    private static Authenticator authenticator;
    
    /**
     * Gets the authenticator.
     * 
     * @param appId the app id
     * @param authenticationSecret the authentication secret
     * 
     * @return the authenticator
     * 
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private static synchronized Authenticator getAuthenticator(
            String appId, byte[] authenticationSecret)
    throws IOException
    {
        if (authenticator == null) {
            authenticator = new SodaAuthenticator(
                appId, authenticationSecret);
        }
        
        return authenticator;
    }
    
    /**
     * Gets the unauthenticated connection.
     * 
     * @return the unauthenticated connection
     */
    public static Connection getUnauthenticatedConnection()
    {
        try
        {
            Connection connection = new Connection();
            connection.setTransport(getTransport());
            
            return connection;
        }
        catch (Exception e)
        {
            throw new HVException(e);
        }
    }
    
    /**
     * Gets the connection.
     * 
     * @param appId the app id
     * @param authenticationSecret the authentication secret
     * 
     * @return the connection
     */
    public static Connection getConnection(String appId, byte[] authenticationSecret)
    {
        try {
            Connection connection = new Connection();
            connection.setAppId(appId);
            connection.setTransport(getTransport());
            connection.setAuthenticator(getAuthenticator(
                    appId, authenticationSecret));
            connection.authenticate();
            
            return connection;    
        } catch (HVException hve) {
            throw hve;
        } catch (Exception e) {
            throw new HVException(e);
        }
        
    }
    
    /**
     * Gets the transport.
     * 
     * @return the transport
     * 
     * @throws Exception the exception
     */
    private static Transport getTransport()
    throws Exception
    {
        int connectTimeout = 30 * 1000;
        int readTimeout = 30 * 1000;
        String urlString =     HealthVaultApp.getInstance().getSettings()
            .getServiceUrl();
        
        URL url = new URL(urlString);
            
        URLConnectionTransport transport = new URLConnectionTransport();
        transport.setConnectionTimeout(connectTimeout);
        transport.setReadTimeout(readTimeout);
        transport.setUrl(url);
        
        return transport;
    }
        
    /**
     * Reset.
     */
    public static void reset() {
        authenticator = null;
    }

}
