//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.08 at 12:00:41 PM PDT 
//


package com.microsoft.healthvault.generated.core.request;

import java.util.Date;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;
import java.math.BigInteger;
import com.microsoft.healthvault.generated.types.HashFinalized;


/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.request" xmlns:wc-types="urn:com.microsoft.wc.types"/&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;remarks xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.request" xmlns:wc-types="urn:com.microsoft.wc.types"/&gt;
 * </pre>
 * 
 * 
 * <p>Java class for Header complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Header">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="method" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="method-version" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="target-person-id" type="{urn:com.microsoft.wc.types}guid" minOccurs="0"/>
 *         &lt;element name="record-id" type="{urn:com.microsoft.wc.types}guid" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;element name="app-id" type="{urn:com.microsoft.wc.types}guid"/>
 *           &lt;element name="auth-session" type="{urn:com.microsoft.wc.request}AuthenticatedSessionInfo"/>
 *         &lt;/choice>
 *         &lt;choice minOccurs="0">
 *           &lt;sequence>
 *             &lt;element name="language" type="{urn:com.microsoft.wc.types}stringnwz64" minOccurs="0"/>
 *             &lt;element name="country" type="{urn:com.microsoft.wc.types}stringnwz64" minOccurs="0"/>
 *           &lt;/sequence>
 *           &lt;element name="culture-code" type="{urn:com.microsoft.wc.types}stringnwz64" minOccurs="0"/>
 *         &lt;/choice>
 *         &lt;element name="final-xsl" type="{urn:com.microsoft.wc.request}Xsl" minOccurs="0"/>
 *         &lt;element name="msg-time" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="msg-ttl" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element name="version" type="{urn:com.microsoft.wc.types}stringnz"/>
 *         &lt;element name="info-hash" type="{urn:com.microsoft.wc.types}HashFinalized" minOccurs="0"/>
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
    "method",
    "methodVersion",
    "targetPersonId",
    "recordId",
    "appId",
    "authSession",
    "language",
    "country",
    "cultureCode",
    "finalXsl",
    "msgTime",
    "msgTtl",
    "version",
    "infoHash"
})
public class Header {

    @Element(required = true)
    protected String method;
    @Element(name = "method-version")
    protected int methodVersion;
    @Element(name = "target-person-id")
    protected String targetPersonId;
    @Element(name = "record-id")
    protected String recordId;
    @Element(name = "app-id")
    protected String appId;
    @Element(name = "auth-session")
    protected AuthenticatedSessionInfo authSession;
    protected String language;
    protected String country;
    @Element(name = "culture-code")
    protected String cultureCode;
    @Element(name = "final-xsl")
    protected Xsl finalXsl;
    @Element(name = "msg-time", required = true)
    protected Date msgTime;
    @Element(name = "msg-ttl", required = true)
    protected BigInteger msgTtl;
    @Element(required = true)
    protected String version;
    @Element(name = "info-hash")
    protected HashFinalized infoHash;

    /**
     * Gets the value of the method property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMethod() {
        return method;
    }

    /**
     * Sets the value of the method property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMethod(String value) {
        this.method = value;
    }

    /**
     * Gets the value of the methodVersion property.
     * 
     */
    public int getMethodVersion() {
        return methodVersion;
    }

    /**
     * Sets the value of the methodVersion property.
     * 
     */
    public void setMethodVersion(int value) {
        this.methodVersion = value;
    }

    /**
     * Gets the value of the targetPersonId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTargetPersonId() {
        return targetPersonId;
    }

    /**
     * Sets the value of the targetPersonId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTargetPersonId(String value) {
        this.targetPersonId = value;
    }

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
     * Gets the value of the appId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppId() {
        return appId;
    }

    /**
     * Sets the value of the appId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppId(String value) {
        this.appId = value;
    }

    /**
     * Gets the value of the authSession property.
     * 
     * @return
     *     possible object is
     *     {@link AuthenticatedSessionInfo }
     *     
     */
    public AuthenticatedSessionInfo getAuthSession() {
        return authSession;
    }

    /**
     * Sets the value of the authSession property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuthenticatedSessionInfo }
     *     
     */
    public void setAuthSession(AuthenticatedSessionInfo value) {
        this.authSession = value;
    }

    /**
     * Gets the value of the language property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets the value of the language property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguage(String value) {
        this.language = value;
    }

    /**
     * Gets the value of the country property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the value of the country property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountry(String value) {
        this.country = value;
    }

    /**
     * Gets the value of the cultureCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCultureCode() {
        return cultureCode;
    }

    /**
     * Sets the value of the cultureCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCultureCode(String value) {
        this.cultureCode = value;
    }

    /**
     * Gets the value of the finalXsl property.
     * 
     * @return
     *     possible object is
     *     {@link Xsl }
     *     
     */
    public Xsl getFinalXsl() {
        return finalXsl;
    }

    /**
     * Sets the value of the finalXsl property.
     * 
     * @param value
     *     allowed object is
     *     {@link Xsl }
     *     
     */
    public void setFinalXsl(Xsl value) {
        this.finalXsl = value;
    }

    /**
     * Gets the value of the msgTime property.
     * 
     * @return
     *     possible object is
     *     {@link Date }
     *     
     */
    public Date getMsgTime() {
        return msgTime;
    }

    /**
     * Sets the value of the msgTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link Date }
     *     
     */
    public void setMsgTime(Date value) {
        this.msgTime = value;
    }

    /**
     * Gets the value of the msgTtl property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMsgTtl() {
        return msgTtl;
    }

    /**
     * Sets the value of the msgTtl property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMsgTtl(BigInteger value) {
        this.msgTtl = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Gets the value of the infoHash property.
     * 
     * @return
     *     possible object is
     *     {@link HashFinalized }
     *     
     */
    public HashFinalized getInfoHash() {
        return infoHash;
    }

    /**
     * Sets the value of the infoHash property.
     * 
     * @param value
     *     allowed object is
     *     {@link HashFinalized }
     *     
     */
    public void setInfoHash(HashFinalized value) {
        this.infoHash = value;
    }

}
