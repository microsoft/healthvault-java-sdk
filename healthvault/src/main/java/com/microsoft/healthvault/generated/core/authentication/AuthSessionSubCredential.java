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
 *                     Defines the possible subcredentials that can be used with
 *                     an AuthSessionCredential.
 *                 &lt;/summary&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;remarks xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.auth" xmlns:wc-thing="urn:com.microsoft.wc.thing" xmlns:wc-types="urn:com.microsoft.wc.types"&gt;
 *                     This credential envelopes other credentials.  None of the 
 *                     contained credentials themselves contain other 
 *                     credentials, avoiding recursion.
 *                 &lt;/remarks&gt;
 * </pre>
 * 
 * 
 * <p>Java class for AuthSessionSubCredential complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AuthSessionSubCredential">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="simple-passport" type="{urn:com.microsoft.wc.auth}SimplePassportCredential"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@Root(name="")
@Order(elements = {
    "simplePassport"
})
public class AuthSessionSubCredential {

    @Element(name = "simple-passport")
    protected SimplePassportCredential simplePassport;

    /**
     * Gets the value of the simplePassport property.
     * 
     * @return
     *     possible object is
     *     {@link SimplePassportCredential }
     *     
     */
    public SimplePassportCredential getSimplePassport() {
        return simplePassport;
    }

    /**
     * Sets the value of the simplePassport property.
     * 
     * @param value
     *     allowed object is
     *     {@link SimplePassportCredential }
     *     
     */
    public void setSimplePassport(SimplePassportCredential value) {
        this.simplePassport = value;
    }

}
