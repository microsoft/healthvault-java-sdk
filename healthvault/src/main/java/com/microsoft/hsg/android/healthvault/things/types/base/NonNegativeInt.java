package com.microsoft.hsg.android.healthvault.things.types.base;

public class NonNegativeInt extends ConstrainedInt {

	public NonNegativeInt() {
		this(0);
	}

	public NonNegativeInt(int value) {
		min = 0;
		setValue(value);
	}
}
