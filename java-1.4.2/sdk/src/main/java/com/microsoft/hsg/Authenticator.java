/*
 * (c) Copyright Microsoft Corporation. 
 * This source is subject to the Microsoft Public License.
 * See http://www.microsoft.com/opensource/licenses.mspx#Ms-PL       
 */
package com.microsoft.hsg;

/**
 * Authenticators authenticate connections.  Not all connections
 * need to be authenticated.  Authenticators are responsible for 
 * setting the shared secret and session token on the connection
 * if necessary.
 */
public interface Authenticator
{
	
	/**
	 * Authenticate the connection.  If the force flag is set,
	 * the Authenticator may not use cached data.  If the flag is
	 * false, the Authenticator <b>may</b> use cached data.
	 * 
	 * @param connection the connection
	 * @param force the flag
	 */
	public void authenticate(Connection connection, boolean force);
}
