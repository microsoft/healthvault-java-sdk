package com.microsoft.hsg.android.simplexml.methods.getthings3.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict=false)
public class GetThings3Response {

	@Element(required=true)
	private Status status;
	
	@Element(required=true)
	private GetThings3Info info;
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public GetThings3Info getInfo() {
		return info;
	}

	public void setInfo(GetThings3Info info) {
		this.info = info;
	}
}
