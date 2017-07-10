package com.microsoft.healthvault.things.types.base;

import org.simpleframework.xml.Text;

import java.util.UUID;

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