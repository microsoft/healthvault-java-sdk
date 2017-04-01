/*
 *  Copyright (c) Microsoft Corporation
 *
 *	All rights reserved. 
 *
 *	MIT License
 *	Permission is hereby granted, free of charge, to any person obtaining a copy of this software
 *  and associated documentation files (the ""Software""), to deal in the Software without
 *  restriction, including without limitation the rights to use, copy, modify, merge, publish,
 *  distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom
 *  the Software is furnished to do so, subject to the following conditions:
 *
 *	The above copyright notice and this permission notice shall be included in all copies or
 *  substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED *AS IS*, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING
 *  BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 *  NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 *  DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.microsoft.hsg;

import java.security.Key;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.cert.Certificate;

import org.apache.commons.codec.binary.Hex;

/**
 * An implementation of PrivateKeyStore which delegates
 * to the Java keystore.  The keystore is loaded from the
 * classpath and uses the provided key alias and password
 * to obtain the private key.  
 * <p>
 * Generate a private/public key pair with the keytool:
 * <code>
 * keytool -genkey -keyalg RSA -keysize 1024 -keystore &lt;filename&gt; -alias &lt;alias&gt;
 * </code>
 * <p>
 * Export the public certificate with:
 * <code>
 * keytool -export -alias &lt;alias&gt; -keystore &lt;filename&gt; 
 * </code>
 * <p>
 * The thumbprint is generated with a SHA1 digest of the
 * binary public key certificate.
 */
public class DefaultPrivateKeyStore
implements PrivateKeyStore
{
	private String alias;
	private String password;
	private String filename;
	private PrivateKey privateKey;
	private String thumbprint;
	private boolean initialized = false;
	
	/**
	 * Gets the filename.
	 * 
	 * @return the filename
	 */
	public String getFilename()
	{
		return filename;
	}

	/**
	 * Sets the filename.  The filename should be resolvable
	 * from the classpath using getResourceAsStream()
	 * 
	 * @param filename the new filename
	 */
	public void setFilename(String filename)
	{
		this.filename = filename;
	}

	/**
	 * Gets the alias.
	 * 
	 * @return the alias
	 */
	public String getAlias()
	{
		return alias;
	}

	/**
	 * Sets the alias.
	 * 
	 * @param alias the new alias
	 */
	public void setAlias(String alias)
	{
		this.alias = alias;
	}

	/**
	 * Gets the password.
	 * 
	 * @return the password
	 */
	public String getPassword()
	{
		return password;
	}

	/**
	 * Sets the password.
	 * 
	 * @param password the new password
	 */
	public void setPassword(String password)
	{
		this.password = password;
	}

	/** 
	 * Returns the Private Key
	 * @see com.microsoft.hsg.PrivateKeyStore#getPrivateKey()
	 */
	public PrivateKey getPrivateKey()
	{
		initData();
		return privateKey; 
	}

	/** 
	 * Returns the thumbprint.  The thumbprint is the SHA1
	 * digest of the public key certificate.
	 * @see com.microsoft.hsg.PrivateKeyStore#getThumbprint()
	 */
	public String getThumbprint()
	{
		initData();
		return thumbprint;
	}
	
	private synchronized void initData()
	{
		try
		{
    		if (!initialized)
    		{
                KeyStore keystore = KeyStore.getInstance("JKS");
                keystore.load(Connection.class
                      .getResourceAsStream(filename), 
                      password.toCharArray());
                Key key = keystore.getKey(alias, password.toCharArray());
                if (key == null)
                {
                	throw new HVException("Key not found");
                }
                
                privateKey = (PrivateKey)key;
                Certificate cert = keystore.getCertificate(alias);
        		MessageDigest md = MessageDigest.getInstance("SHA1");
        		md.update(cert.getEncoded());
        		byte[] thumbprintBytes = md.digest(); 
        		thumbprint = new String(Hex.encodeHex(thumbprintBytes));
    		}
    		initialized = true;
		}
		catch(Exception e)
		{
			throw new HVSystemException(
					"Could not get private key information", e);
		}
	}
}