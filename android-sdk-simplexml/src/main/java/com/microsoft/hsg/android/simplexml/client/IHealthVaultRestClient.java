package com.microsoft.hsg.android.simplexml.client;


import com.microsoft.hsg.Connection;
import com.microsoft.hsg.android.simplexml.HealthVaultSettings;
import com.microsoft.hsg.android.simplexml.things.types.types.Record;

import healthvault.client.implementation.MicrosoftHealthVaultRestApiImpl;

public interface IHealthVaultRestClient {

	public MicrosoftHealthVaultRestApiImpl getClient();
}
