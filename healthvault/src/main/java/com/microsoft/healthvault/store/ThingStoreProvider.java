package com.microsoft.healthvault.store;

import com.microsoft.healthvault.HealthVaultApp;
import com.microsoft.healthvault.methods.getthings3.request.BlobFormatSpec;
import com.microsoft.healthvault.methods.getthings3.request.BlobPayloadRequest;
import com.microsoft.healthvault.methods.getthings3.request.BlobPayloadRequest.BlobFormat;
import com.microsoft.healthvault.methods.getthings3.request.GetThings3Request;
import com.microsoft.healthvault.methods.getthings3.request.ThingFilterSpec;
import com.microsoft.healthvault.methods.getthings3.request.ThingFormatSpec2;
import com.microsoft.healthvault.methods.getthings3.request.ThingRequestGroup2;
import com.microsoft.healthvault.methods.getthings3.request.ThingSectionSpec2;
import com.microsoft.healthvault.methods.getthings3.response.GetThings3Response;
import com.microsoft.healthvault.methods.putthings2.request.PutThings2Request;
import com.microsoft.healthvault.methods.putthings2.response.PutThings2Response;
import com.microsoft.healthvault.methods.request.RequestTemplate;
import com.microsoft.healthvault.thingtypes.Thing2;
import com.microsoft.hsg.Connection;

import java.util.List;

public class ThingStoreProvider implements IThingProvider {

	String personId;
	String recordId;
	Connection connection;
	
	public ThingStoreProvider(
			String personId,
			String recordId) {
		this.personId = personId;
		this.recordId = recordId;
	}
	
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public List<Thing2> getThingsByType(String thingType) {
		RequestTemplate requestTemplate = new RequestTemplate(
				getConnection(),
				personId,
				recordId);
		
		GetThings3Response response = requestTemplate.makeRequest(
				getRequestObject(thingType), 
				GetThings3Response.class);
		
		return response.getInfo().getGroup().get(0).getThing();
	}
	
	public void putThings(List<Thing2> things) {
		RequestTemplate requestTemplate = new RequestTemplate(
				getConnection(),
				personId,
				recordId);
		
		PutThings2Request request = new PutThings2Request();
		request.getThing().addAll(things);
		
		PutThings2Response response = requestTemplate.makeRequest(
				request, 
				PutThings2Response.class); 
	}
	
	private static GetThings3Request getRequestObject(String thingType) {
		GetThings3Request request = new GetThings3Request();
		request.getGroup().add(getRequestGroup(thingType));
		
		return request;
	}
	
	private static ThingRequestGroup2 getRequestGroup(String thingType) {
		ThingRequestGroup2 requestGroup = new ThingRequestGroup2();
		requestGroup.setMax(25);
		requestGroup.getFilterList().add(getThingFilterSpec(thingType));
		requestGroup.setFormat(getFormat());

		return requestGroup;
	}
	
	private static ThingFilterSpec getThingFilterSpec(String thingType) {
		ThingFilterSpec fs = new ThingFilterSpec();
		fs.getTypeId().add(thingType);
		
		return fs;
	}
	
	private static ThingFormatSpec2 getFormat() {
		ThingFormatSpec2 format = new ThingFormatSpec2();
		format.getSection().add(ThingSectionSpec2.core);
		format.getSection().add(ThingSectionSpec2.blobpayload);
		format.getXml().add("");
		format.setBlobPayloadRequest(getBlobPayloadRequest());
		
		return format;
	}
	
	private static BlobPayloadRequest getBlobPayloadRequest() {
		BlobFormat format = new BlobFormat();
		format.setBlobFormatSpec(BlobFormatSpec.streamed);
		
		BlobPayloadRequest blobPayload = new BlobPayloadRequest();
		blobPayload.setBlobFormat(format);
		
		return blobPayload;
	}
	
	private Connection getConnection() {
		if (connection == null) {
			connection = HealthVaultApp.getInstance().getConnection();
		}
		
		return connection;
	}
}
