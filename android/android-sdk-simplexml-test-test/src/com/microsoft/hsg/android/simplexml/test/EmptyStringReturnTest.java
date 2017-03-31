package com.microsoft.hsg.android.simplexml.test;

import java.util.List;

import junit.framework.TestCase;

import com.microsoft.hsg.android.simplexml.HealthVaultApp;
import com.microsoft.hsg.android.simplexml.methods.getthings3.request.ThingRequestGroup2;
import com.microsoft.hsg.android.simplexml.things.thing.Thing2;
import com.microsoft.hsg.android.simplexml.things.thing.ThingKey;
import com.microsoft.hsg.android.simplexml.things.types.allergy.Allergy;
import com.microsoft.hsg.android.simplexml.things.types.base.CodableValue;
import com.microsoft.hsg.android.simplexml.things.types.condition.Condition;
import com.microsoft.hsg.android.simplexml.things.types.types.PersonInfo;
import com.microsoft.hsg.android.simplexml.things.types.types.Record;

public class EmptyStringReturnTest extends TestCase {
	
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

}
