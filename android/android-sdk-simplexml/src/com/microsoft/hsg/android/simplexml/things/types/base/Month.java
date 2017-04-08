package com.microsoft.hsg.android.simplexml.things.types.base;

import java.util.Calendar;

public class Month extends ConstrainedInt {

	public Month() {
		this(Calendar.getInstance().get(Calendar.MONTH) + 1);
	}

	public Month(int value) {
		min = 1;
		max = 12;
		setValue(value);
	}
}
