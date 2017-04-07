package com.microsoft.hsg.android.simplexml.things.types.types;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

import javax.xml.datatype.XMLGregorianCalendar;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Text;

import android.text.TextUtils;

import com.microsoft.hsg.Connection;
import com.microsoft.hsg.android.simplexml.HealthVaultApp;
import com.microsoft.hsg.android.simplexml.HttpStreamer;
import com.microsoft.hsg.android.simplexml.methods.beginputblob.request.BeginPutBlobRequest;
import com.microsoft.hsg.android.simplexml.methods.beginputblob.response.BeginPutBlobResponse;
import com.microsoft.hsg.android.simplexml.methods.beginputblob.response.BlobPutInfo;
import com.microsoft.hsg.android.simplexml.methods.getthings3.request.GetThings3Request;
import com.microsoft.hsg.android.simplexml.methods.getthings3.request.ThingFormatSpec2;
import com.microsoft.hsg.android.simplexml.methods.getthings3.request.ThingRequestGroup2;
import com.microsoft.hsg.android.simplexml.methods.getthings3.request.ThingSectionSpec2;
import com.microsoft.hsg.android.simplexml.methods.getthings3.response.GetThings3Response;
import com.microsoft.hsg.android.simplexml.methods.getthings3.response.ThingResponseGroup2;
import com.microsoft.hsg.android.simplexml.methods.putthings2.request.PutThings2Request;
import com.microsoft.hsg.android.simplexml.methods.putthings2.response.PutThings2Response;
import com.microsoft.hsg.android.simplexml.methods.removethings.request.RemoveThingsRequest;
import com.microsoft.hsg.android.simplexml.methods.removethings.response.RemoveThingsResponse;
import com.microsoft.hsg.android.simplexml.methods.request.HVRequestInfo;
import com.microsoft.hsg.android.simplexml.methods.request.RequestTemplate;
import com.microsoft.hsg.android.simplexml.things.thing.AbstractThing;
import com.microsoft.hsg.android.simplexml.things.thing.BlobInfo;
import com.microsoft.hsg.android.simplexml.things.thing.BlobPayloadItem;
import com.microsoft.hsg.android.simplexml.things.thing.Thing2;
import com.microsoft.hsg.android.simplexml.things.thing.ThingKey;
import com.microsoft.hsg.android.simplexml.things.types.file.File;

