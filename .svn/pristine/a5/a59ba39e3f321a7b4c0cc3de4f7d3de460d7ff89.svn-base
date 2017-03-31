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

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * The Class URLConnectionTransport provides a simple
 * implementation using <code>URLConnection</code>
 * for the http transport.
 */
public class URLConnectionTransport implements Transport
{
	private int connectionTimeout;
	private int readTimeout;
	private URL url;
	 
	/**
	 * @see com.microsoft.hsg.Transport#doRequest(java.lang.String)
	 */
	public void doRequest(String request, ResponseHandler responseHandler)
	{
		try
		{
            URLConnection conn = url.openConnection();
            conn.setRequestProperty("Content-type", "text/xml");
        
            conn.setDoInput (true);
            conn.setDoOutput (true);
            conn.setConnectTimeout(connectionTimeout);
            conn.setReadTimeout(readTimeout);
        
            OutputStream out = conn.getOutputStream ();
            out.write(request.getBytes("UTF-8"));
            out.flush ();
            out.close ();
        
            InputStream is = conn.getInputStream();
            try
            {
            	responseHandler.handleResponse(is);
            }
            finally
            {
            	is.close();
            }
		}
		catch(HVException hve)
		{
			throw hve;
		}
		catch(Exception e)
		{
			throw new HVTransportException(e);
		}
	}

	/**
	 * Gets the connection timeout.
	 * 
	 * @return the connection timeout
	 */
	public int getConnectionTimeout()
	{
		return connectionTimeout;
	}

	/**
	 * Sets the connection timeout.
	 * 
	 * @param connectionTimeout the new connection timeout
	 */
	public void setConnectionTimeout(int connectionTimeout)
	{
		this.connectionTimeout = connectionTimeout;
	}

	/**
	 * Gets the read timeout.
	 * 
	 * @return the read timeout
	 */
	public int getReadTimeout()
	{
		return readTimeout;
	}

	/**
	 * Sets the read timeout.
	 * 
	 * @param readTimeout the new read timeout
	 */
	public void setReadTimeout(int readTimeout)
	{
		this.readTimeout = readTimeout;
	}

	/**
	 * Gets the url.
	 * 
	 * @return the url
	 */
	public URL getUrl()
	{
		return url;
	}

	/**
	 * Sets the url.
	 * 
	 * @param url the new url
	 */
	public void setUrl(URL url)
	{
		this.url = url;
	}
}
