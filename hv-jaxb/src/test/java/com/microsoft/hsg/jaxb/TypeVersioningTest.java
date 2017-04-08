package com.microsoft.hsg.jaxb;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junit.framework.Assert;

import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

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
import com.microsoft.hsg.methods.jaxb.removethings.request.RemoveThingsRequest;
import com.microsoft.hsg.thing.oxm.jaxb.base.CodableValue;
import com.microsoft.hsg.thing.oxm.jaxb.thing.Thing;

@RunWith(JMock.class)
public class TypeVersioningTest {
    
    private static String medication2Type = "30cafccc-047d-4288-94ef-643571f7919d";
    private static String medication1Type = "5c5f1223-f63c-4464-870c-3e36ba471def";
    
    private Mockery context = new JUnit4Mockery() {{
        setImposteriser(ClassImposteriser.INSTANCE);
    }};

    @Test
    public void GetAllVersions() throws Exception
    {
        List<Thing> t = GetAllMedications();
        String [] expected = new String[]{
            medication1Type,
            medication2Type
        };
        
        Assert.assertEquals(2, t.size());
        
        String[] actual = new String[2];
        actual[0] = t.get(0).getTypeId().getValue();
        actual[1] = t.get(1).getTypeId().getValue();
        
        AssertArrays(expected, actual);
    }
    
    @Test
    public void DownConvertVersions() throws Exception
    {
        SimpleRequestTemplate requestTemplate = new SimpleRequestTemplate(
        ConnectionFactory.getConnection());
        requestTemplate.setPersonId("75ac2c6c-c90e-4f7e-b74d-bb7e81787beb");
        requestTemplate.setRecordId("8c390004-3d41-4f5c-8f24-4841651579d6");
        
        ThingRequestGroup group = new ThingRequestGroup();
        
        ThingFilterSpec filter = new ThingFilterSpec();
        filter.getTypeId().add(medication2Type);
        filter.getTypeId().add(medication1Type);
        group.getFilter().add(filter);
       
        ThingFormatSpec format = new ThingFormatSpec();
        format.getSection().add(ThingSectionSpec.CORE);
        format.getXml().add("");
        format.getTypeVersionFormat().add(medication1Type);
        group.setFormat(format);        
        
        GetThingsRequest info = new GetThingsRequest();
        info.getGroup().add(group);
        
        GetThingsResponse response = 
            (GetThingsResponse)requestTemplate.makeRequest(info);
        
        String [] expected = new String[]{
                medication1Type,
                medication1Type
            };
            
        Assert.assertEquals(2, response.getGroup().get(0).getThing().size());
        
        String[] actual = new String[2];
        actual[0] = response.getGroup().get(0).getThing().get(0).getTypeId().getValue();
        actual[1] = response.getGroup().get(0).getThing().get(1).getTypeId().getValue();
        
        AssertArrays(expected, actual);
    }
    
    @Test
    public void UpConvertVersions() throws Exception
    {
        SimpleRequestTemplate requestTemplate = new SimpleRequestTemplate(
        ConnectionFactory.getConnection());
        requestTemplate.setPersonId("75ac2c6c-c90e-4f7e-b74d-bb7e81787beb");
        requestTemplate.setRecordId("8c390004-3d41-4f5c-8f24-4841651579d6");
        
        ThingRequestGroup group = new ThingRequestGroup();
        
        ThingFilterSpec filter = new ThingFilterSpec();
        filter.getTypeId().add(medication2Type);
        filter.getTypeId().add(medication1Type);
        group.getFilter().add(filter);
       
        ThingFormatSpec format = new ThingFormatSpec();
        format.getSection().add(ThingSectionSpec.CORE);
        format.getXml().add("");
        format.getTypeVersionFormat().add(medication2Type);
        group.setFormat(format);        
        
        GetThingsRequest info = new GetThingsRequest();
        info.getGroup().add(group);
        
        GetThingsResponse response = 
            (GetThingsResponse)requestTemplate.makeRequest(info);
        
        String [] expected = new String[]{
                medication2Type,
                medication2Type
            };
            
        Assert.assertEquals(2, response.getGroup().get(0).getThing().size());
        
        String[] actual = new String[2];
        actual[0] = response.getGroup().get(0).getThing().get(0).getTypeId().getValue();
        actual[1] = response.getGroup().get(0).getThing().get(1).getTypeId().getValue();
        
        AssertArrays(expected, actual);
    }

