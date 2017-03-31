package com.microsoft.hsg.android.simplexml.things.types.dates;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;

import com.microsoft.hsg.android.simplexml.things.types.base.CodableValue;

/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:t="urn:com.microsoft.wc.types" xmlns:this="urn:com.microsoft.wc.dates"/&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;remarks xmlns="http://www.w3.org/2001/XMLSchema" xmlns:t="urn:com.microsoft.wc.types" xmlns:this="urn:com.microsoft.wc.dates"/&gt;
 * </pre>
 * 
 * 
 * <p>Java class for StructuredApproxDate complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StructuredApproxDate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="date" type="{urn:com.microsoft.wc.dates}approx-date"/>
 *         &lt;element name="time" type="{urn:com.microsoft.wc.dates}time" minOccurs="0"/>
 *         &lt;element name="tz" type="{urn:com.microsoft.wc.types}codable-value" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@Order(elements = {
    "date",
    "time",
    "tz"
})
public class StructuredApproxDate {

    @Element(required = true)
    protected ApproxDate date;

    @Element(required = false)
    protected Time time;

    @Element(required = false)
    protected CodableValue tz;

    /**
     * Instantiates a new structured approx date.
     */
    public StructuredApproxDate()
    {
    }
    
    /**
     * Instantiates a new structured approx date.
     * 
     * @param date the date
     */
    public StructuredApproxDate(ApproxDate date)
    {
    	this.date = date;
    }
    
    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link ApproxDate }
     *     
     */
    public ApproxDate getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApproxDate }
     *     
     */
    public void setDate(ApproxDate value) {
        this.date = value;
    }

    /**
     * Gets the value of the time property.
     * 
     * @return
     *     possible object is
     *     {@link Time }
     *     
     */
    public Time getTime() {
        return time;
    }

    /**
     * Sets the value of the time property.
     * 
     * @param value
     *     allowed object is
     *     {@link Time }
     *     
     */
    public void setTime(Time value) {
        this.time = value;
    }

    /**
     * Gets the value of the tz property.
     * 
     * @return
     *     possible object is
     *     {@link CodableValue }
     *     
     */
    public CodableValue getTz() {
        return tz;
    }

    /**
     * Sets the value of the tz property.
     * 
     * @param value
     *     allowed object is
     *     {@link CodableValue }
     *     
     */
    public void setTz(CodableValue value) {
        this.tz = value;
    }

}
