package com.microsoft.healthvault.types;

public class PositiveInt extends ConstrainedInt {

	public PositiveInt() {
		this(1);
	}

	public PositiveInt(int value) {
		min = 1;
		setValue(value);
	}
}
