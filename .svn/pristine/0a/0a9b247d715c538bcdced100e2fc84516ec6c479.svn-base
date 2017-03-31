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
