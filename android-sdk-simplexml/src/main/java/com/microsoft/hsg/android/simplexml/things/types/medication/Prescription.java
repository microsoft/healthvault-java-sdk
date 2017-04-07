package com.microsoft.hsg.android.simplexml.things.types.medication;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;

import com.microsoft.hsg.android.simplexml.things.types.base.CodableValue;
import com.microsoft.hsg.android.simplexml.things.types.base.GeneralMeasurement;
import com.microsoft.hsg.android.simplexml.things.types.base.NonNegativeInt;
import com.microsoft.hsg.android.simplexml.things.types.base.Person;
import com.microsoft.hsg.android.simplexml.things.types.base.PositiveInt;
import com.microsoft.hsg.android.simplexml.things.types.dates.ApproxDateTime;
import com.microsoft.hsg.android.simplexml.things.types.dates.Date;

/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:d="urn:com.microsoft.wc.dates" xmlns:med="urn:com.microsoft.wc.thing.medication" xmlns:t="urn:com.microsoft.wc.thing.types"&gt;
 *                         Information related to a medication prescription.
 *                     &lt;/summary&gt;
 * </pre>
 * 
 * 
 * <p>Java class for Prescription complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Prescription">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="prescribed-by" type="{urn:com.microsoft.wc.thing.types}person"/>
 *         &lt;element name="date-prescribed" type="{urn:com.microsoft.wc.dates}approx-date-time" minOccurs="0"/>
 *         &lt;element name="amount-prescribed" type="{urn:com.microsoft.wc.thing.types}general-measurement" minOccurs="0"/>
 *         &lt;element name="substitution" type="{urn:com.microsoft.wc.thing.types}codable-value" minOccurs="0"/>
 *         &lt;element name="refills" type="{urn:com.microsoft.wc.thing.types}nonNegativeInt" minOccurs="0"/>
 *         &lt;element name="days-supply" type="{urn:com.microsoft.wc.thing.types}positiveInt" minOccurs="0"/>
 *         &lt;element name="prescription-expiration" type="{urn:com.microsoft.wc.dates}date" minOccurs="0"/>
 *         &lt;element name="instructions" type="{urn:com.microsoft.wc.thing.types}codable-value" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@Order(elements = {
    "prescribed-by",
    "date-prescribed",
    "amount-prescribed",
    "substitution",
    "refills",
    "days-supply",
    "prescription-expiration",
    "instructions"
})
public class Prescription {

    @Element(name = "prescribed-by", required = true)
    protected Person prescribedBy;

    @Element(name = "date-prescribed", required=false)
    protected ApproxDateTime datePrescribed;

    @Element(name = "amount-prescribed", required=false)
    protected GeneralMeasurement amountPrescribed;

    @Element(required = false)
    protected CodableValue substitution;

    @Element(required = false)
    protected NonNegativeInt refills;

    @Element(name = "days-supply", required=false)
    protected PositiveInt daysSupply;

    @Element(name = "prescription-expiration", required=false)
    protected Date prescriptionExpiration;

    @Element(required = false)
    protected CodableValue instructions;

    /**
     * Gets the value of the prescribedBy property.
     * 
     * @return
     *     possible object is
     *     {@link Person }
     *     
     */
    public Person getPrescribedBy() {
        return prescribedBy;
    }

    /**
     * Sets the value of the prescribedBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link Person }
     *     
     */
    public void setPrescribedBy(Person value) {
        this.prescribedBy = value;
    }

    /**
     * Gets the value of the datePrescribed property.
     * 
     * @return
     *     possible object is
     *     {@link ApproxDateTime }
     *     
     */
    public ApproxDateTime getDatePrescribed() {
        return datePrescribed;
    }

    /**
     * Sets the value of the datePrescribed property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApproxDateTime }
     *     
     */
    public void setDatePrescribed(ApproxDateTime value) {
        this.datePrescribed = value;
    }

    /**
     * Gets the value of the amountPrescribed property.
     * 
     * @return
     *     possible object is
     *     {@link GeneralMeasurement }
     *     
     */
    public GeneralMeasurement getAmountPrescribed() {
        return amountPrescribed;
    }

    /**
     * Sets the value of the amountPrescribed property.
     * 
     * @param value
     *     allowed object is
     *     {@link GeneralMeasurement }
     *     
     */
    public void setAmountPrescribed(GeneralMeasurement value) {
        this.amountPrescribed = value;
    }

    /**
     * Gets the value of the substitution property.
     * 
     * @return
     *     possible object is
     *     {@link CodableValue }
     *     
     */
    public CodableValue getSubstitution() {
        return substitution;
    }

    /**
     * Sets the value of the substitution property.
     * 
     * @param value
     *     allowed object is
     *     {@link CodableValue }
     *     
     */
    public void setSubstitution(CodableValue value) {
        this.substitution = value;
    }

    /**
     * Gets the value of the refills property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRefills() {
        return refills == null ? null : refills.getValue();
    }

    /**
     * Sets the value of the refills property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRefills(Integer value) {
        this.refills = new NonNegativeInt(value);
    }

    /**
     * Gets the value of the daysSupply property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDaysSupply() {
        return daysSupply == null ? null : daysSupply.getValue();
    }

    /**
     * Sets the value of the daysSupply property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDaysSupply(Integer value) {
        this.daysSupply = new PositiveInt(value);
    }

    /**
     * Gets the value of the prescriptionExpiration property.
     * 
     * @return
     *     possible object is
     *     {@link Date }
     *     
     */
    public Date getPrescriptionExpiration() {
        return prescriptionExpiration;
    }

    /**
     * Sets the value of the prescriptionExpiration property.
     * 
     * @param value
     *     allowed object is
     *     {@link Date }
     *     
     */
    public void setPrescriptionExpiration(Date value) {
        this.prescriptionExpiration = value;
    }

    /**
     * Gets the value of the instructions property.
     * 
     * @return
     *     possible object is
     *     {@link CodableValue }
     *     
     */
    public CodableValue getInstructions() {
        return instructions;
    }

    /**
     * Sets the value of the instructions property.
     * 
     * @param value
     *     allowed object is
     *     {@link CodableValue }
     *     
     */
    public void setInstructions(CodableValue value) {
        this.instructions = value;
    }

}
