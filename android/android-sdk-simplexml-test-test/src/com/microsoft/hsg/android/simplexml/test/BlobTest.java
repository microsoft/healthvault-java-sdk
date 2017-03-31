package com.microsoft.hsg.android.simplexml.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;

import junit.framework.TestCase;

import com.microsoft.hsg.android.simplexml.HealthVaultApp;
import com.microsoft.hsg.android.simplexml.methods.getthings3.request.BlobFormatSpec;
import com.microsoft.hsg.android.simplexml.methods.getthings3.request.ThingRequestGroup2;
import com.microsoft.hsg.android.simplexml.things.thing.BlobInfo;
import com.microsoft.hsg.android.simplexml.things.thing.BlobPayload;
import com.microsoft.hsg.android.simplexml.things.thing.BlobPayloadItem;
import com.microsoft.hsg.android.simplexml.things.thing.Thing2;
import com.microsoft.hsg.android.simplexml.things.thing.ThingKey;
import com.microsoft.hsg.android.simplexml.things.types.allergy.Allergy;
import com.microsoft.hsg.android.simplexml.things.types.base.CodableValue;
import com.microsoft.hsg.android.simplexml.things.types.types.PersonInfo;
import com.microsoft.hsg.android.simplexml.things.types.types.Record;

public class BlobTest extends TestCase {
	
	private List<PersonInfo> personInfoList;
	private Record currentRecord;
	private int genCount = 2097152;
	
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
	
	public void putThing() {
		Thing2 thing = new Thing2();
		Allergy allergy = new Allergy();
		allergy.setName(new CodableValue("testblob"));
		thing.setData(allergy);

		ThingKey key = currentRecord.putThing(thing);
	}
	
	public void testPutBlobToThing() {
		putThing();
		
		List<Thing2> things = currentRecord.getThings(ThingRequestGroup2.thingTypeQuery(Allergy.ThingType)).getThing();
		
		if(!things.isEmpty()) {
			BlobInfo info = new BlobInfo();
			info.setName("test2");
			info.setContentType("application/octet-stream");
			
	        try {
               
	        	byte[] test = new byte[genCount];
	        	
	        	for(int i = 0; i < genCount; i++) {
	        		test[i] = (byte)'a'; 
	        	}
	        	
                ByteArrayInputStream inStream = new ByteArrayInputStream(test);
	        	
                currentRecord.putBlobInItem(things.get(0), info, inStream);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void testGetBlobFromThing() {
		ThingRequestGroup2 requestGroup = ThingRequestGroup2.thingTypeQuery(Allergy.ThingType, BlobFormatSpec.streamed);
		List<Thing2> things = currentRecord.getThings(requestGroup).getThing();
		
		if(!things.isEmpty()) {
			
			Iterator<Thing2> itr = things.iterator();
			BlobPayloadItem blob = null;
			
			while(itr.hasNext()) {
				Thing2 thing = itr.next();
				BlobPayload payload = thing.getBlobPayload();
				
				if(payload != null && payload.hasBlobs()) {
					blob = payload.getBlob().get(0);
					break;
				}
			}
			
			if(blob != null) {
				ByteArrayOutputStream output = new ByteArrayOutputStream();
				
				try {
					blob.download(currentRecord, output);
					output.flush();
					output.close();
					
					byte[] bytes = output.toByteArray();
					String str = new String(bytes);
					assertEquals(genCount, str.length());
					assertEquals(str.charAt(genCount - 1), bytes[genCount - 1]);
				} catch (URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
