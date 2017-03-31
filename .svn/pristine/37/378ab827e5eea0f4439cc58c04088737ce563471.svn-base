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
