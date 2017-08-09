//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.08 at 12:00:41 PM PDT 
//


package com.microsoft.healthvault.generated.core.authentication;

import java.util.Date;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;


/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.auth" xmlns:wc-thing="urn:com.microsoft.wc.thing" xmlns:wc-types="urn:com.microsoft.wc.types"&gt;
 *                     Represents the confirmed identification of a user who
 *                     has been authenticated to the Passport service.
 *                 &lt;/summary&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;remarks xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.auth" xmlns:wc-thing="urn:com.microsoft.wc.thing" xmlns:wc-types="urn:com.microsoft.wc.types"&gt;
 *                     Authentication to Passport is done through the Shell which
 *                     extracts the user's PUID from the ticket and passes it to
 *                     the platform for verification against a HealthVault account.
 *                 &lt;/remarks&gt;
 * </pre>
 * 
 * 
 * <p>Java class for SimplePassportCredential complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SimplePassportCredential">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="puid" type="{urn:com.microsoft.wc.types}puid"/>
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
    "puid"
})
public class SimplePassportCredential {

    @Element(required = true)
    protected String puid;

    /**
     * Gets the value of the puid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPuid() {
        return puid;
    }

    /**
     * Sets the value of the puid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPuid(String value) {
        this.puid = value;
    }

}
