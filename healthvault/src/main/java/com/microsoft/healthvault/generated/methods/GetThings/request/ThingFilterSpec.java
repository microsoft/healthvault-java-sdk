//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.08 at 12:00:41 PM PDT 
//


package com.microsoft.healthvault.generated.methods.GetThings.request;

import java.util.Date;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;
import java.util.ArrayList;
import java.util.List;
import com.microsoft.healthvault.generated.thing.ThingState;


/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.methods.GetThings" xmlns:wc-thing="urn:com.microsoft.wc.thing" xmlns:wc-types="urn:com.microsoft.wc.types"&gt;
 *                     Schema for specifying filters on things.
 *                 &lt;/summary&gt;
 * </pre>
 * 
 * 
 * <p>Java class for ThingFilterSpec complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ThingFilterSpec">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="type-id" type="{urn:com.microsoft.wc.types}guid" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="thing-state" type="{urn:com.microsoft.wc.thing}ThingState" maxOccurs="2" minOccurs="0"/>
 *         &lt;element name="eff-date-min" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="eff-date-max" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="created-app-id" type="{urn:com.microsoft.wc.types}guid" minOccurs="0"/>
 *         &lt;element name="created-person-id" type="{urn:com.microsoft.wc.types}guid" minOccurs="0"/>
 *         &lt;element name="updated-app-id" type="{urn:com.microsoft.wc.types}guid" minOccurs="0"/>
 *         &lt;element name="updated-person-id" type="{urn:com.microsoft.wc.types}guid" minOccurs="0"/>
 *         &lt;element name="created-date-min" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="created-date-max" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="updated-date-min" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="updated-date-max" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="xpath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="updated-end-date-max" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="updated-end-date-min" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@Root(name="")
@Order(elements = {
    "typeId",
    "thingState",
    "effDateMin",
    "effDateMax",
    "createdAppId",
    "createdPersonId",
    "updatedAppId",
    "updatedPersonId",
    "createdDateMin",
    "createdDateMax",
    "updatedDateMin",
    "updatedDateMax",
    "xpath",
    "updatedEndDateMax",
    "updatedEndDateMin"
})
public class ThingFilterSpec {

    @Element(name = "type-id")
    protected List<String> typeId;
    @Element(name = "thing-state")
    protected List<ThingState> thingState;
    @Element(name = "eff-date-min")
    protected Date effDateMin;
    @Element(name = "eff-date-max")
    protected Date effDateMax;
    @Element(name = "created-app-id")
    protected String createdAppId;
    @Element(name = "created-person-id")
    protected String createdPersonId;
    @Element(name = "updated-app-id")
    protected String updatedAppId;
    @Element(name = "updated-person-id")
    protected String updatedPersonId;
    @Element(name = "created-date-min")
    protected Date createdDateMin;
    @Element(name = "created-date-max")
    protected Date createdDateMax;
    @Element(name = "updated-date-min")
    protected Date updatedDateMin;
    @Element(name = "updated-date-max")
    protected Date updatedDateMax;
    protected String xpath;
    @Element(name = "updated-end-date-max")
    protected Date updatedEndDateMax;
    @Element(name = "updated-end-date-min")
    protected Date updatedEndDateMin;

    /**
     * Gets the value of the typeId property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the typeId property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTypeId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getTypeId() {
        if (typeId == null) {
            typeId = new ArrayList<String>();
        }
        return this.typeId;
    }

    /**
     * Gets the value of the thingState property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the thingState property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getThingState().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ThingState }
     * 
     * 
     */
    public List<ThingState> getThingState() {
        if (thingState == null) {
            thingState = new ArrayList<ThingState>();
        }
        return this.thingState;
    }

    /**
     * Gets the value of the effDateMin property.
     * 
     * @return
     *     possible object is
     *     {@link Date }
     *     
     */
    public Date getEffDateMin() {
        return effDateMin;
    }

    /**
     * Sets the value of the effDateMin property.
     * 
     * @param value
     *     allowed object is
     *     {@link Date }
     *     
     */
    public void setEffDateMin(Date value) {
        this.effDateMin = value;
    }

    /**
     * Gets the value of the effDateMax property.
     * 
     * @return
     *     possible object is
     *     {@link Date }
     *     
     */
    public Date getEffDateMax() {
        return effDateMax;
    }

