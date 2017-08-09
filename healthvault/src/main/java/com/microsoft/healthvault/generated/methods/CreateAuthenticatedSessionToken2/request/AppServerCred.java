//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.08 at 12:00:41 PM PDT 
//


package com.microsoft.healthvault.generated.methods.CreateAuthenticatedSessionToken2.request;

import java.util.Date;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;
import com.microsoft.healthvault.generated.types.Sig;


/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.methods.CreateAuthenticatedSessionToken2" xmlns:wc-auth="urn:com.microsoft.wc.auth" xmlns:wc-types="urn:com.microsoft.wc.types"&gt;
 *                     Application server credential that is used when an application
 *                     is identifying itself for subsequent calls to Microsoft
 *                     HealthVault.
 *                 &lt;/summary&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;remarks xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.methods.CreateAuthenticatedSessionToken2" xmlns:wc-auth="urn:com.microsoft.wc.auth" xmlns:wc-types="urn:com.microsoft.wc.types"&gt;
 *                     This credential type requires that the content element
 *                     be signed using the application's private key.
 *                 &lt;/remarks&gt;
 * </pre>
 * 
 * 
 * <p>Java class for AppServerCred complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AppServerCred">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="sig" type="{urn:com.microsoft.wc.types}Sig"/>
 *           &lt;element name="hmacSig" type="{urn:com.microsoft.wc.methods.CreateAuthenticatedSessionToken2}HmacSig"/>
 *         &lt;/choice>
 *         &lt;element name="content" type="{urn:com.microsoft.wc.methods.CreateAuthenticatedSessionToken2}AppServerCredInfo"/>
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
    "sig",
    "hmacSig",
    "content"
})
public class AppServerCred {

    protected Sig sig;
    protected HmacSig hmacSig;
    @Element(required = true)
    protected AppServerCredInfo content;

    /**
     * Gets the value of the sig property.
     * 
     * @return
     *     possible object is
     *     {@link Sig }
     *     
     */
    public Sig getSig() {
        return sig;
    }

    /**
     * Sets the value of the sig property.
     * 
     * @param value
     *     allowed object is
     *     {@link Sig }
     *     
     */
    public void setSig(Sig value) {
        this.sig = value;
    }

    /**
     * Gets the value of the hmacSig property.
     * 
     * @return
     *     possible object is
     *     {@link HmacSig }
     *     
     */
    public HmacSig getHmacSig() {
        return hmacSig;
    }

    /**
     * Sets the value of the hmacSig property.
     * 
     * @param value
     *     allowed object is
     *     {@link HmacSig }
     *     
     */
    public void setHmacSig(HmacSig value) {
        this.hmacSig = value;
    }

    /**
     * Gets the value of the content property.
     * 
     * @return
     *     possible object is
     *     {@link AppServerCredInfo }
     *     
     */
    public AppServerCredInfo getContent() {
        return content;
    }

    /**
     * Sets the value of the content property.
     * 
     * @param value
     *     allowed object is
     *     {@link AppServerCredInfo }
     *     
     */
    public void setContent(AppServerCredInfo value) {
        this.content = value;
    }

}
