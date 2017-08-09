package com.microsoft.healthvault.client;

import com.microsoft.healthvault.HealthServiceInstance;
import com.microsoft.healthvault.HealthVaultConfiguration;
import com.microsoft.healthvault.HealthVaultConnectionFactory;
import com.microsoft.healthvault.IHealthVaultSodaConnection;
import com.microsoft.healthvault.ServiceInfo;
import com.microsoft.healthvault.ServiceInfoSections;
import com.microsoft.healthvault.SessionCredential;
import com.microsoft.healthvault.methods.getservicedefinition.request.ResponseSection;
import com.microsoft.healthvault.methods.getservicedefinition.response.GetServiceDefinitionResponseInfo;
import com.microsoft.healthvault.methods.selectinstance.response.SelectInstanceResponseInfo;
import com.microsoft.healthvault.restapi.MicrosoftHealthVaultRESTAPI;
import com.microsoft.healthvault.restapi.models.ActionPlansResponseActionPlanInstance;
import com.microsoft.healthvault.types.Guid;
import com.microsoft.healthvault.types.Location;
import com.microsoft.healthvault.types.PersonInfo;
import com.microsoft.healthvault.types.Record;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.joda.time.DateTime;
import org.joda.time.Instant;
import org.joda.time.Period;

import java.util.ArrayList;
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

    public void testSelectInstance() {
        Location loc = new Location();
        loc.setCountry("US");
        loc.setStateProvince("WA");

        HealthServiceInstance info = this.platformClient.selectInstanceAsync(loc);

        Assert.assertNotNull(info);
        Assert.assertEquals("US instance", info.getDescription());

        loc.setCountry("UK");
        loc.setStateProvince("JS"); // Greater London

        info = this.platformClient.selectInstanceAsync(loc);

        Assert.assertNotNull(info);
        Assert.assertEquals("EU Instance", info.getDescription());
    }

    public void testNewApplicationCreationInfo() {
        Assert.fail("implementation is not completed yet.");
    }

    public void testGetServiceDefinition() {
        GetServiceDefinitionResponseInfo info = this.platformClient.getServiceDefinitionAsync();

        Assert.assertNotNull(info);
        Assert.assertNotNull(info.getMeaningfulUse());
        Assert.assertNotNull(info.getShell());
        Assert.assertNotNull(info.getXmlMethod());
        Assert.assertTrue(info.getXmlMethod().size() > 0);
    }

    public void testGetServiceDefinitionWithSections() {
        ArrayList<ResponseSection> sections = new ArrayList<>();
        sections.add(ResponseSection.SHELL);
        sections.add(ResponseSection.PLATFORM);

        GetServiceDefinitionResponseInfo info = this.platformClient.getServiceDefinitionAsync(sections);

        Assert.assertNotNull(info);
        Assert.assertNotNull(info.getShell());
        Assert.assertNotNull(info.getPlatform());
        Assert.assertNull(info.getXmlMethod());
        Assert.assertNull(info.getMeaningfulUse());
    }

    public void testGetServiceDefinitionsWithInstant() {
        DateTime dt = new DateTime(2013, 03, 27, 12, 0);
        Instant instant = new Instant(dt);

        ArrayList<ResponseSection> sections = new ArrayList<>();
        sections.add(ResponseSection.PLATFORM);

        GetServiceDefinitionResponseInfo info = this.platformClient.getServiceDefinitionAsync(sections, instant);

        Assert.assertNotNull(info);
        Assert.assertNotNull(info.getPlatform());
    }
}
