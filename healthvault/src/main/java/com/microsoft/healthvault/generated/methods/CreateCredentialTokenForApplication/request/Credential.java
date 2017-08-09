//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.08 at 12:00:41 PM PDT 
//


package com.microsoft.healthvault.generated.methods.CreateCredentialTokenForApplication.request;

import java.util.Date;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;
import com.microsoft.healthvault.generated.core.authentication.IntegratedWindowsCredential;
import com.microsoft.healthvault.generated.core.authentication.MSACredentialWithTicket;
import com.microsoft.healthvault.generated.core.authentication.UserPassCred;


/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.methods.CreateCredentialTokenForApplication" xmlns:wc-auth="urn:com.microsoft.wc.auth" xmlns:wc-types="urn:com.microsoft.wc.types"&gt;
 *                     Provides a simple credential that the platform will then
 *                     authenticate and issue a credential token for calling application.
 *                 &lt;/summary&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;remarks xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.methods.CreateCredentialTokenForApplication" xmlns:wc-auth="urn:com.microsoft.wc.auth" xmlns:wc-types="urn:com.microsoft.wc.types"&gt;
 *                     A simple credential is one that only contains enough information
 *                     to authenticate the user, and does not imply anything
 *                     about the session it will be used for.
 *                 &lt;/remarks&gt;
 * </pre>
 * 
 * 
 * <p>Java class for Credential complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Credential">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="simple-userpass" type="{urn:com.microsoft.wc.auth}UserPassCred"/>
 *           &lt;element name="integrated-windows" type="{urn:com.microsoft.wc.auth}IntegratedWindowsCredential"/>
 *           &lt;element name="msa-with-ticket" type="{urn:com.microsoft.wc.auth}MSACredentialWithTicket"/>
 *           &lt;element name="simple-encrypted" type="{urn:com.microsoft.wc.types}stringnz"/>
 *         &lt;/choice>
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
    "simpleUserpass",
    "integratedWindows",
    "msaWithTicket",
    "simpleEncrypted"
})
public class Credential {

    @Element(name = "simple-userpass")
    protected UserPassCred simpleUserpass;
    @Element(name = "integrated-windows")
    protected IntegratedWindowsCredential integratedWindows;
    @Element(name = "msa-with-ticket")
    protected MSACredentialWithTicket msaWithTicket;
    @Element(name = "simple-encrypted")
    protected String simpleEncrypted;

    /**
     * Gets the value of the simpleUserpass property.
     * 
     * @return
     *     possible object is
     *     {@link UserPassCred }
     *     
     */
    public UserPassCred getSimpleUserpass() {
        return simpleUserpass;
    }

    /**
     * Sets the value of the simpleUserpass property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserPassCred }
     *     
     */
    public void setSimpleUserpass(UserPassCred value) {
        this.simpleUserpass = value;
    }

    /**
     * Gets the value of the integratedWindows property.
     * 
     * @return
     *     possible object is
     *     {@link IntegratedWindowsCredential }
     *     
     */
    public IntegratedWindowsCredential getIntegratedWindows() {
        return integratedWindows;
    }

    /**
     * Sets the value of the integratedWindows property.
     * 
     * @param value
     *     allowed object is
     *     {@link IntegratedWindowsCredential }
     *     
     */
    public void setIntegratedWindows(IntegratedWindowsCredential value) {
        this.integratedWindows = value;
    }

    /**
     * Gets the value of the msaWithTicket property.
     * 
     * @return
     *     possible object is
     *     {@link MSACredentialWithTicket }
     *     
     */
    public MSACredentialWithTicket getMsaWithTicket() {
        return msaWithTicket;
    }

    /**
     * Sets the value of the msaWithTicket property.
     * 
     * @param value
     *     allowed object is
     *     {@link MSACredentialWithTicket }
     *     
     */
    public void setMsaWithTicket(MSACredentialWithTicket value) {
        this.msaWithTicket = value;
    }

    /**
     * Gets the value of the simpleEncrypted property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSimpleEncrypted() {
        return simpleEncrypted;
    }

    /**
     * Sets the value of the simpleEncrypted property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSimpleEncrypted(String value) {
        this.simpleEncrypted = value;
    }

}
