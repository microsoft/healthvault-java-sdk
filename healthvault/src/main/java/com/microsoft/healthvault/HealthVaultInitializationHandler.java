package com.microsoft.healthvault;

public interface HealthVaultInitializationHandler {

	public void onConnected();
	
	public void onError(Exception e);
}
