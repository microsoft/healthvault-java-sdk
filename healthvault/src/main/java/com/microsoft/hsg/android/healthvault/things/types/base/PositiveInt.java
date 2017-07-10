package com.microsoft.hsg.android.healthvault.things.types.base;

public class PositiveInt extends ConstrainedInt {

	public PositiveInt() {
		this(1);
	}

	public PositiveInt(int value) {
		min = 1;
		setValue(value);
	}
}