    /**
     * Sets the value of the effDateMax property.
     * 
     * @param value
     *     allowed object is
     *     {@link Date }
     *     
     */
    public void setEffDateMax(Date value) {
        this.effDateMax = value;
    }

    /**
     * Gets the value of the createdAppId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreatedAppId() {
        return createdAppId;
    }

    /**
     * Sets the value of the createdAppId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreatedAppId(String value) {
        this.createdAppId = value;
    }

    /**
     * Gets the value of the createdPersonId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreatedPersonId() {
        return createdPersonId;
    }

    /**
     * Sets the value of the createdPersonId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreatedPersonId(String value) {
        this.createdPersonId = value;
    }

    /**
     * Gets the value of the updatedAppId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUpdatedAppId() {
        return updatedAppId;
    }

    /**
     * Sets the value of the updatedAppId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUpdatedAppId(String value) {
        this.updatedAppId = value;
    }

    /**
     * Gets the value of the updatedPersonId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUpdatedPersonId() {
        return updatedPersonId;
    }

    /**
     * Sets the value of the updatedPersonId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUpdatedPersonId(String value) {
        this.updatedPersonId = value;
    }

    /**
     * Gets the value of the createdDateMin property.
     * 
     * @return
     *     possible object is
     *     {@link Date }
     *     
     */
    public Date getCreatedDateMin() {
        return createdDateMin;
    }

    /**
     * Sets the value of the createdDateMin property.
     * 
     * @param value
     *     allowed object is
     *     {@link Date }
     *     
     */
    public void setCreatedDateMin(Date value) {
        this.createdDateMin = value;
    }

    /**
     * Gets the value of the createdDateMax property.
     * 
     * @return
     *     possible object is
     *     {@link Date }
     *     
     */
    public Date getCreatedDateMax() {
        return createdDateMax;
    }

    /**
     * Sets the value of the createdDateMax property.
     * 
     * @param value
     *     allowed object is
     *     {@link Date }
     *     
     */
    public void setCreatedDateMax(Date value) {
        this.createdDateMax = value;
    }

    /**
     * Gets the value of the updatedDateMin property.
     * 
     * @return
     *     possible object is
     *     {@link Date }
     *     
     */
    public Date getUpdatedDateMin() {
        return updatedDateMin;
    }

    /**
     * Sets the value of the updatedDateMin property.
     * 
     * @param value
     *     allowed object is
     *     {@link Date }
     *     
     */
    public void setUpdatedDateMin(Date value) {
        this.updatedDateMin = value;
    }

    /**
     * Gets the value of the updatedDateMax property.
     * 
     * @return
     *     possible object is
     *     {@link Date }
     *     
     */
    public Date getUpdatedDateMax() {
        return updatedDateMax;
    }

    /**
     * Sets the value of the updatedDateMax property.
     * 
     * @param value
     *     allowed object is
     *     {@link Date }
     *     
     */
    public void setUpdatedDateMax(Date value) {
        this.updatedDateMax = value;
    }

    /**
     * Gets the value of the xpath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXpath() {
        return xpath;
    }

    /**
     * Sets the value of the xpath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXpath(String value) {
        this.xpath = value;
    }

    /**
     * Gets the value of the updatedEndDateMax property.
     * 
     * @return
     *     possible object is
     *     {@link Date }
     *     
     */
    public Date getUpdatedEndDateMax() {
        return updatedEndDateMax;
    }

    /**
     * Sets the value of the updatedEndDateMax property.
     * 
     * @param value
     *     allowed object is
     *     {@link Date }
     *     
     */
    public void setUpdatedEndDateMax(Date value) {
        this.updatedEndDateMax = value;
    }

    /**
     * Gets the value of the updatedEndDateMin property.
     * 
     * @return
     *     possible object is
     *     {@link Date }
     *     
     */
    public Date getUpdatedEndDateMin() {
        return updatedEndDateMin;
    }

    /**
     * Sets the value of the updatedEndDateMin property.
     * 
     * @param value
     *     allowed object is
     *     {@link Date }
     *     
     */
    public void setUpdatedEndDateMin(Date value) {
        this.updatedEndDateMin = value;
    }

}
