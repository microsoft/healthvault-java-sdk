package com.microsoft.hsg.android.simplexml;

public enum ServerStatusCode {
	
	Ok(0),
	Failed(1),
	BadHttp(2),
	InvalidXml(3),
	InvalidRequestIntegrity(4),
	BadMethod(5),
	InvalidApp(6),
	CredentialTokenExpired(7),
	InvalidToken(8),
	InvalidPerson(9),
	InvalidRecord(10),
	AccessDenied(11),
	InvalidItem(13),
	InvalidFilter(15),
	InvalidApplicationAuthorization(18),
	TypeIdNotFound(19),
	DuplicateCredentialFound(22),
	InvalidRecordState(37),
	CredentialNotFound(82),
	RequestTimedOut(0x31),
	VocabNotFound(0x37),
	VersionStampMismatch(0x3d),
	AuthenticatedSessionTokenExpired(0x41),
	RecordQuotaExceeded(0x44),
	ApplicationLimitExceeded(0x5d),
	VocabAccessDenied(130),
	InvalidAge(157),
	InvalidIPAddress(158),
	MaxRecordsExceeded(160);
	
	private final int status;
	
	private ServerStatusCode(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}
}
