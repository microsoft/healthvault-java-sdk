package com.microsoft.healthvault.things.thing;

import com.microsoft.healthvault.things.types.Allergy;
import com.microsoft.healthvault.things.types.Appointment;
import com.microsoft.healthvault.things.types.Cholesterol;
import com.microsoft.healthvault.things.types.Condition;
import com.microsoft.healthvault.things.types.File;
import com.microsoft.healthvault.things.types.Height;
import com.microsoft.healthvault.things.types.Immunization;
import com.microsoft.healthvault.things.types.Medication;
import com.microsoft.healthvault.things.types.PersonalDemographics;
import com.microsoft.healthvault.things.types.PersonalImage;
import com.microsoft.healthvault.things.types.Procedure;
import com.microsoft.healthvault.things.types.Weight;
import com.microsoft.healthvault.things.types.base.Person;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementUnion;

/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:d="urn:com.microsoft.wc.dates" xmlns:ds="http://www.w3.org/2000/09/xmldsig#" xmlns:this="urn:com.microsoft.wc.thing" xmlns:wc-auth="urn:com.microsoft.wc.auth" xmlns:wc-types="urn:com.microsoft.wc.types"/&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;remarks xmlns="http://www.w3.org/2001/XMLSchema" xmlns:d="urn:com.microsoft.wc.dates" xmlns:ds="http://www.w3.org/2000/09/xmldsig#" xmlns:this="urn:com.microsoft.wc.thing" xmlns:wc-auth="urn:com.microsoft.wc.auth" xmlns:wc-types="urn:com.microsoft.wc.types"/&gt;
 * </pre>
 * 
 * 
 * <p>Java class for DataXml complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DataXml">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;any/>
 *         &lt;element name="common" type="{urn:com.microsoft.wc.thing}common" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="transform" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class DataXml {

	@ElementUnion({
		@Element(name="allergy", type=Allergy.class),
		@Element(name="person", type=Person.class),
		@Element(name="personal", type=PersonalDemographics.class),
		@Element(name="medication", type=Medication.class),
		@Element(name="condition", type=Condition.class),
		@Element(name="personal-image", type=PersonalImage.class),	
		@Element(name="weight", type=Weight.class),
		@Element(name="height", type=Height.class),		
		@Element(name="appointment", type=Appointment.class),
		@Element(name="procedure", type=Procedure.class),
		@Element(name="immunization", type=Immunization.class),
		@Element(name="cholesterol-profile", type=Cholesterol.class),
		@Element(name="file", type=File.class)
	})
    protected AbstractThing any;
    
    @Element(required=false)
    protected Common common;
    
    @Attribute(required=false)
    protected String transform;

    /**
     * Gets the value of the any property.
     * 
     * @return
     *     possible object is
     *     {@link Element }
     *     
     */
    public AbstractThing getAny() {
        return any;
    }

    /**
     * Sets the value of the any property.
     * 
     * @param value
     *     allowed object is
     *     {@link Element }
     *     
     */
    public void setAny(AbstractThing value) {
        this.any = value;
    }

    /**
     * Gets the value of the common property.
     * 
     * @return
     *     possible object is
     *     {@link Common }
     *     
     */
    public Common getCommon() {
        return common;
    }

    /**
     * Sets the value of the common property.
     * 
     * @param value
     *     allowed object is
     *     {@link Common }
     *     
     */
    public void setCommon(Common value) {
        this.common = value;
    }

    /**
     * Gets the value of the transform property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransform() {
        return transform;
    }

    /**
     * Sets the value of the transform property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransform(String value) {
        this.transform = value;
    }

}