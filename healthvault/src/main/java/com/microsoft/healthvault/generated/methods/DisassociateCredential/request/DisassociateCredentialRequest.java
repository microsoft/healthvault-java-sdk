//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.08 at 12:00:41 PM PDT 
//


package com.microsoft.healthvault.generated.methods.DisassociateCredential.request;

import java.util.Date;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;
import com.microsoft.healthvault.generated.core.authentication.SamlCredentialWithKey;
import com.microsoft.healthvault.generated.core.authentication.SimpleEmergencyAccessCredential;
import com.microsoft.healthvault.generated.core.authentication.SimpleFacebookCredential;
import com.microsoft.healthvault.generated.core.authentication.SimpleOpenIdCredential;
import com.microsoft.healthvault.generated.core.authentication.SimplePassportCredential;
import com.microsoft.healthvault.generated.core.authentication.SimplePhoneFactorCredential;
import com.microsoft.healthvault.generated.core.authentication.UserPassCred;


/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:wc-auth="urn:com.microsoft.wc.auth" xmlns:wc-types="urn:com.microsoft.wc.types"&gt;
 *                         A credential to delete from the account.
 *                     &lt;/summary&gt;
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
 *         &lt;choice>
 *           &lt;element name="simple-userpass" type="{urn:com.microsoft.wc.auth}UserPassCred"/>
 *           &lt;element name="simple-passport" type="{urn:com.microsoft.wc.auth}SimplePassportCredential"/>
 *           &lt;element name="simple-openid" type="{urn:com.microsoft.wc.auth}SimpleOpenIdCredential"/>
 *           &lt;element name="simple-facebook" type="{urn:com.microsoft.wc.auth}SimpleFacebookCredential"/>
 *           &lt;element name="simple-emergency-access" type="{urn:com.microsoft.wc.auth}SimpleEmergencyAccessCredential"/>
 *           &lt;element name="simple-phone-factor" type="{urn:com.microsoft.wc.auth}SimplePhoneFactorCredential"/>
 *           &lt;element name="saml" type="{urn:com.microsoft.wc.auth}SamlCredentialWithKey"/>
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
    "simplePassport",
    "simpleOpenid",
    "simpleFacebook",
    "simpleEmergencyAccess",
    "simplePhoneFactor",
    "saml"
})
public class DisassociateCredentialRequest {

    @Element(name = "simple-userpass")
    protected UserPassCred simpleUserpass;
    @Element(name = "simple-passport")
    protected SimplePassportCredential simplePassport;
    @Element(name = "simple-openid")
    protected SimpleOpenIdCredential simpleOpenid;
    @Element(name = "simple-facebook")
    protected SimpleFacebookCredential simpleFacebook;
    @Element(name = "simple-emergency-access")
    protected SimpleEmergencyAccessCredential simpleEmergencyAccess;
    @Element(name = "simple-phone-factor")
    protected SimplePhoneFactorCredential simplePhoneFactor;
    protected SamlCredentialWithKey saml;

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

    /**
     * Gets the value of the simpleOpenid property.
     * 
     * @return
     *     possible object is
     *     {@link SimpleOpenIdCredential }
     *     
     */
    public SimpleOpenIdCredential getSimpleOpenid() {
        return simpleOpenid;
    }

    /**
     * Sets the value of the simpleOpenid property.
     * 
     * @param value
     *     allowed object is
     *     {@link SimpleOpenIdCredential }
     *     
     */
    public void setSimpleOpenid(SimpleOpenIdCredential value) {
        this.simpleOpenid = value;
    }

    /**
     * Gets the value of the simpleFacebook property.
     * 
     * @return
     *     possible object is
     *     {@link SimpleFacebookCredential }
     *     
     */
    public SimpleFacebookCredential getSimpleFacebook() {
        return simpleFacebook;
    }

    /**
     * Sets the value of the simpleFacebook property.
     * 
     * @param value
     *     allowed object is
     *     {@link SimpleFacebookCredential }
     *     
     */
    public void setSimpleFacebook(SimpleFacebookCredential value) {
        this.simpleFacebook = value;
    }

    /**
     * Gets the value of the simpleEmergencyAccess property.
     * 
     * @return
     *     possible object is
     *     {@link SimpleEmergencyAccessCredential }
     *     
     */
    public SimpleEmergencyAccessCredential getSimpleEmergencyAccess() {
        return simpleEmergencyAccess;
    }

    /**
     * Sets the value of the simpleEmergencyAccess property.
     * 
     * @param value
     *     allowed object is
     *     {@link SimpleEmergencyAccessCredential }
     *     
     */
    public void setSimpleEmergencyAccess(SimpleEmergencyAccessCredential value) {
        this.simpleEmergencyAccess = value;
    }

    /**
     * Gets the value of the simplePhoneFactor property.
     * 
     * @return
     *     possible object is
     *     {@link SimplePhoneFactorCredential }
     *     
     */
    public SimplePhoneFactorCredential getSimplePhoneFactor() {
        return simplePhoneFactor;
    }

    /**
     * Sets the value of the simplePhoneFactor property.
     * 
     * @param value
     *     allowed object is
     *     {@link SimplePhoneFactorCredential }
     *     
     */
    public void setSimplePhoneFactor(SimplePhoneFactorCredential value) {
        this.simplePhoneFactor = value;
    }

    /**
     * Gets the value of the saml property.
     * 
     * @return
     *     possible object is
     *     {@link SamlCredentialWithKey }
     *     
     */
    public SamlCredentialWithKey getSaml() {
        return saml;
    }

    /**
     * Sets the value of the saml property.
     * 
     * @param value
     *     allowed object is
     *     {@link SamlCredentialWithKey }
     *     
     */
    public void setSaml(SamlCredentialWithKey value) {
        this.saml = value;
    }

}
