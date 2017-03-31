/*
 * (c) Copyright Microsoft Corporation. 
 * This source is subject to the Microsoft Public License.
 * See http://www.microsoft.com/opensource/licenses.mspx#Ms-PL       
 */
package com.microsoft.hsg;

/**
 * Any problems with the transport should be reported
 * through this exception.
 */
public class HVTransportException extends HVException
{
	
	/**
	 * Instantiates a new hV transport exception.
	 */
	public HVTransportException()
	{
		super();
	}

	/**
	 * Instantiates a new hV transport exception.
	 * 
	 * @param e the e
	 */
	public HVTransportException(Exception e)
	{
		super(e);
	}

	/**
	 * Instantiates a new hV transport exception.
	 * 
	 * @param msg the msg
	 * @param e the e
	 */
	public HVTransportException(String msg, Exception e)
	{
		super(msg, e);
	}

	/**
	 * Instantiates a new hV transport exception.
	 * 
	 * @param msg the msg
	 */
	public HVTransportException(String msg)
	{
		super(msg);
	}
	
}
