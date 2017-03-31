/*
 * (c) Copyright Microsoft Corporation. 
 * This source is subject to the Microsoft Public License.
 * See http://www.microsoft.com/opensource/licenses.mspx#Ms-PL       
 */
package com.microsoft.hsg;

/**
 * HVAccessDeniedException indicates that HealthVault returned 
 * an AccessDenied error code.  
 */
public class HVAccessDeniedException extends HVRequestException
{
	
	/**
	 * Instantiates a new exception.
	 * 
	 * @param code the code
	 */
	public HVAccessDeniedException(int code)
	{
		super(code);
	}
}
