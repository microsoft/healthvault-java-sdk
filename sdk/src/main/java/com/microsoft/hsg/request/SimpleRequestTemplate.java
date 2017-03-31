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

package com.microsoft.hsg.request;


import java.io.InputStream;

import com.microsoft.hsg.Connection;
import com.microsoft.hsg.ConnectionFactory;
import com.microsoft.hsg.HVAccessor;
import com.microsoft.hsg.HVException;
import com.microsoft.hsg.Request;


/**
 * This RequestTemplate fills in the details to call HealthVault
 * and receive the response.  Offline means the user is not logged in and
 * we do not have access to the user token.  Fill in the user
 * id, their record, and make the call.
 */
public class SimpleRequestTemplate implements RequestTemplate
{
	
	/** The user auth token. */
	private String userAuthToken;
	
	/** The person id. */
	private String personId;
	
	/** The record id. */
	private String recordId;
	
	/** The connection. */
	private Connection connection;

	/**
	 * Instantiates a new offline request template.
	 */
	public SimpleRequestTemplate(Connection connection)
	{
		this(connection, null, null);
	}
	
	/**
	 * Instantiates a new request template.
	 * 
	 * @param personId the person id
	 * @param recordId the record id
	 */
	public SimpleRequestTemplate(
			Connection connection,
			String personId,
			String recordId)
	{
		this.recordId = recordId;
		this.personId = personId;
		this.connection = connection;
	}
	
	/**
	 * Gets the user auth token.
	 * 
	 * @return the user auth token
	 */
	public String getUserAuthToken() {
		return userAuthToken;
	}

	/**
	 * Sets the user auth token.
	 * 
	 * @param userAuthToken the new user auth token
	 */
	public void setUserAuthToken(String userAuthToken) {
		this.userAuthToken = userAuthToken;
	}
	
	/**
	 * Sets the person id.
	 * 
	 * @param personId the new person id
	 */
	public void setPersonId(String personId)
	{
		this.personId = personId;
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
	 * Sets the connection.
	 * 
	 * @param connection the new connection
	 */
	public void setConnection(Connection connection)
	{
		this.connection = connection;
	}
	
	/* (non-Javadoc)
	 * @see hvsample.RequestTemplate#makeRequest(com.microsoft.hsg.Request)
	 */
	public void makeRequest(Request request)
	{
        makeRequest(request, new RequestMarshaller(){
			public Object marshal(InputStream is){return null;}});
	}
	
	/* (non-Javadoc)
	 * @see hvsample.RequestTemplate#makeRequest(com.microsoft.hsg.Request, hvsample.things.Marshaller)
	 */
	public Object makeRequest(Request request, RequestMarshaller marshaller)
	{
		request.setTtl(3600 * 8 + 300); 
		if (personId != null) request.setOfflineUserId(personId);
		if (recordId != null) request.setRecordId(recordId);
		if (userAuthToken != null) request.setUserAuthToken(userAuthToken);
		
		HVAccessor accessor = new HVAccessor();
		accessor.send(request, connection);
		
		try
		{
			InputStream istream = accessor.getResponse().getInputStream();
			try
			{
				return marshaller.marshal(istream);
			}
			finally
			{
				istream.close();
			}
		}
		catch(HVException e)
		{
			throw e;
		}
		catch(Exception e)
		{
			//TODO: need exception translator
			throw new HVException("Could not marshal response", e);
		}	
		
	}
}
