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
 * <p>Java class for UpdateByNonCustodian complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UpdateByNonCustodian">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="application-id" type="{urn:com.microsoft.wc.types}guid"/>
 *         &lt;element name="expires-date" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="person-online-auth-xml" type="{urn:com.microsoft.wc.auth}AuthXml" minOccurs="0"/>
 *         &lt;element name="person-offline-auth-xml" type="{urn:com.microsoft.wc.auth}AuthXml" minOccurs="0"/>
 *         &lt;element name="display-name" type="{urn:com.microsoft.wc.types}stringz255" minOccurs="0"/>
 *         &lt;element name="rel-id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
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
    "expiresDate",
    "personOnlineAuthXml",
    "personOfflineAuthXml",
    "displayName",
    "relId",
    "autoReconcileDocuments",
    "canBulkExtract"
})
public class UpdateByNonCustodian {

    @Element(name = "application-id", required = true)
    protected String applicationId;
    @Element(name = "expires-date")
    protected Date expiresDate;
    @Element(name = "person-online-auth-xml")
    protected AuthXml personOnlineAuthXml;
    @Element(name = "person-offline-auth-xml")
    protected AuthXml personOfflineAuthXml;
    @Element(name = "display-name")
    protected String displayName;
    @Element(name = "rel-id")
    protected Integer relId;
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
     * Gets the value of the expiresDate property.
     * 
     * @return
     *     possible object is
     *     {@link Date }
     *     
     */
    public Date getExpiresDate() {
        return expiresDate;
    }

    /**
     * Sets the value of the expiresDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Date }
     *     
     */
    public void setExpiresDate(Date value) {
        this.expiresDate = value;
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
     * Gets the value of the displayName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Sets the value of the displayName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisplayName(String value) {
        this.displayName = value;
    }

    /**
     * Gets the value of the relId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRelId() {
        return relId;
    }

    /**
     * Sets the value of the relId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRelId(Integer value) {
        this.relId = value;
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
