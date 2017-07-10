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

package com.microsoft.hsg.android.healthvault;

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
	throws IOException {
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
	public static Connection getUnauthenticatedConnection() {
		try {
			Connection connection = new Connection();
			connection.setTransport(getTransport());

			return connection;
		} catch (Exception e) {
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
