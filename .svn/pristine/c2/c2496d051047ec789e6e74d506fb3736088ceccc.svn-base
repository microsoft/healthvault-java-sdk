/*
 * Copyright 2011 Microsoft Corp.
 * 
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.microsoft.hsg;

import com.microsoft.hsg.util.EnumCode;
import com.microsoft.hsg.util.EnumCodeLookup;

/**
 * The Enum StatusCode with all the known error codes from 
 * HealthVault.
 */
public enum StatusCode implements EnumCode {
	
		OK(0, "OK"),
		FAILED(1, "Failed"),
		BAD_HTTP(2, "Bad HTTP"),
		INVALID_XML(3, "Invalid XML"),
		BAD_SIG(4, "Bad Signature"),
		BAD_METHOD(5, "Bad Method"),
		INVALID_APP(6, "Invalid Application"),
		CREDENTIAL_TOKEN_EXPIRED(7, "Credential Token Expired"),
		INVALID_TOKEN(8, "Invalid Token"),
		INVALID_PERSON(9, "Invalid Person"),
		INVALID_RECORD(10, "Invalid Record"),
		ACCESS_DENIED(11, "Access Denied"),
		NYI(12, "NYI"),
		INVALID_THING(13, "Invalid Thing"),
		CANT_CONVERT_UNITS(14, "Can't Convert Units"),
		INVALID_FILTER(15, "Invalid Filter"),
		INVALID_FORMAT(16, "Invalid Format"),
		MISSING_SHARED_SECRET(17, "Missing Shared Secret"),
		INVALID_APPAUTH(18, "Invalid Application Authorization"),
		INVALID_THING_TYPE(19, "Invalid Thing Type"),
		THING_TYPE_IMMUTABLE(20, "Thing Type Immutable"),
		THING_TYPE_UNCREATABLE(21, "Thing Type Uncreatable"),
		DUPLICATE_CREDENTIAL_FOUND(22, "Duplicate Credential Found"),
		INVALID_RECORD_NAME(23, "Invalid Record Name"),
		DRUG_NOT_FOUND(24, "Drug Not Found"),
		INVALID_PERSON_STATE(25, "Invalid Person State"),
		INVALID_CODESET(26, "Invalid Codeset"),
		INVALID_GROUP(27, "Invalid Group"),
		INVALID_VALIDATION_TOKEN(28, "Invalid Validation Token"),
		INVALID_ACCOUNT_NAME(29, "Invalid Account Name"),
		INVALID_CONTACT_EMAIL(30, "Invalid Contact Email"),
		INVALID_LOGIN_NAME(31, "Invalid Login Name"),
		INVALID_PASSWORD(32, "Invalid Password"),
		INVALID_OPENQUERY(33, "Invalid Open Query"),
		INVALID_TRANSFORM(34, "Invalid Transform"),
		INVALID_RELATIONSHIP_TYPE(35, "Invalid Relationship Type"),
		INVALID_CREDENTIAL_TYPE(36, "Invalid Credential Type"),
		INVALID_RECORD_STATE(37, "Invalid Record State"),
		APP_AUTH_NOT_REQUIRED(38, "Application Authorization Not Required"),
		REQUEST_TOO_LONG(39, "Request Too Long"),
		DUPLICATE_AUTHORIZED_RECORD_FOUND(40, "Duplicate Authorization Record Found"),
		EMAIL_NOT_VERIFIED(41, "Email Not Verified"),
		DUPLICATE_GROUP_FOUND(42, "Duplicate Group Found"),
		GROUP_ALREADY_HAS_PARENT(43, "Group Already Has Parent"),
		GROUP_MEMBERSHIP_CYCLE_DETECTED(44, "Group Membership Cycle Detected"),
		MAIL_ADDRESS_MALFORMED(45, "Mail Address Malformed"),
		PASSWORD_NOT_STRONG(46, "Password Not Strong"),
		CANNOT_REMOVE_LAST_CUSTODIAN(47, "Cannot Remove Last Custodian"),
		INVALID_EMAIL_ADDRESS(48, "Invalid Email Address"),
		REQUEST_TIMED_OUT(49, "Request Timed Out"),
		INVALID_SPONSOR_EMAIL(50, "Invalid Sponsor Email"),
		INVALID_PROMOTION_TOKEN(51, "Invalid Promotion Token"),
		INVALID_RECORD_AUTHORIZATION_TOKEN(52, "Invalid Record Authorization Token"),
		TOO_MANY_GROUPS_IN_QUERY(53, "Too Many Groups In Query"),
		GRANT_AUTHZ_EXCEEDS_DEFAULT(54, "Grant Authorization Exceeds Default"),
		INVALID_VOCABULARY(55, "Invalid Vocabulary"),
		DUPLICATE_APPLICATION_FOUND(56, "Duplicate Application Found"),
		RECORD_AUTHORIZATION_TOKEN_EXPIRED(57, "Record Authorization Token Expired"),
		RECORD_AUTHORIZATION_DOES_NOT_EXIST(58, "Record Authorization Does Not Exist"),
		THING_TYPE_UNDELETABLE(59, "Thing Type Undeletable"),
		VERSION_STAMP_MISSING(60, "Version Stamp Missing"),
		VERSION_STAMP_MISMATCH(61, "Version Stamp Mismatch"),
		EXPIRED_OPENQUERY(62, "Expired Open Query"),
		INVALID_PUBLIC_KEY(63, "Invalid Public Key"),
		DOMAIN_NAME_NOT_SET(64, "Domain Name Not Set"),
		AUTHENTICATED_SESSION_TOKEN_EXPIRED(65, "Authenticated Session Token Expired"),
		INVALID_CREDENTIAL_KEY(66, "Invalid Credential Key"),
		INVALID_PERSON_OR_GROUP_ID(67, "Invalid Person Or Group ID"),
		RECORD_QUOTA_EXCEEDED(68, "Record Quota Exceeded"),
		INVALID_DATETIME(69, "Invalid Datetime"),
		INVALID_CERTIFICATE(70, "Bad Certificate"),
		RESPONSE_TOO_LONG(71, "Response Too Long"),
		INVALID_VERIFICATION_QUESTION(72, "Invalid Verification Question"),
		INVALID_VERIFICATION_ANSWER(73, "Invalid Verification Answer"),
		INVALID_IDENTITY_CODE(74, "Invalid Identity Code"),
		RETRY_LIMIT_EXCEEDED(75, "Retry Limit Exceeded"),
		CULTURE_NOT_SUPPORTED(76, "Culture Not Supported"),
		INVALID_FILE_EXTENSION(77, "Invalid File Extension"),
		INVALID_VOCABULARY_ITEM(78, "Invalid Vocabulary Item"),
		DUPLICATE_CONNECT_REQUEST_FOUND(79, "Duplicate Connect Request Found"),
		INVALID_SPECIAL_ACCOUNT_TYPE(80, "Invalid Special Account Type"),
		DUPLICATE_TYPE_FOUND(81, "Duplicate Type Found"),
		CREDENTIAL_NOT_FOUND(82, "Credential Not Found"),
		CANNOT_REMOVE_LAST_CREDENTIAL(83, "Cannot Remove Last Credential"),
		UNKNOWN(Integer.MAX_VALUE, "Unknown");
	
	private static EnumCodeLookup<StatusCode> map = 
		new EnumCodeLookup<StatusCode>(StatusCode.class);
	
	private int code;
	private String description;
	
	/**
	 * Instantiates a new status code.
	 * 
	 * @param code the code
	 */
	StatusCode(int code, String description)
	{
		this.code = code;
		this.description = description;
	}
	
	/* (non-Javadoc)
	 * @see com.microsoft.hsg.EnumCode#getCode()
	 */
	public int getCode()
	{
		return code;
	}
	
	/**
	 * Gets the description.
	 * 
	 * @return the description
	 */
	public String getDescription()
	{
		return description;
	}
	
	/**
	 * Parses the.
	 * 
	 * @param code the code
	 * 
	 * @return the status code
	 */
	public static StatusCode parse(int code)
	{
		StatusCode statusCode = map.get(code);
		if (statusCode == null)
		{
			statusCode = UNKNOWN;
		}
		return statusCode;
	}

}
