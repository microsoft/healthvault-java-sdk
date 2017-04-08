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
