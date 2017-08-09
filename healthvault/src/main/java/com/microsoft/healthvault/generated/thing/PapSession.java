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
import com.microsoft.healthvault.generated.types.dates.DateTime;


/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:d="urn:com.microsoft.wc.dates" xmlns:t="urn:com.microsoft.wc.thing.types" xmlns:this="urn:com.microsoft.wc.thing.pap-session"&gt;
 *                         The Positive Airway Pressure (PAP) Session records data collected during a PAP session.  A common use for PAP therapy is in the treatment of sleep apnea.
 *                     &lt;/summary&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;remarks xmlns="http://www.w3.org/2001/XMLSchema" xmlns:d="urn:com.microsoft.wc.dates" xmlns:t="urn:com.microsoft.wc.thing.types" xmlns:this="urn:com.microsoft.wc.thing.pap-session"/&gt;
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
 *         &lt;element name="duration-minutes" type="{urn:com.microsoft.wc.thing.types}nonNegativeDouble"/>
 *         &lt;element name="apnea-hypopnea-index" type="{urn:com.microsoft.wc.thing.types}nonNegativeDouble"/>
 *         &lt;element name="apnea-index" type="{urn:com.microsoft.wc.thing.types}nonNegativeDouble" minOccurs="0"/>
 *         &lt;element name="hypopnea-index" type="{urn:com.microsoft.wc.thing.types}nonNegativeDouble" minOccurs="0"/>
 *         &lt;element name="oxygen-desaturation-index" type="{urn:com.microsoft.wc.thing.types}nonNegativeDouble" minOccurs="0"/>
 *         &lt;element name="pressure" type="{urn:com.microsoft.wc.thing.pap-session}pap-session-pressure" minOccurs="0"/>
 *         &lt;element name="leak-rate" type="{urn:com.microsoft.wc.thing.pap-session}pap-session-leak-rate" minOccurs="0"/>
 *         &lt;element name="tidal-volume" type="{urn:com.microsoft.wc.thing.pap-session}pap-session-tidal-volume" minOccurs="0"/>
 *         &lt;element name="minute-ventilation" type="{urn:com.microsoft.wc.thing.pap-session}pap-session-minute-ventilation" minOccurs="0"/>
 *         &lt;element name="respiratory-rate" type="{urn:com.microsoft.wc.thing.pap-session}pap-session-respiratory-rate" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@Root(name="pap-session")
@Order(elements = {
    "when",
    "durationMinutes",
    "apneaHypopneaIndex",
    "apneaIndex",
    "hypopneaIndex",
    "oxygenDesaturationIndex",
    "pressure",
    "leakRate",
    "tidalVolume",
    "minuteVentilation",
    "respiratoryRate"
})
public class PapSession {

    @Element(required = true)
    protected DateTime when;
    @Element(name = "duration-minutes")
    protected double durationMinutes;
    @Element(name = "apnea-hypopnea-index")
    protected double apneaHypopneaIndex;
    @Element(name = "apnea-index")
    protected Double apneaIndex;
    @Element(name = "hypopnea-index")
    protected Double hypopneaIndex;
    @Element(name = "oxygen-desaturation-index")
    protected Double oxygenDesaturationIndex;
    protected PapSessionPressure pressure;
    @Element(name = "leak-rate")
    protected PapSessionLeakRate leakRate;
    @Element(name = "tidal-volume")
    protected PapSessionTidalVolume tidalVolume;
    @Element(name = "minute-ventilation")
    protected PapSessionMinuteVentilation minuteVentilation;
    @Element(name = "respiratory-rate")
    protected PapSessionRespiratoryRate respiratoryRate;

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
     * Gets the value of the durationMinutes property.
     * 
     */
    public double getDurationMinutes() {
        return durationMinutes;
    }

    /**
     * Sets the value of the durationMinutes property.
     * 
     */
    public void setDurationMinutes(double value) {
        this.durationMinutes = value;
    }

    /**
     * Gets the value of the apneaHypopneaIndex property.
     * 
     */
    public double getApneaHypopneaIndex() {
        return apneaHypopneaIndex;
    }

    /**
     * Sets the value of the apneaHypopneaIndex property.
     * 
     */
    public void setApneaHypopneaIndex(double value) {
        this.apneaHypopneaIndex = value;
    }

    /**
     * Gets the value of the apneaIndex property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getApneaIndex() {
        return apneaIndex;
    }

    /**
     * Sets the value of the apneaIndex property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setApneaIndex(Double value) {
        this.apneaIndex = value;
    }

    /**
     * Gets the value of the hypopneaIndex property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getHypopneaIndex() {
        return hypopneaIndex;
    }

    /**
     * Sets the value of the hypopneaIndex property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setHypopneaIndex(Double value) {
        this.hypopneaIndex = value;
    }

    /**
     * Gets the value of the oxygenDesaturationIndex property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getOxygenDesaturationIndex() {
        return oxygenDesaturationIndex;
    }

    /**
     * Sets the value of the oxygenDesaturationIndex property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setOxygenDesaturationIndex(Double value) {
        this.oxygenDesaturationIndex = value;
    }

    /**
     * Gets the value of the pressure property.
     * 
     * @return
     *     possible object is
     *     {@link PapSessionPressure }
     *     
     */
    public PapSessionPressure getPressure() {
        return pressure;
    }

    /**
     * Sets the value of the pressure property.
     * 
     * @param value
     *     allowed object is
     *     {@link PapSessionPressure }
     *     
     */
    public void setPressure(PapSessionPressure value) {
        this.pressure = value;
    }

    /**
     * Gets the value of the leakRate property.
     * 
     * @return
     *     possible object is
     *     {@link PapSessionLeakRate }
     *     
     */
    public PapSessionLeakRate getLeakRate() {
        return leakRate;
    }

    /**
     * Sets the value of the leakRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link PapSessionLeakRate }
     *     
     */
    public void setLeakRate(PapSessionLeakRate value) {
        this.leakRate = value;
    }

    /**
     * Gets the value of the tidalVolume property.
     * 
     * @return
     *     possible object is
     *     {@link PapSessionTidalVolume }
     *     
     */
    public PapSessionTidalVolume getTidalVolume() {
        return tidalVolume;
    }

    /**
     * Sets the value of the tidalVolume property.
     * 
     * @param value
     *     allowed object is
     *     {@link PapSessionTidalVolume }
     *     
     */
    public void setTidalVolume(PapSessionTidalVolume value) {
        this.tidalVolume = value;
    }

    /**
     * Gets the value of the minuteVentilation property.
     * 
     * @return
     *     possible object is
     *     {@link PapSessionMinuteVentilation }
     *     
     */
    public PapSessionMinuteVentilation getMinuteVentilation() {
        return minuteVentilation;
    }

    /**
     * Sets the value of the minuteVentilation property.
     * 
     * @param value
     *     allowed object is
     *     {@link PapSessionMinuteVentilation }
     *     
     */
    public void setMinuteVentilation(PapSessionMinuteVentilation value) {
        this.minuteVentilation = value;
    }

    /**
     * Gets the value of the respiratoryRate property.
     * 
     * @return
     *     possible object is
     *     {@link PapSessionRespiratoryRate }
     *     
     */
    public PapSessionRespiratoryRate getRespiratoryRate() {
        return respiratoryRate;
    }

    /**
     * Sets the value of the respiratoryRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link PapSessionRespiratoryRate }
     *     
     */
    public void setRespiratoryRate(PapSessionRespiratoryRate value) {
        this.respiratoryRate = value;
    }

}
