package com.microsoft.hsg.android.simplexml.test;

import java.util.List;

import junit.framework.TestCase;

import com.microsoft.hsg.android.simplexml.HealthVaultApp;
import com.microsoft.hsg.android.simplexml.methods.querypermissions.request.QueryPermissionsRequest;
import com.microsoft.hsg.android.simplexml.methods.querypermissions.response.QueryPermissionsResponse;
import com.microsoft.hsg.android.simplexml.methods.request.RequestTemplate;
import com.microsoft.hsg.android.simplexml.things.types.types.PersonInfo;
import com.microsoft.hsg.android.simplexml.things.types.types.Record;
import com.microsoft.hsg.android.simplexml.things.types.weight.Weight;

public class QueryPermissionsTest extends TestCase {

    private List<PersonInfo> personInfoList;
	
	public QueryPermissionsTest() {
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
	
	public void testQueryPermissions() {
		personInfoList = HealthVaultApp.getInstance().getPersonInfoList() ;
		Record record = personInfoList.get(0).getRecords().get(0);

		RequestTemplate requestTemplate = new RequestTemplate(
				HealthVaultApp.getInstance().getConnection());
		requestTemplate.setPersonId(record.getPersonId());
		requestTemplate.setRecordId(record.getId());
		
		QueryPermissionsRequest request = new QueryPermissionsRequest();
		request.getThingTypeId().add(Weight.ThingType);
		
		QueryPermissionsResponse response = requestTemplate.makeRequest(
				request, 
				QueryPermissionsResponse.class);
	}
}
