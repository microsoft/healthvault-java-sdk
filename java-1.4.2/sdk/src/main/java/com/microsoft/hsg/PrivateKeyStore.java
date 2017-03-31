/*
 * (c) Copyright Microsoft Corporation. 
 * This source is subject to the Microsoft Public License.
 * See http://www.microsoft.com/opensource/licenses.mspx#Ms-PL       
 */
package com.microsoft.hsg;

import java.security.PrivateKey;

/**
 * The PrivateKeyStore specifies the contract to get the
 * appliction's private key and thumbprint.
 */
public interface PrivateKeyStore
{
	
	/**
	 * Gets the private key.
	 * 
	 * @return the private key
	 */
	PrivateKey getPrivateKey();
	
	/**
	 * Gets the thumbprint.
	 * 
	 * @return the thumbprint
	 */
	String getThumbprint();
}
