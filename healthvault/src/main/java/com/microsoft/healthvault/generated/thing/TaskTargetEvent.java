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
 *                     A filter to be performed on a collection of health measurements or activities.
 *                     This determines which items should be further evaluated for task
 *                     occurrence and completion.
 *                 &lt;/summary&gt;
 * </pre>
 * 
 * 
 * <p>Java class for task-target-event complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="task-target-event">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="element-xpath" type="{urn:com.microsoft.wc.thing.types}stringnznw"/>
 *         &lt;element name="is-negated" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="element-values" type="{urn:com.microsoft.wc.thing.task}strings" minOccurs="0"/>
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
    "elementXpath",
    "isNegated",
    "elementValues"
})
public class TaskTargetEvent {

    @Element(name = "element-xpath", required = true)
    protected String elementXpath;
    @Element(name = "is-negated")
    protected Boolean isNegated;
    @Element(name = "element-values")
    protected Strings elementValues;

    /**
     * Gets the value of the elementXpath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getElementXpath() {
        return elementXpath;
    }

    /**
     * Sets the value of the elementXpath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setElementXpath(String value) {
        this.elementXpath = value;
    }

    /**
     * Gets the value of the isNegated property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsNegated() {
        return isNegated;
    }

    /**
     * Sets the value of the isNegated property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsNegated(Boolean value) {
        this.isNegated = value;
    }

    /**
     * Gets the value of the elementValues property.
     * 
     * @return
     *     possible object is
     *     {@link Strings }
     *     
     */
    public Strings getElementValues() {
        return elementValues;
    }

    /**
     * Sets the value of the elementValues property.
     * 
     * @param value
     *     allowed object is
     *     {@link Strings }
     *     
     */
    public void setElementValues(Strings value) {
        this.elementValues = value;
    }

}
