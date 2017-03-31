package com.microsoft.hsg.android;

public interface HealthVaultInitializationHandler {

	public void OnConnected();
	
	public void onError(Exception e);
}
