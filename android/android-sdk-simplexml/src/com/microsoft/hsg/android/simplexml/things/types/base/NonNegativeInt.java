package com.microsoft.hsg.android.simplexml.things.types.base;

public class NonNegativeInt extends ConstrainedInt {

	public NonNegativeInt() {
		this(0);
	}

	public NonNegativeInt(int value) {
		min = 0;
		setValue(value);
	}
}
