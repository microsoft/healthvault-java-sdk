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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import android.content.Context;
import android.util.Log;

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
		FileInputStream inputStream = null;
		try {
			properties = new Properties();
			try {
				inputStream = ctx.openFileInput(Constants.SettingProperties);
				properties.load(inputStream);
			}
			catch(FileNotFoundException fnfe) {
				Log.e("FileSettings", "the settings.props file could not be found");
			} finally {
				if(inputStream != null) {
					inputStream.close();
				}
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
		return Boolean.valueOf(properties.getProperty(Constants.IsMultiInstanceAware));
	}
	
	/* (non-Javadoc)
	 * @see com.microsoft.hsg.android.HealthVaultSettings#setIsMultiInstanceAware(boolean)
	 */
	public void setIsMultiInstanceAware(boolean isAware) {
		properties.setProperty(Constants.IsMultiInstanceAware, String.valueOf(isAware));
	}
	/* (non-Javadoc)
	* @see com.microsoft.hsg.android.HealthVaultSettings#getAuthenticationSecret()
	*/
	public String getAuthenticationSecret() {
		return properties.getProperty(Constants.AuthenticationSecret);
	}

	/* (non-Javadoc)
	* @see com.microsoft.hsg.android.HealthVaultSettings#setMasterAppId(java.lang.String)
	*/
	public void setMasterAppId(String appId) {
		properties.setProperty(Constants.MasterAppId, appId);
	}

	/* (non-Javadoc)
	 * @see com.microsoft.hsg.android.HealthVaultSettings#getMasterAppId()
	 */
	public String getMasterAppId() {
		return properties.getProperty(Constants.MasterAppId);
	}

	/* (non-Javadoc)
	* @see com.microsoft.hsg.android.HealthVaultSettings#getServiceUrl()
	*/
	public String getServiceUrl() {
		return properties.getProperty(Constants.ServiceUrl);
	}

	/* (non-Javadoc)
	* @see com.microsoft.hsg.android.HealthVaultSettings#setServiceUrl(java.lang.String)
	*/
	public void setServiceUrl(String url) {
		properties.setProperty(Constants.ServiceUrl, url);
	}

	/* (non-Javadoc)
	* @see com.microsoft.hsg.android.HealthVaultSettings#getShellUrl()
	*/
	public String getShellUrl() {
		return properties.getProperty(Constants.ShellUrl);
	}

	/* (non-Javadoc)
	* @see com.microsoft.hsg.android.HealthVaultSettings#setShellUrl(java.lang.String)
	*/
	public void setShellUrl(String url) {
		properties.setProperty(Constants.ShellUrl, url);
	}

	/* (non-Javadoc)
	* @see com.microsoft.hsg.android.HealthVaultSettings#setAppId(java.lang.String)
	*/
	public void setAppId(String appId) {
		properties.setProperty(Constants.AppId, appId);
	}

	/* (non-Javadoc)
	* @see com.microsoft.hsg.android.HealthVaultSettings#getAppId()
	*/
	public String getAppId() {
		return properties.getProperty(Constants.AppId);
	}

	/* (non-Javadoc)
	* @see com.microsoft.hsg.android.HealthVaultSettings#setAuthenticationSecret(java.lang.String)
	*/
	public void setAuthenticationSecret(String secret) {
		properties.setProperty(Constants.AuthenticationSecret, secret);
	}

	/* (non-Javadoc)
	* @see com.microsoft.hsg.android.HealthVaultSettings#getConnectionStatus()
	*/
	public HealthVaultService.ConnectionStatus getConnectionStatus()
	{
		if (properties.containsKey(Constants.ConnectionStatus)) {
			return HealthVaultService.ConnectionStatus.Connected;
		} else {
			return HealthVaultService.ConnectionStatus.NotConnected;
		}
	}

	/* (non-Javadoc)
	* @see com.microsoft.hsg.android.HealthVaultSettings#setConnectionStatus(com.microsoft.hsg.android.HealthVaultService.ConnectionStatus)
	*/
	public void setConnectionStatus(HealthVaultService.ConnectionStatus status) {
		if (status == HealthVaultService.ConnectionStatus.Connected) {
			properties.setProperty(Constants.ConnectionStatus, "true");
		} else {
			properties.remove(Constants.ConnectionStatus);
		}
	}

	public boolean getIsMRA() {
		return Boolean.valueOf(properties.getProperty(Constants.IsMRA));
	}
	
	public void setIsMRA(boolean isMRA) {
		properties.setProperty(Constants.IsMRA, String.valueOf(isMRA));
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
		FileOutputStream os = null;
		try {
			os = ctx.openFileOutput(Constants.SettingProperties, Context.MODE_PRIVATE);
			properties.save(os, Constants.Setting);
		} catch (Exception e) {
			Log.e("Save", "Error saving to file ", e);
		}
		finally {
			if(os != null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
