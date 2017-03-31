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

package com.microsoft.hsg.applications.weight;

import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebRequest;
import org.apache.wicket.request.target.basic.RedirectRequestTarget;
import org.xml.sax.InputSource;

import com.microsoft.hsg.ApplicationConfig;
import com.microsoft.hsg.ConnectionFactory;
import com.microsoft.hsg.HVAccessor;
import com.microsoft.hsg.HVException;
import com.microsoft.hsg.Request;

public class AuthenticationPage extends WebPage
{
	private static final String TOKEN_NAME = "wctoken";
	
	//TODO: handle all cases
    public AuthenticationPage(final PageParameters parameters) {
    	
    	//go to shell
    	if (parameters.containsKey("login"))
		{
    		redirectToShell();
    		return;
		}
    	
    	//coming from shell
    	String authToken = null;
		if (parameters.containsKey(TOKEN_NAME))
		{
			authToken = parameters.getString(TOKEN_NAME);
			PersonInfo personInfo = new PersonInfo();
			personInfo.setUserAuthToken(authToken);
			personInfo.setRecordId(getSelectedRecordId(authToken));
			
			HVSession session = (HVSession)this.getSession();
			session.setPersonInfo(personInfo);
			session.bind();
			
			this.setResponsePage(HomePage.class);
		}
		else
		{
			this.setResponsePage(ErrorPage.class);
		}
    }
    
    private void redirectToShell()
    {
	    StringBuffer url = new StringBuffer();
		url.append(Config.ShellUrl);
		url.append("/redirect.aspx?target=AUTH&targetqs=?appid=");
		url.append(ApplicationConfig.APP_ID);
		if (Config.RedirectUrl != null &&
				Config.RedirectUrl.trim().length()!=0)
		{
			HttpServletRequest request = ((WebRequest)getRequest()).getHttpServletRequest();
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
		
		getRequestCycle().setRequestTarget(new RedirectRequestTarget(url.toString()));	
    }
    
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
