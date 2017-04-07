package com.microsoft.hsg.android.simplexml.methods.getthings3.response;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Order;

import com.microsoft.hsg.android.simplexml.things.thing.Thing2;
import com.microsoft.hsg.android.simplexml.things.thing.UnprocessedThingKeyInfo;

/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.methods.response.GetThings3" xmlns:wc-thing="urn:com.microsoft.wc.thing" xmlns:wc-types="urn:com.microsoft.wc.types"&gt;
 *                     Each response group corresponds to a filter request group sent with the GetThings
 *                     request. 
 *                 &lt;/summary&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;remarks xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.methods.response.GetThings3" xmlns:wc-thing="urn:com.microsoft.wc.thing" xmlns:wc-types="urn:com.microsoft.wc.types"&gt;
 *                     Each group is uniquely identified by the group name and contains the represent an group
 *                     of clauses that are used as a filter to a GetThings method request.
 *                     Each group is independent of the other groups that might be sent with
 *                     the same request. 
 *                 &lt;/remarks&gt;
 * </pre>
 * 
 * 
 * <p>Java class for ThingResponseGroup2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ThingResponseGroup2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="thing" type="{urn:com.microsoft.wc.thing}Thing2" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="unprocessed-thing-key-info" type="{urn:com.microsoft.wc.thing}UnprocessedThingKeyInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="filtered" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@Order(elements = {
    "thing",
    "unprocessed-thing-key-info",
    "filtered"
})
public class ThingResponseGroup2 {

    @ElementList(required=false, inline=true, entry="thing")
    protected List<Thing2> thing;

    @ElementList(required=false, inline=true, entry="unprocessed-thing-key-info")
    protected List<UnprocessedThingKeyInfo> unprocessedThingKeyInfo;

    @Element(required=false)
    protected Boolean filtered;

    @Attribute(name = "name", required=false)
    protected String name;

    /**
     * Gets the value of the thing property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the object.
     * This is why there is not a <CODE>set</CODE> method for the thing property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getThing().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Thing2 }
     * 
     * 
     */
    public List<Thing2> getThing() {
        if (thing == null) {
            thing = new ArrayList<Thing2>();
        }
        return this.thing;
    }

    /**
     * Gets the value of the unprocessedThingKeyInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the unprocessedThingKeyInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUnprocessedThingKeyInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UnprocessedThingKeyInfo }
     * 
     * 
     */
    public List<UnprocessedThingKeyInfo> getUnprocessedThingKeyInfo() {
        if (unprocessedThingKeyInfo == null) {
            unprocessedThingKeyInfo = new ArrayList<UnprocessedThingKeyInfo>();
        }
        return this.unprocessedThingKeyInfo;
    }

    /**
     * Gets the value of the filtered property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFiltered() {
        return filtered;
    }

    /**
     * Sets the value of the filtered property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFiltered(Boolean value) {
        this.filtered = value;
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

}
