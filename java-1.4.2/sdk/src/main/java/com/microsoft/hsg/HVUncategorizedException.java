/*
 * (c) Copyright Microsoft Corporation. 
 * This source is subject to the Microsoft Public License.
 * See http://www.microsoft.com/opensource/licenses.mspx#Ms-PL       
 */
package com.microsoft.hsg;

/**
 * The Class HVUncategorizedException.
 */
public class HVUncategorizedException extends HVRequestException
{
	
	/**
	 * Instantiates a new hV uncategorized exception.
	 * 
	 * @param code the code
	 */
	public HVUncategorizedException(int responseCode)
	{
		super(responseCode);
	}

}
