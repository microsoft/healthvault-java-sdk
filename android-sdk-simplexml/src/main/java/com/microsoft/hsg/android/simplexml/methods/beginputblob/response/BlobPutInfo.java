package com.microsoft.hsg.android.simplexml.methods.beginputblob.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;

import com.microsoft.hsg.android.simplexml.things.thing.BlobHashAlgorithmParameters;

@Order(elements = {
	"blob-ref-url",
	"blob-chunk-size",
	"max-blob-size",
	"blob-hash-algorithm",
	"blob-hash-parameters"
})

public class BlobPutInfo {

	@Element(name="blob-ref-url")
	protected String url;
	
	@Element(name="blob-chunk-size")
	protected int chunkSize;
	
	@Element(name="max-blob-size")
	protected int maxSize;
	
	@Element(name="blob-hash-algorithm")
	protected String hashAlgorithm;
	
	@Element(name="blob-hash-parameters")
	protected BlobHashAlgorithmParameters hasParams;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getChunkSize() {
		return chunkSize;
	}

	public void setChunkSize(int chunkSize) {
		this.chunkSize = chunkSize;
	}

	public int getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}

	public String getHashAlgorithm() {
		return hashAlgorithm;
	}

	public void setHashAlgorithm(String hashAlgorithm) {
		this.hashAlgorithm = hashAlgorithm;
	}

	public BlobHashAlgorithmParameters getHasParams() {
		return hasParams;
	}

	public void setHasParams(BlobHashAlgorithmParameters hasParams) {
		this.hasParams = hasParams;
	}
}
