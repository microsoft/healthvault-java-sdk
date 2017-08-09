//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.08 at 12:00:41 PM PDT 
//


package com.microsoft.healthvault.generated.methods.GetDirectAddressesPrivileged.response;

import java.util.Date;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;
import com.microsoft.healthvault.generated.core.direct.DirectAddressList;


/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.methods.response.GetDirectAddressesPrivileged" xmlns:wc-direct="urn:com.microsoft.wc.direct"&gt;
 *                         The element of the response that contains the method
 *                         specific return value(s).
 *                     &lt;/summary&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;remarks xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.methods.response.GetDirectAddressesPrivileged" xmlns:wc-direct="urn:com.microsoft.wc.direct"&gt;
 *                         All response schemas contain the info element which 
 *                         contain the return value of the method. If the method 
 *                         does not define an info element, the method has no
 *                         return value.
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
 *         &lt;element name="direct-address-list" type="{urn:com.microsoft.wc.direct}DirectAddressList"/>
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
    "directAddressList"
})
public class GetDirectAddressesPrivilegedResponse {

    @Element(name = "direct-address-list", required = true)
    protected DirectAddressList directAddressList;

    /**
     * Gets the value of the directAddressList property.
     * 
     * @return
     *     possible object is
     *     {@link DirectAddressList }
     *     
     */
    public DirectAddressList getDirectAddressList() {
        return directAddressList;
    }

    /**
     * Sets the value of the directAddressList property.
     * 
     * @param value
     *     allowed object is
     *     {@link DirectAddressList }
     *     
     */
    public void setDirectAddressList(DirectAddressList value) {
        this.directAddressList = value;
    }

}
