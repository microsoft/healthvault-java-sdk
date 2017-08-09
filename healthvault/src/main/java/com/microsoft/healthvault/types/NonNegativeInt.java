package com.microsoft.healthvault.types;

public class NonNegativeInt extends ConstrainedInt {

	public NonNegativeInt() {
		this(0);
	}

	public NonNegativeInt(int value) {
		min = 0;
		setValue(value);
	}
}
