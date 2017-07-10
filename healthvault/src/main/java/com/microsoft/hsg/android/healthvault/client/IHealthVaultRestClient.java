package com.microsoft.hsg.android.healthvault.client;


import healthvault.client.implementation.MicrosoftHealthVaultRestApiImpl;

public interface IHealthVaultRestClient {

	public MicrosoftHealthVaultRestApiImpl getClient();
}
