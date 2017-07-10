package com.microsoft.healthvault;

import com.microsoft.healthvault.methods.getvocabulary2.request.GetVocabulary2Request;
import com.microsoft.healthvault.methods.getvocabulary2.request.VocabGetParams;
import com.microsoft.healthvault.methods.getvocabulary2.response.GetVocabulary2Response;
import com.microsoft.healthvault.methods.getvocabulary2.response.VocabCodeSet;
import com.microsoft.healthvault.methods.getvocabulary2.response.VocabGetResults;
import com.microsoft.healthvault.methods.request.RequestTemplate;
import com.microsoft.healthvault.methods.searchvocabulary.request.SearchVocabularyRequest;
import com.microsoft.healthvault.methods.searchvocabulary.request.VocabSearch;
import com.microsoft.healthvault.methods.searchvocabulary.response.SearchVocabularyResponse;
import com.microsoft.healthvault.methods.searchvocabulary.response.VocabQueryResult;
import com.microsoft.healthvault.methods.searchvocabulary.response.VocabQueryResults;
import com.microsoft.healthvault.types.VocabIdentifier;
import com.microsoft.hsg.Connection;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class Vocabs {
	
	public ArrayList<VocabCodeSet> get(ArrayList<VocabIdentifier> vocabIds) {
		
		Connection connection = HealthVaultApp.getInstance().getConnection();
		
		RequestTemplate requestTemplate = new RequestTemplate(connection);

		VocabGetParams getParams = new VocabGetParams(vocabIds);
		
		GetVocabulary2Request request = new GetVocabulary2Request(getParams);
		
		GetVocabulary2Response response = requestTemplate.makeRequest(
			request, 
			GetVocabulary2Response.class);
		
		VocabGetResults getResults = response.getInfo();
		
		if(getResults != null && getResults.HasVocabs()) {
			return getResults.getVocabs();
		}
		
		return new ArrayList<VocabCodeSet>();
	}
	
	public VocabQueryResult search(VocabIdentifier vocabKey, String searchText) {
		
		Connection connection = HealthVaultApp.getInstance().getConnection();
		RequestTemplate requestTemplate = new RequestTemplate(connection);
		
		VocabSearch vocabSearch = new VocabSearch(searchText);
		SearchVocabularyRequest request = new SearchVocabularyRequest(vocabKey, vocabSearch);
		
		SearchVocabularyResponse response = requestTemplate.makeRequest(request, SearchVocabularyResponse.class);
		
		VocabQueryResults results = response.getInfo();
		
		if(results != null && results.hasMatches()) {
			return results.matches;
		}
		
		return null;
	}
	
	public Callable<VocabQueryResult> searchAsync(final VocabIdentifier vocabKey, final String searchText) {
		return new Callable<VocabQueryResult>() {

			@Override
			public VocabQueryResult call() throws Exception {
				return search(vocabKey, searchText);
			}
		};
	}
}
