package com.microsoft.hsg.jaxb;

import java.util.Calendar;

import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.microsoft.hsg.ConnectionFactory;
import com.microsoft.hsg.methods.jaxb.SimpleRequestTemplate;
import com.microsoft.hsg.methods.jaxb.putthings.request.PutThingsRequest;
import com.microsoft.hsg.methods.jaxb.putthings.response.PutThingsResponse;
import com.microsoft.hsg.methods.jaxb.removethings.request.RemoveThingsRequest;
import com.microsoft.hsg.thing.oxm.jaxb.base.DisplayValue;
import com.microsoft.hsg.thing.oxm.jaxb.base.WeightValue;
import com.microsoft.hsg.thing.oxm.jaxb.dates.Date;
import com.microsoft.hsg.thing.oxm.jaxb.dates.DateTime;
import com.microsoft.hsg.thing.oxm.jaxb.thing.Thing;
import com.microsoft.hsg.thing.oxm.jaxb.thing.ThingKey;
import com.microsoft.hsg.thing.oxm.jaxb.thing.ThingType;
import com.microsoft.hsg.thing.oxm.jaxb.weight.Weight;

@RunWith(JMock.class)
public class RemoveThingsTest {
	

	private Mockery context = new JUnit4Mockery() {{
        setImposteriser(ClassImposteriser.INSTANCE);
    }};

    private SimpleRequestTemplate requestTemplate;
    
    @Before
    public void setUp()
    {
    	requestTemplate = new SimpleRequestTemplate(
			ConnectionFactory.getConnection());
    	requestTemplate.setPersonId("75ac2c6c-c90e-4f7e-b74d-bb7e81787beb");
    	requestTemplate.setRecordId("8c390004-3d41-4f5c-8f24-4841651579d6");
    }
    
	/**
     * Create the test case
     *
     */
    @Test
    public void RemoveThingsTest() throws Exception
    {
    	ThingKey thingToRemove = PutNewThing();
    	RemoveThingsRequest requestInfo = new RemoveThingsRequest();
    	requestInfo.getThingId().add(thingToRemove);
    	
    	requestTemplate.makeRequest(requestInfo);
    }
    
    
  
    public ThingKey PutNewThing() throws Exception
    {
    	PutThingsRequest request = new PutThingsRequest();
    	Weight weight = new Weight();
    	
    	WeightValue wv = new WeightValue();
    	wv.setKg(80);
    	weight.setValue(wv);
    	
    	Calendar now = Calendar.getInstance();
    	Date date = new Date();
    	date.setD(now.get(Calendar.DAY_OF_MONTH));
    	date.setM(now.get(Calendar.MONTH) + 1);
    	date.setY(now.get(Calendar.YEAR));
    	
    	DateTime when = new DateTime();
    	when.setDate(date);
    	
    	weight.setWhen(when);
    	
    	DisplayValue dv = new DisplayValue();
    	dv.setUnits("lb");
    	dv.setUnitsCode("lb");
    	wv.setDisplay(dv);
    	
    	Thing thing = new Thing();
    	thing.setData(weight);
    	
    	ThingType thingType = new ThingType();
    	thingType.setValue("3d34d87e-7fc1-4153-800f-f56592cb0d17");
    	thing.setTypeId(thingType);
    	
    	request.getThing().add(thing);
    	
    	PutThingsResponse response = (PutThingsResponse)requestTemplate.makeRequest(request);
    	return response.getThingId().get(0);
    }
}
