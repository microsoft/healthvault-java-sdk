package com.microsoft.healthvault;

import com.microsoft.healthvault.methods.getthings3.request.ThingRequestGroup2;
import com.microsoft.healthvault.methods.getthings3.response.ThingResponseGroup2;
import com.microsoft.healthvault.things.thing.Extension;
import com.microsoft.healthvault.things.thing.Thing2;
import com.microsoft.healthvault.things.thing.ThingKey;
import com.microsoft.healthvault.things.types.PersonalDemographics;
import com.microsoft.healthvault.things.types.Weight;
import com.microsoft.healthvault.things.types.types.PersonInfo;
import com.microsoft.healthvault.things.types.types.Record;

import junit.framework.TestCase;

import java.util.List;

public class RecordTest extends TestCase {

	private List<PersonInfo> personInfoList;
	
	public void setUp()
	{
        HVSettings settings = new HVSettings();
        settings.setAppId("90976b0c-e0c2-467e-b65c-ed9117aa94e9");
        settings.setAuthenticationSecret("JpGYZ54MRAhy2Gw9uoWCfxTG97ufR3v7kZ/i2JG+Utw=");
		HealthVaultApp app = new HealthVaultApp(settings);
		HealthVaultApp.setInstance(app);
		app.resolvePersonInfoList();
		personInfoList = HealthVaultApp.getInstance().getPersonInfoList() ;
	}
	
	public void testGetThingsByType() {
		Record record = personInfoList.get(0).getRecords().get(0);
		ThingRequestGroup2 request = ThingRequestGroup2.thingTypeQuery(Weight.ThingType);
		// request.setMax(100);
		ThingResponseGroup2 response = record.getThings(request);
	}
	
	public void testPutData() throws Exception {
		Record record = personInfoList.get(0).getRecords().get(0);
		ThingKey key = record.putThingDataAsync(new Weight(50)).call();
	}
	
	public void testPutThing() {
		Thing2 thing = new Thing2();
		Weight weight = new Weight(50);
		thing.setData(weight);

		Record record = personInfoList.get(0).getRecords().get(0);
		ThingKey key = record.putThing(thing);
	}
	
	public void testGetPersonalDemographics() {
		Record record = personInfoList.get(0).getRecords().get(0);
		ThingResponseGroup2 response = record.getThings(ThingRequestGroup2.thingTypeQuery(PersonalDemographics.ThingType));
		Thing2 thing = response.getThing().get(0);
		
		Extension extension = new Extension();
		extension.setSource("Lab");
		thing.getDataXml().getCommon().getExtension().add(extension);
		
		record.putThing(thing);
		response = record.getThings(ThingRequestGroup2.thingTypeQuery(PersonalDemographics.ThingType));
	}
}
