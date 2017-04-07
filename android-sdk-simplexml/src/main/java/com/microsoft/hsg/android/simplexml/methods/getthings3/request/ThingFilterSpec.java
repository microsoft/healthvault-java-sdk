package com.microsoft.hsg.android.simplexml.methods.getthings3.request;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Order;

import com.microsoft.hsg.android.simplexml.things.thing.ThingState;

/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.methods.GetThings" xmlns:wc-thing="urn:com.microsoft.wc.thing" xmlns:wc-types="urn:com.microsoft.wc.types"&gt;
 *                     Schema for specifying filters on things.
 *                 &lt;/summary&gt;
 * </pre>
 * 
 * 
 * <p>
 * Java class for ThingFilterSpec complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
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
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@Order(elements = { "type-id", 
		"thing-state", 
		"eff-date-min", 
		"eff-date-max",
		"created-app-id", 
		"created-person-id", 
		"updated-app-id",
		"updated-person-id", 
		"created-date-min", 
		"created-date-max",
		"updated-date-min", 
		"updated-date-max", 
		"xpath" })
public class ThingFilterSpec {

	@ElementList(required = false, inline = true, entry = "type-id")
	protected ArrayList<String> typeId;

	@ElementList(required = false, inline = true, entry = "thing-state")
	protected List<ThingState> thingState;

	@Element(required = false, name = "eff-date-min")
	protected Date effDateMin;

	@Element(required = false, name = "eff-date-max")
	protected Date effDateMax;

	@Element(required = false, name = "created-app-id")
	protected String createdAppId;

	@Element(required = false, name = "created-person-id")
	protected String createdPersonId;

	@Element(required = false, name = "updated-app-id")
	protected String updatedAppId;

	@Element(required = false, name = "updated-person-id")
	protected String updatedPersonId;

	@Element(required = false, name = "created-date-min")
	protected Date createdDateMin;

	@Element(required = false, name = "created-date-max")
	protected Date createdDateMax;

	@Element(required = false, name = "updated-date-min")
	protected Date updatedDateMin;

	@Element(required = false, name = "updated-date-max")
	protected Date updatedDateMax;

	@Element(required = false)
	protected String xpath;
	

	public ThingFilterSpec() {
	}

	public ThingFilterSpec(ArrayList<String> typeId) {
		this.typeId = typeId;
	}
	
	public ThingFilterSpec(String typeId) {
		this.typeId = new ArrayList<String>();
		this.typeId.add(typeId);
	}

	/**
	 * Gets the value of the typeId property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the object. This is why there is not a <CODE>set</CODE>
	 * method for the typeId property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getTypeId().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link String }
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
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the object. This is why there is not a <CODE>set</CODE>
	 * method for the thingState property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getThingState().add(newItem);
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
	 * @return possible object is {@link Date }
	 * 
	 */
	public Date getEffDateMin() {
		return effDateMin;
	}

	/**
	 * Sets the value of the effDateMin property.
	 * 
	 * @param value
	 *            allowed object is {@link Date }
	 * 
	 */
	public void setEffDateMin(Date value) {
		this.effDateMin = value;
	}

	/**
	 * Gets the value of the effDateMax property.
	 * 
	 * @return possible object is {@link Date }
	 * 
	 */
	public Date getEffDateMax() {
		return effDateMax;
	}

	/**
	 * Sets the value of the effDateMax property.
	 * 
	 * @param value
	 *            allowed object is {@link Date }
	 * 
	 */
	public void setEffDateMax(Date value) {
		this.effDateMax = value;
	}

	/**
	 * Gets the value of the createdAppId property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCreatedAppId() {
		return createdAppId;
	}

	/**
	 * Sets the value of the createdAppId property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCreatedAppId(String value) {
		this.createdAppId = value;
	}

	/**
	 * Gets the value of the createdPersonId property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCreatedPersonId() {
		return createdPersonId;
	}

	/**
	 * Sets the value of the createdPersonId property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCreatedPersonId(String value) {
		this.createdPersonId = value;
	}

	/**
	 * Gets the value of the updatedAppId property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getUpdatedAppId() {
		return updatedAppId;
	}

	/**
	 * Sets the value of the updatedAppId property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setUpdatedAppId(String value) {
		this.updatedAppId = value;
	}

	/**
	 * Gets the value of the updatedPersonId property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getUpdatedPersonId() {
		return updatedPersonId;
	}

	/**
	 * Sets the value of the updatedPersonId property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setUpdatedPersonId(String value) {
		this.updatedPersonId = value;
	}

	/**
	 * Gets the value of the createdDateMin property.
	 * 
	 * @return possible object is {@link Date }
	 * 
	 */
	public Date getCreatedDateMin() {
		return createdDateMin;
	}

	/**
	 * Sets the value of the createdDateMin property.
	 * 
	 * @param value
	 *            allowed object is {@link Date }
	 * 
	 */
	public void setCreatedDateMin(Date value) {
		this.createdDateMin = value;
	}

	/**
	 * Gets the value of the createdDateMax property.
	 * 
	 * @return possible object is {@link Date }
	 * 
	 */
	public Date getCreatedDateMax() {
		return createdDateMax;
	}

	/**
	 * Sets the value of the createdDateMax property.
	 * 
	 * @param value
	 *            allowed object is {@link Date }
	 * 
	 */
	public void setCreatedDateMax(Date value) {
		this.createdDateMax = value;
	}

	/**
	 * Gets the value of the updatedDateMin property.
	 * 
	 * @return possible object is {@link Date }
	 * 
	 */
	public Date getUpdatedDateMin() {
		return updatedDateMin;
	}

	/**
	 * Sets the value of the updatedDateMin property.
	 * 
	 * @param value
	 *            allowed object is {@link Date }
	 * 
	 */
	public void setUpdatedDateMin(Date value) {
		this.updatedDateMin = value;
	}

	/**
	 * Gets the value of the updatedDateMax property.
	 * 
	 * @return possible object is {@link Date }
	 * 
	 */
	public Date getUpdatedDateMax() {
		return updatedDateMax;
	}

	/**
	 * Sets the value of the updatedDateMax property.
	 * 
	 * @param value
	 *            allowed object is {@link Date }
	 * 
	 */
	public void setUpdatedDateMax(Date value) {
		this.updatedDateMax = value;
	}

	/**
	 * Gets the value of the xpath property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getXpath() {
		return xpath;
	}

	/**
	 * Sets the value of the xpath property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setXpath(String value) {
		this.xpath = value;
	}
}
