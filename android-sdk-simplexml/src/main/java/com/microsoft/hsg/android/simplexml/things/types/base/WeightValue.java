package com.microsoft.hsg.android.simplexml.things.types.base;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;

/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;wrapper-class-name xmlns="http://www.w3.org/2001/XMLSchema" xmlns:d="urn:com.microsoft.wc.dates" xmlns:t="urn:com.microsoft.wc.thing.types" xmlns:wct="urn:com.microsoft.wc.types"&gt;WeightValue&lt;/wrapper-class-name&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:d="urn:com.microsoft.wc.dates" xmlns:t="urn:com.microsoft.wc.thing.types" xmlns:wct="urn:com.microsoft.wc.types"&gt;
 *                     A weight measurement.
 *                 &lt;/summary&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;remarks xmlns="http://www.w3.org/2001/XMLSchema" xmlns:d="urn:com.microsoft.wc.dates" xmlns:t="urn:com.microsoft.wc.thing.types" xmlns:wct="urn:com.microsoft.wc.types"&gt;
 *                     A weight measurement consists of the value in kilograms,
 *                     which is the base unit of measurement for weight, and
 *                     an optional display value. The display value is used to
 *                     store the weight measurement in the user's preference of
 *                     weight units. This avoids rounding errors when
 *                     converting to and back from kilograms.
 *                 &lt;/remarks&gt;
 * </pre>
 * 
 * 
 * <p>Java class for weight-value complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="weight-value">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="kg" type="{urn:com.microsoft.wc.thing.types}nonNegativeDouble"/>
 *         &lt;element name="display" type="{urn:com.microsoft.wc.thing.types}display-value" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */

@Order(elements = {
	    "kg",
	    "display"
	})
public class WeightValue {

	@Element(required=true)
    protected PositiveDouble kg;
	
	@Element(required=false)
    protected DisplayValue display;
	
	public WeightValue() {
	}
	
	public WeightValue(double kg) {
		this.kg =new PositiveDouble(kg);
	}

    /**
     * Gets the value of the kg property.
     * 
     */
    public Double getKg() {
        return kg == null ? null : kg.getValue();
    }

    /**
     * Sets the value of the kg property.
     * 
     */
    public void setKg(double value) {
        this.kg = new PositiveDouble(value);
    }

    /**
     * Gets the value of the display property.
     * 
     * @return
     *     possible object is
     *     {@link DisplayValue }
     *     
     */
    public DisplayValue getDisplay() {
        return display;
    }

    /**
     * Sets the value of the display property.
     * 
     * @param value
     *     allowed object is
     *     {@link DisplayValue }
     *     
     */
    public void setDisplay(DisplayValue value) {
        this.display = value;
    }

}
