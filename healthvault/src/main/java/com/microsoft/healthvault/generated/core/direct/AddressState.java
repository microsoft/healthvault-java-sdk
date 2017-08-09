//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.08 at 12:00:41 PM PDT 
//


package com.microsoft.healthvault.generated.core.direct;

import java.util.Date;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;


/**
 * <p>Java class for AddressState.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AddressState">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Active"/>
 *     &lt;enumeration value="Inactive"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
public enum AddressState {


    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.direct" xmlns:wc-types="urn:com.microsoft.wc.types"&gt;
     *                             The direct address is active and is capable of receiving
     *                             direct messages.
     *                         &lt;/summary&gt;
     * </pre>
     * 
     * 
     */
    ACTIVE("Active"),

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.direct" xmlns:wc-types="urn:com.microsoft.wc.types"&gt;
     *                             The direct address is not active and is not capable of 
     *                             receiving direct message.
     *                         &lt;/summary&gt;
     * </pre>
     * 
     * 
     */
    INACTIVE("Inactive");
    private final String value;

    AddressState(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AddressState fromValue(String v) {
        for (AddressState c: AddressState.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
