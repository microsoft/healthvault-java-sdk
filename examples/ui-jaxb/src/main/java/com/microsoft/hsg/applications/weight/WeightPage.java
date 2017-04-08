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

import java.io.IOException;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.microsoft.hsg.ConnectionFactory;
import com.microsoft.hsg.applications.OnlineRequestTemplate;
import com.microsoft.hsg.applications.RequestHandler;
import com.microsoft.hsg.methods.jaxb.getthings.request.GetThingsRequest;
import com.microsoft.hsg.methods.jaxb.getthings.request.ThingFilterSpec;
import com.microsoft.hsg.methods.jaxb.getthings.request.ThingFormatSpec;
import com.microsoft.hsg.methods.jaxb.getthings.request.ThingRequestGroup;
import com.microsoft.hsg.methods.jaxb.getthings.request.ThingSectionSpec;
import com.microsoft.hsg.methods.jaxb.getthings.response.GetThingsResponse;
import com.microsoft.hsg.methods.jaxb.putthings.request.PutThingsRequest;
import com.microsoft.hsg.thing.oxm.jaxb.base.DisplayValue;
import com.microsoft.hsg.thing.oxm.jaxb.base.WeightValue;
import com.microsoft.hsg.thing.oxm.jaxb.dates.Date;
import com.microsoft.hsg.thing.oxm.jaxb.dates.DateTime;
import com.microsoft.hsg.thing.oxm.jaxb.dates.Time;
import com.microsoft.hsg.thing.oxm.jaxb.thing.Thing;
import com.microsoft.hsg.thing.oxm.jaxb.thing.ThingType;
import com.microsoft.hsg.thing.oxm.jaxb.weight.Weight;

/**
 * The Class WeightPage.
 */
public class WeightPage implements RequestHandler {
	
	/** The Constant WEIGHT_INPUT. */
	private static final String WEIGHT_INPUT = "weight";
	
	/** The WEIGH t_ page. */
	private static String WEIGHT_PAGE = "/WEB-INF/weight.jsp";

	/* (non-Javadoc)
	 * @see com.microsoft.hsg.applications.RequestHandler#processRequest(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public String processRequest(HttpServletRequest request,
			HttpServletResponse response)
	throws Exception
	{
		if (request.getMethod().equalsIgnoreCase("post"))
        {
			processPost(request, response);
        }
		displayWeight(request, response);
		return WEIGHT_PAGE;
	}
	
	public boolean isAuthenticationRequired() {
		return true;
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
		    	DisplayValue dv = new DisplayValue();
		    	dv.setUnits("lb");
		    	dv.setUnitsCode("lb");
		    	dv.setValue(Double.parseDouble(input));
		    	
		    	WeightValue wv = new WeightValue();
		    	wv.setKg(Double.parseDouble(input)/2.2);
		    	wv.setDisplay(dv);
		    	
		    	Weight weight = new Weight();
		    	weight.setWhen(DateTime.fromCalendar(Calendar.getInstance()));
		    	weight.setValue(wv);
		    	
		    	Thing thing = new Thing();
		    	thing.setData(weight);
		    	
		    	PutThingsRequest ptRequest = new PutThingsRequest();
		    	ptRequest.getThing().add(thing);
		    	
		    	OnlineRequestTemplate requestTemplate = new OnlineRequestTemplate();
		    	Object obj = requestTemplate.makeRequest(ptRequest);
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
	throws Exception
	{
		OnlineRequestTemplate requestTemplate = new OnlineRequestTemplate();
		ThingRequestGroup group = new ThingRequestGroup();
    	
    	ThingFilterSpec filter = new ThingFilterSpec();
    	filter.getTypeId().add("3d34d87e-7fc1-4153-800f-f56592cb0d17");
    	group.getFilter().add(filter);
    	group.setMax(BigInteger.valueOf(30));
    	
    	ThingFormatSpec format = new ThingFormatSpec();
    	format.getSection().add(ThingSectionSpec.CORE);
    	format.getXml().add("");
    	group.setFormat(format);    	
    	
    	GetThingsRequest info = new GetThingsRequest();
    	info.getGroup().add(group);
  
    	GetThingsResponse gtResponse = 
    		(GetThingsResponse)requestTemplate.makeRequest(info);
    	
    	List things = gtResponse.getGroup().get(0).getThing();
    	request.setAttribute("weights", things);
	}
}
