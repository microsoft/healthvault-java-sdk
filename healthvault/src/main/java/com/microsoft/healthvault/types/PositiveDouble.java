package com.microsoft.healthvault.types;

public class PositiveDouble extends ConstrainedDouble {

	public PositiveDouble() {
		this(1);
	}

	public PositiveDouble(double value) {
		min = 1;
		setValue(value);
	}
}