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
package com.microsoft.hsg.android.simplexml;

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
    public HealthVaultFileSettings(Context ctx)
    {
        this.ctx = ctx.getApplicationContext();
        
        try
        {
            properties = new Properties();
            try
            {
                properties.load(ctx.openFileInput("settings.props"));
            }
            catch(FileNotFoundException fnfe)
            {
            }
        }
        catch(IOException ioe)
        {
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
    public HealthVaultApp.ConnectionStatus getConnectionStatus()
    {
        if (properties.containsKey("connected")) {
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
            properties.setProperty("connected", "true");
        } else {
        	properties.remove("connected");
        }
    }
    
    public boolean getIsMRA() {
		return Boolean.valueOf(properties.getProperty("is-mra"));
	}
	
	public void setIsMRA(boolean isMRA) {
		properties.setProperty("is-mra", String.valueOf(isMRA));
	}
	
	public String getAuthorizedRecordsResponse() {
		return properties.getProperty("authorized-records-response");
	}
	
	public void setAuthorizedRecordsResponse(String response) {
		properties.setProperty("authorized-records-response", response);
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
            properties.save(
                ctx.openFileOutput(
                    "settings.props", 
                    Context.MODE_PRIVATE), 
                "settings");
        }
        catch (Exception e)
        {
        }
    }

}
