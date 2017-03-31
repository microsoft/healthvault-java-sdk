/*
 * (c) Copyright Microsoft Corporation. 
 * This source is subject to the Microsoft Public License.
 * See http://www.microsoft.com/opensource/licenses.mspx#Ms-PL       
 */
package com.microsoft.hsg;

/**
 * The Interface SendStrategy.
 */
public interface SendStrategy {

	/**
	 * Do with sender.
	 * 
	 * @param connection the connection
	 * @param sender the sender
	 */
	public void doWithSender(Connection connection, Sender sender);
}
