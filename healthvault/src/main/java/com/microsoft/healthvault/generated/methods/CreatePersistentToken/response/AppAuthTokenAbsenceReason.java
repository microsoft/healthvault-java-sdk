//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.08 at 12:00:41 PM PDT 
//


package com.microsoft.healthvault.generated.methods.CreatePersistentToken.response;

import java.util.Date;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;


/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.methods.response.CreatePersistentToken" xmlns:wc-auth="urn:com.microsoft.wc.auth" xmlns:wc-types="urn:com.microsoft.wc.types"&gt;
 *                     Reasons why a persistent token was not returned.
 *                 &lt;/summary&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;remarks xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.methods.response.CreatePersistentToken" xmlns:wc-auth="urn:com.microsoft.wc.auth" xmlns:wc-types="urn:com.microsoft.wc.types"&gt;
 *                     Depending upon the reason, there may be user-actionable
 *                     events that would enable the request to succeed.
 *                 &lt;/remarks&gt;
 * </pre>
 * 
 * 
 * <p>Java class for AppAuthTokenAbsenceReason complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AppAuthTokenAbsenceReason">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;urn:com.microsoft.wc.methods.response.CreatePersistentToken>AuthTokenAbsenceReason">
 *       &lt;attribute name="app-id" use="required" type="{urn:com.microsoft.wc.types}guid" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@Root(name="")
@Order(elements = {
    "value"
})
public class AppAuthTokenAbsenceReason {

    protected AuthTokenAbsenceReason value;
    @Element(name = "app-id", required = true)
    protected String appId;

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.methods.response.CreatePersistentToken" xmlns:wc-auth="urn:com.microsoft.wc.auth" xmlns:wc-types="urn:com.microsoft.wc.types"&gt;
     *                     Reasons why a persistent token was not returned.
     *                 &lt;/summary&gt;
     * </pre>
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;remarks xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.methods.response.CreatePersistentToken" xmlns:wc-auth="urn:com.microsoft.wc.auth" xmlns:wc-types="urn:com.microsoft.wc.types"&gt;
     *                     Depending upon the reason, there may be user-actionable
     *                     events that would enable the request to succeed.
     *                 &lt;/remarks&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link AuthTokenAbsenceReason }
     *     
     */
    public AuthTokenAbsenceReason getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuthTokenAbsenceReason }
     *     
     */
    public void setValue(AuthTokenAbsenceReason value) {
        this.value = value;
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

}
