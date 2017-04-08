package com.microsoft.hsg.methods.jaxb;

import java.util.Iterator;

import javax.xml.namespace.NamespaceContext;

public class NamespaceResolver implements NamespaceContext {

	private String prefix;
	private String uri;
	
	public NamespaceResolver(String prefix, String uri)
	{
		this.prefix = prefix;
		this.uri = uri;
	}
	
	public String getNamespaceURI(String prefix) {
		return uri;
	}

	public String getPrefix(String namespaceURI) {
		return prefix;
	}

	public Iterator getPrefixes(String namespaceURI) {
		return null;
	}

}
