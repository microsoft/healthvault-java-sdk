package com.microsoft.hsg.android.simplexml.things.types.personal;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;

import com.microsoft.hsg.android.simplexml.things.thing.AbstractThing;
import com.microsoft.hsg.android.simplexml.things.types.base.CodableValue;
import com.microsoft.hsg.android.simplexml.things.types.base.Name;
import com.microsoft.hsg.android.simplexml.things.types.dates.ApproxDateTime;
import com.microsoft.hsg.android.simplexml.things.types.dates.DateTime;

/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:d="urn:com.microsoft.wc.dates" xmlns:personal="urn:com.microsoft.wc.thing.personal" xmlns:t="urn:com.microsoft.wc.thing.types"&gt;
 *                         Personal demographic information this is more sensitve in
 *                         nature.
 *                     &lt;/summary&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;remarks xmlns="http://www.w3.org/2001/XMLSchema" xmlns:d="urn:com.microsoft.wc.dates" xmlns:personal="urn:com.microsoft.wc.thing.personal" xmlns:t="urn:com.microsoft.wc.thing.types"&gt;
 *                         This data is more sensitive than the "basic" thing type
 *                         data and may not be disclosed as freely as the "basic"
 *                         thing type.
 *                     &lt;/remarks&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;singleton xmlns="http://www.w3.org/2001/XMLSchema" xmlns:d="urn:com.microsoft.wc.dates" xmlns:personal="urn:com.microsoft.wc.thing.personal" xmlns:t="urn:com.microsoft.wc.thing.types"/&gt;
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
 *         &lt;element name="name" type="{urn:com.microsoft.wc.thing.types}name" minOccurs="0"/>
 *         &lt;element name="birthdate" type="{urn:com.microsoft.wc.dates}date-time" minOccurs="0"/>
 *         &lt;element name="blood-type" type="{urn:com.microsoft.wc.thing.types}codable-value" minOccurs="0"/>
 *         &lt;element name="ethnicity" type="{urn:com.microsoft.wc.thing.types}codable-value" minOccurs="0"/>
 *         &lt;element name="ssn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="marital-status" type="{urn:com.microsoft.wc.thing.types}codable-value" minOccurs="0"/>
 *         &lt;element name="employment-status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="is-deceased" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="date-of-death" type="{urn:com.microsoft.wc.dates}approx-date-time" minOccurs="0"/>
 *         &lt;element name="religion" type="{urn:com.microsoft.wc.thing.types}codable-value" minOccurs="0"/>
 *         &lt;element name="is-veteran" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="highest-education-level" type="{urn:com.microsoft.wc.thing.types}codable-value" minOccurs="0"/>
 *         &lt;element name="is-disabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="organ-donor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@Order(elements = {
    "name",
    "birthdate",
    "blood-type",
    "ethnicity",
    "ssn",
    "marital-status",
    "employment-status",
    "is-deceased",
    "date-of-death",
    "religion",
    "is-veteran",
    "highest-education-level",
    "is-disabled",
    "organ-donor"
})
@Root(name = "personal")
public class PersonalDemographics extends AbstractThing {

	public static final String ThingType = "92ba621e-66b3-4a01-bd73-74844aed4f5b";

    @Element(required = false)
    protected Name name;

    @Element(required = false)
    protected DateTime birthdate;

    @Element(name = "blood-type", required = false)
    protected CodableValue bloodType;

    @Element(required = false)
    protected CodableValue ethnicity;

    @Element(required = false)
    protected String ssn;

    @Element(name = "marital-status", required = false)
    protected CodableValue maritalStatus;

    @Element(name = "employment-status", required = false)
    protected String employmentStatus;

    @Element(name = "is-deceased", required = false)
    protected Boolean isDeceased;

    @Element(name = "date-of-death", required = false)
    protected ApproxDateTime dateOfDeath;

    @Element(required = false)
    protected CodableValue religion;

    @Element(name = "is-veteran", required = false)
    protected Boolean isVeteran;

    @Element(name = "highest-education-level", required = false)
    protected CodableValue highestEducationLevel;

    @Element(name = "is-disabled", required = false)
    protected Boolean isDisabled;

