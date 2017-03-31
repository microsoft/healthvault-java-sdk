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

package com.microsoft.hsg;

/**
 * The Class Request.
 */
public class Request 
{
    private String info = "<info/>";
    private String methodName;
    private String recordId;
    private String methodVersion = "1";
    private String userAuthToken;
    private String offlineUserId;
    private int ttl = 180000;
    private String finalXsl;
    private String country = "US";
    private String language = "en";
      
	/**
	 * Gets the info.
	 * 
	 * @return the info
	 */
	public String getInfo()
	{
		return info;
	}
	
	/**
	 * Sets the info.
	 * 
	 * @param info the new info
	 */
	public void setInfo(String info)
	{
		this.info = info;
	}
	
	/**
	 * Gets the method name.
	 * 
	 * @return the method name
	 */
	public String getMethodName()
	{
		return methodName;
	}
	
	/**
	 * Sets the method name.
	 * 
	 * @param methodName the new method name
	 */
	public void setMethodName(String methodName)
	{
		this.methodName = methodName;
	}
	
	/**
	 * Gets the method version.
	 * 
	 * @return the method version
	 */
	public String getMethodVersion()
	{
		return methodVersion;
	}
	
	/**
	 * Sets the method version.
	 * 
	 * @param methodVersion the new method version
	 */
	public void setMethodVersion(String methodVersion)
	{
		this.methodVersion = methodVersion;
	}
	
	/**
	 * Gets the record id.
	 * 
	 * @return the record id
	 */
	public String getRecordId()
	{
		return recordId;
	}
	
	/**
	 * Sets the record id.
	 * 
	 * @param recordId the new record id
	 */
	public void setRecordId(String recordId)
	{
		this.recordId = recordId;
	}
	
	/**
	 * Gets the user auth token.
	 * 
	 * @return the user auth token
	 */
	public String getUserAuthToken()
	{
		return userAuthToken;
	}
	
	/**
	 * Sets the user auth token.
	 * 
	 * @param userAuthToken the new user auth token
	 */
	public void setUserAuthToken(String userAuthToken)
	{
		this.userAuthToken = userAuthToken;
	}
	
	/**
	 * Gets the ttl.
	 * 
	 * @return the ttl
	 */
	public int getTtl()
	{
		return ttl;
	}
	
	/**
	 * Sets the ttl.
	 * 
	 * @param ttl the new ttl
	 */
	public void setTtl(int ttl)
	{
		this.ttl = ttl;
	}

	/**
	 * Gets the offline user id.
	 * 
	 * @return the offline user id
	 */
	public String getOfflineUserId() {
		return offlineUserId;
	}

	/**
	 * Sets the offline user id.
	 * 
	 * @param offlineUserId the new offline user id
	 */
	public void setOfflineUserId(String offlineUserId) {
		this.offlineUserId = offlineUserId;
	}

	/**
	 * Gets the final xsl.
	 *
	 * @return the final xsl
	 */
	public String getFinalXsl() {
		return finalXsl;
	}

	/**
	 * Sets the final xsl.
	 *
	 * @param finalXsl the new final xsl
	 */
	public void setFinalXsl(String finalXsl) {
		this.finalXsl = finalXsl;
	}

	/**
	 * Gets the country.
	 *
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Sets the country.
	 *
	 * @param country the new country
	 */
	public void setCountry(String country) {
		if (country == null) {
			throw new IllegalArgumentException("country cannot be null");
		}
		this.country = country;
	}

	/**
	 * Gets the language.
	 *
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * Sets the language.
	 *
	 * @param language the new language
	 */
	public void setLanguage(String language) {
		if (language == null) {
			throw new IllegalArgumentException("language cannot be null");
		}
		this.language = language;
	}	
}
