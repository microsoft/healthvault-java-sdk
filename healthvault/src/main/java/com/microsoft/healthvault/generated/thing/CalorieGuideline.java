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
import com.microsoft.healthvault.generated.types.GeneralMeasurement;
import com.microsoft.healthvault.generated.types.dates.ApproxDateTime;


/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:d="urn:com.microsoft.wc.dates" xmlns:t="urn:com.microsoft.wc.thing.types" xmlns:this="urn:com.microsoft.wc.thing.calorie-guideline"&gt;
 *                         Stores suggested calorie intake guidelines.
 *                     &lt;/summary&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;remarks xmlns="http://www.w3.org/2001/XMLSchema" xmlns:d="urn:com.microsoft.wc.dates" xmlns:t="urn:com.microsoft.wc.thing.types" xmlns:this="urn:com.microsoft.wc.thing.calorie-guideline"&gt;
 *                         Examples: Daily calories suggested for weight loss, calories needed for weight maintenance, BMR.
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
 *         &lt;element name="when" type="{urn:com.microsoft.wc.dates}approx-date-time"/>
 *         &lt;element name="name" type="{urn:com.microsoft.wc.thing.types}codable-value"/>
 *         &lt;element name="calories" type="{urn:com.microsoft.wc.thing.types}general-measurement"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@Root(name="calorie-guideline")
@Order(elements = {
    "when",
    "name",
    "calories"
})
public class CalorieGuideline {

    @Element(required = true)
    protected ApproxDateTime when;
    @Element(required = true)
    protected CodableValue name;
    @Element(required = true)
    protected GeneralMeasurement calories;

    /**
     * Gets the value of the when property.
     * 
     * @return
     *     possible object is
     *     {@link ApproxDateTime }
     *     
     */
    public ApproxDateTime getWhen() {
        return when;
    }

    /**
     * Sets the value of the when property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApproxDateTime }
     *     
     */
    public void setWhen(ApproxDateTime value) {
        this.when = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link CodableValue }
     *     
     */
    public CodableValue getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link CodableValue }
     *     
     */
    public void setName(CodableValue value) {
        this.name = value;
    }

    /**
     * Gets the value of the calories property.
     * 
     * @return
     *     possible object is
     *     {@link GeneralMeasurement }
     *     
     */
    public GeneralMeasurement getCalories() {
        return calories;
    }

    /**
     * Sets the value of the calories property.
     * 
     * @param value
     *     allowed object is
     *     {@link GeneralMeasurement }
     *     
     */
    public void setCalories(GeneralMeasurement value) {
        this.calories = value;
    }

}
