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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.apache.log4j.Logger;
import org.xml.sax.InputSource;

/**
 * This class is reponsible for checking for errors in the 
 * response from HealthVault before forwarding on along.
 */
public class DefaultResponseStrategy
implements ResponseStrategy
{
	static Logger logger = Logger.getLogger(ResponseStrategy.class);


	/**
	 *  
	 * @see com.microsoft.hsg.ResponseStrategy#doWithResponse(com.microsoft.hsg.Response)
	 */
	public void doWithResponse(Response response)
	{
		try 
		{
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			InputStream istream = response.getInputStream();
			try
			{
				int len;
				byte[] buf = new byte[4096];
				while((len = istream.read(buf)) != -1 )
				{
					baos.write(buf, 0, len);
				}
			} 
			finally
			{
				istream.close();
			}
			
			byte[] message = baos.toByteArray();
			ByteArrayInputStream bais = new ByteArrayInputStream(message);
			
			if (logger.isDebugEnabled()) {
				logger.debug(new String(message));
			}
			
			XPath xpath = XPathFactory.newInstance().newXPath();
	        String exp = "/response/status/code";
	        String codeString = xpath.evaluate(exp, new InputSource(bais));
	        
	        int code = 0;
	        if (codeString != null && codeString.length() != 0) {
	        	code = Integer.parseInt(codeString);
	        }
	        
	        bais.reset();
	        response.setInputStream(bais);
	        response.setResponseCode(code);
		}
		catch(Exception e)
		{
			throw new HVException(e);
		}
        
        checkResponseCode(response);
	}       
	
	private void checkResponseCode(Response response)
	{
		if (response.getResponseCode()==0) return;
		
		DefaultResponseCodeTranslator translator = 
			new DefaultResponseCodeTranslator();
		HVException e = translator.translate(response);
		if (e != null)
		{
			throw e;
		}
	}
}
