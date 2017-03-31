/*
 * (c) Copyright Microsoft Corporation. 
 * This source is subject to the Microsoft Public License.
 * See http://www.microsoft.com/opensource/licenses.mspx#Ms-PL       
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
					public void handleResponse(InputStream is) {
						response.setInputStream(is);
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
