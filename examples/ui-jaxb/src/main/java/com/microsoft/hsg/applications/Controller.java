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