    @
    Element(name = "organ-donor", required = false)
    protected String organDonor;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link Name }
     *     
     */
    public Name getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link Name }
     *     
     */
    public void setName(Name value) {
        this.name = value;
    }

    /**
     * Gets the value of the birthdate property.
     * 
     * @return
     *     possible object is
     *     {@link DateTime }
     *     
     */
    public DateTime getBirthdate() {
        return birthdate;
    }

    /**
     * Sets the value of the birthdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateTime }
     *     
     */
    public void setBirthdate(DateTime value) {
        this.birthdate = value;
    }

    /**
     * Gets the value of the bloodType property.
     * 
     * @return
     *     possible object is
     *     {@link CodableValue }
     *     
     */
    public CodableValue getBloodType() {
        return bloodType;
    }

    /**
     * Sets the value of the bloodType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CodableValue }
     *     
     */
    public void setBloodType(CodableValue value) {
        this.bloodType = value;
    }

    /**
     * Gets the value of the ethnicity property.
     * 
     * @return
     *     possible object is
     *     {@link CodableValue }
     *     
     */
    public CodableValue getEthnicity() {
        return ethnicity;
    }

    /**
     * Sets the value of the ethnicity property.
     * 
     * @param value
     *     allowed object is
     *     {@link CodableValue }
     *     
     */
    public void setEthnicity(CodableValue value) {
        this.ethnicity = value;
    }

    /**
     * Gets the value of the ssn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSsn() {
        return ssn;
    }

    /**
     * Sets the value of the ssn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSsn(String value) {
        this.ssn = value;
    }

    /**
     * Gets the value of the maritalStatus property.
     * 
     * @return
     *     possible object is
     *     {@link CodableValue }
     *     
     */
    public CodableValue getMaritalStatus() {
        return maritalStatus;
    }

    /**
     * Sets the value of the maritalStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link CodableValue }
     *     
     */
    public void setMaritalStatus(CodableValue value) {
        this.maritalStatus = value;
    }

    /**
     * Gets the value of the employmentStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmploymentStatus() {
        return employmentStatus;
    }

    /**
     * Sets the value of the employmentStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmploymentStatus(String value) {
        this.employmentStatus = value;
    }

    /**
     * Gets the value of the isDeceased property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsDeceased() {
        return isDeceased;
    }

    /**
     * Sets the value of the isDeceased property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsDeceased(Boolean value) {
        this.isDeceased = value;
    }

    /**
     * Gets the value of the dateOfDeath property.
     * 
     * @return
     *     possible object is
     *     {@link ApproxDateTime }
     *     
     */
    public ApproxDateTime getDateOfDeath() {
        return dateOfDeath;
    }

    /**
     * Sets the value of the dateOfDeath property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApproxDateTime }
     *     
     */
    public void setDateOfDeath(ApproxDateTime value) {
        this.dateOfDeath = value;
    }

    /**
     * Gets the value of the religion property.
     * 
     * @return
     *     possible object is
     *     {@link CodableValue }
     *     
     */
    public CodableValue getReligion() {
        return religion;
    }

    /**
     * Sets the value of the religion property.
     * 
     * @param value
     *     allowed object is
     *     {@link CodableValue }
     *     
     */
    public void setReligion(CodableValue value) {
        this.religion = value;
    }

    /**
     * Gets the value of the isVeteran property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsVeteran() {
        return isVeteran;
    }

    /**
     * Sets the value of the isVeteran property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsVeteran(Boolean value) {
        this.isVeteran = value;
    }

    /**
     * Gets the value of the highestEducationLevel property.
     * 
     * @return
     *     possible object is
     *     {@link CodableValue }
     *     
     */
    public CodableValue getHighestEducationLevel() {
        return highestEducationLevel;
    }

    /**
     * Sets the value of the highestEducationLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link CodableValue }
     *     
     */
    public void setHighestEducationLevel(CodableValue value) {
        this.highestEducationLevel = value;
    }

    /**
     * Gets the value of the isDisabled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsDisabled() {
        return isDisabled;
    }

    /**
     * Sets the value of the isDisabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsDisabled(Boolean value) {
        this.isDisabled = value;
    }

    /**
     * Gets the value of the organDonor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrganDonor() {
        return organDonor;
    }

    /**
     * Sets the value of the organDonor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrganDonor(String value) {
        this.organDonor = value;
    }

	public String getThingType() {
		return ThingType; 
	}
}
