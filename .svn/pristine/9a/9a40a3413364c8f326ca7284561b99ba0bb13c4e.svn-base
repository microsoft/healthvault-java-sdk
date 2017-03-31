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
package com.microsoft.hsg.applications;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.microsoft.hsg.HVAccessDeniedException;
import com.microsoft.hsg.applications.weight.WeightPage;

/**
 * The Class Controller. This controller receives requests for all pages
 * requiring a HealthVault login.
 */
public class Controller extends HttpServlet {

	/** The page map. */
	private static Map pageMap;
	static {
		pageMap = new HashMap();
		pageMap.put("/weight", WeightPage.class);
		pageMap.put("/signout", UnsecuredSimpleActions.class);
		pageMap.put("/new", UnsecuredSimpleActions.class);
		pageMap.put("/create", UnsecuredSimpleActions.class);
		pageMap.put("/createrecord", UnsecuredSimpleActions.class);
		pageMap.put("/failure", UnsecuredSimpleActions.class);
		pageMap.put("/help", UnsecuredSimpleActions.class);
		pageMap.put("/privacy", UnsecuredSimpleActions.class);
		pageMap.put("/service", UnsecuredSimpleActions.class);
		pageMap.put("/home", SecuredSimpleActions.class);
	}
	
	
	private static RequestHandler DefaultHandler = new DefaultHandler();

	/**
	 * Handle all http requests here.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * 
	 * @throws ServletException
	 *             the servlet exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		try {
			try {
                HttpSession session = request.getSession();
                PersonInfo personInfo = (PersonInfo)session.getAttribute(Constants.PERSON_INFO_KEY);
                RequestCtx.setPersonInfo(personInfo);

			    RequestHandler handler = DefaultHandler;
				
				Class clazz = (Class) pageMap.get(request.getPathInfo());
				if (clazz != null) 
				{
					handler = (RequestHandler) clazz.newInstance();
				}
				
				if (handler.isAuthenticationRequired())
				{
				if ( personInfo == null ) 
					{
						ShellUtils.login(
								request, 
								response, 
								request.getContextPath() +
									request.getServletPath() +
									request.getPathInfo() +
									"?" +
									(request.getQueryString() == null
										? "" 
										: request.getQueryString()));
					}
				}
				
				showView(request, response, handler.processRequest(request, response));
				
			} catch (HVAccessDeniedException axdenied) {
				ShellUtils.login(request, response, "things/home");
			} catch (Exception e) {
				throw new ServletException(e);
			}
		} finally {
			RequestCtx.setPersonInfo(null);
		}
	}

	/**
	 * Show view.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @param viewName
	 *            the view name
	 * 
	 * @throws ServletException
	 *             the servlet exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private void showView(HttpServletRequest request,
			HttpServletResponse response, String viewName)
			throws ServletException, IOException {
		if (viewName != null)
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewName);
			dispatcher.forward(request, response);
		}
	}
	
	private static class DefaultHandler implements RequestHandler
	{
		public String processRequest(HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			return "/index.jsp";
		}

		public boolean isAuthenticationRequired() {
			return false;
		}
		
		
	}

}
