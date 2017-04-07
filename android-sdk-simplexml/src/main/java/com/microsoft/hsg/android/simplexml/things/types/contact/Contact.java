package com.microsoft.hsg.android.simplexml.things.types.contact;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;

import com.microsoft.hsg.android.simplexml.things.thing.AbstractThing;

/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:contact="urn:com.microsoft.wc.thing.contact" xmlns:t="urn:com.microsoft.wc.thing.types"&gt;
 *                       This is the contact information for the person owning
 *                       a health record in Microsoft HealthVault.
 *                     &lt;/summary&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;remarks xmlns="http://www.w3.org/2001/XMLSchema" xmlns:contact="urn:com.microsoft.wc.thing.contact" xmlns:t="urn:com.microsoft.wc.thing.types"&gt;
 *                         This data should not be confused with the 'person'
 *                         type which is contact information for an emergency
 *                         contact or someone else related to the health record.
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
 *         &lt;element name="contact" type="{urn:com.microsoft.wc.thing.types}contact"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@Order(elements = {
    "contact"
})
@Root(name = "contact")
public class Contact extends AbstractThing {
	
	public static final String ThingType = "162dd12d-9859-4a66-b75f-96760d67072b";

    @Element(required = true)
    protected com.microsoft.hsg.android.simplexml.things.types.base.Contact contact;

    /**
     * Gets the value of the contact property.
     * 
     * @return
     *     possible object is
     *     {@link com.microsoft.hsg.thing.oxm.jaxb.base.Contact }
     *     
     */
    public com.microsoft.hsg.android.simplexml.things.types.base.Contact getContact() {
        return contact;
    }

    /**
     * Sets the value of the contact property.
     * 
     * @param value
     *     allowed object is
     *     {@link com.microsoft.hsg.thing.oxm.jaxb.base.Contact }
     *     
     */
    public void setContact(com.microsoft.hsg.android.simplexml.things.types.base.Contact value) {
        this.contact = value;
    }
    
    public String getThingType() {
    	return ThingType;
    }

}
