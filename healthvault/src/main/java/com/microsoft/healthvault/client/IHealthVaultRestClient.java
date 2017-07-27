package com.microsoft.healthvault.client;

import com.microsoft.healthvault.restapi.implementation.MicrosoftHealthVaultRESTAPIImpl;

public interface IHealthVaultRestClient {
	MicrosoftHealthVaultRESTAPIImpl getClient();
}
