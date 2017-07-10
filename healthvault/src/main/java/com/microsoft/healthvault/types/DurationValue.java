package com.microsoft.healthvault.types;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;

@Order(elements = {
	    "start-date",
	    "end-date"
	})
public class DurationValue {
	@Element(name = "start-date", required=true)
    protected ApproxDateTime startDate;
	
	@Element(name = "end-date", required=false)
    protected ApproxDateTime endDate;
	
	public ApproxDateTime getStartDate() {
		return startDate;
	}
	
	public void setStartDate(ApproxDateTime value) {
		this.startDate = value;
	}

	public ApproxDateTime getEndDate() {
		return endDate;
	}
	
	public void setEndDate(ApproxDateTime value) {
		this.endDate = value;
	}
}
