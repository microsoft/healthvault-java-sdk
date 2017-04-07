package com.microsoft.hsg.android.simplexml.things.types.condition;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;

import com.microsoft.hsg.android.simplexml.things.thing.AbstractThing;
import com.microsoft.hsg.android.simplexml.things.types.base.CodableValue;
import com.microsoft.hsg.android.simplexml.things.types.dates.ApproxDateTime;

/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:c="urn:com.microsoft.wc.thing.condition" xmlns:d="urn:com.microsoft.wc.dates" xmlns:t="urn:com.microsoft.wc.thing.types"&gt;
 *                         Defines a single health or medical issue/problem.
 *                     &lt;/summary&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;remarks xmlns="http://www.w3.org/2001/XMLSchema" xmlns:c="urn:com.microsoft.wc.thing.condition" xmlns:d="urn:com.microsoft.wc.dates" xmlns:t="urn:com.microsoft.wc.thing.types"&gt;
 *                         CCR qualifiers and other notes should go in the
 *                         common/note section of the thing.
 *                     &lt;/remarks&gt;
 * </pre>
 * 
 * 
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{urn:com.microsoft.wc.thing.types}codable-value"/>
 *         &lt;element name="onset-date" type="{urn:com.microsoft.wc.dates}approx-date-time" minOccurs="0"/>
 *         &lt;element name="status" type="{urn:com.microsoft.wc.thing.types}codable-value" minOccurs="0"/>
 *         &lt;element name="stop-date" type="{urn:com.microsoft.wc.dates}approx-date-time" minOccurs="0"/>
 *         &lt;element name="stop-reason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@Order(elements = {
    "name",
    "onset-date",
    "status",
    "stop-date",
    "stop-reason"
})
@Root(name = "condition")
public class Condition extends AbstractThing {
	
	public static final String ThingType = "7ea7a1f9-880b-4bd4-b593-f5660f20eda8";

    @Element(required = true)
    protected CodableValue name;

    @Element(name = "onset-date", required=false)
    protected ApproxDateTime onsetDate;

    @Element(required = false)
    protected CodableValue status;

    @Element(name = "stop-date", required=false)
    protected ApproxDateTime stopDate;

    @Element(name = "stop-reason", required=false)
    protected String stopReason;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link CodableValue }
     *     
     */
    public CodableValue getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link CodableValue }
     *     
     */
    public void setName(CodableValue value) {
        this.name = value;
    }

    /**
     * Gets the value of the onsetDate property.
     * 
     * @return
     *     possible object is
     *     {@link ApproxDateTime }
     *     
     */
    public ApproxDateTime getOnsetDate() {
        return onsetDate;
    }

    /**
     * Sets the value of the onsetDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApproxDateTime }
     *     
     */
    public void setOnsetDate(ApproxDateTime value) {
        this.onsetDate = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link CodableValue }
     *     
     */
    public CodableValue getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link CodableValue }
     *     
     */
    public void setStatus(CodableValue value) {
        this.status = value;
    }

    /**
     * Gets the value of the stopDate property.
     * 
     * @return
     *     possible object is
     *     {@link ApproxDateTime }
     *     
     */
    public ApproxDateTime getStopDate() {
        return stopDate;
    }

    /**
     * Sets the value of the stopDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApproxDateTime }
     *     
     */
    public void setStopDate(ApproxDateTime value) {
        this.stopDate = value;
    }

    /**
     * Gets the value of the stopReason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStopReason() {
        return stopReason;
    }

    /**
     * Sets the value of the stopReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStopReason(String value) {
        this.stopReason = value;
    }
    
	public String getThingType() {
		return ThingType; 
	}

}
