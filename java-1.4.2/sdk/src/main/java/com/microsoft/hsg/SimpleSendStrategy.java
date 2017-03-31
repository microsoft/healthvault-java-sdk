/*
 * (c) Copyright Microsoft Corporation. 
 * This source is subject to the Microsoft Public License.
 * See http://www.microsoft.com/opensource/licenses.mspx#Ms-PL       
 */
package com.microsoft.hsg;

/**
 * The SimpleSendStrategy provides no added value beyond simply
 * sending once.
 */
public class SimpleSendStrategy implements SendStrategy
{

	/* (non-Javadoc)
	 * @see com.microsoft.hsg.SendStrategy#doWithSender(com.microsoft.hsg.Connection, com.microsoft.hsg.Sender)
	 */
	public void doWithSender(Connection connection, Sender sender)
	{
		sender.send();
	}

}
