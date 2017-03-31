/*
 * (c) Copyright Microsoft Corporation. 
 * This source is subject to the Microsoft Public License.
 * See http://www.microsoft.com/opensource/licenses.mspx#Ms-PL       
 */
package com.microsoft.hsg.applications.weight;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.microsoft.hsg.ConnectionFactory;
import com.microsoft.hsg.applications.*;
import com.microsoft.hsg.things.ThingProvider;
import com.microsoft.hsg.things.Weight;

/**
 * The Class WeightPage.
 */
public class WeightPage implements RequestHandler {
	
	/** The Constant WEIGHT_INPUT. */
	private static final String WEIGHT_INPUT = "weight";
	
	/** The WEIGH t_ page. */
	private static String WEIGHT_PAGE = "/weight.jsp";

	/* (non-Javadoc)
	 * @see com.microsoft.hsg.applications.RequestHandler#processRequest(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void processRequest(HttpServletRequest request,
			HttpServletResponse response)
	throws Exception
	{
		processPost(request, response);
		displayWeight(request, response);
	}
	
	/**
	 * Process post.
	 * 
	 * @param request the request
	 * @param response the response
	 * 
	 * @throws Exception the exception
	 */
	private void processPost(HttpServletRequest request, 
			HttpServletResponse response)
	throws Exception
	{
		if (request.getMethod().equalsIgnoreCase("post"))
		{
			String input = request.getParameter(WEIGHT_INPUT);
			if (input != null && input.trim().length() > 0)
			{
				OnlineRequestTemplate requestTemplate = new OnlineRequestTemplate(ConnectionFactory.getConnection());
				ThingProvider thingProvider = new ThingProvider(requestTemplate);
				Weight weight = new Weight();
				weight.setValue(input);
				thingProvider.putThing(weight);
			}
		}
	}
	
	/**
	 * Display weight.
	 * 
	 * @param request the request
	 * @param response the response
	 * 
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void displayWeight(HttpServletRequest request, 
			HttpServletResponse response)
	throws ServletException, IOException
	{
		OnlineRequestTemplate requestTemplate = new OnlineRequestTemplate(ConnectionFactory.getConnection());
		ThingProvider thingProvider = new ThingProvider(requestTemplate);
		request.setAttribute("weights", thingProvider.getThingsByType(Weight.Type));
		RequestDispatcher dispatcher = request.getRequestDispatcher(WEIGHT_PAGE);
		dispatcher.forward(request, response);
	}
}
