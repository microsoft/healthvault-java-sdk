//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.08 at 12:00:41 PM PDT 
//


package com.microsoft.healthvault.generated.methods.AddApplication.request;

import java.util.Date;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;
import java.util.ArrayList;
import java.util.List;
import com.microsoft.healthvault.generated.core.application.AppLargeLogoInfo;
import com.microsoft.healthvault.generated.core.application.AppPersistentTokens;
import com.microsoft.healthvault.generated.core.application.AppSmallLogoInfo;
import com.microsoft.healthvault.generated.core.application.ApplicationAttributes;
import com.microsoft.healthvault.generated.core.application.BulkExtractionSettings;
import com.microsoft.healthvault.generated.core.application.MeaningfulUseSourcesList;
import com.microsoft.healthvault.generated.core.application.OrganizationsList;
import com.microsoft.healthvault.generated.core.application.PublicKeys;
import com.microsoft.healthvault.generated.core.application.StatementInfo;
import com.microsoft.healthvault.generated.core.authentication.AuthXml;
import com.microsoft.healthvault.generated.core.location.SupportedInstanceList;
import com.microsoft.healthvault.generated.core.location.SupportedLocationList;
import com.microsoft.healthvault.generated.types.CultureSpecificString255;
import com.microsoft.healthvault.generated.types.CultureSpecificStringnz;
import com.microsoft.healthvault.generated.vocabulary.VocabularyAuthorizations;


/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:wc-app="urn:com.microsoft.wc.application" xmlns:wc-auth="urn:com.microsoft.wc.auth" xmlns:wc-location="urn:com.microsoft.wc.location" xmlns:wc-types="urn:com.microsoft.wc.types" xmlns:wc-vocab="urn:com.microsoft.wc.vocab"&gt;
 *                         The element of the request that contains the method
 *                         specific parameters.
 *                     &lt;/summary&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;remarks xmlns="http://www.w3.org/2001/XMLSchema" xmlns:wc-app="urn:com.microsoft.wc.application" xmlns:wc-auth="urn:com.microsoft.wc.auth" xmlns:wc-location="urn:com.microsoft.wc.location" xmlns:wc-types="urn:com.microsoft.wc.types" xmlns:wc-vocab="urn:com.microsoft.wc.vocab"&gt;
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
 *         &lt;element name="name" type="{urn:com.microsoft.wc.types}CultureSpecificString255" maxOccurs="unbounded"/>
 *         &lt;element name="public-keys" type="{urn:com.microsoft.wc.application}PublicKeys"/>
 *         &lt;element name="person-online-base-auth" type="{urn:com.microsoft.wc.auth}AuthXml" minOccurs="0"/>
 *         &lt;element name="person-offline-base-auth" type="{urn:com.microsoft.wc.auth}AuthXml"/>
 *         &lt;element name="methods" type="{urn:com.microsoft.wc.types}stringnz" minOccurs="0"/>
 *         &lt;element name="action-url" type="{urn:com.microsoft.wc.types}stringnz" minOccurs="0"/>
 *         &lt;element name="description" type="{urn:com.microsoft.wc.types}CultureSpecificStringnz" maxOccurs="unbounded"/>
 *         &lt;element name="auth-reason" type="{urn:com.microsoft.wc.types}CultureSpecificStringnz" maxOccurs="unbounded"/>
 *         &lt;element name="domain-name" type="{urn:com.microsoft.wc.types}string255" minOccurs="0"/>
 *         &lt;element name="large-logo" type="{urn:com.microsoft.wc.application}AppLargeLogoInfo"/>
 *         &lt;element name="small-logo" type="{urn:com.microsoft.wc.application}AppSmallLogoInfo" minOccurs="0"/>
 *         &lt;element name="persistent-tokens" type="{urn:com.microsoft.wc.application}AppPersistentTokens" minOccurs="0"/>
 *         &lt;element name="app-type" type="{urn:com.microsoft.wc.types}stringnz" minOccurs="0"/>
 *         &lt;element name="privacy-statement" type="{urn:com.microsoft.wc.application}StatementInfo" minOccurs="0"/>
 *         &lt;element name="terms-of-use" type="{urn:com.microsoft.wc.application}StatementInfo" minOccurs="0"/>
 *         &lt;element name="app-auth-required" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="restrict-app-users" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="is-published" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="dtc-success-message" type="{urn:com.microsoft.wc.application}StatementInfo" minOccurs="0"/>
 *         &lt;element name="app-attributes" type="{urn:com.microsoft.wc.application}ApplicationAttributes" minOccurs="0"/>
 *         &lt;element name="valid-ip-prefixes" type="{urn:com.microsoft.wc.types}string255nw" minOccurs="0"/>
 *         &lt;element name="vocabulary-authorizations" type="{urn:com.microsoft.wc.vocab}VocabularyAuthorizations" minOccurs="0"/>
 *         &lt;element name="supported-record-locations" type="{urn:com.microsoft.wc.location}SupportedLocationList" minOccurs="0"/>
 *         &lt;element name="supported-instances" type="{urn:com.microsoft.wc.location}SupportedInstanceList" minOccurs="0"/>
 *         &lt;element name="meaningful-use-sources" type="{urn:com.microsoft.wc.application}MeaningfulUseSourcesList" minOccurs="0"/>
 *         &lt;element name="organizations" type="{urn:com.microsoft.wc.application}OrganizationsList" minOccurs="0"/>
 *         &lt;element name="bulk-extraction-settings" type="{urn:com.microsoft.wc.application}BulkExtractionSettings" minOccurs="0"/>
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
    "name",
    "publicKeys",
    "personOnlineBaseAuth",
    "personOfflineBaseAuth",
    "methods",
    "actionUrl",
    "description",
    "authReason",
    "domainName",
    "largeLogo",
    "smallLogo",
    "persistentTokens",
    "appType",
    "privacyStatement",
    "termsOfUse",
    "appAuthRequired",
    "restrictAppUsers",
    "isPublished",
    "dtcSuccessMessage",
    "appAttributes",
    "validIpPrefixes",
    "vocabularyAuthorizations",
    "supportedRecordLocations",
    "supportedInstances",
    "meaningfulUseSources",
    "organizations",
    "bulkExtractionSettings"
})
public class AddApplicationRequest {

