package com.microsoft.healthvault;

import android.util.Base64;

import com.microsoft.hsg.Connection;

import junit.framework.TestCase;

public class VocabTest extends TestCase {

	/*
	TODO: These tests were not working prior to refactoring, will have to address once refactoring
	is complete

	private Connection connection;
	
	public VocabTest() {
	}
	
	public void setUp()
	{
        HVSettings settings = new HVSettings();
        HealthVaultApp app = new HealthVaultApp(settings);
        HealthVaultApp.setInstance(app);
		connection = ConnectionFactory.getConnection(
                    "90976b0c-e0c2-467e-b65c-ed9117aa94e9",
                    Base64.decode("JpGYZ54MRAhy2Gw9uoWCfxTG97ufR3v7kZ/i2JG+Utw=", Base64.DEFAULT));
	}

	public void testGetVocab() {
		RequestTemplate requestTemplate = new RequestTemplate(connection);
		
		ArrayList<VocabIdentifier> vocabIds = new ArrayList<VocabIdentifier>();
		
		VocabIdentifier vocabId = new VocabIdentifier(VocabFamily.HealthVault, VocabName.AllergenType);
		vocabIds.add(vocabId);

		VocabGetParams getParams = new VocabGetParams(vocabIds);
		
		GetVocabulary2Request request = new GetVocabulary2Request(getParams);
		
		GetVocabulary2Response response = requestTemplate.makeRequest(
			request, 
			GetVocabulary2Response.class);
		
		assert(response.isSuccess());
	}
	
	public void testSearchVocab() {
		RequestTemplate requestTemplate = new RequestTemplate(connection);
		
		VocabSearch vocabSearch = new VocabSearch("butter");
		VocabIdentifier vocabKey = new VocabIdentifier(VocabFamily.USDA, VocabName.FoodDescription);
		
		SearchVocabularyRequest request = new SearchVocabularyRequest(vocabKey, vocabSearch);
		
		SearchVocabularyResponse response = requestTemplate.makeRequest(
			request, 
			SearchVocabularyResponse.class);
		
		assert(response.isSuccess());
	}

	*/
}
