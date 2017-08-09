//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.08 at 12:00:41 PM PDT 
//


package com.microsoft.healthvault.generated.methods.AuthorizeRecord.request;

import java.util.Date;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;
import com.microsoft.healthvault.generated.core.authentication.AuthXml;


/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.methods.AuthorizeRecord" xmlns:wc-app="urn:com.microsoft.wc.application" xmlns:wc-auth="urn:com.microsoft.wc.auth" xmlns:wc-types="urn:com.microsoft.wc.types"/&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;remarks xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.methods.AuthorizeRecord" xmlns:wc-app="urn:com.microsoft.wc.application" xmlns:wc-auth="urn:com.microsoft.wc.auth" xmlns:wc-types="urn:com.microsoft.wc.types"/&gt;
 * </pre>
 * 
 * 
 * <p>Java class for AppBehestCreation2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AppBehestCreation2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="application-id" type="{urn:com.microsoft.wc.types}guid"/>
 *         &lt;element name="person-online-auth-xml" type="{urn:com.microsoft.wc.auth}AuthXml"/>
 *         &lt;element name="person-offline-auth-xml" type="{urn:com.microsoft.wc.auth}AuthXml" minOccurs="0"/>
 *         &lt;element name="auto-reconcile-documents" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
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
    "applicationId",
    "personOnlineAuthXml",
    "personOfflineAuthXml",
    "autoReconcileDocuments",
    "canBulkExtract"
})
public class AppBehestCreation2 {

    @Element(name = "application-id", required = true)
    protected String applicationId;
    @Element(name = "person-online-auth-xml", required = true)
    protected AuthXml personOnlineAuthXml;
    @Element(name = "person-offline-auth-xml")
    protected AuthXml personOfflineAuthXml;
    @Element(name = "auto-reconcile-documents")
    protected Boolean autoReconcileDocuments;
    @Element(name = "can-bulk-extract")
    protected Boolean canBulkExtract;

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
