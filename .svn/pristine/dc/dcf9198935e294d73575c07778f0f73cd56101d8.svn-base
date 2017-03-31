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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.microsoft.hsg.Connection;
import com.microsoft.hsg.Request;

public class WeightDAO
{
	private Connection connection;
	
	public WeightDAO(Connection connection)
	{
		this.connection = connection;
	}
	
	public List<WeightInfo> getWeights()
	{
		final List<WeightInfo> weightList = new ArrayList<WeightInfo>();
		
		Request request = new Request();
		request.setMethodName("GetThings");
		request.setInfo("<info><group max=\"30\"><filter><type-id>" +
				WeightInfo.WeightType +
				"</type-id></filter><format><section>core</section><xml/></format></group></info>");
		
		RequestTemplate template = new RequestTemplate(connection);
		return template.makeRequest(request, new Marshaller<List<WeightInfo>>() {
			public List<WeightInfo> marshal(InputStream istream) throws Exception {
				InputSource isource = new InputSource(istream);
                XPath xpath = XPathFactory.newInstance().newXPath();
                String exp = "//thing";
                NodeList things = (NodeList)xpath.evaluate(exp,
                		isource,
                		XPathConstants.NODESET);  
                
                int count = Math.min(50, things.getLength());
    	        for (int i=0; i<count; i++)
    	        {
    	            Node thing = things.item(i);
    	            String weight = xpath.evaluate("data-xml/weight/value/display", thing);
    	            String id = xpath.evaluate("thing-id", thing);
    	            weightList.add(new WeightInfo(id, weight));
    	        }  
    	        return weightList;
			}
		});        
	}
		
	public void putWeight(WeightInfo weight)
	{
		Calendar calendar = Calendar.getInstance();
		
		StringBuilder infoBuilder = new StringBuilder(256);
        infoBuilder.append("<info><thing><type-id>");
        infoBuilder.append(WeightInfo.WeightType);
        infoBuilder.append("</type-id><data-xml><weight><when><date><y>");
        infoBuilder.append(calendar.get(Calendar.YEAR));
        infoBuilder.append("</y><m>");
        infoBuilder.append(calendar.get(Calendar.MONTH) + 1);
        infoBuilder.append("</m><d>");
        infoBuilder.append(calendar.get(Calendar.DATE));
        infoBuilder.append("</d></date><time><h>");
        infoBuilder.append(calendar.get(Calendar.HOUR_OF_DAY));
        infoBuilder.append("</h><m>");
        infoBuilder.append(calendar.get(Calendar.MINUTE));
        infoBuilder.append("</m><s>");
        infoBuilder.append(calendar.get(Calendar.SECOND));
        infoBuilder.append("</s></time></when><value><kg>");
        infoBuilder.append(weight.getValue());
        infoBuilder.append("</kg><display units=\"lb\" units-code=\"lb\">");
        infoBuilder.append(weight.getValue());
        infoBuilder.append("</display></value></weight>");
        infoBuilder.append("<common/></data-xml></thing></info>");
        
        Request request = new Request();
		request.setMethodName("PutThings");
		request.setInfo(infoBuilder.toString());
		
		RequestTemplate template = new RequestTemplate(connection);
		template.makeRequest(request);
	}
}
