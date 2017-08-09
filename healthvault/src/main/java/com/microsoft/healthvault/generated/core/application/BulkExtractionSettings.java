//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.08 at 12:00:41 PM PDT 
//


package com.microsoft.healthvault.generated.core.application;

import java.util.Date;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;


/**
 * <p>Java class for BulkExtractionSettings complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BulkExtractionSettings">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="is-onboarded" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="is-permission-required" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "isOnboarded",
    "isPermissionRequired"
})
public class BulkExtractionSettings {

    @Element(name = "is-onboarded")
    protected boolean isOnboarded;
    @Element(name = "is-permission-required")
    protected boolean isPermissionRequired;

    /**
     * Gets the value of the isOnboarded property.
     * 
     */
    public boolean isIsOnboarded() {
        return isOnboarded;
    }

    /**
     * Sets the value of the isOnboarded property.
     * 
     */
    public void setIsOnboarded(boolean value) {
        this.isOnboarded = value;
    }

    /**
     * Gets the value of the isPermissionRequired property.
     * 
     */
    public boolean isIsPermissionRequired() {
        return isPermissionRequired;
    }

    /**
     * Sets the value of the isPermissionRequired property.
     * 
     */
    public void setIsPermissionRequired(boolean value) {
        this.isPermissionRequired = value;
    }

}
