/*
 * (c) Copyright Microsoft Corporation. 
 * This source is subject to the Microsoft Public License.
 * See http://www.microsoft.com/opensource/licenses.mspx#Ms-PL       
 */
package com.microsoft.hsg.applications;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.xml.sax.InputSource;

import com.microsoft.hsg.ConnectionFactory;
import com.microsoft.hsg.HVAccessor;
import com.microsoft.hsg.HVException;
import com.microsoft.hsg.Request;

/**
 * Handle all redirects from HealthVault.
 */
public class HealthVaultActionPage extends HttpServlet {
	
	/** The Constant TOKEN_NAME. */
	private static final String TOKEN_NAME = "wctoken";
	
	/** The Constant PERSON_INFO_KEY. */
	private static final String PERSON_INFO_KEY="wcperson";
		
	public void service(HttpServletRequest request,
			HttpServletResponse response) 
	throws ServletException, IOException {
		
		String target = request.getParameter("target");
		if ("AppAuthSuccess".equalsIgnoreCase(target))
		{
			OnAppAuthSuccess(request, response);
		}
		// Other targets go here...
		
		response.sendRedirect("home.jsp");
	}
	
	/**
	 * Called on a successful logon.
	 * 
	 * @param request the request
	 * @param response the response
	 */
	private void OnAppAuthSuccess(HttpServletRequest request,
			HttpServletResponse response)
	{
		String authToken = (String)request.getParameter(TOKEN_NAME);
		if (authToken != null)
		{
			PersonInfo personInfo = new PersonInfo();
			personInfo.setUserAuthToken(authToken);
			personInfo.setRecordId(getSelectedRecordId(authToken));
			
			HttpSession session = request.getSession();
			session.setAttribute(PERSON_INFO_KEY, personInfo);	
		}
	}
	
	/**
	 * Gets the selected record id.
	 * 
	 * @param userAuthToken the user auth token
	 * 
	 * @return the selected record id
	 * 
	 * @throws HVException the HV exception
	 */
	private String getSelectedRecordId(String userAuthToken)
	throws HVException
	{
    	try
    	{
        	Request request = new Request();
        	request.setTtl(3600 * 8 + 300);  
        	request.setMethodName("GetPersonInfo");
        	request.setUserAuthToken(userAuthToken);
        	HVAccessor accessor = new HVAccessor();
        	accessor.send(request, ConnectionFactory.getConnection());
        	InputStream is = accessor.getResponse().getInputStream();
        	
            XPath xpath = XPathFactory.newInstance().newXPath();
            String exp = "//record/@id";
            return xpath.evaluate(exp,new InputSource(is));      		
    	}
    	catch(HVException he)
    	{
    		throw he;
    	}
    	catch(Exception e)
    	{
    		throw new HVException(e);
    	}
    }
}
