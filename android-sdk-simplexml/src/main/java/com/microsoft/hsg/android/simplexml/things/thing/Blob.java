package com.microsoft.hsg.android.simplexml.things.thing;

import java.io.OutputStream;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;

import com.microsoft.hsg.android.simplexml.things.types.types.*;

@Order(elements = {
	"blob-info",
	"content-length",
	"blob-ref-url",
	"legacy-content-encoding",
	"current-content-encoding"
})

public class Blob {
	
	public Blob() {
	}
	
	public Blob(BlobInfo info, int length, String url) {
		this.info = info;
		this.length = length;
		this.url = url;
	}

	@Element(name="blob-info")
	protected BlobInfo info;
	
	@Element(name="content-length")
	protected int length;
	
	@Element(name="blob-ref-url")
	protected String url;
	
	@Element(name="legacy-content-encoding")
	protected String legacyEncoding;
	
	@Element(name="current-content-encoding")
	protected String encoding;

	public BlobInfo getInfo() {
		return info;
	}

	public void setInfo(BlobInfo info) {
		this.info = info;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getLegacyEncoding() {
		return legacyEncoding;
	}

	public void setLegacyEncoding(String legacyEncoding) {
		this.legacyEncoding = legacyEncoding;
	}

	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}
	
	public String getName() {
		return getInfo() != null ? getInfo().getName() : " ";
	}
	
	public void download(Record record, OutputStream destination) {
		// record.downloadBlob(this, destination);
	}
}
