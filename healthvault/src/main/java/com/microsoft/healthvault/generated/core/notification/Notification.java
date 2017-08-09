//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.08 at 12:00:41 PM PDT 
//


package com.microsoft.healthvault.generated.core.notification;

import java.util.Date;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;


/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.notification" xmlns:wc-types="urn:com.microsoft.wc.types"&gt;
 *                     A notification satisfying a subscription.
 *                 &lt;/summary&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;remarks xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.notification" xmlns:wc-types="urn:com.microsoft.wc.types"/&gt;
 * </pre>
 * 
 * 
 * <p>Java class for Notification complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Notification">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="common" type="{urn:com.microsoft.wc.notification}Common"/>
 *         &lt;choice>
 *           &lt;element name="record-change-notification" type="{urn:com.microsoft.wc.notification}RecordChangeNotification"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@Root(name="")
@Order(elements = {
    "common",
    "recordChangeNotification"
})
public class Notification {

    @Element(required = true)
    protected Common common;
    @Element(name = "record-change-notification")
    protected RecordChangeNotification recordChangeNotification;

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
     * Gets the value of the recordChangeNotification property.
     * 
     * @return
     *     possible object is
     *     {@link RecordChangeNotification }
     *     
     */
    public RecordChangeNotification getRecordChangeNotification() {
        return recordChangeNotification;
    }

    /**
     * Sets the value of the recordChangeNotification property.
     * 
     * @param value
     *     allowed object is
     *     {@link RecordChangeNotification }
     *     
     */
    public void setRecordChangeNotification(RecordChangeNotification value) {
        this.recordChangeNotification = value;
    }

}
