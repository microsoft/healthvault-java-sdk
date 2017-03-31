/*
 * (c) Copyright Microsoft Corporation. 
 * This source is subject to the Microsoft Public License.
 * See http://www.microsoft.com/opensource/licenses.mspx#Ms-PL       
 */
package com.microsoft.hsg.things;

import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Node;

import com.microsoft.hsg.things.marshallers.ThingMarshaller;
import com.microsoft.hsg.things.marshallers.WeightMarshaller;


/**
 * The Class TypeManager.
 */
public class TypeManager {
	
	/** The types. */
	private static Map types = new HashMap();
	static
	{
		types.put(Weight.Type, new WeightMarshaller());
	}
	
	/**
	 * Unmarshal.
	 * 
	 * @param thingNode the thing node
	 * 
	 * @return the thing
	 * 
	 * @throws Exception the exception
	 */
	public static Thing unmarshal(Node thingNode)
	throws Exception
	{
		Thing result = null;
		
		XPath xpath = XPathFactory.newInstance().newXPath();
        String typeId = xpath.evaluate("type-id", thingNode);	
    	ThingMarshaller marshaller = (ThingMarshaller)types.get(typeId);
    	if (marshaller != null)
    	{
    		result = marshaller.unmarhsal(thingNode);
    	}
    	
    	return result;
	}
	
	/**
	 * Marshal.
	 * 
	 * @param thing the thing
	 * @param writer the writer
	 * 
	 * @throws Exception the exception
	 */
	public static void marshal(Thing thing, Writer writer)
	throws Exception
	{
		ThingMarshaller marshaller = (ThingMarshaller)types.get(thing.getTypeId());
		if (marshaller != null)
		{
			marshaller.marshal(thing, writer);
		}
	}
}
