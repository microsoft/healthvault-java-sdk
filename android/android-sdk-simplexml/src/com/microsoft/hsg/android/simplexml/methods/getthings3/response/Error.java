package com.microsoft.hsg.android.simplexml.methods.getthings3.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;

@Order( elements = {
		"message"
})
public class Error {

	@Element(required=true)
	private String message;
}
