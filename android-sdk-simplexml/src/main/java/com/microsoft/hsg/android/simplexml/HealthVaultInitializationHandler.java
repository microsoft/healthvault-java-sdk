package com.microsoft.hsg.android.simplexml;

public interface HealthVaultInitializationHandler {

	public void onConnected();
	
	public void onError(Exception e);
}
