package com.microsoft.hsg.android.simplexml.things.types.dates;

import java.text.DateFormat;
import java.util.Calendar;


import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;

import com.microsoft.hsg.android.simplexml.things.types.base.CodableValue;

/**
 * 
 *             date + time value, requires at least date
 *         
 * 
 * <p>Java class for date-time complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="date-time">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="date" type="{urn:com.microsoft.wc.dates}date"/>
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
public class DateTime {

    @Element(required = true)
    protected Date date;

    @Element(required = false)
    protected Time time;

    @Element(required = false)
    protected CodableValue tz;

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link Date }
     *     
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link Date }
     *     
     */
    public void setDate(Date value) {
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
    
    public String toString()
    {
    	return DateFormat.getDateTimeInstance(
                DateFormat.MEDIUM, DateFormat.SHORT)
                	.format(toCalendar().getTime());
    }
    
    /**
     * Generate instance from calendar.
     * 
     * @param cal the cal
     * 
     * @return the date time
     */
    public static DateTime fromCalendar(Calendar cal)
    {
    	DateTime dateTime = new DateTime();
    	
    	dateTime.date = Date.fromCalendar(cal);
    	dateTime.time = Time.fromCalendar(cal);
    	
    	return dateTime;
    }
    
    /**
     * To calendar.  This is a convenience method to convert the 
     * DateTime class to a Java calendar ignoring any TZ information.
     * 
     * @return the calendar
     */
    public Calendar toCalendar()
    {
    	Calendar cal = Calendar.getInstance();
    	cal.clear();
    	
    	if (date != null)
    	{
	    	cal.set(Calendar.YEAR, date.getY());
	    	cal.set(Calendar.MONTH, date.getM() - 1);	
	    	cal.set(Calendar.DATE, date.getD());
    	}
    	
    	if (time != null)
    	{
	    	cal.set(Calendar.HOUR_OF_DAY, time.getH());
	    	cal.set(Calendar.MINUTE, time.getM());
	    	if (time.getS() != null) {
	    		cal.set(Calendar.SECOND, time.getS());
	    	}
	    	if (time.getF() != null) {
	    		cal.set(Calendar.MILLISECOND, time.getF());
	    	}
    	}
    	
    	return cal;
    }
}
