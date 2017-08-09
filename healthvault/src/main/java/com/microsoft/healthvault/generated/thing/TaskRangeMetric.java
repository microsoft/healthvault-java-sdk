//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.08 at 12:00:41 PM PDT 
//


package com.microsoft.healthvault.generated.thing;

import java.util.Date;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;


/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:d="urn:com.microsoft.wc.dates" xmlns:t="urn:com.microsoft.wc.thing.types" xmlns:this="urn:com.microsoft.wc.thing.task"&gt;
 *                     The rules that a HealthVault item must meet to count toward task occurrence.
 *                 &lt;/summary&gt;
 * </pre>
 * 
 * 
 * <p>Java class for task-range-metric complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="task-range-metric">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="property-xpath" type="{urn:com.microsoft.wc.thing.types}stringnznw"/>
 *         &lt;element name="min-target" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="max-target" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
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
    "propertyXpath",
    "minTarget",
    "maxTarget"
})
public class TaskRangeMetric {

    @Element(name = "property-xpath", required = true)
    protected String propertyXpath;
    @Element(name = "min-target")
    protected Double minTarget;
    @Element(name = "max-target")
    protected Double maxTarget;

    /**
     * Gets the value of the propertyXpath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPropertyXpath() {
        return propertyXpath;
    }

    /**
     * Sets the value of the propertyXpath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPropertyXpath(String value) {
        this.propertyXpath = value;
    }

    /**
     * Gets the value of the minTarget property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getMinTarget() {
        return minTarget;
    }

    /**
     * Sets the value of the minTarget property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setMinTarget(Double value) {
        this.minTarget = value;
    }

    /**
     * Gets the value of the maxTarget property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getMaxTarget() {
        return maxTarget;
    }

    /**
     * Sets the value of the maxTarget property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setMaxTarget(Double value) {
        this.maxTarget = value;
    }

}
