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

package com.microsoft.hsg.android.simplexml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import android.content.Context;

import com.microsoft.hsg.HVSystemException;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

// TODO: Auto-generated Javadoc
/**
 * The Class HealthVaultFileSettings.
 */
public class HealthVaultFileSettings implements HealthVaultSettings {

	/** The mProperties. */
	private Properties mProperties;
	private DateTime mExperation;
	/** The ctx. */
	private Context mContext;

	/**
	 * Instantiates a new health vault file settings.
	 *
	 * @param ctx the ctx
	 */
	public HealthVaultFileSettings(Context ctx)
	{
		mContext = ctx.getApplicationContext();

		try {
			mProperties = new Properties();
			try {
				FileInputStream is = ctx.openFileInput("settings.props");
				mProperties.load(is);
				is.close();
			} catch(FileNotFoundException fnfe) {
				fnfe.printStackTrace();
			}
		} catch(IOException ioe) {
			throw new HVSystemException("Could not load mProperties.", ioe);
		}
	}

	/* (non-Javadoc)
	 * @see com.microsoft.hsg.android.HealthVaultSettings#getIsMultiInstanceAware()
	 */
	public boolean getIsMultiInstanceAware() {
		return Boolean.valueOf(mProperties.getProperty(Constants.IsMultiInstanceAware));
	}
	
	/* (non-Javadoc)
	 * @see com.microsoft.hsg.android.HealthVaultSettings#setIsMultiInstanceAware(boolean)
	 */
	public void setIsMultiInstanceAware(boolean isAware) {
		mProperties.setProperty(Constants.IsMultiInstanceAware, String.valueOf(isAware));
	}
	/* (non-Javadoc)
	 * @see com.microsoft.hsg.android.HealthVaultSettings#getAuthenticationSecret()
	 */
	public String getAuthenticationSecret() {
		return mProperties.getProperty(Constants.AuthenticationSecret);
	}

	/* (non-Javadoc)
	 * @see com.microsoft.hsg.android.HealthVaultSettings#setMasterAppId(java.lang.String)
	 */
	public void setMasterAppId(String appId) {
		mProperties.setProperty(Constants.MasterAppId, appId);
	}

	public void setSessionExpiration() {
		mExperation = DateTime.now().plusHours(4);
	}

	public DateTime getSessionExpiration() {
		return mExperation;
	}

	public boolean isSessionExpiraed() {
		return mExperation.isBeforeNow();
	}

	/* (non-Javadoc)
	 * @see com.microsoft.hsg.android.HealthVaultSettings#getMasterAppId()
	 */
	public String getMasterAppId() {
		return mProperties.getProperty(Constants.MasterAppId);
	}

	/* (non-Javadoc)
	 * @see com.microsoft.hsg.android.HealthVaultSettings#getServiceUrl()
	 */
	public String getServiceUrl() {
		return mProperties.getProperty(Constants.ServiceUrl);
	}

	/* (non-Javadoc)
	 * @see com.microsoft.hsg.android.HealthVaultSettings#setServiceUrl(java.lang.String)
	 */
	public void setServiceUrl(String url) {
		mProperties.setProperty(Constants.ServiceUrl, url);
	}

	/* (non-Javadoc)
	 * @see com.microsoft.hsg.android.HealthVaultSettings#getShellUrl()
	 */
	public String getShellUrl() {
		return mProperties.getProperty(Constants.ShellUrl);
	}

	/* (non-Javadoc)
	 * @see com.microsoft.hsg.android.HealthVaultSettings#setShellUrl(java.lang.String)
	 */
	public void setShellUrl(String url) {
		mProperties.setProperty(Constants.ShellUrl, url);
	}

	/* (non-Javadoc)
 * @see com.microsoft.hsg.android.HealthVaultSettings#getRestUrl()
 */
	public String getRestUrl() {
		return mProperties.getProperty(Constants.RestUrl);
	}

	/* (non-Javadoc)
	 * @see com.microsoft.hsg.android.HealthVaultSettings#setRestUrl(java.lang.String)
	 */
	public void setRestUrl(String url) {
		mProperties.setProperty(Constants.RestUrl, url);
	}

	/* (non-Javadoc)
	 * @see com.microsoft.hsg.android.HealthVaultSettings#setAppId(java.lang.String)
	 */
	public void setAppId(String appId) {
		mProperties.setProperty(Constants.AppId, appId);
	}

	/* (non-Javadoc)
	 * @see com.microsoft.hsg.android.HealthVaultSettings#getAppId()
	 */
	public String getAppId() {
		return mProperties.getProperty(Constants.AppId);
	}

	/* (non-Javadoc)
	 * @see com.microsoft.hsg.android.HealthVaultSettings#setAuthenticationSecret(java.lang.String)
	 */
	public void setAuthenticationSecret(String secret) {
		mProperties.setProperty(Constants.AuthenticationSecret, secret);

	}

	/* (non-Javadoc)
	 * @see com.microsoft.hsg.android.HealthVaultSettings#getConnectionStatus()
	 */
	public HealthVaultApp.ConnectionStatus getConnectionStatus()
	{
		if (mProperties.containsKey(Constants.ConnectionStatus)) {
			return HealthVaultApp.ConnectionStatus.Connected;
		}
		else {
			return HealthVaultApp.ConnectionStatus.NotConnected;
		}
	}

	/* (non-Javadoc)
	 * @see com.microsoft.hsg.android.HealthVaultSettings#setConnectionStatus(com.microsoft.hsg.android.HealthVaultService.ConnectionStatus)
	 */
	public void setConnectionStatus(HealthVaultApp.ConnectionStatus status) {
		if (status == HealthVaultApp.ConnectionStatus.Connected) {
			mProperties.setProperty(Constants.ConnectionStatus, "true");
		} else {
			mProperties.remove(Constants.ConnectionStatus);
		}
	}

	public boolean getIsMRA() {
		return Boolean.valueOf(mProperties.getProperty(Constants.IsMRA));
	}
	
	public void setIsMRA(boolean isMRA) {
		mProperties.setProperty(Constants.IsMRA, String.valueOf(isMRA));
	}
	
	public String getAuthorizedRecordsResponse() {
		return mProperties.getProperty(Constants.AuthorizedRecordsResponse);
	}
	
	public void setAuthorizedRecordsResponse(String response) {
		mProperties.setProperty(Constants.AuthorizedRecordsResponse, response);
	}

	/* (non-Javadoc)
	 * @see com.microsoft.hsg.android.HealthVaultSettings#clear()
	 */
	public void clear() {
		mProperties = new Properties();
	}

	/* (non-Javadoc)
	 * @see com.microsoft.hsg.android.HealthVaultSettings#save()
	 */
	public void save() {
		try {
			FileOutputStream os = mContext.openFileOutput("settings.props", mContext.MODE_PRIVATE);
			mProperties.save(os, "settings");
			os.close();
		} catch (Exception e) {
			throw new HVSystemException("Could not load mProperties.", e);
		}
	}
}
