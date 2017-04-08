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
