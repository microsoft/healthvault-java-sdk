package com.microsoft.hsg.android.healthvault;

public interface HealthVaultInitializationHandler {

	public void onConnected();
	
	public void onError(Exception e);
}
