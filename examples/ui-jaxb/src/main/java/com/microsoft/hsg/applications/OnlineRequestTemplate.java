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
