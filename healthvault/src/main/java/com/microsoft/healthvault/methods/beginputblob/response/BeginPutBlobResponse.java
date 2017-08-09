package com.microsoft.healthvault.methods.beginputblob.response;

import com.microsoft.healthvault.methods.response.Response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "response", strict=false)
public class BeginPutBlobResponse extends Response {
	@Element
	protected BlobPutInfo info;

	public BlobPutInfo getInfo() {
		return info;
	}

	public void setInfo(BlobPutInfo info) {
		this.info = info;
	}
}
