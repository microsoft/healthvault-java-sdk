/*
 * (c) Copyright Microsoft Corporation. 
 * This source is subject to the Microsoft Public License.
 * See http://www.microsoft.com/opensource/licenses.mspx#Ms-PL       
 */
package com.microsoft.hsg.things.marshallers;

import java.io.Writer;

import org.w3c.dom.Node;

import com.microsoft.hsg.things.Thing;

/**
 * The Interface ThingMarshaller.
 */
public interface ThingMarshaller {

	/**
	 * Unmarhsal.
	 * 
	 * @param thingNode the thing node
	 * 
	 * @return the thing
	 * 
	 * @throws Exception the exception
	 */
	public Thing unmarhsal(Node thingNode) throws Exception;
	
	/**
	 * Marshal.
	 * 
	 * @param thing the thing
	 * @param writer the writer
	 * 
	 * @throws Exception the exception
	 */
	public void marshal(Thing thing, Writer writer) throws Exception;
}
