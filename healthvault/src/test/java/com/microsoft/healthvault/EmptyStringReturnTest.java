package com.microsoft.healthvault;

import com.microsoft.healthvault.generated.types.CodableValue;
import com.microsoft.healthvault.generated.types.PersonInfo;
import com.microsoft.healthvault.generated.types.Record;

import junit.framework.TestCase;

import java.util.List;

public class EmptyStringReturnTest extends TestCase {

	/*
	TODO: These tests were not working prior to refactoring, will have to address once refactoring
	is complete
	private List<PersonInfo> personInfoList;
	private Record currentRecord;
	
	String testReason = "fd";
	
	public void setUp()
	{
		HVSettings settings = new HVSettings();
        settings.setAppId("90976b0c-e0c2-467e-b65c-ed9117aa94e9");
        settings.setAuthenticationSecret("JpGYZ54MRAhy2Gw9uoWCfxTG97ufR3v7kZ/i2JG+Utw=");
		
        HealthVaultApp app = new HealthVaultApp(settings);
		HealthVaultApp.setInstance(app);
		app.resolvePersonInfoList();
		personInfoList = HealthVaultApp.getInstance().getPersonInfoList() ;
		
		currentRecord = personInfoList.get(0).getRecords().get(0);
	}
	
	public void putCondition() {
		Thing2 thing = new Thing2();
		Condition condition = new Condition();
		condition.setName(new CodableValue("test"));
		condition.setStopReason(testReason);
		thing.setData(condition);

		ThingKey key = currentRecord.putThing(thing);
	}
	
	public void getCondition() {
		// putCondition();
		
		List<Thing2> things = currentRecord.getThings(ThingRequestGroup2.thingTypeQuery(Condition.ThingType)).getThing();
		
		if(!things.isEmpty()) {
			 Condition condition = (Condition)things.get(0).getData();
			 
			 int length = testReason.length();
			 
			 assertTrue("has stop reason", condition.getStopReason().equals(testReason));
		}
	}
	*/
}
