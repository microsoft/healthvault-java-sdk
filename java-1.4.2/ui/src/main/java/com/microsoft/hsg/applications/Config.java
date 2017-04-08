/*
 * (c) Copyright Microsoft Corporation. 
 * This source is subject to the Microsoft Public License.
 * See http://www.microsoft.com/opensource/licenses.mspx#Ms-PL       
 */
package com.microsoft.hsg.applications;

import com.microsoft.hsg.ApplicationConfig;

/**
 * The Class Config.
 */
public class Config {

	/** The Constant RedirectUrl. */
	public static final String RedirectUrl = 
		ApplicationConfig.getValue("target.auth.redirect");
	
	/** The Constant ActionQS. */
	public static final String ActionQS = 
		ApplicationConfig.getValue("target.auth.actionqs");
	
	/** The Constant ShellUrl. */
	public static final String ShellUrl = 
		ApplicationConfig.getValue("shell.url");
		
}
