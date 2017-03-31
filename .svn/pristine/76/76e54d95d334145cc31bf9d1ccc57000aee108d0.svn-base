/*
 * (c) Copyright Microsoft Corporation. 
 * This source is subject to the Microsoft Public License.
 * See http://www.microsoft.com/opensource/licenses.mspx#Ms-PL       
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
