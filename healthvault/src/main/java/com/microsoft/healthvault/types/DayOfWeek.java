package com.microsoft.healthvault.types;

import java.util.Calendar;

public class DayOfWeek extends ConstrainedInt {
	
	public DayOfWeek() {
		this(Calendar.getInstance().get(Calendar.DAY_OF_WEEK));
	}
	
	public DayOfWeek(int value) {
		min = 1;
		max = 7;
		setValue(value);
	}
}
