/*
 * (c) Copyright Microsoft Corporation. 
 * This source is subject to the Microsoft Public License.
 * See http://www.microsoft.com/opensource/licenses.mspx#Ms-PL       
 */
package com.microsoft.hsg.applications;

import java.io.InputStream;

import com.microsoft.hsg.Connection;
import com.microsoft.hsg.ConnectionFactory;
import com.microsoft.hsg.HVAccessor;
import com.microsoft.hsg.HVException;
import com.microsoft.hsg.Request;

/**
 * This RequestTemplate fills in the details to call HealthVault
 * and receive the response.  Online means the user is logged in and
 * we have access to the user token from the session.  Fill in the user
 * token, their record, and make the call.
 */
public class OnlineRequestTemplate
{
	
	/** The connection. */
	Connection connection;

	/**
	 * Instantiates a new request template.
	 * 
	 * @param connection the connection
	 */
	public OnlineRequestTemplate(Connection connection)
	{
		this.connection = connection;
	}
	
	/**
	 * Make request.
	 * 
	 * @param request the request
	 */
	public void makeRequest(Request request)
	{
        makeRequest(request, new Marshaller(){
			public Object marshal(InputStream is){return null;}});
	}
	
	/**
	 * Make request.
	 * 
	 * @param request the request
	 * @param marshaller the marshaller
	 * 
	 * @return the object
	 */
	public Object makeRequest(Request request, Marshaller marshaller)
	{
		PersonInfo personInfo = RequestCtx.getPersonInfo();
		
		request.setTtl(3600 * 8 + 300);  
		request.setUserAuthToken(personInfo.getUserAuthToken());
		request.setRecordId(personInfo.getRecordId());
		
		HVAccessor accessor = new HVAccessor();
		accessor.send(request, ConnectionFactory.getConnection());
		
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
