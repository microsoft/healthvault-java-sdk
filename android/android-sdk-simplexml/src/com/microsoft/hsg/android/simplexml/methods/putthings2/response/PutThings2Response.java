package com.microsoft.hsg.android.simplexml.methods.putthings2.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict=false)
public class PutThings2Response {

	@Element(required=true)
	private Status status;
	
	@Element(required=true)
	private PutThings2Info info;
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public PutThings2Info getInfo() {
		return info;
	}

	public void setInfo(PutThings2Info info) {
		this.info = info;
	}
}
