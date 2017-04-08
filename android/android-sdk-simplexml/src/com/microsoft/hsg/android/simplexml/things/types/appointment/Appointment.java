package com.microsoft.hsg.android.simplexml.things.types.appointment;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;

import com.microsoft.hsg.android.simplexml.things.thing.AbstractThing;
import com.microsoft.hsg.android.simplexml.things.types.base.CodableValue;
import com.microsoft.hsg.android.simplexml.things.types.base.Person;
import com.microsoft.hsg.android.simplexml.things.types.dates.ApproxDateTime;
import com.microsoft.hsg.android.simplexml.things.types.dates.DateTime;

@Order(elements = {
		"when",
		"duration",
		"service",
		"clinic",
		"speciality",
		"status",
		"care-class"		
})

@Root(name = "appointment")

public class Appointment extends AbstractThing {
	public static final String ThingType = "4b18aeb6-5f01-444c-8c70-dbf13a2f510b";
	
    @Element(name = "when", required=true)
    protected DateTime when;
    
    @Element(name="duration", required=false)
    protected DurationValue duration;
    
    @Element (name="service", required=false)
    protected CodableValue service;
    
    @Element (name="clinic", required=false)
    protected Person clinic;
    
    @Element (name="speciality", required=false)
    protected CodableValue speciality;
    
    @Element (name="status", required=false)
    protected CodableValue status;
    
    @Element (name="care-class", required=false)
    protected CodableValue careClass;
    
    public String getThingType() {
    	return ThingType; 
    }
    
    public DateTime getWhen() {
    	return when;
    }
    
    public void setWhen(DateTime value) {
    	this.when = value;
    }

    public DurationValue getDuration() {
    	return duration;
    }
    
    public void setDuration(DurationValue value) {
    	this.duration = value;
    }
    public CodableValue getService() {
    	return service;    	
    }
    
    public void setService(CodableValue value) {
    	this.service = value;
    }
    
    public Person getClinic() {
    	return clinic;
    }
    
    public void setClinic(Person value) {
    	this.clinic = value;
    }
    
    public CodableValue getSpeciality() {
    	return speciality;
    }
    
    public void setSpeciality(CodableValue value) {
    	this.speciality = value;
    }
    
    public CodableValue getStatus() {
    	return status;
    }
    
    public void setStatus(CodableValue value) {
    	this.status = value;
    }
    
    public CodableValue getCareClass() {
    	return careClass;
    }
    
    public void setCareClass(CodableValue value) {
    	this.careClass = value;
    }
}
