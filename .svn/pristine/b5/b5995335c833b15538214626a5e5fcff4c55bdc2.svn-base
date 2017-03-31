package com.microsoft.hsg.android.simplexml.things.types.dates;

import java.util.Calendar;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;

import com.microsoft.hsg.android.simplexml.things.types.base.Hour;
import com.microsoft.hsg.android.simplexml.things.types.base.Millisecond;
import com.microsoft.hsg.android.simplexml.things.types.base.Minute;
import com.microsoft.hsg.android.simplexml.things.types.base.Second;

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
 * <p>Java class for time complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="time">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="h" type="{urn:com.microsoft.wc.dates}hour"/>
 *         &lt;element name="m" type="{urn:com.microsoft.wc.dates}minute"/>
 *         &lt;element name="s" type="{urn:com.microsoft.wc.dates}second" minOccurs="0"/>
 *         &lt;element name="f" type="{urn:com.microsoft.wc.dates}millisecond" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@Order(elements = {
		"h",
		"m",
		"s",
		"f"
})
public class Time {

	@Element(required = false)
	protected Hour h;
	@Element(required = false)
	protected Minute m;
	@Element(required = false)
	protected Second s;
	@Element(required = false)
	protected Millisecond f;

	public Time() {
		h = new Hour();
		m = new Minute();
		s = new Second();
		f = new Millisecond();
	}

	/**
	 * Gets the value of the h property.
	 * 
	 */
	public int getH() {
		return h.getValue();
	}

	/**
	 * Sets the value of the h property.
	 * 
	 */
	public void setH(int value) {
		this.h = new Hour(value);
	}

	/**
	 * Gets the value of the m property.
	 * 
	 */
	public int getM() {
		return m.getValue();
	}

	/**
	 * Sets the value of the m property.
	 * 
	 */
	public void setM(int value) {
		this.m = new Minute(value);
	}

	/**
	 * Gets the value of the s property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link Integer }
	 *     
	 */
	public Integer getS() {
		return s.getValue();
	}

	/**
	 * Sets the value of the s property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link Integer }
	 *     
	 */
	public void setS(Integer value) {
		this.s = new Second(value);
	}

	/**
	 * Gets the value of the f property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link Integer }
	 *     
	 */
	public Integer getF() {
		return f.getValue();
	}

	/**
	 * Sets the value of the f property.
	 * 
	 * @param value allowed object is
	 * {@link Integer }
	 */
	public void setF(Integer value) {
		this.f = new Millisecond(value);
	}

	/**
	 * Generate instance from calendar.
	 * 
	 * @param cal the cal
	 * 
	 * @return the time
	 */
	public static Time fromCalendar(Calendar cal)
	{
		Time time = new Time();

		time.setH(cal.get(Calendar.HOUR_OF_DAY));
		time.setM(cal.get(Calendar.MINUTE));
		time.setS(cal.get(Calendar.SECOND));
		time.setF(cal.get(Calendar.MILLISECOND));

		return time;
	}
}
