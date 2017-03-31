package com.microsoft.hsg.android.simplexml.things.thing;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;

/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:d="urn:com.microsoft.wc.dates" xmlns:ds="" xmlns:this="urn:com.microsoft.wc.thing" xmlns:wc-auth="urn:com.microsoft.wc.auth" xmlns:wc-types="urn:com.microsoft.wc.types"&gt;
 *                     Defines a loose relationship between instances of things within a record.
 *                 &lt;/summary&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;remarks xmlns="http://www.w3.org/2001/XMLSchema" xmlns:d="urn:com.microsoft.wc.dates" xmlns:ds="" xmlns:this="urn:com.microsoft.wc.thing" xmlns:wc-auth="urn:com.microsoft.wc.auth" xmlns:wc-types="urn:com.microsoft.wc.types"&gt;
 *                     This relationship is completely application defined and maintained.
 *                     HealthVault does nothing to ensure that related things exist
 *                     or have a relationship back to this thing.
 *                     An example usage for related-things are to use an annotation thing
 *                     instance to make medical annotations for another thing type or to relate
 *                     a file instance (like an MRI) to problem instance.
 *                 &lt;/remarks&gt;
 * </pre>
 * 
 * 
 * <p>Java class for RelatedThing complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RelatedThing">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;sequence>
 *             &lt;element name="thing-id" type="{urn:com.microsoft.wc.types}guid"/>
 *             &lt;element name="version-stamp" type="{urn:com.microsoft.wc.types}guid" minOccurs="0"/>
 *           &lt;/sequence>
 *           &lt;element name="client-thing-id" type="{urn:com.microsoft.wc.types}string255" minOccurs="0"/>
 *         &lt;/choice>
 *         &lt;element name="relationship-type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "version-stamp",
    "client-thing-id",
    "relationship-type"
})
public class RelatedThing {

    @Element(name = "thing-id", required=true)
    protected String thingId;

    @Element(name = "version-stamp", required=false)
    protected String versionStamp;

    @Element(name = "client-thing-id", required=false)
    protected String clientThingId;

    @Element(name = "relationship-type", required=false)
    protected String relationshipType;

    /**
     * Gets the value of the thingId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getThingId() {
        return thingId;
    }

    /**
     * Sets the value of the thingId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setThingId(String value) {
        this.thingId = value;
    }

    /**
     * Gets the value of the versionStamp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersionStamp() {
        return versionStamp;
    }

    /**
     * Sets the value of the versionStamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersionStamp(String value) {
        this.versionStamp = value;
    }

    /**
     * Gets the value of the clientThingId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientThingId() {
        return clientThingId;
    }

    /**
     * Sets the value of the clientThingId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientThingId(String value) {
        this.clientThingId = value;
    }

    /**
     * Gets the value of the relationshipType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRelationshipType() {
        return relationshipType;
    }

    /**
     * Sets the value of the relationshipType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRelationshipType(String value) {
        this.relationshipType = value;
    }

}
