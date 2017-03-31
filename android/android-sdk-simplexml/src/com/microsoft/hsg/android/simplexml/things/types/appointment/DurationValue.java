package com.microsoft.hsg.android.simplexml.things.types.appointment;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;

import com.microsoft.hsg.android.simplexml.things.types.dates.ApproxDateTime;

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
