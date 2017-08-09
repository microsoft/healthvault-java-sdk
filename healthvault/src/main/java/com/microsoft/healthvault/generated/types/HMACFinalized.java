//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.08 at 12:00:41 PM PDT 
//


package com.microsoft.healthvault.generated.types;

import java.util.Date;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;


/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.types"&gt;
 *                     Digest from a HMAC operation that is used to provide both
 *                     authentication and integrity verification for requests.
 *                 &lt;/summary&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;remarks xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.types"&gt;
 *                     This is the result of an HMAC operation, as opposed to
 *                     HMAC algorithm which specifies the properties of the
 *                     operation.  The HMAC key is the shared secret provided in
 *                     the original application request to create an authenticated
 *                     session token.
 *                 &lt;/remarks&gt;
 * </pre>
 * 
 * 
 * <p>Java class for HMACFinalized complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HMACFinalized">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="hmac-data" type="{urn:com.microsoft.wc.types}HMACFinalizedData"/>
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
    "hmacData"
})
public class HMACFinalized {

    @Element(name = "hmac-data", required = true)
    protected HMACFinalizedData hmacData;

    /**
     * Gets the value of the hmacData property.
     * 
     * @return
     *     possible object is
     *     {@link HMACFinalizedData }
     *     
     */
    public HMACFinalizedData getHmacData() {
        return hmacData;
    }

    /**
     * Sets the value of the hmacData property.
     * 
     * @param value
     *     allowed object is
     *     {@link HMACFinalizedData }
     *     
     */
    public void setHmacData(HMACFinalizedData value) {
        this.hmacData = value;
    }

}
