package com.microsoft.hsg.android.simplexml.things.thing;

import java.util.Date;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;

/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:d="urn:com.microsoft.wc.dates" xmlns:ds="" xmlns:this="urn:com.microsoft.wc.thing" xmlns:wc-auth="urn:com.microsoft.wc.auth" xmlns:wc-types="urn:com.microsoft.wc.types"&gt;
 *                     Specifies the things returned with partial information.
 *                 &lt;/summary&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;remarks xmlns="http://www.w3.org/2001/XMLSchema" xmlns:d="urn:com.microsoft.wc.dates" xmlns:ds="" xmlns:this="urn:com.microsoft.wc.thing" xmlns:wc-auth="urn:com.microsoft.wc.auth" xmlns:wc-types="urn:com.microsoft.wc.types"&gt;
 *                     Things will be returned with partial information if the maximum limit for full things have
 *                     been reached.
 *                     To retrieve the things in full form, the thing ids can be specified in the filter group
 *                     of additional GetThing methods requests.
 *                 &lt;/remarks&gt;
 * </pre>
 * 
 * 
 * <p>Java class for UnprocessedThingKeyInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UnprocessedThingKeyInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="thing-id" type="{urn:com.microsoft.wc.thing}ThingKey"/>
 *         &lt;element name="type-id" type="{urn:com.microsoft.wc.thing}ThingType"/>
 *         &lt;element name="eff-date" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@Order(elements = {
    "thing-id",
    "type-id",
    "eff-date"
})
public class UnprocessedThingKeyInfo {

    @Element(name = "thing-id", required = true)
    protected ThingKey thingId;

    @Element(name = "type-id", required = true)
    protected ThingType typeId;

    @Element(name = "eff-date", required = true)
    protected Date effDate;

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

}
