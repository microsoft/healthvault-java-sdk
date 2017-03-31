package com.microsoft.hsg.android.simplexml.things.types.base;

import org.simpleframework.xml.Text;

public abstract class ConstrainedInt {
	
	protected int min = Integer.MIN_VALUE;
	
	protected int max = Integer.MAX_VALUE;
	
	@Text
	protected int value;

	public int getMin() {
		return min;
	}

	protected void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	protected void setMax(int max) {
		this.max = max;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
		String message = String.format("Should exist between %d and %d but actual is %d", min, max, value);
		validate(message);
	}

	protected Boolean inRange() {
		return value >= getMin() && value <= getMax();
	}
	
	public void validate(String message) {
		if(!inRange()) {
			throw new IllegalArgumentException(message);
		}
	}
}
