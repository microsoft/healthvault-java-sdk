package com.microsoft.hsg.jaxb.things;

import java.io.StringReader;
import java.math.BigInteger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

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
import com.microsoft.hsg.oxm.jaxb.JaxbContextFactory;
import com.microsoft.hsg.thing.oxm.jaxb.allergy.Allergy;
import com.microsoft.hsg.thing.oxm.jaxb.base.CodableValue;
import com.microsoft.hsg.thing.oxm.jaxb.base.CodedValue;
import com.microsoft.hsg.thing.oxm.jaxb.base.Name;
import com.microsoft.hsg.thing.oxm.jaxb.base.Person;
import com.microsoft.hsg.thing.oxm.jaxb.dates.ApproxDate;
import com.microsoft.hsg.thing.oxm.jaxb.dates.ApproxDateTime;
import com.microsoft.hsg.thing.oxm.jaxb.dates.StructuredApproxDate;
import com.microsoft.hsg.thing.oxm.jaxb.thing.Thing;
import com.microsoft.hsg.thing.oxm.jaxb.thing.TypeManager;
import com.microsoft.hsg.thing.oxm.jaxb.weight.Weight;

public class AllergyTest {

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
    	thing.setData(createValidAllergy());
		
		PutThingsRequest request = new PutThingsRequest();
    	request.getThing().add(thing);
    	
    	PutThingsResponse response = (PutThingsResponse)requestTemplate.makeRequest(request);
    	
    	ThingRequestGroup group = new ThingRequestGroup();
    	
    	ThingFilterSpec filter = new ThingFilterSpec();
    	filter.getTypeId().add(TypeManager.getTypeForClass(Allergy.class));
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
    	
    	Allergy result = (Allergy)thingsResponse.getGroup().get(0).getThing().get(0).getData();
	}
	
	private Allergy createValidAllergy()
	{
		Allergy allergy = new Allergy();
		allergy.setName(new CodableValue("Dairy", 
				new CodedValue("value", "family", "type", "version")));
		
		ApproxDate dt = new ApproxDate();
		dt.setY(1960);
		StructuredApproxDate sad = new StructuredApproxDate();
		sad.setDate(dt);
		ApproxDateTime firstObs = new ApproxDateTime();
		firstObs.setStructured(sad);
		allergy.setFirstObserved(firstObs);
		
		allergy.setAllergenCode(new CodableValue("my-code"));
		
		Name name = new Name();
		name.setFull("Dr. Who");
		Person person = new Person();
		person.setName(name);
		allergy.setTreatmentProvider(person);
		
		return allergy;
	}
	
	@Test
	public void testUnknownElements() throws Exception
	{
		String xml = "<allergy><pleaseIgnoreMe/><name><text>Dairy</text><code><value>value</value><family>family</family><type>type</type><version>version</version></code></name></allergy>";
		JAXBContext ctx = JaxbContextFactory.getContext(Allergy.class.getPackage().getName());
		Unmarshaller um = ctx.createUnmarshaller();
		um.unmarshal(new StringReader(xml));
	}
}
