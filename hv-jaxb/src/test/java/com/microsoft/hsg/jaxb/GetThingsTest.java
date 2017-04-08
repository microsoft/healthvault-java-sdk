package com.microsoft.hsg.jaxb;

import java.math.BigInteger;

import junit.framework.Assert;

import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.microsoft.hsg.ConnectionFactory;
import com.microsoft.hsg.Request;
import com.microsoft.hsg.methods.jaxb.SimpleRequestTemplate;
import com.microsoft.hsg.methods.jaxb.getthings.request.GetThingsRequest;
import com.microsoft.hsg.methods.jaxb.getthings.request.ThingFilterSpec;
import com.microsoft.hsg.methods.jaxb.getthings.request.ThingFormatSpec;
import com.microsoft.hsg.methods.jaxb.getthings.request.ThingRequestGroup;
import com.microsoft.hsg.methods.jaxb.getthings.request.ThingSectionSpec;
import com.microsoft.hsg.methods.jaxb.getthings.response.GetThingsResponse;
import com.microsoft.hsg.thing.oxm.jaxb.basic.Basic;
import com.microsoft.hsg.thing.oxm.jaxb.thing.Thing;
import com.microsoft.hsg.thing.oxm.jaxb.weight.Weight;

@RunWith(JMock.class)
public class GetThingsTest {
	

	private Mockery context = new JUnit4Mockery() {{
        setImposteriser(ClassImposteriser.INSTANCE);
    }};

	/**
     * Create the test case
     *
     */
    public GetThingsTest()
    {
    }
    
    @Test
    public void GetThing() throws Exception
    {
    	SimpleRequestTemplate requestTemplate = new SimpleRequestTemplate(
    			ConnectionFactory.getConnection());
    	requestTemplate.setPersonId("75ac2c6c-c90e-4f7e-b74d-bb7e81787beb");
    	requestTemplate.setRecordId("8c390004-3d41-4f5c-8f24-4841651579d6");
    	
    	ThingRequestGroup group = new ThingRequestGroup();
    	
    	ThingFilterSpec filter = new ThingFilterSpec();
    	filter.getTypeId().add("3d34d87e-7fc1-4153-800f-f56592cb0d17");
    	group.getFilter().add(filter);
    	group.setMax(BigInteger.valueOf(30));
    	
    	ThingFormatSpec format = new ThingFormatSpec();
    	format.getSection().add(ThingSectionSpec.CORE);
    	format.getXml().add("");
    	group.setFormat(format);    	
    	
    	GetThingsRequest info = new GetThingsRequest();
    	info.getGroup().add(group);
    	
    	GetThingsResponse response = 
    		(GetThingsResponse)requestTemplate.makeRequest(info);
    	
    	Weight weight = (Weight)response.getGroup().get(0).getThing().get(0).getData();
    }
    
    @Test
    public void GetThingBasic() throws Exception
    {
    	SimpleRequestTemplate requestTemplate = new SimpleRequestTemplate(
    			ConnectionFactory.getConnection());
    	requestTemplate.setPersonId("75ac2c6c-c90e-4f7e-b74d-bb7e81787beb");
    	requestTemplate.setRecordId("8c390004-3d41-4f5c-8f24-4841651579d6");
    	
    	ThingRequestGroup group = new ThingRequestGroup();
    	
    	ThingFilterSpec filter = new ThingFilterSpec();
    	filter.getTypeId().add("3b3e6b16-eb69-483c-8d7e-dfe116ae6092");
    	group.getFilter().add(filter);
    	
    	ThingFormatSpec format = new ThingFormatSpec();
    	format.getSection().add(ThingSectionSpec.CORE);
    	format.getXml().add("");
    	group.setFormat(format);
    	group.setMax(BigInteger.valueOf(30));
    	
    	GetThingsRequest info = new GetThingsRequest();
    	info.getGroup().add(group);
    	
    	GetThingsResponse response = 
    		(GetThingsResponse)requestTemplate.makeRequest(info);
    	
    	Basic weight = (Basic)response.getGroup().get(0).getThing().get(0).getData();
    }
    
    @Test
    public void GetThingWithAudit() throws Exception
    {
    	SimpleRequestTemplate requestTemplate = new SimpleRequestTemplate(
    			ConnectionFactory.getConnection());
    	requestTemplate.setPersonId("75ac2c6c-c90e-4f7e-b74d-bb7e81787beb");
    	requestTemplate.setRecordId("8c390004-3d41-4f5c-8f24-4841651579d6");
    	
    	ThingRequestGroup group = new ThingRequestGroup();
    	
    	ThingFilterSpec filter = new ThingFilterSpec();
    	filter.getTypeId().add("3d34d87e-7fc1-4153-800f-f56592cb0d17");
    	group.getFilter().add(filter);
    	group.setMax(BigInteger.valueOf(30));
    	
    	ThingFormatSpec format = new ThingFormatSpec();
    	format.getSection().add(ThingSectionSpec.CORE);
    	format.getSection().add(ThingSectionSpec.AUDITS);
    	format.getXml().add("");
    	group.setFormat(format);    	
    	
    	GetThingsRequest info = new GetThingsRequest();
    	info.getGroup().add(group);
    	
    	GetThingsResponse response = 
    		(GetThingsResponse)requestTemplate.makeRequest(info);
    	
    	Thing thing = response.getGroup().get(0).getThing().get(0);
    	Assert.assertNotNull(thing.getCreated());
    }
    
    @Test
    public void GetThingToCCR() throws Exception
    {
    	Request request = new Request();
    	request.setFinalXsl("toccr");
    	
    	SimpleRequestTemplate requestTemplate = new SimpleRequestTemplate(
    			ConnectionFactory.getConnection());
    	requestTemplate.setPersonId("75ac2c6c-c90e-4f7e-b74d-bb7e81787beb");
    	requestTemplate.setRecordId("8c390004-3d41-4f5c-8f24-4841651579d6");
    	
    	ThingRequestGroup group = new ThingRequestGroup();
    	
    	ThingFilterSpec filter = new ThingFilterSpec();
    	filter.getTypeId().add("3d34d87e-7fc1-4153-800f-f56592cb0d17");
    	group.getFilter().add(filter);
    	group.setMax(BigInteger.valueOf(30));
    	
    	ThingFormatSpec format = new ThingFormatSpec();
    	format.getSection().add(ThingSectionSpec.CORE);
    	format.getSection().add(ThingSectionSpec.AUDITS);
    	format.getXml().add("");
    	group.setFormat(format);    	
    	
    	GetThingsRequest info = new GetThingsRequest();
    	info.getGroup().add(group);
    	
    	GetThingsResponse response = 
    		(GetThingsResponse)requestTemplate.makeRequest(request, info);
    }
}
