//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.08 at 12:00:41 PM PDT 
//


package com.microsoft.healthvault.generated.core.meaningfuluse;

import java.util.Date;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;


/**
 * <p>Java class for Action.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Action">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="View"/>
 *     &lt;enumeration value="Download"/>
 *     &lt;enumeration value="Transmit"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
public enum Action {


    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.MeaningfulUse" xmlns:wc-types="urn:com.microsoft.wc.types"&gt;
     *                             The user has performed no trackable meaningful use action on their health information.
     *                         &lt;/summary&gt;
     * </pre>
     * 
     * 
     */
    NONE("None"),

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.MeaningfulUse" xmlns:wc-types="urn:com.microsoft.wc.types"&gt;
     *                             The user has performed "View" action on their health information.
     *                         &lt;/summary&gt;
     * </pre>
     * 
     * 
     */
    VIEW("View"),

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.MeaningfulUse" xmlns:wc-types="urn:com.microsoft.wc.types"&gt;
     *                             The user has performed "Download" action on their health information.
     *                         &lt;/summary&gt;
     * </pre>
     * 
     * 
     */
    DOWNLOAD("Download"),

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.MeaningfulUse" xmlns:wc-types="urn:com.microsoft.wc.types"&gt;
     *                             The user has performed "Transmit" action on their health information.
     *                         &lt;/summary&gt;
     * </pre>
     * 
     * 
     */
    TRANSMIT("Transmit");
    private final String value;

    Action(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Action fromValue(String v) {
        for (Action c: Action.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
