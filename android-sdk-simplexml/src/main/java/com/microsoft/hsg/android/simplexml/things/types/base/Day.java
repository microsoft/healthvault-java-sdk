package com.microsoft.hsg.android.simplexml.things.types.base;

import java.util.Calendar;

public class Day extends ConstrainedInt {

	public Day() {
		this(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
	}

	public Day(int val) {
		min = 1;
		max = 31;
		setValue(val);
	}
}
