//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.08 at 12:00:41 PM PDT 
//


package com.microsoft.healthvault.generated.methods.AddRecordAudit.request;

import java.util.Date;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;


/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.methods.AddRecordAudit"/&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;remarks xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.methods.AddRecordAudit"/&gt;
 * </pre>
 * 
 * 
 * <p>Java class for RecordAudit complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RecordAudit">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="record-audit-action" type="{urn:com.microsoft.wc.methods.AddRecordAudit}RecordAuditActionType"/>
 *         &lt;element name="record-audit-message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "recordAuditAction",
    "recordAuditMessage"
})
public class RecordAudit {

    @Element(name = "record-audit-action", required = true)
    protected RecordAuditActionType recordAuditAction;
    @Element(name = "record-audit-message")
    protected String recordAuditMessage;

    /**
     * Gets the value of the recordAuditAction property.
     * 
     * @return
     *     possible object is
     *     {@link RecordAuditActionType }
     *     
     */
    public RecordAuditActionType getRecordAuditAction() {
        return recordAuditAction;
    }

    /**
     * Sets the value of the recordAuditAction property.
     * 
     * @param value
     *     allowed object is
     *     {@link RecordAuditActionType }
     *     
     */
    public void setRecordAuditAction(RecordAuditActionType value) {
        this.recordAuditAction = value;
    }

    /**
     * Gets the value of the recordAuditMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecordAuditMessage() {
        return recordAuditMessage;
    }

    /**
     * Sets the value of the recordAuditMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecordAuditMessage(String value) {
        this.recordAuditMessage = value;
    }

}