/*
 * (c) Copyright Microsoft Corporation. 
 * This source is subject to the Microsoft Public License.
 * See http://www.microsoft.com/opensource/licenses.mspx#Ms-PL       
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

import com.microsoft.hsg.ApplicationConfig;
import com.microsoft.hsg.HVAccessDeniedException;
import com.microsoft.hsg.applications.weight.WeightPage;

/**
 * The Class Controller.  This controller receives requests for
 * all pages requiring a HealthVault login.  
 */
public class Controller extends HttpServlet {
		
	/** The Constant PERSON_INFO_KEY. */
	private static final String PERSON_INFO_KEY="wcperson";
	
	/** The page map. */
	private static Map pageMap;
	static
	{
		pageMap = new HashMap();
		pageMap.put("/weight", WeightPage.class);
	}
	
	/**
	 * Handle all http requests here.
	 * 
	 * @param request the request
	 * @param response the response
	 * 
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void service(HttpServletRequest request,
			HttpServletResponse response)
	throws ServletException, IOException 
	{	
		try
		{
			HttpSession session = request.getSession();
			PersonInfo personInfo = (PersonInfo)session.getAttribute(PERSON_INFO_KEY);
			RequestCtx.setPersonInfo(personInfo);
		
			if (personInfo == null)
			{
				// If no user, login to get one.
				login(request, response);
				return;
			}
	
			try
			{
				Class clazz = (Class)pageMap.get(request.getPathInfo());
	            if (clazz != null)
	            {
	            	RequestHandler handler = (RequestHandler)clazz.newInstance();
	            	handler.processRequest(request, response);
	            }
	            else
	            {
	            	showView(request, response, "/home.jsp");
	            }
			}
			catch (HVAccessDeniedException axdenied)
			{
				login(request, response);
			}
			catch (Exception e)
			{
				throw new ServletException(e);
			}
		}
		finally
		{
			RequestCtx.setPersonInfo(null);
		}
	}
	
	/**
	 * Show view.
	 * 
	 * @param request the request
	 * @param response the response
	 * @param viewName the view name
	 * 
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void showView(HttpServletRequest request, 
			HttpServletResponse response,
			String viewName)
	throws ServletException, IOException
	{
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewName);
			dispatcher.forward(request, response);
	}
	
	/**
	 * Login.
	 * 
	 * @param request the request
	 * @param response the response
	 * 
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void login(HttpServletRequest request, 
			HttpServletResponse response)
	throws ServletException, IOException
    {
	    StringBuffer url = new StringBuffer();
		url.append(Config.ShellUrl);
		url.append("/redirect.aspx?target=AUTH&targetqs=?appid=");
		url.append(ApplicationConfig.APP_ID);
		if (Config.RedirectUrl != null &&
				Config.RedirectUrl.trim().length()!=0)
		{
			url.append("%26redirect=");
			url.append(request.getScheme());
			url.append("://");
			url.append(request.getServerName());
			url.append(":");
			url.append(request.getServerPort());
			url.append(request.getContextPath());
			url.append(Config.RedirectUrl);
		}
		if (Config.ActionQS != null &&
				Config.ActionQS.trim().length()!=0)
		{
			url.append("%26actionqs=");
			url.append(Config.ActionQS);
		}
		response.sendRedirect(url.toString());
    }
}
