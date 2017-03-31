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
import com.microsoft.hsg.methods.jaxb.getauthorizedpeople.request.GetAuthorizedPeopleParameters;
import com.microsoft.hsg.methods.jaxb.getauthorizedpeople.request.GetAuthorizedPeopleRequest;
import com.microsoft.hsg.methods.jaxb.getauthorizedpeople.response.GetAuthorizedPeopleResponseWrapper;

@RunWith(JMock.class)
public class GetAuthorizedPeopleTest {
	

	private Mockery context = new JUnit4Mockery() {{
        setImposteriser(ClassImposteriser.INSTANCE);
    }};

	/**
     * Create the test case
     *
     */
    public GetAuthorizedPeopleTest()
    {
    }
    
    @Test
    public void GetAuthorizedPeople() throws Exception
    {
    	SimpleRequestTemplate requestTemplate = new SimpleRequestTemplate(
    			ConnectionFactory.getConnection());
    	
    	GetAuthorizedPeopleRequest request = new GetAuthorizedPeopleRequest();
    	GetAuthorizedPeopleParameters params = new GetAuthorizedPeopleParameters();
    	request.setParameters(params);
    	
    	GetAuthorizedPeopleResponseWrapper response = 
    		(GetAuthorizedPeopleResponseWrapper)requestTemplate.makeRequest(request);
    	
    	Assert.assertNotNull(response);
    }
}
