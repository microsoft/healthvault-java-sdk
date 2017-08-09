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
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:t="urn:com.microsoft.wc.thing.types" xmlns:this="urn:com.microsoft.wc.thing.plan"&gt;
 *                         The action plan.
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
 *         &lt;element name="name" type="{urn:com.microsoft.wc.thing.types}stringnznw"/>
 *         &lt;element name="description" type="{urn:com.microsoft.wc.thing.types}stringnznw" minOccurs="0"/>
 *         &lt;element name="status" type="{urn:com.microsoft.wc.thing.plan}plan-status"/>
 *         &lt;element name="category" type="{urn:com.microsoft.wc.thing.plan}plan-category"/>
 *         &lt;element name="objectives" type="{urn:com.microsoft.wc.thing.plan}plan-objective-list"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@Root(name="plan")
@Order(elements = {
    "name",
    "description",
    "status",
    "category",
    "objectives"
})
public class Plan {

    @Element(required = true)
    protected String name;
    protected String description;
    @Element(required = true)
    protected PlanStatus status;
    @Element(required = true)
    protected PlanCategory category;
    @Element(required = true)
    protected PlanObjectiveList objectives;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link PlanStatus }
     *     
     */
    public PlanStatus getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link PlanStatus }
     *     
     */
    public void setStatus(PlanStatus value) {
        this.status = value;
    }

    /**
     * Gets the value of the category property.
     * 
     * @return
     *     possible object is
     *     {@link PlanCategory }
     *     
     */
    public PlanCategory getCategory() {
        return category;
    }

    /**
     * Sets the value of the category property.
     * 
     * @param value
     *     allowed object is
     *     {@link PlanCategory }
     *     
     */
    public void setCategory(PlanCategory value) {
        this.category = value;
    }

    /**
     * Gets the value of the objectives property.
     * 
     * @return
     *     possible object is
     *     {@link PlanObjectiveList }
     *     
     */
    public PlanObjectiveList getObjectives() {
        return objectives;
    }

    /**
     * Sets the value of the objectives property.
     * 
     * @param value
     *     allowed object is
     *     {@link PlanObjectiveList }
     *     
     */
    public void setObjectives(PlanObjectiveList value) {
        this.objectives = value;
    }

}
