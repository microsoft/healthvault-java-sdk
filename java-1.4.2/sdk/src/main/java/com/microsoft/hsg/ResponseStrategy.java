/*
 * (c) Copyright Microsoft Corporation. 
 * This source is subject to the Microsoft Public License.
 * See http://www.microsoft.com/opensource/licenses.mspx#Ms-PL       
 */
package com.microsoft.hsg;

/**
 * The Interface ResponseStrategy.
 */
public interface ResponseStrategy
{
	
	/**
	 * Do with response.
	 * 
	 * @param response the response
	 */
	public void doWithResponse(Response response);
}
