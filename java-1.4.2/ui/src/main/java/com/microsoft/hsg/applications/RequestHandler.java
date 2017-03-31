/*
 * (c) Copyright Microsoft Corporation. 
 * This source is subject to the Microsoft Public License.
 * See http://www.microsoft.com/opensource/licenses.mspx#Ms-PL       
 */
package com.microsoft.hsg.applications;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The Interface RequestHandler.  Request handlers service requests
 * for a page.
 */
public interface RequestHandler {

		/**
		 * Process request.
		 * 
		 * @param request the request
		 * @param resonse the response
		 * 
		 * @throws Exception the exception
		 */
		public void processRequest(HttpServletRequest request,
				HttpServletResponse response)
		throws Exception;
}
