package com.microsoft.healthvault;

import com.microsoft.healthvault.client.HealthVaultRestClient;
import com.microsoft.healthvault.methods.getthings3.request.ThingRequestGroup2;
import com.microsoft.healthvault.methods.getthings3.response.ThingResponseGroup2;
import com.microsoft.healthvault.restapi.implementation.MicrosoftHealthVaultRESTAPIImpl;
import com.microsoft.healthvault.restapi.models.ActionPlansResponseActionPlanInstance;
import com.microsoft.healthvault.thingtypes.Extension;
import com.microsoft.healthvault.thingtypes.Thing2;
import com.microsoft.healthvault.thingtypes.ThingKey;
import com.microsoft.healthvault.thingtypes.PersonalDemographics;
import com.microsoft.healthvault.thingtypes.Weight;
import com.microsoft.healthvault.types.PersonInfo;
import com.microsoft.healthvault.types.Record;

import junit.framework.TestCase;

import java.util.List;

public class RecordTest extends TestCase {

	private List<PersonInfo> personInfoList;
	
	public void setUp()
	{
        HVSettings settings = new HVSettings();
		settings.setAppId("d00f9957-f954-48a6-adf8-4cfa27ff0e82");
		settings.setAuthenticationSecret("3e+Hv1dq0CxH2Sp/s0Dqv8RTv/oGfyFEvTwqkvI/DSU=");
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
