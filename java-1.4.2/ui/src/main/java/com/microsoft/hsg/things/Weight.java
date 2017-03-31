/*
 * (c) Copyright Microsoft Corporation. 
 * This source is subject to the Microsoft Public License.
 * See http://www.microsoft.com/opensource/licenses.mspx#Ms-PL       
 */
package com.microsoft.hsg.things;

import java.io.Serializable;

/**
 * The Class Weight.
 */
public class Weight implements Serializable, Thing
{
	
	/** The Constant Type. */
	public static final String Type = "3d34d87e-7fc1-4153-800f-f56592cb0d17";
	
	/** The id. */
	private String id;
	
	/** The value. */
	private String value;
	
	/**
	 * Instantiates a new weight.
	 */
	public Weight()
	{
	}
	
	/**
	 * Instantiates a new weight.
	 * 
	 * @param id the id
	 * @param value the value
	 */
	public Weight(String id, String value) {
		this.id = id;
		this.value = value;
	}
	
	/* (non-Javadoc)
	 * @see com.microsoft.hsg.things.Thing#getTypeId()
	 */
	public String getTypeId()
	{
		return Type;
	}
	
	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 * 
	 * @param id the new id
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Gets the value.
	 * 
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	
	/**
	 * Sets the value.
	 * 
	 * @param value the new value
	 */
	public void setValue(String value) {
		this.value = value;
	}    	
}
