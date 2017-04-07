package com.microsoft.hsg.android.simplexml.things.types.procedure;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;

import com.microsoft.hsg.android.simplexml.things.thing.AbstractThing;
import com.microsoft.hsg.android.simplexml.things.types.appointment.DurationValue;
import com.microsoft.hsg.android.simplexml.things.types.base.CodableValue;
import com.microsoft.hsg.android.simplexml.things.types.base.GeneralMeasurement;
import com.microsoft.hsg.android.simplexml.things.types.base.Person;
import com.microsoft.hsg.android.simplexml.things.types.dates.ApproxDateTime;

@Order(elements = {
		"when",
		"name",
		"anatomic-location",
		"primary-provider",
		"secondary-provider"
})

@Root(name = "procedure")

public class Procedure extends AbstractThing {
	
	public static final String ThingType = "df4db479-a1ba-42a2-8714-2b083b88150f";
	
    @Element(name = "when", required=true)
    protected ApproxDateTime when;
    
    @Element (name="name", required=false)
    protected CodableValue name;
    
    @Element (name="anatomic-location", required=false)
    protected CodableValue anatomicLocation;    
    
    @Element (name="primary-provider", required=false)
    protected Person primaryProvider;
    
    
    @Element (name="secondary-provider", required=false)
    protected Person secondaryProvider;

    
    public ApproxDateTime getWhen() {
    	return when;
    }
    
    public void setWhen(ApproxDateTime value) {
    	this.when = value;
    }

     public CodableValue getName() {
    	return name;    	
    }
    
    public void setName(CodableValue value) {
    	this.name = value;
    }
    
    public Person getPrimaryProvider() {
    	return primaryProvider;
    }
    
    public void setPrimaryProvider(Person value) {
    	this.primaryProvider = value;
    }
    
    public CodableValue getAnatomicLocation() {
    	return anatomicLocation;
    }
    
    public void setAnatomicLocation(CodableValue value) {
    	this.anatomicLocation = value;
    }
    
    public Person getSecondaryProvider() {
    	return secondaryProvider;
    }
    
    public void setSecondaryProvider(Person value) {
    	this.secondaryProvider = value;
    }

    public String getThingType() {
    	return ThingType;
    }
    
}
