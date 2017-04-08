package com.microsoft.hsg.android.simplexml.test;

import java.util.ArrayList;

import junit.framework.TestCase;
import android.util.Base64;

import com.microsoft.hsg.Connection;
import com.microsoft.hsg.android.simplexml.ConnectionFactory;
import com.microsoft.hsg.android.simplexml.HealthVaultApp;
import com.microsoft.hsg.android.simplexml.methods.getvocabulary2.request.GetVocabulary2Request;
import com.microsoft.hsg.android.simplexml.methods.getvocabulary2.request.VocabGetParams;
import com.microsoft.hsg.android.simplexml.methods.getvocabulary2.response.GetVocabulary2Response;
import com.microsoft.hsg.android.simplexml.methods.request.RequestTemplate;
import com.microsoft.hsg.android.simplexml.methods.searchvocabulary.request.SearchVocabularyRequest;
import com.microsoft.hsg.android.simplexml.methods.searchvocabulary.request.VocabSearch;
import com.microsoft.hsg.android.simplexml.methods.searchvocabulary.response.SearchVocabularyResponse;
import com.microsoft.hsg.android.simplexml.things.types.base.VocabFamily;
import com.microsoft.hsg.android.simplexml.things.types.base.VocabName;
import com.microsoft.hsg.android.simplexml.vocabs.types.VocabIdentifier;

public class VocabTest extends TestCase {

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
}
