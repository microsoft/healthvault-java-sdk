package com.microsoft.healthvault.types;

public class EmailAddress extends ConstrainedString {
	
	public EmailAddress(String value) {
		minLength = 6;
		maxLength = 128;
		setValue(value);
	}
}
