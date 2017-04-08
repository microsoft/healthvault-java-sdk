/*
 * (c) Copyright Microsoft Corporation. 
 * This source is subject to the Microsoft Public License.
 * See http://www.microsoft.com/opensource/licenses.mspx#Ms-PL       
 */
package com.microsoft.hsg;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.xml.sax.InputSource;

/**
 * This class is reponsible for checking for errors in the 
 * response from HealthVault before forwarding on along.
 */
public class DefaultResponseStrategy
implements ResponseStrategy
{
	
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
			
			XPath xpath = XPathFactory.newInstance().newXPath();
	        String exp = "/response/status/code";
	        String codeString = xpath.evaluate(exp, new InputSource(bais));
	        int code = Integer.parseInt(codeString);
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
		HVException e = translator.translate(response.getResponseCode());
		if (e != null)
		{
			throw e;
		}
	}
}
