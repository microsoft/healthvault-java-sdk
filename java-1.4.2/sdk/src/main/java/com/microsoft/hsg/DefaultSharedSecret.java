/*
 * (c) Copyright Microsoft Corporation. 
 * This source is subject to the Microsoft Public License.
 * See http://www.microsoft.com/opensource/licenses.mspx#Ms-PL       
 */
package com.microsoft.hsg;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * The default implementation of a shared secret.  When asked,
 * generate a 20 byte array filled with random numbers from
 * <code>java.security.SecureRandom</code>
 */
public class DefaultSharedSecret implements SharedSecretGenerator {

	private SecureRandom random;
	
	/**
	 * Instantiates a new default shared secret.
	 * 
	 * @throws HVException the HV exception
	 */
	public DefaultSharedSecret()
	throws HVException
	{
		try
		{
			random = SecureRandom.getInstance("SHA1PRNG");
		}
		catch (NoSuchAlgorithmException nsae)
		{
			throw new HVException(nsae);
		}
	}
	
	/** 
	 * Generate the Shared Secret.
	 * @see com.microsoft.hsg.SharedSecretGenerator#generateSharedSecret()
	 */
	public byte[] generateSharedSecret() {
		byte[] secret = new byte[20];
		random.nextBytes(secret);
		return secret;
	}

}
