package com.microsoft.hsg.jaxb.things;

import java.math.BigInteger;

import org.junit.Before;
import org.junit.Test;

import com.microsoft.hsg.ConnectionFactory;
import com.microsoft.hsg.methods.jaxb.SimpleRequestTemplate;
import com.microsoft.hsg.methods.jaxb.getthings.request.GetThingsRequest;
import com.microsoft.hsg.methods.jaxb.getthings.request.ThingFilterSpec;
import com.microsoft.hsg.methods.jaxb.getthings.request.ThingFormatSpec;
import com.microsoft.hsg.methods.jaxb.getthings.request.ThingRequestGroup;
import com.microsoft.hsg.methods.jaxb.getthings.request.ThingSectionSpec;
import com.microsoft.hsg.methods.jaxb.getthings.response.GetThingsResponse;
import com.microsoft.hsg.methods.jaxb.putthings.request.PutThingsRequest;
import com.microsoft.hsg.methods.jaxb.putthings.response.PutThingsResponse;
import com.microsoft.hsg.thing.oxm.jaxb.base.Name;
import com.microsoft.hsg.thing.oxm.jaxb.base.Person;
import com.microsoft.hsg.thing.oxm.jaxb.thing.Thing;
import com.microsoft.hsg.thing.oxm.jaxb.thing.TypeManager;



public class ContactTest {

private SimpleRequestTemplate requestTemplate;
	
	@Before
	public void before()
	{
		requestTemplate = new SimpleRequestTemplate(
    			ConnectionFactory.getConnection());
    	requestTemplate.setPersonId("75ac2c6c-c90e-4f7e-b74d-bb7e81787beb");
    	requestTemplate.setRecordId("8c390004-3d41-4f5c-8f24-4841651579d6");
	}
	
	@Test
	public void testBasicPutGet() throws Exception
	{
		Thing thing = new Thing();
    	thing.setData(createValidContact());
		
		PutThingsRequest request = new PutThingsRequest();
    	request.getThing().add(thing);
    	
    	PutThingsResponse response = (PutThingsResponse)requestTemplate.makeRequest(request);
    	
    	ThingRequestGroup group = new ThingRequestGroup();
    	
    	ThingFilterSpec filter = new ThingFilterSpec();
    	filter.getTypeId().add(TypeManager.getTypeForClass(Person.class));
    	group.getFilter().add(filter);
    	
    	ThingFormatSpec format = new ThingFormatSpec();
    	format.getSection().add(ThingSectionSpec.CORE);
    	format.getXml().add("");
    	group.setFormat(format);
    	group.setMax(BigInteger.valueOf(30));
    	
    	GetThingsRequest info = new GetThingsRequest();
    	info.getGroup().add(group);
    	
    	GetThingsResponse thingsResponse = 
    		(GetThingsResponse)requestTemplate.makeRequest(info);
    	
    	 Person result = (Person)thingsResponse.getGroup().get(0).getThing().get(0).getData();
	}
	
	private Person createValidContact()
	{	
		Name name = new Name();
		name.setFull("Dr. Who");
		Person person = new Person();
		person.setName(name);
		
		return person;
	}
}