    @Element(required = true)
    protected List<CultureSpecificString255> name;
    @Element(name = "public-keys", required = true)
    protected PublicKeys publicKeys;
    @Element(name = "person-online-base-auth")
    protected AuthXml personOnlineBaseAuth;
    @Element(name = "person-offline-base-auth", required = true)
    protected AuthXml personOfflineBaseAuth;
    protected String methods;
    @Element(name = "action-url")
    protected String actionUrl;
    @Element(required = true)
    protected List<CultureSpecificStringnz> description;
    @Element(name = "auth-reason", required = true)
    protected List<CultureSpecificStringnz> authReason;
    @Element(name = "domain-name")
    protected String domainName;
    @Element(name = "large-logo", required = true)
    protected AppLargeLogoInfo largeLogo;
    @Element(name = "small-logo")
    protected AppSmallLogoInfo smallLogo;
    @Element(name = "persistent-tokens")
    protected AppPersistentTokens persistentTokens;
    @Element(name = "app-type")
    protected String appType;
    @Element(name = "privacy-statement")
    protected StatementInfo privacyStatement;
    @Element(name = "terms-of-use")
    protected StatementInfo termsOfUse;
    @Element(name = "app-auth-required")
    protected Boolean appAuthRequired;
    @Element(name = "restrict-app-users")
    protected Boolean restrictAppUsers;
    @Element(name = "is-published")
    protected Boolean isPublished;
    @Element(name = "dtc-success-message")
    protected StatementInfo dtcSuccessMessage;
    @Element(name = "app-attributes")
    protected ApplicationAttributes appAttributes;
    @Element(name = "valid-ip-prefixes")
    protected String validIpPrefixes;
    @Element(name = "vocabulary-authorizations")
    protected VocabularyAuthorizations vocabularyAuthorizations;
    @Element(name = "supported-record-locations")
    protected SupportedLocationList supportedRecordLocations;
    @Element(name = "supported-instances")
    protected SupportedInstanceList supportedInstances;
    @Element(name = "meaningful-use-sources")
    protected MeaningfulUseSourcesList meaningfulUseSources;
    protected OrganizationsList organizations;
    @Element(name = "bulk-extraction-settings")
    protected BulkExtractionSettings bulkExtractionSettings;

    /**
     * Gets the value of the name property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the name property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CultureSpecificString255 }
     * 
     * 
     */
    public List<CultureSpecificString255> getName() {
        if (name == null) {
            name = new ArrayList<CultureSpecificString255>();
        }
        return this.name;
    }

    /**
     * Gets the value of the publicKeys property.
     * 
     * @return
     *     possible object is
     *     {@link PublicKeys }
     *     
     */
    public PublicKeys getPublicKeys() {
        return publicKeys;
    }

    /**
     * Sets the value of the publicKeys property.
     * 
     * @param value
     *     allowed object is
     *     {@link PublicKeys }
     *     
     */
    public void setPublicKeys(PublicKeys value) {
        this.publicKeys = value;
    }

    /**
     * Gets the value of the personOnlineBaseAuth property.
     * 
     * @return
     *     possible object is
     *     {@link AuthXml }
     *     
     */
    public AuthXml getPersonOnlineBaseAuth() {
        return personOnlineBaseAuth;
    }

