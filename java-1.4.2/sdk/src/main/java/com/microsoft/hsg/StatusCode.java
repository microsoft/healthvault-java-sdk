/*
 * (c) Copyright Microsoft Corporation. 
 * This source is subject to the Microsoft Public License.
 * See http://www.microsoft.com/opensource/licenses.mspx#Ms-PL       
 */
package com.microsoft.hsg;

/**
 * The Enum StatusCode with all the known error codes from 
 * HealthVault.
 */
public interface StatusCode 
{
	
	/** The OK. */
	public int OK = 0;
	
	/** The FAILED. */
	public int FAILED = 1;
	
	/** The BA d_ http. */
	public int BAD_HTTP = 2;
	
	/** The INVALI d_ xml. */
	public int INVALID_XML = 3;
	
	/** The BA d_ sig. */
	public int BAD_SIG =4;
	
	/** The BA d_ method. */
	public int BAD_METHOD = 5;
	
	/** The INVALI d_ app. */
	public int INVALID_APP = 6;
	
	/** The CREDENTIA l_ toke n_ expired. */
	public int CREDENTIAL_TOKEN_EXPIRED = 7;
	
	/** The INVALI d_ token. */
	public int INVALID_TOKEN = 8;
	
	/** The INVALI d_ person. */
	public int INVALID_PERSON = 9;
	
	/** The INVALI d_ record. */
	public int INVALID_RECORD = 10;
	
	/** The ACCES s_ denied. */
	public int ACCESS_DENIED = 11;
	
	/** The NYI. */
	public int NYI = 12;
	
	/** The INVALI d_ thing. */
	public int INVALID_THING = 13;
	
	/** The CAN t_ conver t_ units. */
	public int CANT_CONVERT_UNITS = 14;
	
	/** The INVALI d_ filter. */
	public int INVALID_FILTER = 15;
	
	/** The INVALI d_ format. */
	public int INVALID_FORMAT = 16;
	
	/** The MISSIN g_ share d_ secret. */
	public int MISSING_SHARED_SECRET = 17;
	
	/** Invalid appauth */
	public int INVALID_APPAUTH = 18;
	
	/** The INVALI d_ thin g_ type. */
	public int INVALID_THING_TYPE = 19;
	
	/** The THIN g_ typ e_ immutable. */
	public int THING_TYPE_IMMUTABLE = 20;
	
	/** The THIN g_ typ e_ uncreatable. */
	public int THING_TYPE_UNCREATABLE = 21;
	
	/** The DUPLICAT e_ credentia l_ found. */
	public int DUPLICATE_CREDENTIAL_FOUND = 22;
	
	/** The INVALI d_ recor d_ name. */
	public int INVALID_RECORD_NAME = 23;
	
	/** The DRU g_ no t_ found. */
	public int DRUG_NOT_FOUND = 24;
	
	/** The INVALI d_ perso n_ state. */
	public int INVALID_PERSON_STATE = 25;
	
	/** The INVALI d_ codeset. */
	public int INVALID_CODESET = 26;
	
	/** The INVALI d_ group. */
	public int INVALID_GROUP = 27;
	
	/** The INVALI d_ validatio n_ token. */
	public int INVALID_VALIDATION_TOKEN = 28;
	
	/** The INVALI d_ accoun t_ name. */
	public int INVALID_ACCOUNT_NAME = 29;
	
	/** The INVALI d_ contac t_ email. */
	public int INVALID_CONTACT_EMAIL = 30;
	
	/** The INVALI d_ logi n_ name. */
	public int INVALID_LOGIN_NAME = 31;
	
	/** The INVALI d_ password. */
	public int INVALID_PASSWORD = 32;
	
	/** The INVALI d_ openquery. */
	public int INVALID_OPENQUERY = 33;
	
	/** The INVALI d_ transform. */
	public int INVALID_TRANSFORM = 34;
	
	/** The INVALI d_ relationshi p_ type. */
	public int INVALID_RELATIONSHIP_TYPE = 35;
	
	/** The INVALI d_ credentia l_ type. */
	public int INVALID_CREDENTIAL_TYPE = 36;
	
	/** The INVALI d_ recor d_ state. */
	public int INVALID_RECORD_STATE = 37;
	
	/** The AP p_ aut h_ no t_ required. */
	public int APP_AUTH_NOT_REQUIRED = 38;
	
	/** The REQUES t_ to o_ long. */
	public int REQUEST_TOO_LONG = 39;
	
	/** The DUPLICAT e_ authorize d_ recor d_ found. */
	public int DUPLICATE_AUTHORIZED_RECORD_FOUND = 40;
	
	/** The EMAI l_ no t_ verified. */
	public int EMAIL_NOT_VERIFIED = 41;
	
	/** The DUPLICAT e_ grou p_ found. */
	public int DUPLICATE_GROUP_FOUND = 42;
	
	/** The GROU p_ alread y_ ha s_ parent. */
	public int GROUP_ALREADY_HAS_PARENT = 43;
	
	/** The GROU p_ membershi p_ cycl e_ detected. */
	public int GROUP_MEMBERSHIP_CYCLE_DETECTED = 44;
	
