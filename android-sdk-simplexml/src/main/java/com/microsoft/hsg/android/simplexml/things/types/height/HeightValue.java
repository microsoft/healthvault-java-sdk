package com.microsoft.hsg.android.simplexml.things.types.height;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;

import com.microsoft.hsg.android.simplexml.things.types.base.DisplayValue;
import com.microsoft.hsg.android.simplexml.things.types.base.PositiveDouble;

@Order(elements = {
	    "m",
	    "display"
	})

// TODO: need to properly define the object type for the two elements,
// right now I'm just using double
public class HeightValue {
	
	@Element(name = "m", required=true)
    protected PositiveDouble m;

	@Element(name="display", required=false)
	protected DisplayValue display;
	
	public Double getM() {
		return m == null ? null : m.getValue();
	}
	
	public void setM(double value) {
		this.m = new PositiveDouble(value);
	}
	
	public DisplayValue getDisplay() {
		return display;
	}
	
	public void setDisplay(DisplayValue value) {
		this.display = value;
	}
}
