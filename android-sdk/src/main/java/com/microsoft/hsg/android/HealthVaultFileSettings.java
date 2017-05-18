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

package com.microsoft.hsg.android;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import android.content.Context;

import com.microsoft.hsg.HVSystemException;

// TODO: Auto-generated Javadoc
/**
 * The Class HealthVaultFileSettings.
 */
public class HealthVaultFileSettings implements HealthVaultSettings {

	/** The properties. */
	private Properties properties;

	/** The ctx. */
	private Context ctx;

	/**
	 * Instantiates a new health vault file settings.
	 *
	 * @param ctx the ctx
	 */
	public HealthVaultFileSettings(Context ctx) {
		this.ctx = ctx;

		try
		{
			properties = new Properties();
			try
			{
				properties.load(ctx.openFileInput("settings.props"));
			}
			catch(FileNotFoundException fnfe) {
			}
		}
		catch(IOException ioe) {
			throw new HVSystemException("Could not load properties.", ioe);
		}
	}

	/* (non-Javadoc)
	 * @see com.microsoft.hsg.android.HealthVaultSettings#getIsMultiInstanceAware()
	 */
	public boolean getIsMultiInstanceAware() {
		return Boolean.valueOf(properties.getProperty("is-multi-instance-aware"));
	}
	
	/* (non-Javadoc)
	 * @see com.microsoft.hsg.android.HealthVaultSettings#setIsMultiInstanceAware(boolean)
	 */
	public void setIsMultiInstanceAware(boolean isAware) {
		properties.setProperty("is-multi-instance-aware", String.valueOf(isAware));
	}
	/* (non-Javadoc)
	* @see com.microsoft.hsg.android.HealthVaultSettings#getAuthenticationSecret()
	*/
	public String getAuthenticationSecret() {
		return properties.getProperty("authentication-secret");
	}

	/* (non-Javadoc)
	* @see com.microsoft.hsg.android.HealthVaultSettings#setMasterAppId(java.lang.String)
	*/
	public void setMasterAppId(String appId) {
		properties.setProperty("master-app-id", appId);
	}

	/* (non-Javadoc)
	 * @see com.microsoft.hsg.android.HealthVaultSettings#getMasterAppId()
	 */
	public String getMasterAppId() {
		return properties.getProperty("master-app-id");
	}

	/* (non-Javadoc)
	* @see com.microsoft.hsg.android.HealthVaultSettings#getServiceUrl()
	*/
	public String getServiceUrl() {
		return properties.getProperty("service-url");
	}

	/* (non-Javadoc)
	* @see com.microsoft.hsg.android.HealthVaultSettings#setServiceUrl(java.lang.String)
	*/
	public void setServiceUrl(String url) {
		properties.setProperty("service-url", url);
	}

	/* (non-Javadoc)
	* @see com.microsoft.hsg.android.HealthVaultSettings#getShellUrl()
	*/
	public String getShellUrl() {
		return properties.getProperty("shell-url");
	}

	/* (non-Javadoc)
	* @see com.microsoft.hsg.android.HealthVaultSettings#setShellUrl(java.lang.String)
	*/
	public void setShellUrl(String url) {
		properties.setProperty("shell-url", url);
	}

	/* (non-Javadoc)
	* @see com.microsoft.hsg.android.HealthVaultSettings#setAppId(java.lang.String)
	*/
	public void setAppId(String appId) {
		properties.setProperty("appid", appId);
	}

	/* (non-Javadoc)
	* @see com.microsoft.hsg.android.HealthVaultSettings#getAppId()
	*/
	public String getAppId() {
		return properties.getProperty("appid");
	}

	/* (non-Javadoc)
	* @see com.microsoft.hsg.android.HealthVaultSettings#setAuthenticationSecret(java.lang.String)
	*/
	public void setAuthenticationSecret(String secret) {
		properties.setProperty("authentication-secret", secret);
	}

	/* (non-Javadoc)
	* @see com.microsoft.hsg.android.HealthVaultSettings#getConnectionStatus()
	*/
	public HealthVaultService.ConnectionStatus getConnectionStatus()
	{
		if (properties.containsKey("connected")) {
			return HealthVaultService.ConnectionStatus.Connected;
		}
		else {
			return HealthVaultService.ConnectionStatus.NotConnected;
		}
	}

	/* (non-Javadoc)
	* @see com.microsoft.hsg.android.HealthVaultSettings#setConnectionStatus(com.microsoft.hsg.android.HealthVaultService.ConnectionStatus)
	*/
	public void setConnectionStatus(HealthVaultService.ConnectionStatus status) {
		if (status == HealthVaultService.ConnectionStatus.Connected) {
			properties.setProperty("connected", "true");
		} else {
			properties.remove("connected");
		}
	}

	public boolean getIsMRA() {
		return Boolean.valueOf(properties.getProperty("isMRA"));
	}
	
	public void setIsMRA(boolean isMRA) {
		properties.setProperty("isMRA", String.valueOf(isMRA));
	}

	/* (non-Javadoc)
	* @see com.microsoft.hsg.android.HealthVaultSettings#clear()
	*/
	public void clear() {
		properties = new Properties();
	}

	/* (non-Javadoc)
	* @see com.microsoft.hsg.android.HealthVaultSettings#save()
	*/
	public void save() {
		try
		{
			properties.save(ctx.openFileOutput("settings.props", Context.MODE_PRIVATE), "settings");
		}
		catch (Exception e) {
		}
	}
}
