/*
 * (c) Copyright Microsoft Corporation. 
 * This source is subject to the Microsoft Public License.
 * See http://www.microsoft.com/opensource/licenses.mspx#Ms-PL       
 */
package com.microsoft.hsg;

/**
 * Translate a HealthVault response code into an enum
 * and exception class.
 */
public class DefaultResponseCodeTranslator
{
	
	/**
	 * Translate.
	 * 
	 * @param responseCode the response code
	 * 
	 * @return the exception
	 */
	public HVException translate(int responseCode)
	{
		switch(responseCode)
		{
		    case StatusCode.AUTHENTICATED_SESSION_TOKEN_EXPIRED:
		    	return new HVApplicationSessionExpiredException(responseCode);
		    case StatusCode.CREDENTIAL_TOKEN_EXPIRED:
		    	return new HVUserTokenExpiredException(responseCode);
		    case StatusCode.ACCESS_DENIED:
		    	return new HVAccessDeniedException(responseCode);
		}
		return new HVUncategorizedException(responseCode);
	}
}
