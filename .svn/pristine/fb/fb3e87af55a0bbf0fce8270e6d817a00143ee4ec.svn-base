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
package com.microsoft.hsg;

import java.io.InputStream;

/**
 * The HVAccessor is a convenience class for sending requests
 * to HealthVault and receiving the responses.  Most of the details are 
 * hidden from the user. The sequence goes like this:
 * <pre>
 * Request request = new Request();
 * <populate request here>
 * Connection con = ConnectionFactory.getConnection();
 * HVAccessor accessor = new HVAccessor();
 * accessor.send(request, con);
 * Response response = accessor.getResponse();
 * </pre>
 */
public class HVAccessor
{
	private Request request;
	private Response response;
	private Connection connection;
	private SendStrategy sendStrategy;
	private ResponseStrategy responseStrategy;
	
	/**
	 * Instantiates a new hV accessor.
	 */
	public HVAccessor()
	{
		sendStrategy = new DefaultSendStrategy();
		responseStrategy = new DefaultResponseStrategy();
	}
	
	/**
	 * Gets the response strategy.
	 * 
	 * @return the response strategy
	 */
	public ResponseStrategy getResponseStrategy()
	{
		return responseStrategy;
	}
	
	/**
	 * Sets the response strategy.
	 * 
	 * @param responseStrategy the new response strategy
	 */
	public void setResponseStrategy(ResponseStrategy responseStrategy)
	{
		this.responseStrategy = responseStrategy;
	}
	
	/**
	 * Gets the send strategy.
	 * 
	 * @return the send strategy
	 */
	public SendStrategy getSendStrategy()
	{
		return sendStrategy;
	}
	
	/**
	 * Sets the send strategy.
	 * 
	 * @param sendStrategy the new send strategy
	 */
	public void setSendStrategy(SendStrategy sendStrategy)
	{
		this.sendStrategy = sendStrategy;
	}
	
	/**
	 * Send.
	 * 
	 * @param request the request
	 * @param connection the connection
	 */
	public void send(final Request request, final Connection connection)
	{
		response = new Response();
		sendStrategy.doWithSender( connection, new Sender() {
			public void send() {
				connection.send(request, new ResponseHandler() {
					public void handleResponse(InputStream istream) {
						response.setInputStream(istream);
						responseStrategy.doWithResponse(response);
					}
				});
				
			}
		});	
	}
	
	/**
	 * Gets the response.
	 * 
	 * @return the response
	 */
	public Response getResponse()
	{
		return response;
	}
	
}
