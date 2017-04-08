package com.microsoft.hsg.android.simplexml.things.types.base;

public class String255 extends ConstrainedString {

	public String255(String value) {
		minLength = 1;
		maxLength = 255;
		setValue(value);
	}
}