//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.08 at 12:00:41 PM PDT 
//


package com.microsoft.healthvault.generated.core.record;

import java.util.Date;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;
import com.microsoft.healthvault.generated.core.authentication.AuthXml;


/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.record" xmlns:wc-auth="urn:com.microsoft.wc.auth" xmlns:wc-types="urn:com.microsoft.wc.types"/&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;remarks xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.record" xmlns:wc-auth="urn:com.microsoft.wc.auth" xmlns:wc-types="urn:com.microsoft.wc.types"/&gt;
 * </pre>
 * 
 * 
 * <p>Java class for ActivePersonAuthorization complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ActivePersonAuthorization">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="record-id" type="{urn:com.microsoft.wc.types}guid"/>
 *         &lt;element name="person-id" type="{urn:com.microsoft.wc.types}guid"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="record-custodian" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="is-group" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="contact-email" type="{urn:com.microsoft.wc.types}EmailAddress"/>
 *         &lt;element name="contact-email-validated" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="record-display-name" type="{urn:com.microsoft.wc.types}string255" minOccurs="0"/>
 *         &lt;element name="date-auth-expires" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="auth-xml" type="{urn:com.microsoft.wc.auth}AuthXml" minOccurs="0"/>
 *         &lt;element name="rel-type" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="date-auth-created" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="date-auth-updated" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="can-access-audit" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="can-bulk-extract" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
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
    "personId",
    "name",
    "recordCustodian",
    "isGroup",
    "contactEmail",
    "contactEmailValidated",
    "recordDisplayName",
    "dateAuthExpires",
    "authXml",
    "relType",
    "dateAuthCreated",
    "dateAuthUpdated",
    "canAccessAudit",
    "canBulkExtract"
})
public class ActivePersonAuthorization {

    @Element(name = "record-id", required = true)
    protected String recordId;
    @Element(name = "person-id", required = true)
    protected String personId;
    @Element(required = true)
    protected String name;
    @Element(name = "record-custodian")
    protected boolean recordCustodian;
    @Element(name = "is-group")
    protected boolean isGroup;
    @Element(name = "contact-email", required = true)
    protected String contactEmail;
    @Element(name = "contact-email-validated")
    protected Boolean contactEmailValidated;
    @Element(name = "record-display-name")
    protected String recordDisplayName;
    @Element(name = "date-auth-expires")
    protected Date dateAuthExpires;
    @Element(name = "auth-xml")
    protected AuthXml authXml;
    @Element(name = "rel-type")
    protected Integer relType;
    @Element(name = "date-auth-created")
    protected Date dateAuthCreated;
    @Element(name = "date-auth-updated")
    protected Date dateAuthUpdated;
    @Element(name = "can-access-audit")
    protected Boolean canAccessAudit;
    @Element(name = "can-bulk-extract")
    protected Boolean canBulkExtract;

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

    /**
     * Gets the value of the recordCustodian property.
     * 
     */
    public boolean isRecordCustodian() {
        return recordCustodian;
    }

    /**
     * Sets the value of the recordCustodian property.
     * 
     */
    public void setRecordCustodian(boolean value) {
        this.recordCustodian = value;
    }

    /**
     * Gets the value of the isGroup property.
     * 
     */
    public boolean isIsGroup() {
        return isGroup;
    }

    /**
     * Sets the value of the isGroup property.
     * 
     */
    public void setIsGroup(boolean value) {
        this.isGroup = value;
    }

    /**
     * Gets the value of the contactEmail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactEmail() {
        return contactEmail;
    }

    /**
     * Sets the value of the contactEmail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactEmail(String value) {
        this.contactEmail = value;
    }

    /**
     * Gets the value of the contactEmailValidated property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isContactEmailValidated() {
        return contactEmailValidated;
    }

    /**
     * Sets the value of the contactEmailValidated property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setContactEmailValidated(Boolean value) {
        this.contactEmailValidated = value;
    }

    /**
     * Gets the value of the recordDisplayName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecordDisplayName() {
        return recordDisplayName;
    }

    /**
     * Sets the value of the recordDisplayName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecordDisplayName(String value) {
        this.recordDisplayName = value;
    }

    /**
     * Gets the value of the dateAuthExpires property.
     * 
     * @return
     *     possible object is
     *     {@link Date }
     *     
     */
    public Date getDateAuthExpires() {
        return dateAuthExpires;
    }

    /**
     * Sets the value of the dateAuthExpires property.
     * 
     * @param value
     *     allowed object is
     *     {@link Date }
     *     
     */
    public void setDateAuthExpires(Date value) {
        this.dateAuthExpires = value;
    }

    /**
     * Gets the value of the authXml property.
     * 
     * @return
     *     possible object is
     *     {@link AuthXml }
     *     
     */
    public AuthXml getAuthXml() {
        return authXml;
    }

    /**
     * Sets the value of the authXml property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuthXml }
     *     
     */
    public void setAuthXml(AuthXml value) {
        this.authXml = value;
    }

    /**
     * Gets the value of the relType property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRelType() {
        return relType;
    }

    /**
     * Sets the value of the relType property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRelType(Integer value) {
        this.relType = value;
    }

    /**
     * Gets the value of the dateAuthCreated property.
     * 
     * @return
     *     possible object is
     *     {@link Date }
     *     
     */
    public Date getDateAuthCreated() {
        return dateAuthCreated;
    }

    /**
     * Sets the value of the dateAuthCreated property.
     * 
     * @param value
     *     allowed object is
     *     {@link Date }
     *     
     */
    public void setDateAuthCreated(Date value) {
        this.dateAuthCreated = value;
    }

    /**
     * Gets the value of the dateAuthUpdated property.
     * 
     * @return
     *     possible object is
     *     {@link Date }
     *     
     */
    public Date getDateAuthUpdated() {
        return dateAuthUpdated;
    }

    /**
     * Sets the value of the dateAuthUpdated property.
     * 
     * @param value
     *     allowed object is
     *     {@link Date }
     *     
     */
    public void setDateAuthUpdated(Date value) {
        this.dateAuthUpdated = value;
    }

    /**
     * Gets the value of the canAccessAudit property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCanAccessAudit() {
        return canAccessAudit;
    }

    /**
     * Sets the value of the canAccessAudit property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCanAccessAudit(Boolean value) {
        this.canAccessAudit = value;
    }

    /**
     * Gets the value of the canBulkExtract property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCanBulkExtract() {
        return canBulkExtract;
    }

    /**
     * Sets the value of the canBulkExtract property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCanBulkExtract(Boolean value) {
        this.canBulkExtract = value;
    }

}
