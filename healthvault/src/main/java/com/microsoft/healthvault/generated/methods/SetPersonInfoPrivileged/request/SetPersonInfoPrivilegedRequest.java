//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.08 at 12:00:41 PM PDT 
//


package com.microsoft.healthvault.generated.methods.SetPersonInfoPrivileged.request;

import java.util.Date;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;
import com.microsoft.healthvault.generated.core.person.SecurityContactInfo;
import com.microsoft.healthvault.generated.types.Culture;
import com.microsoft.healthvault.generated.types.Location;


/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:wc-person="urn:com.microsoft.wc.person" xmlns:wc-types="urn:com.microsoft.wc.types"/&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;remarks xmlns="http://www.w3.org/2001/XMLSchema" xmlns:wc-person="urn:com.microsoft.wc.person" xmlns:wc-types="urn:com.microsoft.wc.types"/&gt;
 * </pre>
 * 
 * 
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="is-newsletter-subscriber" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="preferred-culture" type="{urn:com.microsoft.wc.types}Culture" minOccurs="0"/>
 *         &lt;element name="preferred-uiculture" type="{urn:com.microsoft.wc.types}Culture" minOccurs="0"/>
 *         &lt;element name="preferred-timezone" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="security-contact" type="{urn:com.microsoft.wc.person}SecurityContactInfo" minOccurs="0"/>
 *         &lt;element name="is-health-statement-subscriber" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="health-statement-last-sent-date" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="is-eprep-user" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="is-wmgmt-user" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="version-stamp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="location" type="{urn:com.microsoft.wc.types}Location" minOccurs="0"/>
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
    "isNewsletterSubscriber",
    "preferredCulture",
    "preferredUiculture",
    "preferredTimezone",
    "securityContact",
    "isHealthStatementSubscriber",
    "healthStatementLastSentDate",
    "isEprepUser",
    "isWmgmtUser",
    "versionStamp",
    "location"
})
public class SetPersonInfoPrivilegedRequest {

    @Element(name = "is-newsletter-subscriber")
    protected boolean isNewsletterSubscriber;
    @Element(name = "preferred-culture")
    protected Culture preferredCulture;
    @Element(name = "preferred-uiculture")
    protected Culture preferredUiculture;
    @Element(name = "preferred-timezone")
    protected Integer preferredTimezone;
    @Element(name = "security-contact")
    protected SecurityContactInfo securityContact;
    @Element(name = "is-health-statement-subscriber")
    protected Boolean isHealthStatementSubscriber;
    @Element(name = "health-statement-last-sent-date")
    protected Date healthStatementLastSentDate;
    @Element(name = "is-eprep-user")
    protected Boolean isEprepUser;
    @Element(name = "is-wmgmt-user")
    protected Boolean isWmgmtUser;
    @Element(name = "version-stamp")
    protected String versionStamp;
    protected Location location;

    /**
     * Gets the value of the isNewsletterSubscriber property.
     * 
     */
    public boolean isIsNewsletterSubscriber() {
        return isNewsletterSubscriber;
    }

    /**
     * Sets the value of the isNewsletterSubscriber property.
     * 
     */
    public void setIsNewsletterSubscriber(boolean value) {
        this.isNewsletterSubscriber = value;
    }

    /**
     * Gets the value of the preferredCulture property.
     * 
     * @return
     *     possible object is
     *     {@link Culture }
     *     
     */
    public Culture getPreferredCulture() {
        return preferredCulture;
    }

    /**
     * Sets the value of the preferredCulture property.
     * 
     * @param value
     *     allowed object is
     *     {@link Culture }
     *     
     */
    public void setPreferredCulture(Culture value) {
        this.preferredCulture = value;
    }

    /**
     * Gets the value of the preferredUiculture property.
     * 
     * @return
     *     possible object is
     *     {@link Culture }
     *     
     */
    public Culture getPreferredUiculture() {
        return preferredUiculture;
    }

    /**
     * Sets the value of the preferredUiculture property.
     * 
     * @param value
     *     allowed object is
     *     {@link Culture }
     *     
     */
    public void setPreferredUiculture(Culture value) {
        this.preferredUiculture = value;
    }

    /**
     * Gets the value of the preferredTimezone property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPreferredTimezone() {
        return preferredTimezone;
    }

    /**
     * Sets the value of the preferredTimezone property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPreferredTimezone(Integer value) {
        this.preferredTimezone = value;
    }

    /**
     * Gets the value of the securityContact property.
     * 
     * @return
     *     possible object is
     *     {@link SecurityContactInfo }
     *     
     */
    public SecurityContactInfo getSecurityContact() {
        return securityContact;
    }

    /**
     * Sets the value of the securityContact property.
     * 
     * @param value
     *     allowed object is
     *     {@link SecurityContactInfo }
     *     
     */
    public void setSecurityContact(SecurityContactInfo value) {
        this.securityContact = value;
    }

    /**
     * Gets the value of the isHealthStatementSubscriber property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsHealthStatementSubscriber() {
        return isHealthStatementSubscriber;
    }

    /**
     * Sets the value of the isHealthStatementSubscriber property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsHealthStatementSubscriber(Boolean value) {
        this.isHealthStatementSubscriber = value;
    }

    /**
     * Gets the value of the healthStatementLastSentDate property.
     * 
     * @return
     *     possible object is
     *     {@link Date }
     *     
     */
    public Date getHealthStatementLastSentDate() {
        return healthStatementLastSentDate;
    }

    /**
     * Sets the value of the healthStatementLastSentDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Date }
     *     
     */
    public void setHealthStatementLastSentDate(Date value) {
        this.healthStatementLastSentDate = value;
    }

    /**
     * Gets the value of the isEprepUser property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsEprepUser() {
        return isEprepUser;
    }

    /**
     * Sets the value of the isEprepUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsEprepUser(Boolean value) {
        this.isEprepUser = value;
    }

    /**
     * Gets the value of the isWmgmtUser property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsWmgmtUser() {
        return isWmgmtUser;
    }

    /**
     * Sets the value of the isWmgmtUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsWmgmtUser(Boolean value) {
        this.isWmgmtUser = value;
    }

    /**
     * Gets the value of the versionStamp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersionStamp() {
        return versionStamp;
    }

    /**
     * Sets the value of the versionStamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersionStamp(String value) {
        this.versionStamp = value;
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

}
