package com.microsoft.healthvault.client;

import com.microsoft.healthvault.HealthVaultConfiguration;
import com.microsoft.healthvault.HealthVaultConnectionFactory;
import com.microsoft.healthvault.IHealthVaultSodaConnection;
import com.microsoft.healthvault.thingtypes.Thing2;
import com.microsoft.healthvault.thingtypes.ThingKey;
import com.microsoft.healthvault.thingtypes.Weight;
import com.microsoft.healthvault.types.Guid;
import com.microsoft.healthvault.types.PersonInfo;
import com.microsoft.healthvault.types.Record;

import junit.framework.Assert;
import junit.framework.TestCase;

import java.util.ArrayList;

public class ThingClientTest extends TestCase {
    private HealthVaultConfiguration configuration;
    private IHealthVaultSodaConnection connection;
    private IThingClient thingClient;
    private PersonInfo personInfo;
    private Record record;

    public ThingClientTest() {
    }

    public void setUp() throws Exception {
        this.configuration = TestSettings.getTestConfiguration();
        this.record = TestSettings.getTestRecord();
        this.connection = HealthVaultConnectionFactory.Current().GetOrCreateSodaConnection(this.configuration);
        this.connection.setSessionCredential(TestSettings.getTestSessionCredential());
        this.thingClient = connection.createThingClient();
        this.personInfo = connection.getPersonInfo(); // authenticate or refresh token.
    }

    public void testGetThingById() {
        Thing2 theThing = this.thingClient.getThingAsync(new Guid(this.record.getId()), new Guid("8f87a5c6-ff24-46b2-903a-380be3ac720c"));

        Assert.assertNotNull(theThing);
        Assert.assertTrue(theThing.getTypeId().getValue().equalsIgnoreCase(Weight.ThingType));
    }

    public void testCreateThings() {
        Thing2 thing1 = new Thing2();
        Weight weight = new Weight(51);
        thing1.setData(weight);

        Thing2 thing2 = new Thing2();
        Weight weight2 = new Weight(52);
        thing2.setData(weight2);

        ArrayList<Thing2> things = new ArrayList<>();
        things.add(thing1);
        things.add(thing2);

        ArrayList<ThingKey> result = this.thingClient.createThingsAsync(new Guid(this.record.getId()), things);
        Assert.assertNotNull(result);
        Assert.assertEquals(2, result.size());
    }

    public void testRemoveThings() {
        Thing2 thing1 = new Thing2();
        Weight weight = new Weight(51);
        thing1.setData(weight);

        ArrayList<Thing2> things = new ArrayList<>();
        things.add(thing1);

        ArrayList<ThingKey> result = this.thingClient.createThingsAsync(new Guid(this.record.getId()), things);
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());

        things.clear();
        thing1 = new Thing2();
        thing1.setThingId(result.get(0));
        things.add(thing1);

        this.thingClient.removeThingsAsync(new Guid(this.record.getId()), things);

        Thing2 theThing = this.thingClient.getThingAsync(new Guid(this.record.getId()), new Guid(thing1.getThingId().getValue()));

        Assert.assertNull(theThing);
    }

}
