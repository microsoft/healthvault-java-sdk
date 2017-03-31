package com.microsoft.hsg.android.simplexml;

public interface IRecord {
	
	public String getId();
	public boolean isCustodian();
	public String getPersonId();
	public String getDisplayName();
	public String getName();
	public int getRelationshipType();
	public String getRelationship();
}
