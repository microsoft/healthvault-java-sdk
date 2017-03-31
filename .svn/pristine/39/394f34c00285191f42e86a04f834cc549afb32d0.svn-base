package com.microsoft.hsg.android.simplexml.things.types.types;

import java.util.ArrayList;
import java.util.List;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Element;

/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.types"&gt;
 *                     A list of the permissions the calling application has to the specified record.
 *                 &lt;/summary&gt;
 * </pre>
 * 
 * 
 * <p>Java class for EffectiveRecordPermission complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EffectiveRecordPermission">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="record-id" type="{urn:com.microsoft.wc.types}guid"/>
 *         &lt;element name="thing-type-permission" type="{urn:com.microsoft.wc.types}ThingTypePermission" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@Order(elements = {
    "record-id",
    "thing-type-permission"
})
public class EffectiveRecordPermission {

    @Element(name = "record-id", required = true)
    protected String recordId;
    @Element(name = "thing-type-permission", required = false)
    protected List<ThingTypePermission> thingTypePermission;

    /**
     * Gets the value of the recordId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecordId() {
        return recordId;
    }

    /**
     * Sets the value of the recordId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecordId(String value) {
        this.recordId = value;
    }

    /**
     * Gets the value of the thingTypePermission property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the object.
     * This is why there is not a <CODE>set</CODE> method for the thingTypePermission property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getThingTypePermission().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ThingTypePermission }
     * 
     * 
     */
    public List<ThingTypePermission> getThingTypePermission() {
        if (thingTypePermission == null) {
            thingTypePermission = new ArrayList<ThingTypePermission>();
        }
        return this.thingTypePermission;
    }

}
