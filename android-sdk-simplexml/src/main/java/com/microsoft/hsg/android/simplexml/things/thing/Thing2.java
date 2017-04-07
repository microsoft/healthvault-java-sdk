package com.microsoft.hsg.android.simplexml.things.thing;

import java.util.Date;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.core.Commit;

import com.microsoft.hsg.android.simplexml.methods.getthings3.request.BlobFormatSpec;
import com.microsoft.hsg.android.simplexml.methods.getthings3.request.BlobPayloadRequest;
import com.microsoft.hsg.android.simplexml.methods.getthings3.request.ThingFilterSpec;
import com.microsoft.hsg.android.simplexml.methods.getthings3.request.ThingFormatSpec2;
import com.microsoft.hsg.android.simplexml.methods.getthings3.request.ThingRequestGroup2;
import com.microsoft.hsg.android.simplexml.methods.getthings3.request.ThingSectionSpec2;
import com.microsoft.hsg.android.simplexml.methods.getthings3.request.BlobPayloadRequest.BlobFormat;
import com.microsoft.hsg.android.simplexml.methods.getthings3.response.ThingResponseGroup2;
import com.microsoft.hsg.android.simplexml.things.types.types.Record;

/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:d="urn:com.microsoft.wc.dates" xmlns:ds="http://www.w3.org/2000/09/xmldsig#" xmlns:this="urn:com.microsoft.wc.thing" xmlns:wc-auth="urn:com.microsoft.wc.auth" xmlns:wc-types="urn:com.microsoft.wc.types"/&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;remarks xmlns="http://www.w3.org/2001/XMLSchema" xmlns:d="urn:com.microsoft.wc.dates" xmlns:ds="http://www.w3.org/2000/09/xmldsig#" xmlns:this="urn:com.microsoft.wc.thing" xmlns:wc-auth="urn:com.microsoft.wc.auth" xmlns:wc-types="urn:com.microsoft.wc.types"/&gt;
 * </pre>
 * 
 * 
 * <p>Java class for Thing2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Thing2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="thing-id" type="{urn:com.microsoft.wc.thing}ThingKey" minOccurs="0"/>
 *         &lt;element name="type-id" type="{urn:com.microsoft.wc.thing}ThingType" minOccurs="0"/>
 *         &lt;element name="thing-state" type="{urn:com.microsoft.wc.thing}ThingState" minOccurs="0"/>
 *         &lt;element name="flags" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *         &lt;element name="eff-date" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="created" type="{urn:com.microsoft.wc.thing}Audit2" minOccurs="0"/>
 *         &lt;element name="updated" type="{urn:com.microsoft.wc.thing}Audit2" minOccurs="0"/>
 *         &lt;element name="data-xml" type="{urn:com.microsoft.wc.thing}DataXml" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="blob-payload" type="{urn:com.microsoft.wc.thing}BlobPayload" minOccurs="0"/>
 *         &lt;element name="eff-permissions" type="{urn:com.microsoft.wc.thing}EffectivePermissions" minOccurs="0"/>
 *         &lt;element name="tags" type="{urn:com.microsoft.wc.types}stringz512" minOccurs="0"/>
 *         &lt;element name="signature-info" type="{urn:com.microsoft.wc.thing}SignatureInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@Root(name="thing")
@Order(elements = {
    "thing-id",
    "type-id",
    "thing-state",
    "flags",
    "eff-date",
    "created",
    "updated",
    "data-xml",
    "blob-payload",
    "eff-permissions",
    "tags"
})
public class Thing2 {

    @Element(name = "thing-id", required=false)
    protected ThingKey thingId;

    @Element(name = "type-id", required=false)
    protected ThingType typeId;

    @Element(name = "thing-state", required=false)
    protected ThingState thingState;

    @Element(required=false)
    protected Long flags;

    @Element(name = "eff-date", required=false)
    protected Date effDate;

    @Element(required=false)
    protected Audit2 created;

    @Element(required=false)
    protected Audit2 updated;

    @Element(name = "data-xml", required=false)
    protected DataXml dataXml;

    @Element(name = "blob-payload", required=false)
    protected BlobPayload blobPayload;

    @Element(name = "eff-permissions", required=false)
    protected EffectivePermissions effPermissions;

    @Element(required=false)
    protected String tags;

    /**
     * Gets the value of the thingId property.
     * 
     * @return
     *     possible object is
     *     {@link ThingKey }
     *     
     */
    public ThingKey getThingId() {
        return thingId;
    }

    /**
     * Sets the value of the thingId property.
     * 
     * @param value
     *     allowed object is
     *     {@link ThingKey }
     *     
     */
    public void setThingId(ThingKey value) {
        this.thingId = value;
    }

    /**
     * Gets the value of the typeId property.
     * 
     * @return
     *     possible object is
     *     {@link ThingType }
     *     
     */
    public ThingType getTypeId() {
        return typeId;
    }

    /**
     * Sets the value of the typeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link ThingType }
     *     
     */
    public void setTypeId(ThingType value) {
        this.typeId = value;
    }

