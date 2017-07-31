package com.microsoft.healthvault.client;

import com.microsoft.healthvault.HealthVaultConfiguration;
import com.microsoft.healthvault.HealthVaultConnectionFactory;
import com.microsoft.healthvault.IHealthVaultSodaConnection;
import com.microsoft.healthvault.methods.getvocabulary2.response.VocabCodeSet;
import com.microsoft.healthvault.methods.getvocabulary2.response.VocabKey;
import com.microsoft.healthvault.thingtypes.Thing2;
import com.microsoft.healthvault.thingtypes.ThingKey;
import com.microsoft.healthvault.thingtypes.Weight;
import com.microsoft.healthvault.types.Guid;
import com.microsoft.healthvault.types.PersonInfo;
import com.microsoft.healthvault.types.Record;
import com.microsoft.healthvault.types.VocabFamily;
import com.microsoft.healthvault.types.VocabIdentifier;
import com.microsoft.healthvault.types.VocabItem;
import com.microsoft.healthvault.types.VocabName;

import junit.framework.Assert;
import junit.framework.TestCase;

import java.util.ArrayList;

public class VocabClientTest extends TestCase {
    private HealthVaultConfiguration configuration;
    private IHealthVaultSodaConnection connection;
    private IVocabularyClient vocabClient;
    private PersonInfo personInfo;
    private Record record;

    public VocabClientTest() {
    }

    public void setUp() throws Exception {
        this.configuration = TestSettings.getTestConfiguration();
        this.record = TestSettings.getTestRecord();
        this.connection = HealthVaultConnectionFactory.Current().GetOrCreateSodaConnection(this.configuration);
        this.connection.setSessionCredential(TestSettings.getTestSessionCredential());
        this.vocabClient = connection.createVocabularyClient();
        this.personInfo = connection.getPersonInfo(); // authenticate or refresh token.
    }

    public void testGetVocabularyKeys() {
        ArrayList<VocabKey> results = this.vocabClient.getVocabularyKeysAsync();

        Assert.assertNotNull(results);
        Assert.assertTrue(results.size() > 10);
    }

    public void testGetVocabulary() {
        VocabIdentifier key = new VocabIdentifier(VocabFamily.HealthVault, VocabName.AllergenType);
        ArrayList<VocabCodeSet> results = this.vocabClient.getVocabularyAsync(key, false);

        Assert.assertNotNull(results);
        Assert.assertTrue(results.size() > 0);
        Assert.assertEquals("allergen-type", results.get(0).getName());
        Assert.assertTrue(results.get(0).getItems().size() > 0);
    }

    public void testGetVocabularies() {
        ArrayList<VocabIdentifier> keys = new ArrayList<>();
        keys.add(new VocabIdentifier(VocabFamily.HealthVault, VocabName.BloodType));
        keys.add(new VocabIdentifier(VocabFamily.HealthVault, VocabName.PersonTypes));

        ArrayList<VocabCodeSet> results = this.vocabClient.getVocabulariesAsync(keys, false);

        Assert.assertNotNull(results);
        Assert.assertTrue(results.size() >= 2);
        Assert.assertTrue(results.get(0).getItems().size() > 0);
    }


    public void testSearchVocabularies() {
        ArrayList<VocabItem> results = this.vocabClient.searchVocabularyAsync("butternut", null, 0);

        Assert.assertNotNull(results);
    }
}