	/** The MAI l_ addres s_ malformed. */
	public int MAIL_ADDRESS_MALFORMED = 45;
	
	/** The PASSWOR d_ no t_ strong. */
	public int PASSWORD_NOT_STRONG = 46;
	
	/** The CANNO t_ remov e_ las t_ custodian. */
	public int CANNOT_REMOVE_LAST_CUSTODIAN = 47;
	
	/** The INVALI d_ emai l_ address. */
	public int INVALID_EMAIL_ADDRESS = 48;
	
	/** The REQUES t_ time d_ out. */
	public int REQUEST_TIMED_OUT = 49;
	
	/** The INVALI d_ sponso r_ email. */
	public int INVALID_SPONSOR_EMAIL = 50;
	
	/** The INVALI d_ promotio n_ token. */
	public int INVALID_PROMOTION_TOKEN = 51;
	
	/** The INVALI d_ recor d_ authorizatio n_ token. */
	public int INVALID_RECORD_AUTHORIZATION_TOKEN = 52;
	
	/** The TO o_ man y_ group s_ i n_ query. */
	public int TOO_MANY_GROUPS_IN_QUERY = 53;
	
	/** The GRAN t_ auth z_ exceed s_ default. */
	public int GRANT_AUTHZ_EXCEEDS_DEFAULT = 54;
	
	/** The INVALI d_ vocabulary. */
	public int INVALID_VOCABULARY = 55;
	
	/** The DUPLICAT e_ applicatio n_ found. */
	public int DUPLICATE_APPLICATION_FOUND = 56;
	
	/** The RECOR d_ authorizatio n_ toke n_ expired. */
	public int RECORD_AUTHORIZATION_TOKEN_EXPIRED = 57;
	
	/** The RECOR d_ authorizatio n_ doe s_ no t_ exist. */
	public int RECORD_AUTHORIZATION_DOES_NOT_EXIST = 58;
	
	/** The TYP e_ typ e_ undeletable. */
	public int TYPE_TYPE_UNDELETABLE = 59;
	
	/** The VERSIO n_ stam p_ missing. */
	public int VERSION_STAMP_MISSING = 60;
	
	/** The VERSIO n_ stam p_ mismatch. */
	public int VERSION_STAMP_MISMATCH = 61;
	
	/** The EXPIRE d_ openquery. */
	public int EXPIRED_OPENQUERY = 62;
	
	/** The INVALI d_ publi c_ key. */
	public int INVALID_PUBLIC_KEY = 63;
	
	/** The DOMAI n_ nam e_ no t_ set. */
	public int DOMAIN_NAME_NOT_SET = 64;
	
	/** The AUTHENTICATE d_ sessio n_ toke n_ expired. */
	public int AUTHENTICATED_SESSION_TOKEN_EXPIRED = 65;
	
	/** The INVALI d_ credentia l_ key. */
	public int INVALID_CREDENTIAL_KEY = 66;
	
	/** The INVALI d_ perso n_ o r_ grou p_ id. */
	public int INVALID_PERSON_OR_GROUP_ID = 67;
	
	/** The RECOR d_ quot a_ exceeded. */
	public int RECORD_QUOTA_EXCEEDED = 68;
	
	/** The INVALI d_ datetime. */
	public int INVALID_DATETIME = 69;	
	
    /** The Invalid certificate. */
    public int InvalidCertificate = 70;
    
    /** The Response too long. */
    public int ResponseTooLong = 71;
    
    /** The Invalid verification question. */
    public int InvalidVerificationQuestion = 72;
   
    /** The Invalid verification answer. */
    public int InvalidVerificationAnswer = 73;
    
    /** The Invalid identity code. */
    public int InvalidIdentityCode = 74;
   
    /** The Retry limit exceeded. */
    public int RetryLimitExceeded = 75;
    
    /** The Culture not supported. */
    public int CultureNotSupported = 76;
   
    /** The Invalid file extension. */
    public int InvalidFileExtension = 77;

    /** The Invalid vocabulary item. */
    public int InvalidVocabularyItem = 78;

    /** The Duplicate connect request found. */
    public int DuplicateConnectRequestFound = 79;

    /** The Invalid special account type. */
    public int InvalidSpecialAccountType = 80;
    
    /** The Duplicate type found. */
    public int DuplicateTypeFound = 81;

    /** The Credential not found. */
    public int CredentialNotFound = 82;
    
    /** Cannot remove last credential. */
    public int CannotRemoveLastCredential = 83;
    
    public int ConnectRequestAlreadyAuthorized = 84;

    /** 
     The type specified to update an instance of a thing is an older version of the type
     than the existing instance.
    */ 
    public int InvalidThingTypeVersion = 85;

    /**  
     The maximum number of allowed credentials has been exceeded.
    */  
    public int CredentialsLimitExceeded = 86;

    /** 
     One or more invalid methods were specified in the method mask.
    */ 
    public int InvalidMethod = 87;
    /**
    * The authentication token supplied for the other data streaming API is invalid. 
    */
    public int InvalidOtherDataToken = 88;

    /** 
     The type version of the thing cannot be changed without a data xml supplied for validation.
    */
    public int UpdateThingTypeVersionNoDataXml = 90;
	
}
