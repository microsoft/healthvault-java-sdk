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
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:a="urn:com.microsoft.wc.thing.aerobic-profile" xmlns:d="urn:com.microsoft.wc.dates" xmlns:t="urn:com.microsoft.wc.thing.types"&gt;
 *                     The maximum capacity of person to transport and 
 *                     utilize oxygen during incremental exercise.
 *                 &lt;/summary&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;remarks xmlns="http://www.w3.org/2001/XMLSchema" xmlns:a="urn:com.microsoft.wc.thing.aerobic-profile" xmlns:d="urn:com.microsoft.wc.dates" xmlns:t="urn:com.microsoft.wc.thing.types"&gt;
 *                     VO2 max can be measured as either an absolute
 *                     amount of oxygen utilized, or as an amount
 *                     that is relative to the person's body weight.
 *                 &lt;/remarks&gt;
 * </pre>
 * 
 * 
 * <p>Java class for MaxVO2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MaxVO2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="absolute" type="{urn:com.microsoft.wc.thing.types}positiveDouble" minOccurs="0"/>
 *         &lt;element name="relative" type="{urn:com.microsoft.wc.thing.types}positiveDouble" minOccurs="0"/>
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
    "absolute",
    "relative"
})
public class MaxVO2 {

    protected Double absolute;
    protected Double relative;

    /**
     * Gets the value of the absolute property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getAbsolute() {
        return absolute;
    }

    /**
     * Sets the value of the absolute property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setAbsolute(Double value) {
        this.absolute = value;
    }

    /**
     * Gets the value of the relative property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getRelative() {
        return relative;
    }

    /**
     * Sets the value of the relative property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setRelative(Double value) {
        this.relative = value;
    }

}
