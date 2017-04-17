package com.microsoft.hsg.android.simplexml.things.types.dates;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;


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
 * <p>Java class for approx-date-time complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="approx-date-time">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="structured" type="{urn:com.microsoft.wc.dates}StructuredApproxDate"/>
 *         &lt;element name="descriptive" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@Order(elements = {
    "structured",
    "descriptive"
})
public class ApproxDateTime {

    @Element(required = false)
    protected StructuredApproxDate structured;

    @Element(required = false)
    protected String descriptive;
    
    /**
     * Instantiates a new approx date time.
     */
    public ApproxDateTime() {
    }
    
    /**
     * Instantiates a new approx date time.
     * 
     * @param descriptive the descriptive
     */
    public ApproxDateTime(String descriptive)
    {
    	this.descriptive = descriptive;
    }
    
    /**
     * Instantiates a new approx date time.
     * 
     * @param structured the structured
     * @param descriptive the descriptive
     */
    public ApproxDateTime(StructuredApproxDate structured) {
    	this.structured = structured;
    }

    /**
     * Gets the value of the structured property.
     * 
     * @return
     *     possible object is
     *     {@link StructuredApproxDate }
     *     
     */
    public StructuredApproxDate getStructured() {
        return structured;
    }

    /**
     * Sets the value of the structured property.
     * 
     * @param value
     *     allowed object is
     *     {@link StructuredApproxDate }
     *     
     */
    public void setStructured(StructuredApproxDate value) {
        this.structured = value;
    }

    /**
     * Gets the value of the descriptive property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescriptive() {
        return descriptive;
    }

    /**
     * Sets the value of the descriptive property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescriptive(String value) {
        this.descriptive = value;
    }

}
