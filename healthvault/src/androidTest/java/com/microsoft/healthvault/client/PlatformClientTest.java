package com.microsoft.healthvault.client;

import com.microsoft.healthvault.HealthVaultConfiguration;
import com.microsoft.healthvault.HealthVaultConnectionFactory;
import com.microsoft.healthvault.IHealthVaultSodaConnection;
import com.microsoft.healthvault.ServiceInfo;
import com.microsoft.healthvault.ServiceInfoSections;
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

public class PlatformClientTest extends TestCase {
    private HealthVaultConfiguration configuration;
    private IHealthVaultSodaConnection connection;
    private IPersonClient personClient;
    private IPlatformClient platformClient;
    private Record record;

    public PlatformClientTest() {

    }

    public void setUp() throws Exception {
        this.configuration = TestSettings.getTestConfiguration();
        this.record = TestSettings.getTestRecord();
        this.connection = HealthVaultConnectionFactory.Current().GetOrCreateSodaConnection(this.configuration);
        this.connection.setSessionCredential(TestSettings.getTestSessionCredential());
        this.personClient = connection.createPersonClient();
        this.platformClient = connection.createPlatformClient();
        connection.getPersonInfo(); // authenticate or refresh token.
    }


    public void testGetServiceDefinition() {
        ServiceInfo info = this.platformClient.getServiceDefinitionAsync();

        Assert.assertNotNull(info);
    }
}
