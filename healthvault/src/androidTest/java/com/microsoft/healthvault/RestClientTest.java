package com.microsoft.healthvault;

import com.microsoft.healthvault.client.HealthVaultRestClient;
import com.microsoft.healthvault.methods.removethings.request.RemoveThingsRequest;
import com.microsoft.healthvault.methods.removethings.response.RemoveThingsResponse;
import com.microsoft.healthvault.methods.request.RequestTemplate;
import com.microsoft.healthvault.restapi.MicrosoftHealthVaultRESTAPI;
import com.microsoft.healthvault.restapi.implementation.MicrosoftHealthVaultRESTAPIImpl;
import com.microsoft.healthvault.restapi.models.ActionPlansResponseActionPlanInstance;
import com.microsoft.healthvault.thingtypes.Thing2;
import com.microsoft.healthvault.thingtypes.ThingKey;
import com.microsoft.healthvault.thingtypes.Weight;
import com.microsoft.healthvault.types.Guid;
import com.microsoft.healthvault.types.PersonInfo;
import com.microsoft.healthvault.types.Record;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.joda.time.DateTime;
import org.joda.time.Period;

import java.net.URL;
import java.util.List;

public class RestClientTest extends TestCase {
    private HealthVaultConfiguration configuration;
    private List<PersonInfo> personInfoList;
    private IHealthVaultSodaConnection connection;
    private Record record;

    public RestClientTest() {
    }


    public void setUp() throws Exception
    {
        HealthVaultConfiguration config = new HealthVaultConfiguration();
        config.setMasterApplicationId(new Guid("7c81b435-f091-4444-9534-59eb53da66c9"));
        config.setDefaultHealthVaultShellUri(new URL("https://account.healthvault-ppe.com"));
        config.setDefaultHealthVaultUri(new URL("https://platform.healthvault-ppe.com/platform"));
        config.setRestHealthVaultRootUri(new URL("https://data.ppe.microsofthealth.net"));
        config.setRestHealthVaultVersion("1.0-preview2");

        Record record = new Record();
        record.setId("20F3FEAA-BDE7-4A09-834A-F9AA6B385887");
        record.setPersonId("55218808-6E06-449B-8F41-26F773D4B5CD");

        SessionCredential cred = new SessionCredential();
        cred.setToken("AiAAAFixdV7ccO5FrRHAtzdYMCOBwQy6dbc1x55acmeZTvXPhmNXLRlJgq+hP71wDRn9ksAAAAApdduWnTjlohi+1Qy8+kqOLwrDdQCPxDK7SIieXFDSfWS3JcZKNJFVJXt6AmCUQqKMdMkLxxubvqsqLW4FceXCwJ1XmPqdR7w2i54ofsAlSh/XrIZ7+fVOWDwgJ3ykSj/J/JEJaQcrHS2YiO15PGLG6S7eZQdl+2nvjtNQzt9T5k8LUMeHT8hnsD17O58rcgT7UVggF/QOPc7sJBsv1xAoM1FpAJuZZ8jN+Ow1brTm29OeR/vBdMe1iQJr4Pv0C+0gAAAAyV6VxgW5LODSClsV6iv7zC2evbJ9N9/rNH+l0lOrhk4gAAAAyV6VxgW5LODSClsV6iv7zC2evbJ9N9/rNH+l0lOrhk4=");
        DateTime expiration = new DateTime();
        cred.setExpirationUtc(expiration.plus(Period.days(2)));

        this.connection = HealthVaultConnectionFactory.Current().GetOrCreateSodaConnection(config);
        this.connection.setSessionCredential(cred);
        this.configuration = config;
        this.record = record;
    }

    public void testRest() {
        IHealthVaultSodaConnection connection = HealthVaultConnectionFactory.Current().GetOrCreateSodaConnection(this.configuration);
        MicrosoftHealthVaultRESTAPI restClient = connection.createRestClient(record);
        ActionPlansResponseActionPlanInstance plans = restClient.actionPlans().get();
        int i = 1;
        i++;
    }
}
