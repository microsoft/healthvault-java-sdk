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

package com.microsoft.hsg.applications;

import java.io.Serializable;

/**
 * The person info class contains enough information
 * about the logged in user to access their record.
 */
public class PersonInfo implements Serializable
{
	
	/** The record id. */
	private String recordId;
	
	/** The record id. */
	private String personId;
	
	/** The record id. */
	private String personName;

	/** The record id. */
	private String recordName;

	/** An idenfier of which instance contains the persons Health Record. */
	private String instanceId;
	
	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getRecordName() {
		return recordName;
	}

	public void setRecordName(String recordName) {
		this.recordName = recordName;
	}

	/** The user auth token. */
	private String userAuthToken;
	
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

    public String getInstanceId() 
    {
        return instanceId;
    }

    public void setInstanceId(String instanceId) 
    {
        this.instanceId = instanceId;
    }
}
