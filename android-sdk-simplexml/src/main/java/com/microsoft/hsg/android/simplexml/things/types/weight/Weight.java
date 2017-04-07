package com.microsoft.hsg.android.simplexml.things.types.weight;

import java.util.Calendar;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;

import com.microsoft.hsg.android.simplexml.things.thing.AbstractThing;
import com.microsoft.hsg.android.simplexml.things.types.base.WeightValue;
import com.microsoft.hsg.android.simplexml.things.types.dates.DateTime;

@Order(elements = {
		"when",
		"value"		
})

@Root(name = "weight")
public class Weight extends AbstractThing {
	
	public static final String ThingType = "3d34d87e-7fc1-4153-800f-f56592cb0d17";
	
	public Weight() {
	}
	
	public Weight(double kg) {
		value = new WeightValue(kg);
		when = DateTime.fromCalendar(Calendar.getInstance());
	}
	
	@Element(name = "when", required=true)
    protected DateTime when;
	
	@Element(name="value", required=true)
	protected WeightValue value;
	
	public String getThingType() {
		return ThingType;
	}
	
    public DateTime getWhen() {
    	return when;
    }
    
    public void setWhen(DateTime value) {
    	this.when = value;
    }

    public WeightValue getValue() {
    	return value;
    }
    
    public void setValue(WeightValue value) {
    	this.value = value;
    }
}
