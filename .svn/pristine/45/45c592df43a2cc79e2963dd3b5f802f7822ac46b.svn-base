/*
 * Copyright 2011 Microsoft Corp.
 * 
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
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
