package com.microsoft.hsg.jaxb;

import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.microsoft.hsg.ConnectionFactory;
import com.microsoft.hsg.methods.jaxb.SimpleRequestTemplate;
import com.microsoft.hsg.methods.jaxb.getupdatedrecordsforapplication.request.GetUpdatedRecordsForApplicationRequest;
import com.microsoft.hsg.methods.jaxb.getupdatedrecordsforapplication.response.GetUpdatedRecordsForApplicationResponse;

@RunWith(JMock.class)
public class GetUpdatedRecordsForApplicationTest {
	

	private Mockery context = new JUnit4Mockery() {{
        setImposteriser(ClassImposteriser.INSTANCE);
    }};

	/**
     * Create the test case
     *
     */
    public GetUpdatedRecordsForApplicationTest()
    {
    }
    
    @Test
    public void GetUpdatedRecords() throws Exception
    {
    	SimpleRequestTemplate requestTemplate = new SimpleRequestTemplate(
    			ConnectionFactory.getConnection());
    	
    	GetUpdatedRecordsForApplicationResponse response = 
    		(GetUpdatedRecordsForApplicationResponse)requestTemplate.makeRequest(
    			new GetUpdatedRecordsForApplicationRequest());
    	
    	Assert.assertNotNull(response);
    }
}
