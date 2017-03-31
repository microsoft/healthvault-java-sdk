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
