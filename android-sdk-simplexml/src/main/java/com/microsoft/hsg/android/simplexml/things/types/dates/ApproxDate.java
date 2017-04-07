package com.microsoft.hsg.android.simplexml.things.types.dates;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;

import com.microsoft.hsg.android.simplexml.things.types.base.Day;
import com.microsoft.hsg.android.simplexml.things.types.base.Month;
import com.microsoft.hsg.android.simplexml.things.types.base.Year;


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
 * <p>Java class for approx-date complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="approx-date">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="y" type="{urn:com.microsoft.wc.dates}year"/>
 *         &lt;element name="m" type="{urn:com.microsoft.wc.dates}month" minOccurs="0"/>
 *         &lt;element name="d" type="{urn:com.microsoft.wc.dates}day" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@Order(elements = {
		"y",
		"m",
		"d"
})
public class ApproxDate {

	@Element(required = false)
	protected Year y;

	@Element(required = false)
	protected Month m;

	@Element(required = false)
	protected Day d;

	public ApproxDate() {
		y = new Year();
		m = new Month();
		d = new Day();
	}
	
	/**
	 * Gets the value of the y property.
	 * 
	 */
	public int getY() {
		return y.getValue();
	}

	/**
	 * Sets the value of the y property.
	 * 
	 */
	public void setY(int value) {
		y = new Year(value);
	}

	/**
	 * Gets the value of the m property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link Integer }
	 *     
	 */
	public int getM() {
		return m.getValue();
	}

	/**
	 * Sets the value of the m property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link Integer }
	 *     
	 */
	public void setM(int value) {
		this.m = new Month(value);
	}

	/**
	 * Gets the value of the d property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link Integer }
	 *     
	 */
	public int getD() {
		return d.getValue();
	}

	/**
	 * Sets the value of the d property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link Integer }
	 *     
	 */
	public void setD(int value) {
		d = new Day(value);
	}
}
