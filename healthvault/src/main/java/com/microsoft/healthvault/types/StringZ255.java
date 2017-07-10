package com.microsoft.healthvault.types;

public class StringZ255 extends ConstrainedString {
	
	public StringZ255() {
		this(null);
	}
	
	public StringZ255(String value) {
		minLength = 0;
		maxLength = 255;
		setValue(value);
	}
}
