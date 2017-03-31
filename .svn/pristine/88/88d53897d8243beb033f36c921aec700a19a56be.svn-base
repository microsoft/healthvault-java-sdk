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
import com.microsoft.hsg.methods.jaxb.getservicedefinition2.request.GetServiceDefinition2Request;
import com.microsoft.hsg.methods.jaxb.getservicedefinition2.response.GetServiceDefinition2Response;

@RunWith(JMock.class)
public class GetServiceDefinitionTest {
	

	private Mockery context = new JUnit4Mockery() {{
        setImposteriser(ClassImposteriser.INSTANCE);
    }};

	/**
     * Create the test case
     *
     */
    public GetServiceDefinitionTest()
    {
    }
    
    @Test
    public void GetServiceDefinition() throws Exception
    {
    	SimpleRequestTemplate requestTemplate = new SimpleRequestTemplate(
    			ConnectionFactory.getConnection());
    	
    	GetServiceDefinition2Response response = 
    		(GetServiceDefinition2Response)requestTemplate.makeRequest(
    			new GetServiceDefinition2Request());
    	
    	Assert.assertNotNull(response);
    }
}
