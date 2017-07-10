package com.microsoft.healthvault.types;

import java.util.Calendar;

public class Year extends ConstrainedInt {
	
	public Year() {
		this(Calendar.getInstance().get(Calendar.YEAR));
	}

	public Year(int value) {
		min = 1000;
		max = 9999;
		setValue(value);
	}
}
