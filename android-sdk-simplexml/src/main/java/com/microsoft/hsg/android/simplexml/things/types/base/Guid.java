package com.microsoft.hsg.android.simplexml.things.types.base;

import java.util.UUID;

import org.simpleframework.xml.Text;

public class Guid {

	@Text
	private UUID guid;
	
	public Guid() {
		guid = UUID.randomUUID();
	}
	
	public Guid(String guid) {
		this.guid = UUID.fromString(guid);
	}
	
	public Guid(UUID guid) {
		this.guid = guid;
	}
	
	public void set(UUID guid) {
		this.guid = guid;
	}
	
	public UUID get() {
		return guid;
	}
}