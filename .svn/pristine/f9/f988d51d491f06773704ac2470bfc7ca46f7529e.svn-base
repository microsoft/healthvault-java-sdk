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
 * Thd DefaultSendStrategy implements a simple retry 
 * when the connection's application authentication token expires. 
 */
public class DefaultSendStrategy implements SendStrategy
{
	/**
	 * Send the request.  If the request is denied because
	 * the session token is expired, authenticate and try again. 
	 * @see com.microsoft.hsg.SendStrategy#doWithSender(com.microsoft.hsg.Connection, com.microsoft.hsg.Sender)
	 */
	public void doWithSender(Connection connection, Sender sender)
	{
		int remainingAttempts = 2;
		while(remainingAttempts-->0)
		{
    		try
    		{
    			sender.send();
    			break;
    		}
    		catch(HVApplicationSessionExpiredException e)
    		{
    			connection.authenticate(true);    			
    		}
		}
	}
}
