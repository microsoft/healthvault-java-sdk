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
public class SecuredSimpleActions implements RequestHandler {

	/* (non-Javadoc)
	 * @see com.microsoft.hsg.applications.RequestHandler#processRequest(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public String processRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception
	{
		String pathInfo = request.getPathInfo();
		String servletPath = request.getServletPath();
		
		String view = null;
		
		HttpSession session = request.getSession();
		
		if (pathInfo.equals("/home")) {
			view = "/WEB-INF/home.jsp";
		} else {
			view = "/WEB-INF/home.jsp";
		}
		
		return view;
	}

	public boolean isAuthenticationRequired() {
		return true;
	}
	
	

}
