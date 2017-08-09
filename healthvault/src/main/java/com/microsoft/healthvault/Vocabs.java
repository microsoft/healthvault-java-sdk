package com.microsoft.healthvault;

import com.microsoft.healthvault.client.request.RequestTemplate;
import com.microsoft.healthvault.generated.methods.GetVocabulary.request.GetVocabularyRequest;
import com.microsoft.healthvault.generated.methods.GetVocabulary.request.VocabularyParameters;
import com.microsoft.healthvault.generated.methods.GetVocabulary.response.GetVocabularyResponse;
import com.microsoft.healthvault.generated.methods.SearchVocabulary.request.SearchVocabularyRequest;
import com.microsoft.healthvault.generated.methods.SearchVocabulary.request.VocabularySearchParams;
import com.microsoft.healthvault.generated.methods.SearchVocabulary.request.VocabularySearchString;
import com.microsoft.healthvault.generated.methods.SearchVocabulary.response.SearchVocabularyResponse;
import com.microsoft.healthvault.generated.vocabulary.VocabularyCodeSet;
import com.microsoft.healthvault.generated.vocabulary.VocabularyKey;
import com.microsoft.hsg.Connection;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class Vocabs {
	
	public List<VocabularyCodeSet> get(ArrayList<VocabularyKey> vocabIds) {
		
		Connection connection = HealthVaultApp.getInstance().getConnection();
		
		RequestTemplate requestTemplate = new RequestTemplate(connection);

		VocabularyParameters getParams = new VocabularyParameters();
		getParams.setVocabularyKey(vocabIds);
		
		GetVocabularyRequest request = new GetVocabularyRequest();
		request.setVocabularyParameters(getParams);

		GetVocabularyResponse response = requestTemplate.makeRequest(
			request,
			GetVocabularyResponse.class);

		if(response != null) {
			List<VocabularyCodeSet> vocabularyCodeSets = response.getVocabulary();
			if (vocabularyCodeSets != null && !vocabularyCodeSets.isEmpty()) {
				return vocabularyCodeSets;
			}
		}
		
		return new ArrayList<VocabularyCodeSet>();
	}
	
	public VocabularyCodeSet search(VocabularyKey vocabKey, String searchText) {
		
		Connection connection = HealthVaultApp.getInstance().getConnection();
		RequestTemplate requestTemplate = new RequestTemplate(connection);
		
		VocabularySearchString vocabSearch = new VocabularySearchString();
		vocabSearch.setValue(searchText);

		VocabularySearchParams params = new VocabularySearchParams();
		params.setSearchString(vocabSearch);

		SearchVocabularyRequest request = new SearchVocabularyRequest();
		request.setVocabularyKey(vocabKey);
		request.setTextSearchParameters(params);
		
		SearchVocabularyResponse response = requestTemplate.makeRequest(request, SearchVocabularyResponse.class);

		if(response != null) {
			response.getCodeSetResult();
		}
		
		return null;
	}
	
	public Callable<VocabularyCodeSet> searchAsync(final VocabularyKey vocabKey, final String searchText) {
		return new Callable<VocabularyCodeSet>() {

			@Override
			public VocabularyCodeSet call() throws Exception {
				return search(vocabKey, searchText);
			}
		};
	}
}
