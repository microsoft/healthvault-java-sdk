package com.microsoft.hsg.jaxb;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeFactory;

import junit.framework.Assert;

import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.microsoft.hsg.ConnectionFactory;
import com.microsoft.hsg.methods.jaxb.SimpleRequestTemplate;
import com.microsoft.hsg.methods.jaxb.getauthorizedconnectrequests.request.GetAuthorizedConnectRequestsRequest;
import com.microsoft.hsg.methods.jaxb.getauthorizedconnectrequests.response.GetAuthorizedConnectRequestsResponse;

@RunWith(JMock.class)
public class GetAuthorizedConnectRequests {
	

	private Mockery context = new JUnit4Mockery() {{
        setImposteriser(ClassImposteriser.INSTANCE);
    }};

	/**
     * Create the test case
     *
     */
    public GetAuthorizedConnectRequests()
    {
    }
    
    @Test
    public void TestGetAuthorizedConnectRequests() throws Exception
    {
    	SimpleRequestTemplate requestTemplate = new SimpleRequestTemplate(
    			ConnectionFactory.getConnection());
    	
    	GetAuthorizedConnectRequestsRequest request = new GetAuthorizedConnectRequestsRequest();
    	GregorianCalendar cal  = new GregorianCalendar();
    	cal.add(Calendar.YEAR, -1);
    	request.setAuthorizedConnectRequestsSince(
    		DatatypeFactory.newInstance().newXMLGregorianCalendar(cal));
    	
    	GetAuthorizedConnectRequestsResponse response = 
    		(GetAuthorizedConnectRequestsResponse)requestTemplate.makeRequest(request);
    	
    	Assert.assertNotNull(response);
    }
}
