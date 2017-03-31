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
import java.io.InputStream;
import java.net.URLDecoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.apache.log4j.Logger;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

import com.microsoft.hsg.ApplicationConfig;
import com.microsoft.hsg.ConnectionFactory;
import com.microsoft.hsg.HVAccessor;
import com.microsoft.hsg.HVException;
import com.microsoft.hsg.Request;
import com.microsoft.hsg.applications.Constants;

/**
 * Handle all redirects from HealthVault.
 */
public class HealthVaultActionPage extends HttpServlet {
	Logger logger = Logger.getLogger("HealthVaultActionPage");

	/** the constant request parameter fields */
	public static final String APP_TARGET = "target";
	public static final String APP_ACTIONQS = "actionqs";

	@SuppressWarnings("deprecation")
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String target = request.getParameter(APP_TARGET);
		String actionqs = request.getParameter(APP_ACTIONQS);
		if (actionqs != null && actionqs != "") 
		{
			actionqs = URLDecoder.decode(actionqs);
		}
		else
		{
			actionqs = "/";
		}
		
		if ("APPAUTHINVALIDRECORD".equalsIgnoreCase(target)) {
			OnActionAppAuthInvalidRecord(request, response, actionqs);
		} else if ("APPAUTHREJECT".equalsIgnoreCase(target)) {
			OnActionAppAuthReject(request, response, actionqs);
		} else if ("APPAUTHSUCCESS".equalsIgnoreCase(target)) {
			OnActionAppAuthSuccess(request, response, actionqs);
		} else if ("HELP".equalsIgnoreCase(target)) {
			OnActionHelp(request, response, actionqs);
		} else if ("HOME".equalsIgnoreCase(target)) {
			OnActionHome(request, response, actionqs);
		} else if ("PRIVACY".equalsIgnoreCase(target)) {
			OnActionPrivacy(request, response, actionqs);
		} else if ("RECONCILECANCELED".equalsIgnoreCase(target)) {
			OnActionReconcileCancelled(request, response, actionqs);
		} else if ("RECONCILECOMPLETE".equalsIgnoreCase(target)) {
			OnActionReconcileComplete(request, response, actionqs);
		} else if ("RECONCILEFAILURE".equalsIgnoreCase(target)) {
			OnActionReconcileFailure(request, response, actionqs);
		} else if ("SELECTEDRECORDCHANGED".equalsIgnoreCase(target)) {
			OnActionSelectedRecordChanged(request, response, actionqs);
		} else if ("SERVICEAGREEMENT".equalsIgnoreCase(target)) {
			OnActionServiceAgreement(request, response, actionqs);
		} else if ("SHARERECORDFAILED".equalsIgnoreCase(target)) {
			OnActionShareRecordFailed(request, response, actionqs);
		} else if ("SHARERECORDSUCCESS".equalsIgnoreCase(target)) {
			OnActionShareRecordSucceeded(request, response, actionqs);
		} else if ("SIGNOUT".equalsIgnoreCase(target)) {
			OnActionSignOut(request, response, actionqs);
		} else {
			OnActionUnknown(request, response, actionqs);
		}

	}

	protected void OnActionAppAuthInvalidRecord(HttpServletRequest request,
			HttpServletResponse response, String actionqs)
			throws ServletException, IOException {
		forward(request, response, actionqs);
	}

	// Called on a auth request rejected
	protected void OnActionAppAuthReject(HttpServletRequest request,
			HttpServletResponse response, String actionqs)
			throws ServletException, IOException {
		forward(request, response, actionqs);
	}

	/**
	 * Called on a successful logon.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 */
	protected void OnActionAppAuthSuccess(HttpServletRequest request,
			HttpServletResponse response, String actionqs)
			throws ServletException, IOException {
		loginSuccess( request, response);
		forward(request, response, actionqs);
	}

	protected void OnActionCreateRecordReject(HttpServletRequest request,
			HttpServletResponse response, String actionqs)
			throws ServletException, IOException {
		forward(request, response, actionqs);
	}

	protected void OnActionCreateRecordSuccess(HttpServletRequest request,
			HttpServletResponse response, String actionqs)
			throws ServletException, IOException {
		loginSuccess( request, response);
		forward(request, response, actionqs);
	}

	protected void OnActionHelp(HttpServletRequest request,
			HttpServletResponse response, String actionqs)
			throws ServletException, IOException {
		forward(request, response, actionqs);

	}

	protected void OnActionHome(HttpServletRequest request,
			HttpServletResponse response, String actionqs)
			throws ServletException, IOException {
		forward(request, response, actionqs);

	}

	protected void OnActionPrivacy(HttpServletRequest request,
			HttpServletResponse response, String actionqs)
			throws ServletException, IOException {
		forward(request, response, actionqs);

	}

	protected void OnActionReconcileCancelled(HttpServletRequest request,
			HttpServletResponse response, String actionqs) {
		// TODO
	}

	protected void OnActionReconcileComplete(HttpServletRequest request,
			HttpServletResponse response, String actionqs) {
		// TODO
	}

	protected void OnActionReconcileFailure(HttpServletRequest request,
			HttpServletResponse response, String actionqs) {
		// TODO
	}

	protected void OnActionSelectedRecordChanged(HttpServletRequest request,
			HttpServletResponse response, String actionqs)
			throws ServletException, IOException {
		loginSuccess( request, response);
		forward(request, response, actionqs);
	}

	protected void OnActionServiceAgreement(HttpServletRequest request,
			HttpServletResponse response, String actionqs)
			throws ServletException, IOException {
		forward(request, response, actionqs);
	}

	protected void OnActionShareRecordFailed(HttpServletRequest request,
			HttpServletResponse response, String actionqs)
			throws ServletException, IOException {
		forward(request, response, actionqs);
	}

	protected void OnActionShareRecordSucceeded(HttpServletRequest request,
			HttpServletResponse response, String actionqs)
			throws ServletException, IOException {
		forward(request, response, actionqs);
	}

	protected void OnActionSignOut(HttpServletRequest request,
			HttpServletResponse response, String actionqs)
			throws ServletException, IOException {
		forward(request, response, actionqs);
	}

	protected void OnActionUnknown(HttpServletRequest request,
			HttpServletResponse response, String actionqs)
			throws ServletException, IOException {
		forward(request, response, actionqs);
	}

	private void forward(HttpServletRequest request,
			HttpServletResponse response, String actionqs)
			throws ServletException, IOException {
		//RequestDispatcher dispatcher = request.getRequestDispatcher(actionqs);
		//dispatcher.forward(request, response);
		response.sendRedirect(actionqs);
	}

	private PersonInfo loginSuccess(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String authToken = (String) request.getParameter(Constants.TOKEN_NAME);
		String instanceId = (String) request.getParameter(Constants.INSTANCE_ID);
		if (authToken != null) {
			PersonInfo personInfo = HealthVaultActionPage
					.getSelectedRecordAndPerson(authToken, instanceId);

			HttpSession session = request.getSession();
			session.setAttribute(Constants.PERSON_INFO_KEY, personInfo);
			return personInfo;
		}
		return null;
	}

	public static PersonInfo getSelectedRecordAndPerson(
	        String userAuthToken,
	        String instanceId)
			throws HVException {
		try {
			Request request = new Request();
			request.setTtl(3600 * 8 + 300);
			request.setMethodName("GetPersonInfo");
			request.setUserAuthToken(userAuthToken);
			HVAccessor accessor = new HVAccessor();
			accessor.send(
			        request, 
			        ConnectionFactory.getConnectionForInstance(
			                ApplicationConfig.APP_ID,
			                instanceId));
			InputStream is = accessor.getResponse().getInputStream();

			XPath xpath = XPathFactory.newInstance().newXPath();
			PersonInfo person = new PersonInfo();
			person.setUserAuthToken(userAuthToken);
			Node personInfo = (Node) xpath.evaluate("//person-info",
					new InputSource(is), XPathConstants.NODE);
			person.setPersonId(xpath.evaluate("person-id", personInfo));
			person.setPersonName(xpath.evaluate("name", personInfo));
			person.setRecordId(xpath.evaluate("record/@id", personInfo));
			person.setRecordName(xpath.evaluate("record", personInfo));
			person.setInstanceId(instanceId);
			
			is.close();
			
			return person;
		} catch (HVException he) {
			throw he;
		} catch (Exception e) {
			throw new HVException(e);
		}
	}
}