    @Before
    public void Cleanup() throws Exception
    {
        List<Thing> things = GetAllMedications();
        RemoveThings(things);
        AddMeds();
    }
    
    private void AssertArrays(
            String[] expected, 
            String[] actual)
    {
        Arrays.sort(expected);
        Arrays.sort(actual);
        
        Assert.assertEquals(expected.length, actual.length);
        for(int i=0; i<expected.length; i++)
        {
            Assert.assertEquals(
                expected[i].toUpperCase(), 
                actual[i].toUpperCase());
        }
        
    }
    
    private void AddMeds() throws Exception
    {
        com.microsoft.hsg.thing.oxm.jaxb.medication1.Medication med1 = new com.microsoft.hsg.thing.oxm.jaxb.medication1.Medication();
        med1.setName("Test Med1");
        
        com.microsoft.hsg.thing.oxm.jaxb.medication.Medication med2 = new com.microsoft.hsg.thing.oxm.jaxb.medication.Medication();
        CodableValue name = new CodableValue();
        name.setText("Test Med2");
        med2.setName(name);
        
        List<Object> things = new ArrayList<Object>();
        things.add(med1);
        things.add(med2);
        PutThings(things);
    }
    
    private List<Thing> GetAllMedications() throws Exception
    {
        SimpleRequestTemplate requestTemplate = new SimpleRequestTemplate(
        ConnectionFactory.getConnection());
        requestTemplate.setPersonId("75ac2c6c-c90e-4f7e-b74d-bb7e81787beb");
        requestTemplate.setRecordId("8c390004-3d41-4f5c-8f24-4841651579d6");
        
        ThingRequestGroup group = new ThingRequestGroup();
        
        ThingFilterSpec filter = new ThingFilterSpec();
        filter.getTypeId().add(medication2Type);
        filter.getTypeId().add(medication1Type);
        group.getFilter().add(filter);
       
        ThingFormatSpec format = new ThingFormatSpec();
        format.getSection().add(ThingSectionSpec.CORE);
        format.getXml().add("");
        group.setFormat(format);        
        
        GetThingsRequest info = new GetThingsRequest();
        info.getGroup().add(group);
        
        GetThingsResponse response = 
            (GetThingsResponse)requestTemplate.makeRequest(info);
        
        return response.getGroup().get(0).getThing();
    }
    
    private void PutThings(List<Object> things) throws Exception
    {
        SimpleRequestTemplate requestTemplate = new SimpleRequestTemplate(
                ConnectionFactory.getConnection());
        requestTemplate.setPersonId("75ac2c6c-c90e-4f7e-b74d-bb7e81787beb");
        requestTemplate.setRecordId("8c390004-3d41-4f5c-8f24-4841651579d6");
            
        PutThingsRequest request = new PutThingsRequest();
        for( Object thing : things)
        {
            Thing t = new Thing();
            t.setData(thing);
            request.getThing().add(t);
        }
        PutThingsResponse response = (PutThingsResponse)requestTemplate.makeRequest(request);
    }
    
    private void RemoveThings(List<Thing> things) throws Exception
    {
        if (things.size() == 0) 
        {
            return;
        }
        
        RemoveThingsRequest removeThings = new RemoveThingsRequest();
        
        for ( Thing thing : things )
        {
            removeThings.getThingId().add(thing.getThingId());
        }
        
        SimpleRequestTemplate requestTemplate = new SimpleRequestTemplate(
        ConnectionFactory.getConnection());
        requestTemplate.setPersonId("75ac2c6c-c90e-4f7e-b74d-bb7e81787beb");
        requestTemplate.setRecordId("8c390004-3d41-4f5c-8f24-4841651579d6");
                
        requestTemplate.makeRequest(removeThings);
    }
}
