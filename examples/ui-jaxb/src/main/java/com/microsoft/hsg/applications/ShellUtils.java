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
import java.net.URI;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.microsoft.hsg.ApplicationConfig;
import com.microsoft.hsg.HVException;
import com.microsoft.hsg.HVInstanceResolver;
import com.microsoft.hsg.ShellUrlBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class ShellUtils.
 */
public class ShellUtils {

	/**
	 * Login.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @param returnUrl
	 *            the Url in the app where this should return
	 * @throws ServletException
	 *             the servlet exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static void login(HttpServletRequest request,
			HttpServletResponse response, String returnUrl)
			throws ServletException, IOException {
		sendShellTarget(request, response, "AUTH", returnUrl);
	}

	/**
	 * Logout.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @param returnUrl
	 *            the Url in the app where this should return
	 * 
	 * @throws ServletException
	 *             the servlet exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static void logout(HttpServletRequest request,
			HttpServletResponse response, String returnUrl)
			throws ServletException, IOException {
		sendShellTarget(request, response, "APPSIGNOUT", returnUrl);
	}

	/**
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
	public static void appAuth(HttpServletRequest request,
			HttpServletResponse response, String returnUrl)
			throws ServletException, IOException {
		sendShellTarget(request, response, "APPAUTH", returnUrl);
	}

	/**
	 * Login and Create.
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
	public static void createAccount(HttpServletRequest request,
			HttpServletResponse response, String returnUrl)
			throws ServletException, IOException {
		sendShellTarget(request, response, "CREATEACCOUNT", returnUrl);
	}

	/**
	 * Login and Create Record.
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
	public static void CreateRecord(HttpServletRequest request,
			HttpServletResponse response, String returnUrl)
			throws ServletException, IOException {
		sendShellTarget(request, response, "CREATERECORD", returnUrl);
	}
	
	/**
	 * Send shell target.
	 * 
	 * @param request the request
	 * @param response the response
	 * @param target the target
	 * @param returnUrl the return url
	 * 
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@SuppressWarnings("deprecation")
	public static void sendShellTarget(HttpServletRequest request,
			HttpServletResponse response, String target, String returnUrl)
			throws ServletException, IOException {
		
	    PersonInfo personInfo = RequestCtx.getPersonInfo();
	    
	    ShellUrlBuilder shellUrl = new ShellUrlBuilder();
	    shellUrl.setAllowInstanceBounce(true);
	    shellUrl.setAppId(ApplicationConfig.APP_ID);
	    shellUrl.setTarget(target);
	    if (personInfo != null) {
	        shellUrl.setShellInstance(personInfo.getInstanceId());
	    }
	    
		if (Config.RedirectUrl != null
				&& Config.RedirectUrl.trim().length() != 0) {
		    StringBuilder returnUrlBuilder = new StringBuilder();
			returnUrlBuilder.append(request.getScheme());
			returnUrlBuilder.append("://");
			returnUrlBuilder.append(request.getServerName());
			returnUrlBuilder.append(":");
			returnUrlBuilder.append(request.getServerPort());
			returnUrlBuilder.append(request.getContextPath());
			returnUrlBuilder.append(Config.RedirectUrl);
			
			try
			{
			    shellUrl.setReturnUrlOverride(new URI(returnUrlBuilder.toString()));
			}
			catch (Exception e)
			{
			    throw new HVException(e);
			}
		}
		
		shellUrl.setActionqs(returnUrl);
		
		response.sendRedirect(shellUrl.toString());
	}
}