    /**
     * Gets the value of the thingState property.
     * 
     * @return
     *     possible object is
     *     {@link ThingState }
     *     
     */
    public ThingState getThingState() {
        return thingState;
    }

    /**
     * Sets the value of the thingState property.
     * 
     * @param value
     *     allowed object is
     *     {@link ThingState }
     *     
     */
    public void setThingState(ThingState value) {
        this.thingState = value;
    }

    /**
     * Gets the value of the flags property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFlags() {
        return flags;
    }

    /**
     * Sets the value of the flags property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFlags(Long value) {
        this.flags = value;
    }

    /**
     * Gets the value of the effDate property.
     * 
     * @return
     *     possible object is
     *     {@link Date }
     *     
     */
    public Date getEffDate() {
        return effDate;
    }

    /**
     * Sets the value of the effDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Date }
     *     
     */
    public void setEffDate(Date value) {
        this.effDate = value;
    }

    /**
     * Gets the value of the created property.
     * 
     * @return
     *     possible object is
     *     {@link Audit2 }
     *     
     */
    public Audit2 getCreated() {
        return created;
    }

    /**
     * Sets the value of the created property.
     * 
     * @param value
     *     allowed object is
     *     {@link Audit2 }
     *     
     */
    public void setCreated(Audit2 value) {
        this.created = value;
    }

    /**
     * Gets the value of the updated property.
     * 
     * @return
     *     possible object is
     *     {@link Audit2 }
     *     
     */
    public Audit2 getUpdated() {
        return updated;
    }

    /**
     * Sets the value of the updated property.
     * 
     * @param value
     *     allowed object is
     *     {@link Audit2 }
     *     
     */
    public void setUpdated(Audit2 value) {
        this.updated = value;
    }

    /**
     * Gets the value of the dataXml property.
     */
    public DataXml getDataXml() {
        return this.dataXml;
    }

    /**
     * Sets the value of DataXml.
     */
    public void setDataXml(DataXml dataXml) {
        this.dataXml = dataXml;
    }

    /**
     * Gets the value of the blobPayload property.
     * 
     * @return
     *     possible object is
     *     {@link BlobPayload }
     *     
     */
    public BlobPayload getBlobPayload() {
        return blobPayload;
    }

    /**
     * Sets the value of the blobPayload property.
     * 
     * @param value
     *     allowed object is
     *     {@link BlobPayload }
     *     
     */
    public void setBlobPayload(BlobPayload value) {
        this.blobPayload = value;
    }

    /**
     * Gets the value of the effPermissions property.
     * 
     * @return
     *     possible object is
     *     {@link EffectivePermissions }
     *     
     */
    public EffectivePermissions getEffPermissions() {
        return effPermissions;
    }

    /**
     * Sets the value of the effPermissions property.
     * 
     * @param value
     *     allowed object is
     *     {@link EffectivePermissions }
     *     
     */
    public void setEffPermissions(EffectivePermissions value) {
        this.effPermissions = value;
    }

    /**
     * Gets the value of the tags property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTags() {
        return tags;
    }

    /**
     * Sets the value of the tags property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTags(String value) {
        this.tags = value;
    }
    
    public AbstractThing getData() {
    	return dataXml.getAny();
    }
    
    public void setData(AbstractThing obj) {
    	if (dataXml == null) {
    		dataXml = new DataXml();
    	}
    	
    	dataXml.setAny(obj);
    	typeId = new ThingType(obj.getThingType());
    }
    
    @Commit
    private void fixUpInternalThingReference() {
    	dataXml.getAny().setThing(this);
    }
    
    public Boolean hasBlobData() {
    	return blobPayload != null;
    }

	public void addOrUpdateBlob(BlobPayloadItem blob) {
		if(blobPayload == null || !blobPayload.hasBlobs()) {
			blobPayload = new BlobPayload();
		}
		
		blobPayload.addOrUpdateBlob(blob);
	}
	
	public void refreshBlobData(Record record) {
		refreshBlobData(record, null);
	}
	
	public void refreshBlobData(Record record, BlobFormatSpec blobSpec) {
		BlobFormatSpec blobFormatSpec = blobSpec == null ? BlobFormatSpec.streamed : BlobFormatSpec.inline;
		
		BlobFormat blobFormat = new BlobFormat();
		blobFormat.setBlobFormatSpec(blobFormatSpec);
		
		BlobPayloadRequest blobPayloadRequest = new BlobPayloadRequest();
		blobPayloadRequest.setBlobFormat(blobFormat);
		
		ThingFormatSpec2 formatSpec = new ThingFormatSpec2();
		formatSpec.getSection().add(ThingSectionSpec2.blobpayload);
		formatSpec.getXml().add("");
		formatSpec.setBlobPayloadRequest(blobPayloadRequest);
		
		ThingRequestGroup2 requestGroup = ThingRequestGroup2.keyQuery(thingId);
		requestGroup.setFormat(formatSpec);
		
		ThingResponseGroup2 response = record.getThings(requestGroup);
		
		Thing2 thing = response.getThing().get(0);
		
		if(thing.hasBlobData()) {
			this.blobPayload = thing.getBlobPayload();
		}
	}
}
