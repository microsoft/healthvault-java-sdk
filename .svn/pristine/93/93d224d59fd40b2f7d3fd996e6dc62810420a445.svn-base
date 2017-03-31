/*
 * (c) Copyright Microsoft Corporation. 
 * This source is subject to the Microsoft Public License.
 * See http://www.microsoft.com/opensource/licenses.mspx#Ms-PL       
 */
package com.microsoft.hsg.things.marshallers;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.Calendar;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Node;

import com.microsoft.hsg.things.Thing;
import com.microsoft.hsg.things.Weight;

/**
 * The Class WeightMarshaller.
 */
public class WeightMarshaller implements ThingMarshaller
{	
	
	/* (non-Javadoc)
	 * @see com.microsoft.hsg.things.marshallers.ThingMarshaller#unmarhsal(org.w3c.dom.Node)
	 */
	public Thing unmarhsal(Node thingNode)
	throws Exception
	{
		XPath xpath = XPathFactory.newInstance().newXPath();
		Weight weight = new Weight();
        weight.setValue(xpath.evaluate("data-xml/weight/value/display", thingNode));
        weight.setId(xpath.evaluate("thing-id", thingNode));
        
        return weight;        
	}
	
	/* (non-Javadoc)
	 * @see com.microsoft.hsg.things.marshallers.ThingMarshaller#marshal(com.microsoft.hsg.things.Thing, java.io.Writer)
	 */
	public void marshal(Thing thing, Writer out)
	{
		Weight weight = (Weight)thing;
		Calendar calendar = Calendar.getInstance();
		PrintWriter writer = new PrintWriter(out);
        writer.print("<thing><type-id>");
        writer.print(Weight.Type);
        writer.print("</type-id><data-xml><weight><when><date><y>");
        writer.print(calendar.get(Calendar.YEAR));
        writer.print("</y><m>");
        writer.print(calendar.get(Calendar.MONTH) + 1);
        writer.print("</m><d>");
        writer.print(calendar.get(Calendar.DATE));
        writer.print("</d></date><time><h>");
        writer.print(calendar.get(Calendar.HOUR_OF_DAY));
        writer.print("</h><m>");
        writer.print(calendar.get(Calendar.MINUTE));
        writer.print("</m><s>");
        writer.print(calendar.get(Calendar.SECOND));
        writer.print("</s></time></when><value><kg>");
        writer.print(weight.getValue());
        writer.print("</kg><display units=\"lb\" units-code=\"lb\">");
        writer.print(weight.getValue());
        writer.print("</display></value></weight>");
        writer.print("<common/></data-xml></thing>");
        writer.flush();
	}
}
