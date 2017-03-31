package com.microsoft.hsg.jaxb;

import junit.framework.Assert;

import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.microsoft.hsg.ConnectionFactory;
import com.microsoft.hsg.methods.jaxb.SimpleRequestTemplate;
import com.microsoft.hsg.methods.jaxb.searchvocabulary.request.SearchVocabularyRequest;
import com.microsoft.hsg.methods.jaxb.searchvocabulary.request.VocabularySearchParams;
import com.microsoft.hsg.methods.jaxb.searchvocabulary.request.VocabularySearchString;
import com.microsoft.hsg.methods.jaxb.searchvocabulary.response.SearchVocabularyResponse;
import com.microsoft.hsg.methods.jaxb.vocab.VocabularyKey;

@RunWith(JMock.class)
public class SearchVocabularyTest {
	

	private Mockery context = new JUnit4Mockery() {{
        setImposteriser(ClassImposteriser.INSTANCE);
    }};

	/**
     * Create the test case
     *
     */
    public SearchVocabularyTest()
    {
    }
    
    @Test
    public void SearchVocabulary() throws Exception
    {
    	SimpleRequestTemplate requestTemplate = new SimpleRequestTemplate(
    			ConnectionFactory.getConnection());
    	
    	VocabularyKey key = new VocabularyKey();
    	key.setName("time-zones");
    	
    	VocabularySearchString searchString = new VocabularySearchString();
    	searchString.setValue("Yellow");
    	searchString.setSearchMode("Contains");
    	
    	VocabularySearchParams params = new VocabularySearchParams();
    	params.setSearchString(searchString);
    	
    	SearchVocabularyRequest request = new SearchVocabularyRequest();
    	request.setTextSearchParameters(params);
    	request.setVocabularyKey(key);
    	
    	SearchVocabularyResponse response = 
    		(SearchVocabularyResponse)requestTemplate.makeRequest(request);
    	
    	Assert.assertNotNull(response);
    }
}
