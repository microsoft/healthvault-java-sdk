package com.microsoft.hsg.android.simplexml.methods.getthings3.request;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Order;

/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.methods.GetThings3" xmlns:wc-method-getthings="urn:com.microsoft.wc.methods.GetThings" xmlns:wc-thing="urn:com.microsoft.wc.thing" xmlns:wc-types="urn:com.microsoft.wc.types"&gt;
 *                     Specifies how the results are returned.
 *                 &lt;/summary&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;remarks xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.methods.GetThings3" xmlns:wc-method-getthings="urn:com.microsoft.wc.methods.GetThings" xmlns:wc-thing="urn:com.microsoft.wc.thing" xmlns:wc-types="urn:com.microsoft.wc.types"&gt;
 *                     The section element specifies which sections are returned. The xml element
 *                     specifies how the actual thing data is formatted.
 *                 &lt;/remarks&gt;
 * </pre>
 * 
 * 
 * <p>Java class for ThingFormatSpec2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ThingFormatSpec2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="section" type="{urn:com.microsoft.wc.methods.GetThings3}ThingSectionSpec2" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="xml" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="type-version-format" type="{urn:com.microsoft.wc.types}guid" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="blob-payload-request" type="{urn:com.microsoft.wc.methods.GetThings3}BlobPayloadRequest" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@Order(elements = {
    "section",
    "xml",
    "type-version-format",
    "blob-payload-request"
})
public class ThingFormatSpec2 {

    @ElementList(required = false, inline=true, entry="section")
    protected ArrayList<ThingSectionSpec2> section;

    @ElementList(required = true, inline=true, entry="xml")
    protected ArrayList<String> xml;

    @ElementList(required=false, inline=true, entry="type-version-format")
    protected ArrayList<String> typeVersionFormat;

    @Element(required=false, name="blob-payload-request")
    protected BlobPayloadRequest blobPayloadRequest;

	/**
     * Gets the value of the section property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the section property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSection().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ThingSectionSpec2 }
     * 
     * 
     */
    public List<ThingSectionSpec2> getSection() {
        if (section == null) {
            section = new ArrayList<ThingSectionSpec2>();
        }
        return this.section;
    }

    /**
     * Gets the value of the xml property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the xml property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getXml().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getXml() {
        if (xml == null) {
            xml = new ArrayList<String>();
        }
        return this.xml;
    }

    /**
     * Gets the value of the typeVersionFormat property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the typeVersionFormat property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTypeVersionFormat().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getTypeVersionFormat() {
        if (typeVersionFormat == null) {
            typeVersionFormat = new ArrayList<String>();
        }
        return this.typeVersionFormat;
    }

    /**
     * Gets the value of the blobPayloadRequest property.
     * 
     * @return
     *     possible object is
     *     {@link BlobPayloadRequest }
     *     
     */
    public BlobPayloadRequest getBlobPayloadRequest() {
        return blobPayloadRequest;
    }

    /**
     * Sets the value of the blobPayloadRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link BlobPayloadRequest }
     *     
     */
    public void setBlobPayloadRequest(BlobPayloadRequest value) {
        this.blobPayloadRequest = value;
    }
    
    public ThingFormatSpec2 setSection(ThingSectionSpec2 sectionSpec) {
    	getSection().add(sectionSpec);
    	
    	return this;
    }
}
