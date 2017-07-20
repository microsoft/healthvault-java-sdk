package com.microsoft.healthvault.client;

import com.microsoft.healthvault.HealthVaultConfiguration;
import com.microsoft.healthvault.HealthVaultConnectionFactory;
import com.microsoft.healthvault.IHealthVaultSodaConnection;
import com.microsoft.healthvault.SessionCredential;
import com.microsoft.healthvault.restapi.MicrosoftHealthVaultRESTAPI;
import com.microsoft.healthvault.restapi.models.ActionPlansResponseActionPlanInstance;
import com.microsoft.healthvault.types.PersonInfo;
import com.microsoft.healthvault.types.Record;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.joda.time.DateTime;
import org.joda.time.Period;

import java.util.List;

public class PersonClientTest extends TestCase {
    private HealthVaultConfiguration configuration;
    private IHealthVaultSodaConnection connection;
    private IPersonClient personClient;
    private Record record;

    public PersonClientTest() {
    }

    public void setUp() throws Exception {
        this.configuration = TestSettings.getTestConfiguration();
        this.record = TestSettings.getTestRecord();
        this.connection = HealthVaultConnectionFactory.Current().GetOrCreateSodaConnection(this.configuration);
        this.connection.setSessionCredential(TestSettings.getTestSessionCredential());
        this.personClient = connection.createPersonClient();
    }

    public void testGetPersonInfo() {
        IHealthVaultSodaConnection connection = this.connection;
        PersonInfo personInfo = connection.getPersonInfo();

        Assert.assertNotNull(personInfo);
    }

}
