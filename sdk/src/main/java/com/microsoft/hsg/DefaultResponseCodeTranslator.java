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
