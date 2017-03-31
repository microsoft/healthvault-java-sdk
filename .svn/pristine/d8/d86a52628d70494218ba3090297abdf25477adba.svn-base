/*
 * (c) Copyright Microsoft Corporation. 
 * This source is subject to the Microsoft Public License.
 * See http://www.microsoft.com/opensource/licenses.mspx#Ms-PL       
 */
package com.microsoft.hsg.things;

import java.io.InputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.microsoft.hsg.Request;
import com.microsoft.hsg.applications.Marshaller;
import com.microsoft.hsg.applications.OnlineRequestTemplate;

/**
 * The Class ThingProvider.
 */
public class ThingProvider {
	
	/** The _request template. */
	OnlineRequestTemplate _requestTemplate;
	
	/**
	 * Instantiates a new thing provider.
	 * 
	 * @param template the template
	 */
	public ThingProvider(OnlineRequestTemplate template)
	{
		_requestTemplate = template;
	}
	
	/**
	 * Gets the things by type.
	 * 
	 * @param type the type
	 * 
	 * @return the things by type
	 */
	public List getThingsByType(String type)
	{
		Request request = new Request();
		request.setMethodName("GetThings");
		request.setInfo("<info><group><filter><type-id>" +
				type +
				"</type-id></filter><format><section>core</section><xml/></format></group></info>");
		
		return (List)_requestTemplate.makeRequest(request, new Marshaller() {
			public Object marshal(InputStream istream) throws Exception {
				InputSource isource = new InputSource(istream);
                XPath xpath = XPathFactory.newInstance().newXPath();
                String exp = "//thing";
                NodeList things = (NodeList)xpath.evaluate(exp,
                		isource,
                		XPathConstants.NODESET);  
                
                List thingList = new ArrayList();
                int count = Math.min(50, things.getLength());
    	        for (int i=0; i<count; i++)
    	        {
    	            Node thing = things.item(i);
    	            thingList.add(TypeManager.unmarshal(thing));
    	        }  
    	        return thingList;
			}
		});
	}
	
	/**
	 * Put thing.
	 * 
	 * @param thing the thing
	 * 
	 * @throws Exception the exception
	 */
	public void putThing(Thing thing)
	throws Exception
	{
		StringWriter writer = new StringWriter();
		TypeManager.marshal(thing, writer);
		
		Request request = new Request();
		request.setMethodName("PutThings");
		request.setInfo("<info>" + writer.toString() + "</info>");
		
		_requestTemplate.makeRequest(request);
	}
}
