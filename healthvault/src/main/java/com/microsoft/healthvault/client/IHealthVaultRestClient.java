package com.microsoft.healthvault.client;

import com.microsoft.healthvault.restapi.implementation.MicrosoftHealthVaultRestApiImpl;

public interface IHealthVaultRestClient {

	public MicrosoftHealthVaultRestApiImpl getClient();
}
