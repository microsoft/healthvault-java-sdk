/*
 * (c) Copyright Microsoft Corporation. 
 * This source is subject to the Microsoft Public License.
 * See http://www.microsoft.com/opensource/licenses.mspx#Ms-PL       
 */
package com.microsoft.hsg.xom;

import java.io.Writer;

import org.w3c.dom.Node;

/**
 * The Interface ThingMarshaller.
 */
public interface XmlMarshaller {

	/**
	 * Unmarshal.
	 * 
	 * @param thingNode the thing node
	 * 
	 * @return the thing
	 * 
	 * @throws Exception the exception
	 */
	public Object unmarshal(Node thingNode) throws Exception;
	
	/**
	 * Marshal.
	 * 
	 * @param thing the thing
	 * @param writer the writer
	 * 
	 * @throws Exception the exception
	 */
	public void marshal(Object obj, Writer writer) throws Exception;
}
