package com.microsoft.hsg.android.simplexml.things.thing;

import java.util.Date;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;

/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:d="urn:com.microsoft.wc.dates" xmlns:ds="" xmlns:this="urn:com.microsoft.wc.thing" xmlns:wc-auth="urn:com.microsoft.wc.auth" xmlns:wc-types="urn:com.microsoft.wc.types"&gt;
 *                     Represents an audit trail of creations or updates
 *                     or deletes to information in the Health service.
 *                 &lt;/summary&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;remarks xmlns="http://www.w3.org/2001/XMLSchema" xmlns:d="urn:com.microsoft.wc.dates" xmlns:ds="" xmlns:this="urn:com.microsoft.wc.thing" xmlns:wc-auth="urn:com.microsoft.wc.auth" xmlns:wc-types="urn:com.microsoft.wc.types"&gt;
 *                     The audit records when the operation happened,
 *                     by which application, and by which person.
 *                 &lt;/remarks&gt;
 * </pre>
 * 
 * 
 * <p>Java class for Audit2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Audit2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{urn:com.microsoft.wc.thing}AuditBase"/>
 *         &lt;element name="master-app-id" type="{urn:com.microsoft.wc.types}guid" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@Order(elements = {
    "timestamp",
    "app-id",
    "person-id",
    "impersonator-id",
    "access-avenue",
    "audit-action",
    "master-app-id"
})
public class Audit2 {

    @Element(required = true)
    protected Date timestamp;

    @Element(name = "app-id", required = true)
    protected GuidAndName appId;

    @Element(name = "person-id", required = true)
    protected GuidAndName personId;

    @Element(name = "impersonator-id", required=false)
    protected GuidAndName impersonatorId;

    @Element(name = "access-avenue", required=false)
    protected AccessAvenue accessAvenue;

    @Element(name = "audit-action", required = true)
    protected AuditAction auditAction;

    @Element(name = "master-app-id", required=false)
    protected String masterAppId;

    /**
     * Gets the value of the timestamp property.
     * 
     * @return
     *     possible object is
     *     {@link Date }
     *     
     */
    public Date getTimestamp() {
        return timestamp;
    }

    /**
     * Sets the value of the timestamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link Date }
     *     
     */
    public void setTimestamp(Date value) {
        this.timestamp = value;
    }

    /**
     * Gets the value of the appId property.
     * 
     * @return
     *     possible object is
     *     {@link GuidAndName }
     *     
     */
    public GuidAndName getAppId() {
        return appId;
    }

    /**
     * Sets the value of the appId property.
     * 
     * @param value
     *     allowed object is
     *     {@link GuidAndName }
     *     
     */
    public void setAppId(GuidAndName value) {
        this.appId = value;
    }

    /**
     * Gets the value of the personId property.
     * 
     * @return
     *     possible object is
     *     {@link GuidAndName }
     *     
     */
    public GuidAndName getPersonId() {
        return personId;
    }

    /**
     * Sets the value of the personId property.
     * 
     * @param value
     *     allowed object is
     *     {@link GuidAndName }
     *     
     */
    public void setPersonId(GuidAndName value) {
        this.personId = value;
    }

    /**
     * Gets the value of the impersonatorId property.
     * 
     * @return
     *     possible object is
     *     {@link GuidAndName }
     *     
     */
    public GuidAndName getImpersonatorId() {
        return impersonatorId;
    }

    /**
     * Sets the value of the impersonatorId property.
     * 
     * @param value
     *     allowed object is
     *     {@link GuidAndName }
     *     
     */
    public void setImpersonatorId(GuidAndName value) {
        this.impersonatorId = value;
    }

    /**
     * Gets the value of the accessAvenue property.
     * 
     * @return
     *     possible object is
     *     {@link AccessAvenue }
     *     
     */
    public AccessAvenue getAccessAvenue() {
        return accessAvenue;
    }

    /**
     * Sets the value of the accessAvenue property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccessAvenue }
     *     
     */
    public void setAccessAvenue(AccessAvenue value) {
        this.accessAvenue = value;
    }

    /**
     * Gets the value of the auditAction property.
     * 
     * @return
     *     possible object is
     *     {@link AuditAction }
     *     
     */
    public AuditAction getAuditAction() {
        return auditAction;
    }

    /**
     * Sets the value of the auditAction property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuditAction }
     *     
     */
    public void setAuditAction(AuditAction value) {
        this.auditAction = value;
    }

    /**
     * Gets the value of the masterAppId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMasterAppId() {
        return masterAppId;
    }

    /**
     * Sets the value of the masterAppId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMasterAppId(String value) {
        this.masterAppId = value;
    }

}
