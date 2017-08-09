//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.08 at 12:00:41 PM PDT 
//


package com.microsoft.healthvault.generated.methods.GetServiceDefinition.response;

import java.util.Date;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;
import java.util.ArrayList;
import java.util.List;


/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.methods.response.GetServiceDefinition" xmlns:wc-types="urn:com.microsoft.wc.types"&gt;
 *                         The element of the request that contains the method
 *                         specific parameters.
 *                     &lt;/summary&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;remarks xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.methods.response.GetServiceDefinition" xmlns:wc-types="urn:com.microsoft.wc.types"&gt;
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
 *         &lt;element name="platform" type="{urn:com.microsoft.wc.methods.response.GetServiceDefinition}Platform" minOccurs="0"/>
 *         &lt;element name="shell" type="{urn:com.microsoft.wc.methods.response.GetServiceDefinition}Shell" minOccurs="0"/>
 *         &lt;element name="sdk-assembly" type="{urn:com.microsoft.wc.methods.response.GetServiceDefinition}SDKAssembly" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="xml-method" type="{urn:com.microsoft.wc.methods.response.GetServiceDefinition}XmlMethod" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="common-schema" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="updated-date" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
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
    "platform",
    "shell",
    "sdkAssembly",
    "xmlMethod",
    "commonSchema",
    "updatedDate"
})
public class GetServiceDefinitionResponse {

    protected Platform platform;
    protected Shell shell;
    @Element(name = "sdk-assembly")
    protected List<SDKAssembly> sdkAssembly;
    @Element(name = "xml-method")
    protected List<XmlMethod> xmlMethod;
    @Element(name = "common-schema")
    protected List<String> commonSchema;
    @Element(name = "updated-date")
    protected Date updatedDate;

    /**
     * Gets the value of the platform property.
     * 
     * @return
     *     possible object is
     *     {@link Platform }
     *     
     */
    public Platform getPlatform() {
        return platform;
    }

    /**
     * Sets the value of the platform property.
     * 
     * @param value
     *     allowed object is
     *     {@link Platform }
     *     
     */
    public void setPlatform(Platform value) {
        this.platform = value;
    }

    /**
     * Gets the value of the shell property.
     * 
     * @return
     *     possible object is
     *     {@link Shell }
     *     
     */
    public Shell getShell() {
        return shell;
    }

    /**
     * Sets the value of the shell property.
     * 
     * @param value
     *     allowed object is
     *     {@link Shell }
     *     
     */
    public void setShell(Shell value) {
        this.shell = value;
    }

    /**
     * Gets the value of the sdkAssembly property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sdkAssembly property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSdkAssembly().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SDKAssembly }
     * 
     * 
     */
    public List<SDKAssembly> getSdkAssembly() {
        if (sdkAssembly == null) {
            sdkAssembly = new ArrayList<SDKAssembly>();
        }
        return this.sdkAssembly;
    }

    /**
     * Gets the value of the xmlMethod property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the xmlMethod property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getXmlMethod().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link XmlMethod }
     * 
     * 
     */
    public List<XmlMethod> getXmlMethod() {
        if (xmlMethod == null) {
            xmlMethod = new ArrayList<XmlMethod>();
        }
        return this.xmlMethod;
    }

    /**
     * Gets the value of the commonSchema property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the commonSchema property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCommonSchema().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getCommonSchema() {
        if (commonSchema == null) {
            commonSchema = new ArrayList<String>();
        }
        return this.commonSchema;
    }

    /**
     * Gets the value of the updatedDate property.
     * 
     * @return
     *     possible object is
     *     {@link Date }
     *     
     */
    public Date getUpdatedDate() {
        return updatedDate;
    }

    /**
     * Sets the value of the updatedDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Date }
     *     
     */
    public void setUpdatedDate(Date value) {
        this.updatedDate = value;
    }

}
