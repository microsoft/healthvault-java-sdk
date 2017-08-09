package com.microsoft.healthvault.client;

import com.microsoft.healthvault.HealthVaultConfiguration;
import com.microsoft.healthvault.SessionCredential;
import com.microsoft.healthvault.types.Guid;
import com.microsoft.healthvault.types.Record;

import java.net.MalformedURLException;
import java.net.URL;

public class TestSettings {
    public static HealthVaultConfiguration getTestConfiguration() throws MalformedURLException {
        HealthVaultConfiguration config = new HealthVaultConfiguration();
        // config.setMasterApplicationId(new Guid("7c81b435-f091-4444-9534-59eb53da66c9")); // master app id
        config.setMasterApplicationId(new Guid("a9b5417e-caa0-4025-b296-cf9456619a72")); // child app id
        config.setDefaultHealthVaultShellUri(new URL("https://account.healthvault-ppe.com"));
        config.setDefaultHealthVaultUri(new URL("https://platform.healthvault-ppe.com/platform/wildcat.ashx"));
        config.setRestHealthVaultRootUri(new URL("https://data.ppe.microsofthealth.net"));
        config.setRestHealthVaultVersion("1.0-rc");

        return config;
    }

    public static Record getTestRecord() {
        Record record = new Record();
        record.setId("0D668CA1-47FD-4D95-BDBB-B9827F77D472");
        record.setPersonId("5405A9B8-BA51-4C00-ADBA-445EA03D1366");
        return record;
    }

    public static SessionCredential getTestSessionCredential()
    {
        SessionCredential credential = new SessionCredential();
        credential.setSharedSecret("o7EyH7Ue8cgizFEuj3gEUBagV8VPkyD9l1+NYWgvTpY=");
        credential.setExpirationUtc();

        return credential;
    }
}
