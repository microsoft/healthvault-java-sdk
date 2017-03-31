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
