package com.microsoft.healthvault.store;

import com.microsoft.healthvault.HealthVaultApp;
import com.microsoft.healthvault.client.request.RequestTemplate;
import com.microsoft.healthvault.generated.methods.GetThings.request.ThingFilterSpec;
import com.microsoft.healthvault.generated.methods.GetThings3.request.BlobFormatSpec;
import com.microsoft.healthvault.generated.methods.GetThings3.request.BlobPayloadRequest;
import com.microsoft.healthvault.generated.methods.GetThings3.request.GetThings3Request;
import com.microsoft.healthvault.generated.methods.GetThings3.request.ThingFormatSpec2;
import com.microsoft.healthvault.generated.methods.GetThings3.request.ThingRequestGroup2;
import com.microsoft.healthvault.generated.methods.GetThings3.request.ThingSectionSpec2;
import com.microsoft.healthvault.generated.methods.GetThings3.response.GetThings3Response;
import com.microsoft.healthvault.generated.methods.PutThings.response.PutThingsResponse;
import com.microsoft.healthvault.generated.methods.PutThings2.request.PutThings2Request;
import com.microsoft.healthvault.generated.thing.Thing2;
import com.microsoft.hsg.Connection;

import java.math.BigInteger;
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
		
		return response.getGroup().get(0).getThing();
	}
	
	public void putThings(List<Thing2> things) {
		RequestTemplate requestTemplate = new RequestTemplate(
				getConnection(),
				personId,
				recordId);
		
		PutThings2Request request = new PutThings2Request();
		request.getThing().addAll(things);
		
		PutThingsResponse response = requestTemplate.makeRequest(
				request, 
				PutThingsResponse.class);
	}
	
	private static GetThings3Request getRequestObject(String thingType) {
		GetThings3Request request = new GetThings3Request();
		request.getGroup().add(getRequestGroup(thingType));
		
		return request;
	}
	
	private static ThingRequestGroup2 getRequestGroup(String thingType) {
		ThingRequestGroup2 requestGroup = new ThingRequestGroup2();
		requestGroup.setMax(BigInteger.valueOf(25));
		requestGroup.getFilter().add(getThingFilterSpec(thingType));
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
		format.getSection().add(ThingSectionSpec2.CORE);
		format.getSection().add(ThingSectionSpec2.BLOBPAYLOAD);
		format.getXml().add("");
		format.setBlobPayloadRequest(getBlobPayloadRequest());
		
		return format;
	}
	
	private static BlobPayloadRequest getBlobPayloadRequest() {
		BlobPayloadRequest.BlobFormat format = new BlobPayloadRequest.BlobFormat();
		format.setBlobFormatSpec(BlobFormatSpec.STREAMED);
		
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
