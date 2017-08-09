//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.08 at 12:00:41 PM PDT 
//


package com.microsoft.healthvault.generated.methods.GetUpdatedRecordsForApplication2.response;

import java.util.Date;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;


/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.methods.response.GetUpdatedRecordsForApplication2" xmlns:wc-types="urn:com.microsoft.wc.types"&gt;
 *                     Record identifier for the record authorized for
 *                     the application that has been updated and its corresponding
 *                     person identifier.
 *                 &lt;/summary&gt;
 * </pre>
 * 
 * 
 * <p>Java class for UpdatedRecord complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UpdatedRecord">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="record-id" type="{urn:com.microsoft.wc.types}guid"/>
 *         &lt;element name="update-date" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="person-id" type="{urn:com.microsoft.wc.types}guid"/>
 *         &lt;element name="latest-operation-sequence-number" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
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
    "recordId",
    "updateDate",
    "personId",
    "latestOperationSequenceNumber"
})
public class UpdatedRecord {

    @Element(name = "record-id", required = true)
    protected String recordId;
    @Element(name = "update-date", required = true)
    protected Date updateDate;
    @Element(name = "person-id", required = true)
    protected String personId;
    @Element(name = "latest-operation-sequence-number")
    protected Long latestOperationSequenceNumber;

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
     * Gets the value of the updateDate property.
     * 
     * @return
     *     possible object is
     *     {@link Date }
     *     
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * Sets the value of the updateDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Date }
     *     
     */
    public void setUpdateDate(Date value) {
        this.updateDate = value;
    }

    /**
     * Gets the value of the personId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPersonId() {
        return personId;
    }

    /**
     * Sets the value of the personId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPersonId(String value) {
        this.personId = value;
    }

    /**
     * Gets the value of the latestOperationSequenceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLatestOperationSequenceNumber() {
        return latestOperationSequenceNumber;
    }

    /**
     * Sets the value of the latestOperationSequenceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLatestOperationSequenceNumber(Long value) {
        this.latestOperationSequenceNumber = value;
    }

}
