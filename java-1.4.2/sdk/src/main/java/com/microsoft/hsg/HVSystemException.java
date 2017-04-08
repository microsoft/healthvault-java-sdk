/*
 * (c) Copyright Microsoft Corporation. 
 * This source is subject to the Microsoft Public License.
 * See http://www.microsoft.com/opensource/licenses.mspx#Ms-PL       
 */
package com.microsoft.hsg;

/**
 * The Class HVSystemException.
 */
public class HVSystemException extends HVException
{

	/**
	 * Instantiates a new hV system exception.
	 */
	public HVSystemException()
	{
		super();
	}

	/**
	 * Instantiates a new hV system exception.
	 * 
	 * @param e the e
	 */
	public HVSystemException(Exception e)
	{
		super(e);
	}

	/**
	 * Instantiates a new hV system exception.
	 * 
	 * @param msg the msg
	 * @param e the e
	 */
	public HVSystemException(String msg, Exception e)
	{
		super(msg, e);
	}

	/**
	 * Instantiates a new hV system exception.
	 * 
	 * @param msg the msg
	 */
	public HVSystemException(String msg)
	{
		super(msg);
	}

}
