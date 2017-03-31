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
import com.microsoft.hsg.methods.jaxb.getapplicationsettings.request.GetApplicationSettings;
import com.microsoft.hsg.methods.jaxb.getapplicationsettings.response.GetApplicationSettingsResponse;

@RunWith(JMock.class)
public class GetApplicationSettingsTest {
	

	private Mockery context = new JUnit4Mockery() {{
        setImposteriser(ClassImposteriser.INSTANCE);
    }};

	/**
     * Create the test case
     *
     */
    public GetApplicationSettingsTest()
    {
    }
    
    @Test
    public void GetApplicationSettings() throws Exception
    {
    	SimpleRequestTemplate requestTemplate = new SimpleRequestTemplate(
    			ConnectionFactory.getConnection());
    	requestTemplate.setPersonId("75ac2c6c-c90e-4f7e-b74d-bb7e81787beb");
    	
    	GetApplicationSettingsResponse response = 
    		(GetApplicationSettingsResponse)requestTemplate.makeRequest(
    			new GetApplicationSettings());
    	
    	Assert.assertNotNull(response);
    }
}
