/*
 * (c) Copyright Microsoft Corporation. 
 * This source is subject to the Microsoft Public License.
 * See http://www.microsoft.com/opensource/licenses.mspx#Ms-PL       
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
class URLConnectionTransport implements Transport
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
            // The following properties are not supported in jdk 1.4
            //conn.setConnectTimeout(connectionTimeout);
            //conn.setReadTimeout(readTimeout);
        
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
