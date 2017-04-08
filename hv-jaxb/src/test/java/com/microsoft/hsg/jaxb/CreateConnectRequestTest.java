package com.microsoft.hsg.jaxb;

import java.util.Random;

import junit.framework.Assert;

import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.microsoft.hsg.ConnectionFactory;
import com.microsoft.hsg.methods.jaxb.SimpleRequestTemplate;
import com.microsoft.hsg.methods.jaxb.createconnectrequest.request.CreateConnectRequestRequest;
import com.microsoft.hsg.methods.jaxb.createconnectrequest.response.CreateConnectRequestResponse;

@RunWith(JMock.class)
public class CreateConnectRequestTest {
	

	private Mockery context = new JUnit4Mockery() {{
        setImposteriser(ClassImposteriser.INSTANCE);
    }};

	/**
     * Create the test case
     *
     */
    public CreateConnectRequestTest()
    {
    }
    
    @Test
    public void CreateConnectRequest() throws Exception
    {
    	SimpleRequestTemplate requestTemplate = new SimpleRequestTemplate(
    			ConnectionFactory.getConnection());
    	//requestTemplate.setPersonId("75ac2c6c-c90e-4f7e-b74d-bb7e81787beb");
    	//requestTemplate.setRecordId("8c390004-3d41-4f5c-8f24-4841651579d6");
    	
    	CreateConnectRequestRequest connectRequest = new CreateConnectRequestRequest();
    	connectRequest.setFriendlyName("friendly-name");
    	connectRequest.setQuestion("What is your favorite color");
    	connectRequest.setAnswer("green");
    	connectRequest.setExternalId(newExternalId());
    	
    	CreateConnectRequestResponse response =
    		(CreateConnectRequestResponse)requestTemplate.makeRequest(connectRequest);
    	
    	Assert.assertNotNull(response);
    }
    
    private String newExternalId() throws Exception 
    {
    	byte[] buf = new byte[20];
    	
    	Random rand = new Random();
    	rand.nextBytes(buf);
    	
    	return hexToString(buf);
    }
    
    static final byte[] HEX_CHARS= {
        (byte)'0', (byte)'1', (byte)'2', (byte)'3',
        (byte)'4', (byte)'5', (byte)'6', (byte)'7',
        (byte)'8', (byte)'9', (byte)'a', (byte)'b',
        (byte)'c', (byte)'d', (byte)'e', (byte)'f'
    };    

    private static String hexToString(byte[] raw) throws Exception 
    {
        byte[] hex = new byte[2 * raw.length];
        int index = 0;

        for (byte b : raw) 
        {
          int v = b & 0xFF;
          hex[index++] = HEX_CHARS[v >>> 4];
          hex[index++] = HEX_CHARS[v & 0xF];
        }
        return new String(hex, "ASCII");
    }

}
