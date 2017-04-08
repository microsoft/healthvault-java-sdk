/*
 * (c) Copyright Microsoft Corporation. 
 * This source is subject to the Microsoft Public License.
 * See http://www.microsoft.com/opensource/licenses.mspx#Ms-PL       
 */
package com.microsoft.hsg;

/**
 * The Class HVUserTokenExpiredException indicates the user
 * token has expired.
 */
public class HVUserTokenExpiredException extends HVRequestException
{
	
	/**
	 * Instantiates a new hV user token expired exception.
	 * 
	 * @param code the code
	 */
	public HVUserTokenExpiredException(int code)
	{
		super(code);
	}

}
