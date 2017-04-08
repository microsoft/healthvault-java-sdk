package com.microsoft.hsg.android.simplexml.things.types.base;

public class PositiveDouble extends ConstrainedDouble {

	public PositiveDouble() {
		this(1);
	}

	public PositiveDouble(double value) {
		min = 1;
		setValue(value);
	}
}