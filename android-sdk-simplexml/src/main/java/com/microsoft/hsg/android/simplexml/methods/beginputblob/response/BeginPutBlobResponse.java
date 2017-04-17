package com.microsoft.hsg.android.simplexml.methods.beginputblob.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import com.microsoft.hsg.android.simplexml.methods.response.Response;

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
