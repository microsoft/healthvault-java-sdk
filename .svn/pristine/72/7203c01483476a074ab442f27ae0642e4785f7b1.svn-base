package com.microsoft.hsg.jaxb;

import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.microsoft.hsg.ConnectionFactory;
import com.microsoft.hsg.methods.jaxb.SimpleRequestTemplate;
import com.microsoft.hsg.methods.jaxb.setapplicationsettings.request.AppSettings;
import com.microsoft.hsg.methods.jaxb.setapplicationsettings.request.SetApplicationSettingsRequest;

@RunWith(JMock.class)
public class SetApplicationSettingsTest {
	

	private Mockery context = new JUnit4Mockery() {{
        setImposteriser(ClassImposteriser.INSTANCE);
    }};

	/**
     * Create the test case
     *
     */
    public SetApplicationSettingsTest()
    {
    }
    
    @Test
    public void SetApplicationSettings() throws Exception
    {
    	SimpleRequestTemplate requestTemplate = new SimpleRequestTemplate(
    			ConnectionFactory.getConnection());
    	requestTemplate.setPersonId("75ac2c6c-c90e-4f7e-b74d-bb7e81787beb");
    	requestTemplate.setRecordId("8c390004-3d41-4f5c-8f24-4841651579d6");
    	
    	AppSettings settings = new AppSettings();
    	
    	SetApplicationSettingsRequest requestInfo = new SetApplicationSettingsRequest();
    	requestInfo.setAppSettings(settings);
    	
    	requestTemplate.makeRequest(requestInfo);
    }
}
