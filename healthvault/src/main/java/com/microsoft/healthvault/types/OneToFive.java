package com.microsoft.healthvault.types;

public class OneToFive  extends ConstrainedInt {

	public OneToFive() {
		setValue(1);
	}

	public OneToFive(int value) {
		min = 1;
		max = 5;
		setValue(value);
	}
}