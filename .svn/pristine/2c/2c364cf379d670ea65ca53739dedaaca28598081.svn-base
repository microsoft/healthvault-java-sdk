package com.microsoft.hsg.android.simplexml.things.types.base;

import org.simpleframework.xml.Text;

public abstract class ConstrainedDouble {

	protected double min = Double.MIN_VALUE;

	protected double max = Double.MAX_VALUE;

	@Text
	protected double value;

	public double getMin() {
		return min;
	}

	protected void setMin(double min) {
		this.min = min;
	}

	public double getMax() {
		return max;
	}

	protected void setMax(double max) {
		this.max = max;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
		String message = String.format("Should exist between %.1f and %.1f but actual is %.1f", min, max, value);
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
