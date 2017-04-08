package com.microsoft.hsg.oxm.jaxb;

import java.util.HashMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

public class JaxbContextFactory {

	private static HashMap<String, JAXBContext> contextMap = new HashMap<String, JAXBContext>();
	
	public static synchronized JAXBContext getContext(String path) throws JAXBException
	{
		JAXBContext context = contextMap.get(path);
		
		if (context == null)
		{
			context = JAXBContext.newInstance(
					path, 
					JaxbContextFactory.class.getClassLoader());
			contextMap.put(path, context);
		}
		
		return context;
	}
}
