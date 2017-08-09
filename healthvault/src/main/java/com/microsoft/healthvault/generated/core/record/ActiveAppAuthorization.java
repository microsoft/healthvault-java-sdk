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
import com.microsoft.healthvault.generated.types.Location;


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
 * <p>Java class for ActiveAppAuthorization complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ActiveAppAuthorization">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="record-id" type="{urn:com.microsoft.wc.types}guid"/>
 *         &lt;element name="application-id" type="{urn:com.microsoft.wc.types}guid"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="date-auth-expires" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="person-online-auth-xml" type="{urn:com.microsoft.wc.auth}AuthXml" minOccurs="0"/>
 *         &lt;element name="person-offline-auth-xml" type="{urn:com.microsoft.wc.auth}AuthXml" minOccurs="0"/>
 *         &lt;element name="date-auth-created" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="date-auth-updated" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="record-display-name" type="{urn:com.microsoft.wc.types}string255"/>
 *         &lt;element name="auto-reconcile-documents" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="location" type="{urn:com.microsoft.wc.types}Location" minOccurs="0"/>
 *         &lt;element name="pseudo-record-id" type="{urn:com.microsoft.wc.types}guid" minOccurs="0"/>
 *         &lt;element name="pseudo-person-id" type="{urn:com.microsoft.wc.types}guid" minOccurs="0"/>
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
    "applicationId",
    "name",
    "dateAuthExpires",
    "personOnlineAuthXml",
    "personOfflineAuthXml",
    "dateAuthCreated",
    "dateAuthUpdated",
    "recordDisplayName",
    "autoReconcileDocuments",
    "location",
    "pseudoRecordId",
    "pseudoPersonId",
    "canBulkExtract"
})
public class ActiveAppAuthorization {

    @Element(name = "record-id", required = true)
    protected String recordId;
    @Element(name = "application-id", required = true)
    protected String applicationId;
    @Element(required = true)
    protected String name;
    @Element(name = "date-auth-expires")
    protected Date dateAuthExpires;
    @Element(name = "person-online-auth-xml")
    protected AuthXml personOnlineAuthXml;
    @Element(name = "person-offline-auth-xml")
    protected AuthXml personOfflineAuthXml;
    @Element(name = "date-auth-created")
    protected Date dateAuthCreated;
    @Element(name = "date-auth-updated")
    protected Date dateAuthUpdated;
    @Element(name = "record-display-name", required = true)
    protected String recordDisplayName;
    @Element(name = "auto-reconcile-documents")
    protected Boolean autoReconcileDocuments;
    protected Location location;
    @Element(name = "pseudo-record-id")
    protected String pseudoRecordId;
    @Element(name = "pseudo-person-id")
    protected String pseudoPersonId;
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
     * Gets the value of the applicationId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplicationId() {
        return applicationId;
    }

    /**
     * Sets the value of the applicationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplicationId(String value) {
        this.applicationId = value;
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
     * Gets the value of the personOnlineAuthXml property.
     * 
     * @return
     *     possible object is
     *     {@link AuthXml }
     *     
     */
    public AuthXml getPersonOnlineAuthXml() {
        return personOnlineAuthXml;
    }

    /**
     * Sets the value of the personOnlineAuthXml property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuthXml }
     *     
     */
    public void setPersonOnlineAuthXml(AuthXml value) {
        this.personOnlineAuthXml = value;
    }

    /**
     * Gets the value of the personOfflineAuthXml property.
     * 
     * @return
     *     possible object is
     *     {@link AuthXml }
     *     
     */
    public AuthXml getPersonOfflineAuthXml() {
        return personOfflineAuthXml;
    }

    /**
     * Sets the value of the personOfflineAuthXml property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuthXml }
     *     
     */
    public void setPersonOfflineAuthXml(AuthXml value) {
        this.personOfflineAuthXml = value;
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
     * Gets the value of the autoReconcileDocuments property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAutoReconcileDocuments() {
        return autoReconcileDocuments;
    }

    /**
     * Sets the value of the autoReconcileDocuments property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAutoReconcileDocuments(Boolean value) {
        this.autoReconcileDocuments = value;
    }

    /**
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link Location }
     *     
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link Location }
     *     
     */
    public void setLocation(Location value) {
        this.location = value;
    }

    /**
     * Gets the value of the pseudoRecordId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPseudoRecordId() {
        return pseudoRecordId;
    }

    /**
     * Sets the value of the pseudoRecordId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPseudoRecordId(String value) {
        this.pseudoRecordId = value;
    }

    /**
     * Gets the value of the pseudoPersonId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPseudoPersonId() {
        return pseudoPersonId;
    }

    /**
     * Sets the value of the pseudoPersonId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPseudoPersonId(String value) {
        this.pseudoPersonId = value;
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
