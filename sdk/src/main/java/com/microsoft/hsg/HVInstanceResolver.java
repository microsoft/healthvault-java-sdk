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
import java.net.URI;
import java.util.HashMap;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.microsoft.hsg.request.RequestMarshaller;
import com.microsoft.hsg.request.SimpleRequestTemplate;

/**
 *
 */
public class HVInstanceResolver {

    private static class Singleton { 
        static {
            HVInstanceResolver resolver = new HVInstanceResolver(
                    ConnectionFactory.getConnection(
                            ApplicationConfig.APP_ID,
                            ApplicationConfig.HV_URI));
            INSTANCE = resolver;
        }
        public static final HVInstanceResolver INSTANCE;
    }

    private HashMap<String, HVInstance> instanceMap = new HashMap<String, HVInstance>();
    
    public HVInstanceResolver(Connection connection) {
        load(connection);
        
    }
    
    public static HVInstanceResolver getInstanceResolver() {
        return Singleton.INSTANCE;
    }
    
    public HVInstance getInstanceForId(String id) {
        HVInstance instance = instanceMap.get(id);
        
        if (instance == null) {
            throw new HVException("No instance found for id: " + id);
        }
        
        return instance;
    }
    
    private void load(Connection connection) {     
        Request request = new Request();
        request.setMethodName("GetServiceDefinition");
        request.setMethodVersion("2");
        SimpleRequestTemplate template = new SimpleRequestTemplate(connection);
        instanceMap = (HashMap<String, HVInstance>)template.makeRequest(request, new RequestMarshaller() {
            public Object marshal(InputStream is) {
                return parseInstances(is);     
            }
        });
    }
    
    private HashMap<String, HVInstance> parseInstances(InputStream is) {
        HashMap<String, HVInstance> instanceMap = new HashMap<String, HVInstance>();
        try
        {
            XPath xpath = XPathFactory.newInstance().newXPath();
            String exp = "//instances/instance";
            NodeList list = (NodeList)xpath.evaluate(exp, new InputSource(is), XPathConstants.NODESET);
            for(int i=0; i<list.getLength(); i++) {
                HVInstance hvInstance = parseInstance(list.item(i));
                instanceMap.put(hvInstance.getId(), hvInstance);
            }
        }
        catch(Exception e)
        {
            throw new HVException(e);
        }
        return instanceMap;
    }
    
    private HVInstance parseInstance(Node instance) 
    throws Exception {
        HVInstance hvInstance = new HVInstance();
        
        NodeList elements = instance.getChildNodes();
        for (int j=0; j<elements.getLength(); j++) {
            Node element = elements.item(j);
            String elementName = element.getNodeName();
            
            if ("id".equals(elementName)) {
                hvInstance.setId(element.getTextContent());
                continue;
            }
            
            if ("name".equals(elementName)) {
                hvInstance.setName(element.getTextContent());
                continue;
            }
            
            if ("description".equals(elementName)) {
                hvInstance.setDescription(element.getTextContent());
                continue;
            }
            
            if ("platform-url".equals(elementName)) {
                hvInstance.setPlatformUri(new URI(element.getTextContent()));
                continue;
            }
            
            if ("shell-url".equals(elementName)) {
                hvInstance.setShellUri(new URI(element.getTextContent()));
                continue;
            }
        }
        
        return hvInstance;
    }
}
