//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.08 at 12:00:41 PM PDT 
//


package com.microsoft.healthvault.generated.methods.GetThingOperator.response;

import java.util.Date;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;


/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.methods.response.GetThingOperator" xmlns:wc-types="urn:com.microsoft.wc.types"/&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;remarks xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.methods.response.GetThingOperator" xmlns:wc-types="urn:com.microsoft.wc.types"/&gt;
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
 *         &lt;element name="person-operator-infos" type="{urn:com.microsoft.wc.methods.response.GetThingOperator}PersonOperatorInfos" minOccurs="0"/>
 *         &lt;element name="application-operator-infos" type="{urn:com.microsoft.wc.methods.response.GetThingOperator}ApplicationOperatorInfos" minOccurs="0"/>
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
    "personOperatorInfos",
    "applicationOperatorInfos"
})
public class GetThingOperatorResponse {

    @Element(name = "person-operator-infos")
    protected PersonOperatorInfos personOperatorInfos;
    @Element(name = "application-operator-infos")
    protected ApplicationOperatorInfos applicationOperatorInfos;

    /**
     * Gets the value of the personOperatorInfos property.
     * 
     * @return
     *     possible object is
     *     {@link PersonOperatorInfos }
     *     
     */
    public PersonOperatorInfos getPersonOperatorInfos() {
        return personOperatorInfos;
    }

    /**
     * Sets the value of the personOperatorInfos property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonOperatorInfos }
     *     
     */
    public void setPersonOperatorInfos(PersonOperatorInfos value) {
        this.personOperatorInfos = value;
    }

    /**
     * Gets the value of the applicationOperatorInfos property.
     * 
     * @return
     *     possible object is
     *     {@link ApplicationOperatorInfos }
     *     
     */
    public ApplicationOperatorInfos getApplicationOperatorInfos() {
        return applicationOperatorInfos;
    }

    /**
     * Sets the value of the applicationOperatorInfos property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApplicationOperatorInfos }
     *     
     */
    public void setApplicationOperatorInfos(ApplicationOperatorInfos value) {
        this.applicationOperatorInfos = value;
    }

}
