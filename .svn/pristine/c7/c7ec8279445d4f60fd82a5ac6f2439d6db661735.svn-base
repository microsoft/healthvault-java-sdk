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

import java.io.InputStream;

import com.microsoft.hsg.ApplicationConfig;
import com.microsoft.hsg.Connection;
import com.microsoft.hsg.ConnectionFactory;
import com.microsoft.hsg.HVAccessor;
import com.microsoft.hsg.HVException;
import com.microsoft.hsg.methods.jaxb.JaxbRequest;
import com.microsoft.hsg.methods.jaxb.SimpleRequestTemplate;

/**
 * This RequestTemplate fills in the details to call HealthVault
 * and receive the response.  Online means the user is logged in and
 * we have access to the user token from the session.  Fill in the user
 * token, their record, and make the call.
 */
public class OnlineRequestTemplate extends SimpleRequestTemplate
{
	
	/** The connection. */
	Connection connection;

	/**
	 * Instantiates a new request template.
	 * 
	 * @param connection the connection
	 */
	public OnlineRequestTemplate()
	{
		super(ConnectionFactory.getConnectionForInstance(
		        ApplicationConfig.APP_ID, 
		        RequestCtx.getPersonInfo().getInstanceId()));
	}
	
	/**
	 * Make request.
	 * 
	 * @param request the request
	 */
	// TODO: refine exceptions here...should be HVException
	public Object makeRequest(Object request) throws Exception {
		PersonInfo personInfo = RequestCtx.getPersonInfo();
		
		setUserAuthToken(personInfo.getUserAuthToken());
		setRecordId(personInfo.getRecordId());
		
		return super.makeRequest(request);
	}
}
