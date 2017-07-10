package com.microsoft.healthvault;

import com.microsoft.healthvault.methods.removethings.request.RemoveThingsRequest;
import com.microsoft.healthvault.methods.removethings.response.RemoveThingsResponse;
import com.microsoft.healthvault.methods.request.RequestTemplate;
import com.microsoft.healthvault.things.thing.Thing2;
import com.microsoft.healthvault.things.thing.ThingKey;
import com.microsoft.healthvault.things.types.Weight;
import com.microsoft.healthvault.things.types.types.PersonInfo;
import com.microsoft.healthvault.things.types.types.Record;

import junit.framework.TestCase;

import java.util.List;

public class RemoveThingsTest extends TestCase {

    private List<PersonInfo> personInfoList;
	
	public RemoveThingsTest() {
	}
	
	public void setUp()
	{
        HVSettings settings = new HVSettings();
        settings.setAppId("90976b0c-e0c2-467e-b65c-ed9117aa94e9");
        settings.setAuthenticationSecret("JpGYZ54MRAhy2Gw9uoWCfxTG97ufR3v7kZ/i2JG+Utw=");
		HealthVaultApp app = new HealthVaultApp(settings);
		HealthVaultApp.setInstance(app);
		app.resolvePersonInfoList();
		personInfoList = HealthVaultApp.getInstance().getPersonInfoList();
	}
	
	public void testRemoveOneThing() {
		personInfoList = HealthVaultApp.getInstance().getPersonInfoList() ;
		Record record = personInfoList.get(0).getRecords().get(0);

		Thing2 thing = new Thing2();
		thing.setData(new Weight(50));

		ThingKey key = record.putThing(thing);
		
		RequestTemplate requestTemplate = new RequestTemplate(
				HealthVaultApp.getInstance().getConnection());
		requestTemplate.setPersonId(record.getPersonId());
		requestTemplate.setRecordId(record.getId());
		
		RemoveThingsRequest request = new RemoveThingsRequest();
		request.getThingId().add(key);
		
		RemoveThingsResponse response = requestTemplate.makeRequest(
				request, 
				RemoveThingsResponse.class);
	}
}