/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.types"&gt;
 *                     Basic information about the authenticated person's view
 *                     of a health record.
 *                 &lt;/summary&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;remarks xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.types"&gt;
 *                     Health records are a place to store health and fitness
 *                     related data. Each person may be authorized to zero to
 *                     many health records. This type represents the metadata
 *                     about the authenticated person's view of the record,
 *                     including it's unique identifier, the relationship the
 *                     authorized person has with the owner of the record, the
 *                     name of the record, whether the authorized person is a
 *                     custodian of the record, and more.
 *                 &lt;/remarks&gt;
 * </pre>
 * 
 * 
 * <p>Java class for Record complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Record">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;urn:com.microsoft.wc.types>string255">
 *       &lt;attribute name="id" use="required" type="{urn:com.microsoft.wc.types}guid" />
 *       &lt;attribute name="record-custodian" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="rel-type" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="rel-name" type="{urn:com.microsoft.wc.types}string255" />
 *       &lt;attribute name="auth-expires" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="auth-expired" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="display-name" type="{urn:com.microsoft.wc.types}string255" />
 *       &lt;attribute name="state" type="{urn:com.microsoft.wc.types}RecordState" />
 *       &lt;attribute name="date-created" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="max-size-bytes" type="{urn:com.microsoft.wc.types}positiveLong" />
 *       &lt;attribute name="size-bytes" type="{urn:com.microsoft.wc.types}positiveLong" />
 *       &lt;attribute name="app-record-auth-action" type="{urn:com.microsoft.wc.types}AppRecordAuthAction" />
 *       &lt;attribute name="auto-reconcile-documents" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="app-specific-record-id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="location-country" type="{urn:com.microsoft.wc.types}string3nw" />
 *       &lt;attribute name="location-state-province" type="{urn:com.microsoft.wc.types}string3nw" />
 *       &lt;attribute name="date-updated" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class Record {

	private String personId = "00000000-0000-0000-0000-000000000000";

	@Text
	protected String name; 

	@Attribute(name = "id", required = true)
	protected String id;

	@Attribute(name = "record-custodian", required = false)
	protected Boolean recordCustodian;

	@Attribute(name = "rel-type", required = true)
	protected int relType;

	@Attribute(name = "rel-name", required = false)
	protected String relName;

	@Attribute(name = "auth-expires", required = false)
	protected Date authExpires;

	@Attribute(name = "auth-expired", required = false)
	protected Boolean authExpired;

	@Attribute(name = "display-name", required = false)
	protected String displayName;

	@Attribute(name = "state", required = false)
	protected RecordState state;

	@Attribute(name = "date-created", required = false)
	protected Date dateCreated;

	@Attribute(name = "max-size-bytes", required = false)
	protected Long maxSizeBytes;

	@Attribute(name = "size-bytes", required = false)
	protected Long sizeBytes;

	@Attribute(name = "app-record-auth-action", required = false)
	protected String appRecordAuthAction;

	@Attribute(name = "auto-reconcile-documents", required = false)
	protected Boolean autoReconcileDocuments;

	@Attribute(name = "app-specific-record-id", required = false)
	protected String appSpecificRecordId;

	@Attribute(name = "location-country", required = false)
	protected String locationCountry;

	@Attribute(name = "location-state-province", required = false)
	protected String locationStateProvince;

	@Attribute(name = "date-updated", required = false)
	protected Date dateUpdated;

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getPersonId() {
		return personId;
	}

	/**
	 * 
	 * <pre>
	 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.types"/&gt;
	 * </pre>
	 * 
	 * <pre>
	 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;remarks xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.types"/&gt;
	 * </pre>
	 * 
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the value of the value property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the value of the id property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the value of the id property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setId(String value) {
		this.id = value;
	}

	/**
	 * Gets the value of the recordCustodian property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link Boolean }
	 *     
	 */
	public Boolean isRecordCustodian() {
		return recordCustodian;
	}

	/**
	 * Sets the value of the recordCustodian property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link Boolean }
	 *     
	 */
	public void setRecordCustodian(Boolean value) {
		this.recordCustodian = value;
	}

	/**
	 * Gets the value of the relType property.
	 * 
	 */
	public int getRelType() {
		return relType;
	}

	/**
	 * Sets the value of the relType property.
	 * 
	 */
	public void setRelType(int value) {
		this.relType = value;
	}

	/**
	 * Gets the value of the relName property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getRelName() {
		return relName;
	}

	/**
	 * Sets the value of the relName property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setRelName(String value) {
		this.relName = value;
	}

	/**
	 * Gets the value of the authExpires property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link Date }
	 *     
	 */
	public Date getAuthExpires() {
		return authExpires;
	}

	/**
	 * Sets the value of the authExpires property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link Date }
	 *     
	 */
	public void setAuthExpires(Date value) {
		this.authExpires = value;
	}

	/**
	 * Gets the value of the authExpired property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link Boolean }
	 *     
	 */
	public Boolean isAuthExpired() {
		return authExpired;
	}

	/**
	 * Sets the value of the authExpired property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link Boolean }
	 *     
	 */
	public void setAuthExpired(Boolean value) {
		this.authExpired = value;
	}

	/**
	 * Gets the value of the displayName property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * Sets the value of the displayName property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setDisplayName(String value) {
		this.displayName = value;
	}

	/**
	 * Gets the value of the state property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link RecordState }
	 *     
	 */
	public RecordState getState() {
		return state;
	}

	/**
	 * Sets the value of the state property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link RecordState }
	 *     
	 */
	public void setState(RecordState value) {
		this.state = value;
	}

	/**
	 * Gets the value of the dateCreated property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link XMLGregorianCalendar }
	 *     
	 */
	public Date getDateCreated() {
		return dateCreated;
	}

	/**
	 * Sets the value of the dateCreated property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link XMLGregorianCalendar }
	 *     
	 */
	public void setDateCreated(Date value) {
		this.dateCreated = value;
	}

	/**
	 * Gets the value of the maxSizeBytes property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link Long }
	 *     
	 */
	public Long getMaxSizeBytes() {
		return maxSizeBytes;
	}

	/**
	 * Sets the value of the maxSizeBytes property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link Long }
	 *     
	 */
	public void setMaxSizeBytes(Long value) {
		this.maxSizeBytes = value;
	}

	/**
	 * Gets the value of the sizeBytes property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link Long }
	 *     
	 */
	public Long getSizeBytes() {
		return sizeBytes;
	}

	/**
	 * Sets the value of the sizeBytes property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link Long }
	 *     
	 */
	public void setSizeBytes(Long value) {
		this.sizeBytes = value;
	}

	/**
	 * Gets the value of the appRecordAuthAction property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getAppRecordAuthAction() {
		return appRecordAuthAction;
	}

	/**
	 * Sets the value of the appRecordAuthAction property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setAppRecordAuthAction(String value) {
		this.appRecordAuthAction = value;
	}

	/**
	 * Gets the value of the autoReconcileDocuments property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link Boolean }
	 *     
	 */
	public Boolean isAutoReconcileDocuments() {
		return autoReconcileDocuments;
	}

	/**
	 * Sets the value of the autoReconcileDocuments property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link Boolean }
	 *     
	 */
	public void setAutoReconcileDocuments(Boolean value) {
		this.autoReconcileDocuments = value;
	}

	/**
	 * Gets the value of the appSpecificRecordId property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getAppSpecificRecordId() {
		return appSpecificRecordId;
	}

	/**
	 * Sets the value of the appSpecificRecordId property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setAppSpecificRecordId(String value) {
		this.appSpecificRecordId = value;
	}

	/**
	 * Gets the value of the locationCountry property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getLocationCountry() {
		return locationCountry;
	}

	/**
	 * Sets the value of the locationCountry property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setLocationCountry(String value) {
		this.locationCountry = value;
	}

	/**
	 * Gets the value of the locationStateProvince property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getLocationStateProvince() {
		return locationStateProvince;
	}

	/**
	 * Sets the value of the locationStateProvince property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setLocationStateProvince(String value) {
		this.locationStateProvince = value;
	}

	/**
	 * Gets the value of the dateUpdated property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link Date }
	 *     
	 */
	public Date getDateUpdated() {
		return dateUpdated;
	}

	/**
	 * Sets the value of the dateUpdated property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link Date }
	 *     
	 */
	public void setDateUpdated(Date value) {
		this.dateUpdated = value;
	}

	public Callable<ThingKey> putThingDataAsync(final AbstractThing thing) {
		return putThingAsync(thing.getThing());
	}

	public Callable<ThingKey> putThingAsync(final Thing2 thing) {
		return new Callable<ThingKey>() {
			public ThingKey call() {
				return putThing(thing);
			}
		};
	}

	public Callable<List<ThingKey>> putThingMultipleAsync(final List<Thing2> things) {
		return new Callable<List<ThingKey>>() {
			public List<ThingKey> call() {
				return putThingMultiple(things);
			}
		};
	}

	public ThingKey putThing(Thing2 thing) {
		List<Thing2> things = new ArrayList<Thing2>();
		things.add(thing);

		return putThingMultiple(things).get(0);
	}

	public List<ThingKey> putThingMultiple(List<Thing2> things) {
		PutThings2Request request = new PutThings2Request();
		request.getThing().addAll(things);

		return makeRequest(request, PutThings2Response.class)
				.getInfo().getThingId();
	}

	public Callable<ThingResponseGroup2> getThingsAsync(final ThingRequestGroup2 requestGroup) {
		return new Callable<ThingResponseGroup2>() {
			public ThingResponseGroup2 call() {
				return getThings(requestGroup);
			}
		};
	}

	public ThingResponseGroup2 getThings(ThingRequestGroup2 requestGroup) {
		GetThings3Request request = new GetThings3Request();
		request.getGroup().add(requestGroup);

		return makeRequest(request, GetThings3Response.class)
				.getInfo().getGroup().get(0);
	}

	public Thing2 getThing(ThingKey key, ArrayList<ThingSectionSpec2> sections) {
		return getThing(key, null, sections);
	}

	public Thing2 getThing(ThingKey key, String versionType, ArrayList<ThingSectionSpec2> sections) {

		ThingRequestGroup2 requestGroup = ThingRequestGroup2.keyQuery(key);
		ThingFormatSpec2 formatSpec = new ThingFormatSpec2();

		for(ThingSectionSpec2 section: sections) {
			formatSpec.setSection(section);
		}

		if(TextUtils.isEmpty(versionType)) {
			formatSpec.getTypeVersionFormat().add(versionType);
		}

		requestGroup.setFormat(formatSpec);

		List<Thing2> things = getThings(requestGroup).getThing();

		return things != null ? (things.isEmpty() ? null : things.get(0)) : null;
	}

	public Callable<Void> RemoveAsync(final ThingKey key) {
		ArrayList<ThingKey> keys = new ArrayList<ThingKey>(1);
		keys.add(key);

		return RemoveMultipleAsync(keys);
	}

	public Callable<Void> RemoveMultipleAsync(final List<ThingKey> keys) {
		return new Callable<Void>() {
			public Void call() {
				RemoveMultiple(keys);
				return null;
			}
		};
	}

	public void Remove(ThingKey key) {
		ArrayList<ThingKey> list = new ArrayList<ThingKey>();
		list.add(key);

		RemoveMultiple(list);
	}

	public void RemoveMultiple(List<ThingKey> keys) {
		RemoveThingsRequest request = new RemoveThingsRequest();
		request.getThingId().addAll(keys);

		makeRequest(request, RemoveThingsResponse.class);
	}

	public void downloadBlob(BlobPayloadItem blob, OutputStream destination) 
			throws URISyntaxException, IOException {
		HttpStreamer streamer = new HttpStreamer();
		streamer.download(blob.getBlobRefUrl(), destination);
	}

	public URI uploadBlobStream(BlobInfo blobInfo, InputStream source) 
			throws IOException, URISyntaxException {
		BeginPutBlobRequest request = new BeginPutBlobRequest();

		Connection connection = HealthVaultApp.getInstance().getConnection();

		RequestTemplate requestTemplate = new RequestTemplate(
				connection,
				personId,
				id);

		BeginPutBlobResponse response = requestTemplate.makeRequest(
				request,
				BeginPutBlobResponse.class);

		BlobPutInfo putInfo = response.getInfo();
		HttpStreamer streamer = new HttpStreamer();

		streamer.upload(putInfo.getUrl(), source, putInfo.getChunkSize(), putInfo.getMaxSize());

		return new URI(putInfo.getUrl());
	}

	public BlobPayloadItem uploadBlob(BlobInfo blobInfo, InputStream source) 
			throws IOException, URISyntaxException {

		BeginPutBlobRequest request = new BeginPutBlobRequest();

		Connection connection = HealthVaultApp.getInstance().getConnection();

		RequestTemplate requestTemplate = new RequestTemplate(
				connection,
				personId,
				id);

		BeginPutBlobResponse response = requestTemplate.makeRequest(
				request,
				BeginPutBlobResponse.class);

		BlobPutInfo putInfo = response.getInfo();
		HttpStreamer streamer = new HttpStreamer();

		int length = streamer.upload(putInfo.getUrl(), source, putInfo.getChunkSize(), putInfo.getMaxSize());

		URI uri = new URI(putInfo.getUrl());
		BlobPayloadItem blob = new BlobPayloadItem();
		blob.setBlobRefUrl(uri.toURL().toString());
		blob.setBlobInfo(blobInfo);
		blob.setContentLength((long)length);

		return blob;
	}

	public ThingKey putBlobInItem(Thing2 thing, BlobInfo blobInfo, InputStream source) 
			throws IOException, URISyntaxException {

		BlobPayloadItem blob = uploadBlob(blobInfo, source);

		thing.addOrUpdateBlob(blob);
		Object data = thing.getData();

		if(data instanceof File) {
			File hvFile = (File)data;
			hvFile.setSize(blob.getContentLength());
		}

		return putThing(thing);
	}

	// TODO
	/*
    IAsyncOperation<IList<RecordItem>> GetAllItemsAsync(ItemQuery query);
	 */

	 /*
    //-----------------------------------
    //
    // Key retrieval
    //
    //------------------------------------
    IAsyncOperation<IList<ItemKey>> GetKeysAsync(IList<ItemFilter> filters);
    IAsyncOperation<IList<ItemKey>> GetKeysAsync(IList<ItemFilter> filters, int maxResults);
    IAsyncOperation<IList<PendingItem>> GetKeysAndDateAsync(IList<ItemFilter> filters, int maxResults);
    //-----------------------------------
    //
    // Remove Authorization
    //
    //------------------------------------
    IAsyncAction RemoveApplicationRecordAuthorizationAsync();

    IAsyncOperation<QueryPermissionsResponse> QueryPermissionsAsync(
        IList<QueryPermissionsRequestParams> requestParams);
	  */    

	private RequestTemplate getRequestTemplate() {
		return new RequestTemplate(
				HealthVaultApp.getInstance().getConnection(),
				personId,
				id);
	}

	private <T> T makeRequest(HVRequestInfo request, Class<T> clazz) {
		return getRequestTemplate().makeRequest(
				request,
				clazz);
	}

	public String toString() {
		return name;
	}
}
