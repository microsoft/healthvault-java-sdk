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


/**
 * <p>Java class for AccessAvenue.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AccessAvenue">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Online"/>
 *     &lt;enumeration value="Offline"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
public enum AccessAvenue {


    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:d="urn:com.microsoft.wc.dates" xmlns:ds="http://www.w3.org/2000/09/xmldsig#" xmlns:this="urn:com.microsoft.wc.thing" xmlns:wc-auth="urn:com.microsoft.wc.auth" xmlns:wc-types="urn:com.microsoft.wc.types"&gt;
     *                             Indicates that online access avenue was used
     *                             to perform the operation on the thing.
     *                         &lt;/summary&gt;
     * </pre>
     * 
     * 
     */
    ONLINE("Online"),

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:d="urn:com.microsoft.wc.dates" xmlns:ds="http://www.w3.org/2000/09/xmldsig#" xmlns:this="urn:com.microsoft.wc.thing" xmlns:wc-auth="urn:com.microsoft.wc.auth" xmlns:wc-types="urn:com.microsoft.wc.types"&gt;
     *                             Indicates that offline access avenue was used
     *                             to perform the operation on the thing.
     *                         &lt;/summary&gt;
     * </pre>
     * 
     * 
     */
    OFFLINE("Offline");
    private final String value;

    AccessAvenue(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AccessAvenue fromValue(String v) {
        for (AccessAvenue c: AccessAvenue.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}