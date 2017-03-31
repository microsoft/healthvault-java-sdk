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
package com.microsoft.hsg.applications.weight;

import java.io.InputStream;

import org.apache.wicket.Session;

import com.microsoft.hsg.Connection;
import com.microsoft.hsg.ConnectionFactory;
import com.microsoft.hsg.HVAccessor;
import com.microsoft.hsg.HVException;
import com.microsoft.hsg.Request;

public class RequestTemplate
{
	Connection connection;

	public RequestTemplate(Connection connection)
	{
		this.connection = connection;
	}
	
	public Integer makeRequest(Request request)
	{
		return makeRequest(request, new Marshaller<Integer>(){
			public Integer marshal(InputStream is){return 0;}});
	}
	
	public <T> T makeRequest(Request request, Marshaller<T> marshaller)
	{
		HVSession session = (HVSession)Session.get();
		PersonInfo personInfo = session.getPersonInfo();
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
