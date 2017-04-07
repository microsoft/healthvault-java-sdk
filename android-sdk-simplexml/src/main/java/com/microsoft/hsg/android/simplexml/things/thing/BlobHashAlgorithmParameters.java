package com.microsoft.hsg.android.simplexml.things.thing;

import org.simpleframework.xml.Element;

public class BlobHashAlgorithmParameters {
	
	@Element(name="block-size")
	protected int blockSize;

	public int getBlockSize() {
		return blockSize;
	}

	public void setBlockSize(int blockSize) {
		this.blockSize = blockSize;
	}
}
