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

import java.net.URI;

// TODO: Auto-generated Javadoc
/**
 * The Interface HealthVaultSettings.
 */
public interface HealthVaultSettings {

	
	/**
	 * Returns whether or not this application is configured
	 * in multiple HealthVault instances.
	 * @return
	 */
	public boolean getIsMultiInstanceAware();
	
	/**
	 * Set whether or not this application is configured
	 * in multiple HealthVault instances.  
	 * @param isAware
	 */
	public void setIsMultiInstanceAware(boolean isAware);
	
    /**
     * Gets the service url.
     * 
     * @return the service url
     */
    public String getServiceUrl();
    
    /**
     * Sets the service url.
     * 
     * @param url the new service url
     */
    public void setServiceUrl(String url);
    
    /**
     * Gets the shell url.
     * 
     * @return the shell url
     */
    public String getShellUrl();
    
    /**
     * Sets the shell url.
     * 
     * @param url the new shell url
     */
    public void setShellUrl(String url);

    /**
     * Gets the app id.
     * 
     * @return the app id
     */
    public String getAppId();
    
    /**
     * Sets the app id.
     */
    public void setAppId(String appid);
    
    /**
     * Gets the master app id.
     * 
     * @return the master app id
     */
    public String getMasterAppId();
    
    /**
     * Sets the master app id.
     * 
     * @param appId the new master app id
     */
    public void setMasterAppId(String appId);
    
    /**
     * Gets the authentication secret.
     * 
     * @return the authentication secret
     */
    public String getAuthenticationSecret();
    
    /**
     * Sets the authentication secret.
     * 
     * @param secret the new authentication secret
     */
    public void setAuthenticationSecret(String secret);
    
    /**
     * Gets the connection status.
     * 
     * @return the connection status
     */
    public HealthVaultApp.ConnectionStatus getConnectionStatus();
    
    /**
     * Sets the connection status.
     * 
     * @param status the new connection status
     */
    public void setConnectionStatus(HealthVaultApp.ConnectionStatus status);
    
    public boolean getIsMRA();
	
	public void setIsMRA(boolean isAware);
	
	public void setAuthorizedRecordsResponse(String response);
	
	public String getAuthorizedRecordsResponse();
	
    /**
     * Save.
     */
    public void save();
    
    /**
     * Clear.
     */
    public void clear();
}