    /**
     * Sets the value of the personOnlineBaseAuth property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuthXml }
     *     
     */
    public void setPersonOnlineBaseAuth(AuthXml value) {
        this.personOnlineBaseAuth = value;
    }

    /**
     * Gets the value of the personOfflineBaseAuth property.
     * 
     * @return
     *     possible object is
     *     {@link AuthXml }
     *     
     */
    public AuthXml getPersonOfflineBaseAuth() {
        return personOfflineBaseAuth;
    }

    /**
     * Sets the value of the personOfflineBaseAuth property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuthXml }
     *     
     */
    public void setPersonOfflineBaseAuth(AuthXml value) {
        this.personOfflineBaseAuth = value;
    }

    /**
     * Gets the value of the methods property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMethods() {
        return methods;
    }

    /**
     * Sets the value of the methods property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMethods(String value) {
        this.methods = value;
    }

    /**
     * Gets the value of the actionUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActionUrl() {
        return actionUrl;
    }

    /**
     * Sets the value of the actionUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActionUrl(String value) {
        this.actionUrl = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the description property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDescription().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CultureSpecificStringnz }
     * 
     * 
     */
    public List<CultureSpecificStringnz> getDescription() {
        if (description == null) {
            description = new ArrayList<CultureSpecificStringnz>();
        }
        return this.description;
    }

    /**
     * Gets the value of the authReason property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the authReason property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAuthReason().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CultureSpecificStringnz }
     * 
     * 
     */
    public List<CultureSpecificStringnz> getAuthReason() {
        if (authReason == null) {
            authReason = new ArrayList<CultureSpecificStringnz>();
        }
        return this.authReason;
    }

    /**
     * Gets the value of the domainName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDomainName() {
        return domainName;
    }

    /**
     * Sets the value of the domainName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDomainName(String value) {
        this.domainName = value;
    }

    /**
     * Gets the value of the largeLogo property.
     * 
     * @return
     *     possible object is
     *     {@link AppLargeLogoInfo }
     *     
     */
    public AppLargeLogoInfo getLargeLogo() {
        return largeLogo;
    }

    /**
     * Sets the value of the largeLogo property.
     * 
     * @param value
     *     allowed object is
     *     {@link AppLargeLogoInfo }
     *     
     */
    public void setLargeLogo(AppLargeLogoInfo value) {
        this.largeLogo = value;
    }

    /**
     * Gets the value of the smallLogo property.
     * 
     * @return
     *     possible object is
     *     {@link AppSmallLogoInfo }
     *     
     */
    public AppSmallLogoInfo getSmallLogo() {
        return smallLogo;
    }

    /**
     * Sets the value of the smallLogo property.
     * 
     * @param value
     *     allowed object is
     *     {@link AppSmallLogoInfo }
     *     
     */
    public void setSmallLogo(AppSmallLogoInfo value) {
        this.smallLogo = value;
    }

    /**
     * Gets the value of the persistentTokens property.
     * 
     * @return
     *     possible object is
     *     {@link AppPersistentTokens }
     *     
     */
    public AppPersistentTokens getPersistentTokens() {
        return persistentTokens;
    }

    /**
     * Sets the value of the persistentTokens property.
     * 
     * @param value
     *     allowed object is
     *     {@link AppPersistentTokens }
     *     
     */
    public void setPersistentTokens(AppPersistentTokens value) {
        this.persistentTokens = value;
    }

    /**
     * Gets the value of the appType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppType() {
        return appType;
    }

    /**
     * Sets the value of the appType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppType(String value) {
        this.appType = value;
    }

    /**
     * Gets the value of the privacyStatement property.
     * 
     * @return
     *     possible object is
     *     {@link StatementInfo }
     *     
     */
    public StatementInfo getPrivacyStatement() {
        return privacyStatement;
    }

    /**
     * Sets the value of the privacyStatement property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatementInfo }
     *     
     */
    public void setPrivacyStatement(StatementInfo value) {
        this.privacyStatement = value;
    }

    /**
     * Gets the value of the termsOfUse property.
     * 
     * @return
     *     possible object is
     *     {@link StatementInfo }
     *     
     */
    public StatementInfo getTermsOfUse() {
        return termsOfUse;
    }

    /**
     * Sets the value of the termsOfUse property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatementInfo }
     *     
     */
    public void setTermsOfUse(StatementInfo value) {
        this.termsOfUse = value;
    }

