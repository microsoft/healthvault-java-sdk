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
package com.microsoft.hsg;

import java.io.InputStream;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.xml.sax.InputSource;

/**
 * Translate a HealthVault response code into an enum
 * and exception class.
 */
public class DefaultResponseCodeTranslator
{
	
	/**
	 * Translate.
	 * 
	 * @param responseCode the response code
	 * 
	 * @return the exception
	 */
	public HVException translate(Response response)
	{
		int responseCode = response.getResponseCode();
		StatusCode statusCode = StatusCode.parse(responseCode);
		String message = parseResponseMessage(response);
		
		switch(statusCode)
		{
		    case AUTHENTICATED_SESSION_TOKEN_EXPIRED:
		    	return new HVApplicationSessionExpiredException(message);
		    case CREDENTIAL_TOKEN_EXPIRED:
		    	return new HVUserTokenExpiredException(message);
		    case ACCESS_DENIED:
		    	return new HVAccessDeniedException(message);
		    case INVALID_XML:
		    	return new HVInvalidXmlException(message);	    
		}
		return new HVUncategorizedException(statusCode, responseCode, message);
	}
	
	private String parseResponseMessage(Response response)
	{
		String message = null;
		
		try
		{
			InputStream responseStream = response.getInputStream();
			responseStream.mark(Integer.MIN_VALUE);
			
			XPath xpath = XPathFactory.newInstance().newXPath();
	        String exp = "/response/status/error/message";
	        message = xpath.evaluate(exp, new InputSource(responseStream));
	        
	        responseStream.reset();
		}
		catch(Exception e)
		{
			//TODO: log
		}
		
		return message;
	}
}
