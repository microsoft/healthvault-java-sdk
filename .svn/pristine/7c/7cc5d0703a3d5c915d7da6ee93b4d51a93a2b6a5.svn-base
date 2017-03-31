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
