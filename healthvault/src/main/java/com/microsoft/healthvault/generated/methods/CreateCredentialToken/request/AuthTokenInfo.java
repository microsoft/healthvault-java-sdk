//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.08 at 12:00:41 PM PDT 
//


package com.microsoft.healthvault.generated.methods.CreateCredentialToken.request;

import java.util.Date;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;
import java.util.ArrayList;
import java.util.List;
import com.microsoft.healthvault.generated.types.AppInfo;


/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.methods.CreateCredentialToken" xmlns:wc-auth="urn:com.microsoft.wc.auth" xmlns:wc-types="urn:com.microsoft.wc.types"&gt;
 *                     Enables a caller to specify which applications to create
 *                     credential tokens for and the authenticating credential
 *                     itself.
 *                 &lt;/summary&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;remarks xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.methods.CreateCredentialToken" xmlns:wc-auth="urn:com.microsoft.wc.auth" xmlns:wc-types="urn:com.microsoft.wc.types"&gt;
 *                     Multiple applications can specified for a single credential.
 *                 &lt;/remarks&gt;
 * </pre>
 * 
 * 
 * <p>Java class for AuthTokenInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AuthTokenInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="app-id" type="{urn:com.microsoft.wc.types}AppInfo" maxOccurs="2"/>
 *         &lt;element name="credential" type="{urn:com.microsoft.wc.methods.CreateCredentialToken}Credential"/>
 *         &lt;element name="sts-info" type="{urn:com.microsoft.wc.methods.CreateCredentialToken}STSInfo" minOccurs="0"/>
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
    "appId",
    "credential",
    "stsInfo"
})
public class AuthTokenInfo {

    @Element(name = "app-id", required = true)
    protected List<AppInfo> appId;
    @Element(required = true)
    protected Credential credential;
    @Element(name = "sts-info")
    protected STSInfo stsInfo;

    /**
     * Gets the value of the appId property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the appId property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAppId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AppInfo }
     * 
     * 
     */
    public List<AppInfo> getAppId() {
        if (appId == null) {
            appId = new ArrayList<AppInfo>();
        }
        return this.appId;
    }

    /**
     * Gets the value of the credential property.
     * 
     * @return
     *     possible object is
     *     {@link Credential }
     *     
     */
    public Credential getCredential() {
        return credential;
    }

    /**
     * Sets the value of the credential property.
     * 
     * @param value
     *     allowed object is
     *     {@link Credential }
     *     
     */
    public void setCredential(Credential value) {
        this.credential = value;
    }

    /**
     * Gets the value of the stsInfo property.
     * 
     * @return
     *     possible object is
     *     {@link STSInfo }
     *     
     */
    public STSInfo getStsInfo() {
        return stsInfo;
    }

    /**
     * Sets the value of the stsInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link STSInfo }
     *     
     */
    public void setStsInfo(STSInfo value) {
        this.stsInfo = value;
    }

}