    /**
     * Gets the value of the appAuthRequired property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAppAuthRequired() {
        return appAuthRequired;
    }

    /**
     * Sets the value of the appAuthRequired property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAppAuthRequired(Boolean value) {
        this.appAuthRequired = value;
    }

    /**
     * Gets the value of the restrictAppUsers property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRestrictAppUsers() {
        return restrictAppUsers;
    }

    /**
     * Sets the value of the restrictAppUsers property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRestrictAppUsers(Boolean value) {
        this.restrictAppUsers = value;
    }

    /**
     * Gets the value of the isPublished property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsPublished() {
        return isPublished;
    }

    /**
     * Sets the value of the isPublished property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsPublished(Boolean value) {
        this.isPublished = value;
    }

    /**
     * Gets the value of the dtcSuccessMessage property.
     * 
     * @return
     *     possible object is
     *     {@link StatementInfo }
     *     
     */
    public StatementInfo getDtcSuccessMessage() {
        return dtcSuccessMessage;
    }

    /**
     * Sets the value of the dtcSuccessMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatementInfo }
     *     
     */
    public void setDtcSuccessMessage(StatementInfo value) {
        this.dtcSuccessMessage = value;
    }

    /**
     * Gets the value of the appAttributes property.
     * 
     * @return
     *     possible object is
     *     {@link ApplicationAttributes }
     *     
     */
    public ApplicationAttributes getAppAttributes() {
        return appAttributes;
    }

    /**
     * Sets the value of the appAttributes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApplicationAttributes }
     *     
     */
    public void setAppAttributes(ApplicationAttributes value) {
        this.appAttributes = value;
    }

    /**
     * Gets the value of the validIpPrefixes property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValidIpPrefixes() {
        return validIpPrefixes;
    }

    /**
     * Sets the value of the validIpPrefixes property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValidIpPrefixes(String value) {
        this.validIpPrefixes = value;
    }

    /**
     * Gets the value of the vocabularyAuthorizations property.
     * 
     * @return
     *     possible object is
     *     {@link VocabularyAuthorizations }
     *     
     */
    public VocabularyAuthorizations getVocabularyAuthorizations() {
        return vocabularyAuthorizations;
    }

    /**
     * Sets the value of the vocabularyAuthorizations property.
     * 
     * @param value
     *     allowed object is
     *     {@link VocabularyAuthorizations }
     *     
     */
    public void setVocabularyAuthorizations(VocabularyAuthorizations value) {
        this.vocabularyAuthorizations = value;
    }

    /**
     * Gets the value of the supportedRecordLocations property.
     * 
     * @return
     *     possible object is
     *     {@link SupportedLocationList }
     *     
     */
    public SupportedLocationList getSupportedRecordLocations() {
        return supportedRecordLocations;
    }

    /**
     * Sets the value of the supportedRecordLocations property.
     * 
     * @param value
     *     allowed object is
     *     {@link SupportedLocationList }
     *     
     */
    public void setSupportedRecordLocations(SupportedLocationList value) {
        this.supportedRecordLocations = value;
    }

    /**
     * Gets the value of the supportedInstances property.
     * 
     * @return
     *     possible object is
     *     {@link SupportedInstanceList }
     *     
     */
    public SupportedInstanceList getSupportedInstances() {
        return supportedInstances;
    }

    /**
     * Sets the value of the supportedInstances property.
     * 
     * @param value
     *     allowed object is
     *     {@link SupportedInstanceList }
     *     
     */
    public void setSupportedInstances(SupportedInstanceList value) {
        this.supportedInstances = value;
    }

    /**
     * Gets the value of the meaningfulUseSources property.
     * 
     * @return
     *     possible object is
     *     {@link MeaningfulUseSourcesList }
     *     
     */
    public MeaningfulUseSourcesList getMeaningfulUseSources() {
        return meaningfulUseSources;
    }

    /**
     * Sets the value of the meaningfulUseSources property.
     * 
     * @param value
     *     allowed object is
     *     {@link MeaningfulUseSourcesList }
     *     
     */
    public void setMeaningfulUseSources(MeaningfulUseSourcesList value) {
        this.meaningfulUseSources = value;
    }

    /**
     * Gets the value of the organizations property.
     * 
     * @return
     *     possible object is
     *     {@link OrganizationsList }
     *     
     */
    public OrganizationsList getOrganizations() {
        return organizations;
    }

    /**
     * Sets the value of the organizations property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrganizationsList }
     *     
     */
    public void setOrganizations(OrganizationsList value) {
        this.organizations = value;
    }

    /**
     * Gets the value of the bulkExtractionSettings property.
     * 
     * @return
     *     possible object is
     *     {@link BulkExtractionSettings }
     *     
     */
    public BulkExtractionSettings getBulkExtractionSettings() {
        return bulkExtractionSettings;
    }

    /**
     * Sets the value of the bulkExtractionSettings property.
     * 
     * @param value
     *     allowed object is
     *     {@link BulkExtractionSettings }
     *     
     */
    public void setBulkExtractionSettings(BulkExtractionSettings value) {
        this.bulkExtractionSettings = value;
    }

}
