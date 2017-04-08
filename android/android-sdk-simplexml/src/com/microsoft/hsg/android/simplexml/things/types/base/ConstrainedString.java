package com.microsoft.hsg.android.simplexml.things.types.base;

import org.simpleframework.xml.Text;

public abstract class ConstrainedString {

	protected int minLength = 1;

	protected int maxLength = Integer.MAX_VALUE;

	@Text(required=false)
	protected String value;

	public int getMinLength() {
		return minLength;
	}

	protected void setMinLength(int minLength) {
		this.minLength = minLength;
	}

	public int getMaxLength() {
		return maxLength;
	}

	protected void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
		int length = value == null ? 0 : value.length();
		String message = String.format(
				"Should exist between %d and %d but actual is %d",
				minLength,
				maxLength,
				length);
		validate(message);
	}

	protected Boolean inRange() {
		int length = (value != null) ? value.length() : 0;

		return length >= getMinLength() && length <= getMaxLength();
	}

	public void validate(String message) {
		if(!inRange()) {
			throw new IllegalArgumentException(message);
		}
	}
}
