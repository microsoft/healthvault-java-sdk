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

package com.microsoft.healthvault;

import org.joda.time.DateTime;

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
	 * Gets the rest url.
	 *
	 * @return the rest url
	 */
	public String getRestUrl();

	/**
	 * Sets the rest url.
	 *
	 * @param url the new rest url
	 */
	public void setRestUrl(String url);

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

	public void setSessionExpiration();

	public DateTime getSessionExpiration();

	public boolean isSessionExpiraed();
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
