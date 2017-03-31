package com.microsoft.hsg.android.simplexml.things.types.base;

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