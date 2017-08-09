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
import com.microsoft.healthvault.generated.types.CodableValue;
import com.microsoft.healthvault.generated.types.dates.DateTime;


/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:d="urn:com.microsoft.wc.dates" xmlns:t="urn:com.microsoft.wc.thing.types" xmlns:weight="urn:com.microsoft.wc.thing.menstruation"&gt;
 *                         A single assessment of menstrual flow including heaviness and whether the menstruation is the start of a new cycle/period.
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
 *         &lt;element name="when" type="{urn:com.microsoft.wc.dates}date-time"/>
 *         &lt;element name="is-new-cycle" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="amount" type="{urn:com.microsoft.wc.thing.types}codable-value" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@Root(name="menstruation")
@Order(elements = {
    "when",
    "isNewCycle",
    "amount"
})
public class Menstruation {

    @Element(required = true)
    protected DateTime when;
    @Element(name = "is-new-cycle")
    protected Boolean isNewCycle;
    protected CodableValue amount;

    /**
     * Gets the value of the when property.
     * 
     * @return
     *     possible object is
     *     {@link DateTime }
     *     
     */
    public DateTime getWhen() {
        return when;
    }

    /**
     * Sets the value of the when property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateTime }
     *     
     */
    public void setWhen(DateTime value) {
        this.when = value;
    }

    /**
     * Gets the value of the isNewCycle property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsNewCycle() {
        return isNewCycle;
    }

    /**
     * Sets the value of the isNewCycle property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsNewCycle(Boolean value) {
        this.isNewCycle = value;
    }

    /**
     * Gets the value of the amount property.
     * 
     * @return
     *     possible object is
     *     {@link CodableValue }
     *     
     */
    public CodableValue getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     * @param value
     *     allowed object is
     *     {@link CodableValue }
     *     
     */
    public void setAmount(CodableValue value) {
        this.amount = value;
    }

}
