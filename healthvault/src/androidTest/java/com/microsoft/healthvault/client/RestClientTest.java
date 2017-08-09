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

public class RestClientTest extends TestCase {
    private HealthVaultConfiguration configuration;
    private List<PersonInfo> personInfoList;
    private IHealthVaultSodaConnection connection;

    public RestClientTest() {
    }

    public void setUp() throws Exception
    {
        this.configuration = TestSettings.getTestConfiguration();
        this.connection = HealthVaultConnectionFactory.Current().GetOrCreateSodaConnection(this.configuration);
        this.connection.setSessionCredential(TestSettings.getTestSessionCredential());
        this.connection.authenticate();
    }

    public void testRest() {
        IHealthVaultSodaConnection connection = this.connection;
        MicrosoftHealthVaultRESTAPI restClient = connection.createRestClient(TestSettings.getTestRecord());
        ActionPlansResponseActionPlanInstance plans = restClient.actionPlans().get();
        Assert.assertNotNull(plans);
        Assert.assertTrue(plans.plans().size() > 0);
    }
}
