package com.microsoft.hsg.android.simplexml.methods.putthings2.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;

@Order( elements = {
		"code",
		"error"
})
public class Status {

	@Element(required=true)
	private int code;
	
	@Element(required=false)
	private Error error;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Error getError() {
		return error;
	}

	public void setError(Error error) {
		this.error = error;
	}
}
