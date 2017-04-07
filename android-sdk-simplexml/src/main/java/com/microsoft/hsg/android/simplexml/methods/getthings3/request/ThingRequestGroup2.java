package com.microsoft.hsg.android.simplexml.methods.getthings3.request;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Order;

import com.microsoft.hsg.android.simplexml.methods.getthings3.request.BlobPayloadRequest.BlobFormat;
import com.microsoft.hsg.android.simplexml.things.thing.ThingKey;
import com.microsoft.hsg.android.simplexml.things.types.base.NonNegativeInt;

/**
 * <p>Java class for ThingRequestGroup2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ThingRequestGroup2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="id" type="{urn:com.microsoft.wc.types}guid" maxOccurs="unbounded" minOccurs="0"/>
 *           &lt;element name="key" type="{urn:com.microsoft.wc.thing}ThingKey" maxOccurs="unbounded" minOccurs="0"/>
 *           &lt;element name="client-thing-id" type="{urn:com.microsoft.wc.types}string255" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;/choice>
 *         &lt;element name="filter" type="{urn:com.microsoft.wc.methods.GetThings}ThingFilterSpec" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="format" type="{urn:com.microsoft.wc.methods.GetThings3}ThingFormatSpec2"/>
 *         &lt;element name="current-version-only" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="max" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" />
 *       &lt;attribute name="max-full" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@Order(elements = {
    "id",
    "key",
    "client-thing-id",
    "filter",
    "format",
    "current-version-only"
})
public class ThingRequestGroup2 {

    @ElementList(required=false, inline=true, entry="id")
    protected ArrayList<String> thingIdList;

    @ElementList(required=false, inline=true, entry="key")
    protected ArrayList<ThingKey> key;

    @ElementList(required=false, inline=true, entry="client-thing-id")
    protected ArrayList<String> clientThingIdList;

    @ElementList(required=false, inline=true, entry="filter")
    protected ArrayList<ThingFilterSpec> filterList;

    @Element(required = true)
    protected ThingFormatSpec2 format;

    @Element(required=false, name = "current-version-only")
    protected Boolean currentVersionOnly;

    @Attribute(required=false, name = "name")
    protected String name;
    
    @Attribute(required=false, name = "max")
    protected Integer max;

    @Attribute(required=false, name = "max-full")
    protected Integer maxFull;

    /**
     * Gets the value of the id property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the object.
     * This is why there is not a <CODE>set</CODE> method for the id property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getThingIdList() {
        if (thingIdList == null) {
            thingIdList = new ArrayList<String>();
        }
        return this.thingIdList;
    }

    /**
     * Gets the value of the key property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the object.
     * This is why there is not a <CODE>set</CODE> method for the key property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKey().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ThingKey }
     * 
     * 
     */
    public List<ThingKey> getKeyList() {
        if (key == null) {
            key = new ArrayList<ThingKey>();
        }
        return this.key;
    }

    /**
     * Gets the value of the clientThingId property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the object.
     * This is why there is not a <CODE>set</CODE> method for the clientThingId property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClientThingId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getClientThingIdList() {
        if (clientThingIdList == null) {
            clientThingIdList = new ArrayList<String>();
        }
        return this.clientThingIdList;
    }

    /**
     * Gets the value of the filter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the object.
     * This is why there is not a <CODE>set</CODE> method for the filter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFilter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ThingFilterSpec }
     * 
     * 
     */
    public List<ThingFilterSpec> getFilterList() {
        if (filterList == null) {
            filterList = new ArrayList<ThingFilterSpec>();
        }
        return this.filterList;
    }

    /**
     * Gets the value of the format property.
     * 
     * @return
     *     possible object is
     *     {@link ThingFormatSpec2 }
     *     
     */
    public ThingFormatSpec2 getFormat() {
    	if(format == null) {
    		format = new ThingFormatSpec2();
    		format.getXml().add("");
    	}
        return format;
    }

    /**
     * Sets the value of the format property.
     * 
     * @param value
     *     allowed object is
     *     {@link ThingFormatSpec2 }
     *     
     */
    public void setFormat(ThingFormatSpec2 value) {
        this.format = value;
    }

    /**
     * Gets the value of the currentVersionOnly property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCurrentVersionOnly() {
        return currentVersionOnly;
    }

    /**
     * Sets the value of the currentVersionOnly property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCurrentVersionOnly(Boolean value) {
        this.currentVersionOnly = value;
    }

    /**
     * Gets the value of the name property.
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
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the max property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMax() {
        return max;
    }

    /**
     * Sets the value of the max property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMax(Integer value) {
        NonNegativeInt maxValue = new NonNegativeInt(value);
        this.max = maxValue.getValue();
    }

    /**
     * Gets the value of the maxFull property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxFull() {
        return maxFull;
    }

    /**
     * Sets the value of the maxFull property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxFull(Integer value) {
        NonNegativeInt maxFullValue = new NonNegativeInt(value);
        this.maxFull = maxFullValue.getValue();
    }
    
    
    public static ThingRequestGroup2 thingTypeQuery(String thingType) {
		ThingRequestGroup2 requestGroup = new ThingRequestGroup2();
		requestGroup.name = thingType;
		
		ThingFilterSpec filter = new ThingFilterSpec(thingType);
		requestGroup.getFilterList().add(filter);
		
		requestGroup.getFormat().getTypeVersionFormat().add(thingType);
		
		return requestGroup;
	}
    
    public static ThingRequestGroup2 thingTypeQuery(String thingType, BlobFormatSpec blobFormatSpec) {
    	ThingRequestGroup2 requestGroup = thingTypeQuery(thingType);
    	
    	ThingFormatSpec2 formatSpec = new ThingFormatSpec2();
		BlobFormat format = new BlobFormat();
		format.setBlobFormatSpec(blobFormatSpec);
		
		BlobPayloadRequest blobPayload = new BlobPayloadRequest();
		blobPayload.setBlobFormat(format);
		
		formatSpec.setSection(ThingSectionSpec2.core).setSection(ThingSectionSpec2.blobpayload);
		formatSpec.getXml().add("");
		formatSpec.setBlobPayloadRequest(blobPayload);
		
		requestGroup.setFormat(formatSpec);
		
		return requestGroup;
	}
    
    public static ThingRequestGroup2 keyQuery(ThingKey key) {
    	ThingRequestGroup2 requestGroup = new ThingRequestGroup2();
    	requestGroup.key = new ArrayList<ThingKey>();
    	requestGroup.key.add(key);
    	
    	return requestGroup;
    }
    
    public static ThingRequestGroup2 keysQuery(ArrayList<ThingKey> keys) {
    	ThingRequestGroup2 requestGroup = new ThingRequestGroup2();
    	requestGroup.key = new ArrayList<ThingKey>();
    	requestGroup.key.addAll(keys);
    	
    	return requestGroup;
    }
    
    public static ThingRequestGroup2 keysQuery(ArrayList<ThingFilterSpec> filters, int maxResults) {
    	ThingRequestGroup2 requestGroup = new ThingRequestGroup2();
    	requestGroup.getFormat().setSection(ThingSectionSpec2.core);
    	requestGroup.getFilterList().addAll(filters);
    	requestGroup.setMaxFull(0);
    	
    	if(maxResults > 0) {
    		requestGroup.setMax(maxResults);
    	}
    	
    	return requestGroup;
    }
	
	private static ThingFilterSpec getThingFilterSpec(String thingType) {
		ThingFilterSpec fs = new ThingFilterSpec();
		fs.getTypeId().add(thingType);
		
		return fs;
	}
	
	private static ThingFormatSpec2 getFormatSpec() {
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
}
