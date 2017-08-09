package com.microsoft.healthvault.types;

import java.util.Calendar;

public class Hour extends ConstrainedInt {

	public Hour() {
		this(Calendar.getInstance().get(Calendar.HOUR));
	}
	
	public Hour(int value) {
		min = 0;
		max = 23;
		setValue(value);
	}
}
