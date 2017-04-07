package com.microsoft.hsg.android.simplexml.things.types.base;

import java.util.Calendar;

public class Minute extends ConstrainedInt {

	public Minute() {
		this(Calendar.getInstance().get(Calendar.MINUTE));
	}

	public Minute(int value) {
		min = 0;
		max = 59;
		setValue(value);
	}
}
