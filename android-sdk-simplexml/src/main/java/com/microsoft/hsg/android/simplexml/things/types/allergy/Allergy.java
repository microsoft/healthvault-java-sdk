package com.microsoft.hsg.android.simplexml.things.types.allergy;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;

import com.microsoft.hsg.android.simplexml.things.thing.AbstractThing;
import com.microsoft.hsg.android.simplexml.things.types.base.CodableValue;
import com.microsoft.hsg.android.simplexml.things.types.base.Person;
import com.microsoft.hsg.android.simplexml.things.types.dates.ApproxDateTime;

/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:allergy="urn:com.microsoft.wc.thing.allergy" xmlns:d="urn:com.microsoft.wc.dates" xmlns:t="urn:com.microsoft.wc.thing.types"&gt;
 *                         Information related to an allergy.
 *                     &lt;/summary&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;remarks xmlns="http://www.w3.org/2001/XMLSchema" xmlns:allergy="urn:com.microsoft.wc.thing.allergy" xmlns:d="urn:com.microsoft.wc.dates" xmlns:t="urn:com.microsoft.wc.thing.types"&gt;
 *                         This thing type describes an allergy a person has. The
 *                         allergic-episode type defines an occurrence of that 
 *                         episode resulting in symptoms.
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
 *         &lt;element name="name" type="{urn:com.microsoft.wc.thing.types}codable-value"/>
 *         &lt;element name="reaction" type="{urn:com.microsoft.wc.thing.types}codable-value" minOccurs="0"/>
 *         &lt;element name="first-observed" type="{urn:com.microsoft.wc.dates}approx-date-time" minOccurs="0"/>
 *         &lt;element name="allergen-type" type="{urn:com.microsoft.wc.thing.types}codable-value" minOccurs="0"/>
 *         &lt;element name="allergen-code" type="{urn:com.microsoft.wc.thing.types}codable-value" minOccurs="0"/>
 *         &lt;element name="treatment-provider" type="{urn:com.microsoft.wc.thing.types}person" minOccurs="0"/>
 *         &lt;element name="treatment" type="{urn:com.microsoft.wc.thing.types}codable-value" minOccurs="0"/>
 *         &lt;element name="is-negated" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
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
    "reaction",
    "first-observed",
    "allergen-type",
    "allergen-code",
    "treatment-provider",
    "treatment",
    "is-negated"
})
@Root(name = "allergy")
public class Allergy extends AbstractThing {

	public static final String ThingType = "52bf9104-2c5e-4f1f-a66d-552ebcc53df7";

    @Element(required = true)
    protected CodableValue name;
    
    @Element(required = false)
    protected CodableValue reaction;
    
    @Element(name = "first-observed", required = false)
    protected ApproxDateTime firstObserved;
    
    @Element(name = "allergen-type", required = false)
    protected CodableValue allergenType;
    
    @Element(name = "allergen-code", required = false)
    protected CodableValue allergenCode;
    
    @Element(name = "treatment-provider", required = false)
    protected Person treatmentProvider;
    
    @Element(required = false)
    protected CodableValue treatment;
    
    @Element(name = "is-negated", required = false)
    protected Boolean isNegated;

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
     * Gets the value of the reaction property.
     * 
     * @return
     *     possible object is
     *     {@link CodableValue }
     *     
     */
    public CodableValue getReaction() {
        return reaction;
    }

    /**
     * Sets the value of the reaction property.
     * 
     * @param value
     *     allowed object is
     *     {@link CodableValue }
     *     
     */
    public void setReaction(CodableValue value) {
        this.reaction = value;
    }

    /**
     * Gets the value of the firstObserved property.
     * 
     * @return
     *     possible object is
     *     {@link ApproxDateTime }
     *     
     */
    public ApproxDateTime getFirstObserved() {
        return firstObserved;
    }

    /**
     * Sets the value of the firstObserved property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApproxDateTime }
     *     
     */
    public void setFirstObserved(ApproxDateTime value) {
        this.firstObserved = value;
    }

    /**
     * Gets the value of the allergenType property.
     * 
     * @return
     *     possible object is
     *     {@link CodableValue }
     *     
     */
    public CodableValue getAllergenType() {
        return allergenType;
    }

    /**
     * Sets the value of the allergenType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CodableValue }
     *     
     */
    public void setAllergenType(CodableValue value) {
        this.allergenType = value;
    }

    /**
     * Gets the value of the allergenCode property.
     * 
     * @return
     *     possible object is
     *     {@link CodableValue }
     *     
     */
    public CodableValue getAllergenCode() {
        return allergenCode;
    }

    /**
     * Sets the value of the allergenCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link CodableValue }
     *     
     */
    public void setAllergenCode(CodableValue value) {
        this.allergenCode = value;
    }

    /**
     * Gets the value of the treatmentProvider property.
     * 
     * @return
     *     possible object is
     *     {@link Person }
     *     
     */
    public Person getTreatmentProvider() {
        return treatmentProvider;
    }

    /**
     * Sets the value of the treatmentProvider property.
     * 
     * @param value
     *     allowed object is
     *     {@link Person }
     *     
     */
    public void setTreatmentProvider(Person value) {
        this.treatmentProvider = value;
    }

    /**
     * Gets the value of the treatment property.
     * 
     * @return
     *     possible object is
     *     {@link CodableValue }
     *     
     */
    public CodableValue getTreatment() {
        return treatment;
    }

    /**
     * Sets the value of the treatment property.
     * 
     * @param value
     *     allowed object is
     *     {@link CodableValue }
     *     
     */
    public void setTreatment(CodableValue value) {
        this.treatment = value;
    }

    /**
     * Gets the value of the isNegated property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsNegated() {
        return isNegated;
    }

    /**
     * Sets the value of the isNegated property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsNegated(Boolean value) {
        this.isNegated = value;
    }
    
    @Override
	public String toString() {
		return getName().getText();
	}

	public String getThingType() {
		return ThingType; 
	}
}
