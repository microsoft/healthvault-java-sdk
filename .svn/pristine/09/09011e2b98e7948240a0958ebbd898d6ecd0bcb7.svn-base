/*
 * (c) Copyright Microsoft Corporation. 
 * This source is subject to the Microsoft Public License.
 * See http://www.microsoft.com/opensource/licenses.mspx#Ms-PL       
 */
package com.microsoft.hsg;

/**
 * The class HVRequestException is the base class for
 * all exception resulting from received HealthVault responses
 * where the status code != 0.
 */
public class HVRequestException extends HVException
{
	private int responseCode;
	
	/**
	 * Instantiates a new hV request exception.
	 * 
	 * @param code the code
	 */
	public HVRequestException(int code)
	{
		this.responseCode = code;
	}
	
	/**
	 * Gets the response code.
	 * 
	 * @return the response code
	 */
	public int getResponseCode()
	{
		return responseCode;
	}
}
