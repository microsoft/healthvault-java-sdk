//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.08 at 12:00:41 PM PDT 
//


package com.microsoft.healthvault.generated.methods.CreateConnectPackage2.request;

import java.util.Date;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;
import com.microsoft.healthvault.generated.thing.Thing2;


/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.methods.CreateConnectPackage2" xmlns:wc-thing="urn:com.microsoft.wc.thing" xmlns:wc-types="urn:com.microsoft.wc.types"&gt;
 *                         The element of the request that contains the method
 *                         specific parameters.
 *                     &lt;/summary&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;remarks xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.methods.CreateConnectPackage2" xmlns:wc-thing="urn:com.microsoft.wc.thing" xmlns:wc-types="urn:com.microsoft.wc.types"&gt;
 *                         All requests contain the info element to pass parameters
 *                         that are specific to each method. If the method does not
 *                         define an info element, the method does not take any
 *                         parameters.
 *                     &lt;/remarks&gt;
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
 *         &lt;element name="identity-code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="friendly-name" type="{urn:com.microsoft.wc.types}stringnz"/>
 *         &lt;element name="question" type="{urn:com.microsoft.wc.types}stringnz"/>
 *         &lt;element name="external-id" type="{urn:com.microsoft.wc.types}stringnz"/>
 *         &lt;element name="package" type="{urn:com.microsoft.wc.thing}Thing2"/>
 *         &lt;element name="streamed-package-blobs" type="{urn:com.microsoft.wc.methods.CreateConnectPackage2}StreamedPackageBlobs" minOccurs="0"/>
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
    "identityCode",
    "friendlyName",
    "question",
    "externalId",
    "_package",
    "streamedPackageBlobs"
})
public class CreateConnectPackage2Request {

    @Element(name = "identity-code")
    protected String identityCode;
    @Element(name = "friendly-name", required = true)
    protected String friendlyName;
    @Element(required = true)
    protected String question;
    @Element(name = "external-id", required = true)
    protected String externalId;
    @Element(name = "package", required = true)
    protected Thing2 _package;
    @Element(name = "streamed-package-blobs")
    protected StreamedPackageBlobs streamedPackageBlobs;

    /**
     * Gets the value of the identityCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentityCode() {
        return identityCode;
    }

    /**
     * Sets the value of the identityCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentityCode(String value) {
        this.identityCode = value;
    }

    /**
     * Gets the value of the friendlyName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFriendlyName() {
        return friendlyName;
    }

    /**
     * Sets the value of the friendlyName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFriendlyName(String value) {
        this.friendlyName = value;
    }

    /**
     * Gets the value of the question property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Sets the value of the question property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQuestion(String value) {
        this.question = value;
    }

    /**
     * Gets the value of the externalId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExternalId() {
        return externalId;
    }

    /**
     * Sets the value of the externalId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExternalId(String value) {
        this.externalId = value;
    }

    /**
     * Gets the value of the package property.
     * 
     * @return
     *     possible object is
     *     {@link Thing2 }
     *     
     */
    public Thing2 getPackage() {
        return _package;
    }

    /**
     * Sets the value of the package property.
     * 
     * @param value
     *     allowed object is
     *     {@link Thing2 }
     *     
     */
    public void setPackage(Thing2 value) {
        this._package = value;
    }

    /**
     * Gets the value of the streamedPackageBlobs property.
     * 
     * @return
     *     possible object is
     *     {@link StreamedPackageBlobs }
     *     
     */
    public StreamedPackageBlobs getStreamedPackageBlobs() {
        return streamedPackageBlobs;
    }

    /**
     * Sets the value of the streamedPackageBlobs property.
     * 
     * @param value
     *     allowed object is
     *     {@link StreamedPackageBlobs }
     *     
     */
    public void setStreamedPackageBlobs(StreamedPackageBlobs value) {
        this.streamedPackageBlobs = value;
    }

}
