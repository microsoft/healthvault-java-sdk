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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author robmay
 *
 */
public class UnsecuredSimpleActions implements RequestHandler {

	/* (non-Javadoc)
	 * @see com.microsoft.hsg.applications.RequestHandler#processRequest(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public String processRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception
	{
		String pathInfo = request.getPathInfo();
		String servletPath = request.getContextPath() + request.getServletPath();
		
		String view = null;
		
		HttpSession session = request.getSession();
		
		if (pathInfo.equals("/signout")) {
			session.setAttribute(Constants.PERSON_INFO_KEY, null);
			ShellUtils.logout(request, response, request.getContextPath());
		} else if (pathInfo.equals("/new")) {
			ShellUtils.appAuth(request, response, servletPath + "/home");
		} else if (pathInfo.equals("/create")) {
			ShellUtils.createAccount(request, response, servletPath + "/home");
		} else if (pathInfo.equals("/createrecord")) {
			ShellUtils.CreateRecord(request, response, servletPath + "/home");
		} else if (pathInfo.equals("/failure")) {
			view = "/WEB-INF/failure.jsp";
		} else if (pathInfo.equals("/help")) {
			view =  "/WEB-INF/help.jsp";
		} else if (pathInfo.equals("/privacy")) {
			view = "/WEB-INF/privacy.jsp";
		} else if (pathInfo.equals("/service")) {
			view = "/WEB-INF/service.jsp";
		} else {
			view = "/WEB-INF/failure.jsp";
		}
		
		return view;
	}

	public boolean isAuthenticationRequired() {
		return false;
	}
	
	

}
