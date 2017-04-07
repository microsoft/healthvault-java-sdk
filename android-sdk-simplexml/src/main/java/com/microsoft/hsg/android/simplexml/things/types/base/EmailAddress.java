package com.microsoft.hsg.android.simplexml.things.types.base;

public class EmailAddress extends ConstrainedString {
	
	public EmailAddress(String value) {
		minLength = 6;
		maxLength = 128;
		setValue(value);
	}
}
