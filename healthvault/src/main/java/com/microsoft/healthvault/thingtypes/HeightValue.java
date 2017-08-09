package com.microsoft.healthvault.thingtypes;

import com.microsoft.healthvault.types.DisplayValue;
import com.microsoft.healthvault.types.PositiveDouble;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;

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
