//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.08 at 12:00:41 PM PDT 
//


package com.microsoft.healthvault.generated.methods.QueryPersons2.response;

import java.util.Date;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;


/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.methods.response.QueryPersons2" xmlns:wc-person="urn:com.microsoft.wc.person" xmlns:wc-types="urn:com.microsoft.wc.types"/&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;remarks xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.methods.response.QueryPersons2" xmlns:wc-person="urn:com.microsoft.wc.person" xmlns:wc-types="urn:com.microsoft.wc.types"/&gt;
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
 *         &lt;element name="query-person-infos" type="{urn:com.microsoft.wc.methods.response.QueryPersons2}QueryPersonInfos" minOccurs="0"/>
 *         &lt;element name="query-persons-cursor" type="{urn:com.microsoft.wc.types}stringnz" minOccurs="0"/>
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
    "queryPersonInfos",
    "queryPersonsCursor"
})
public class QueryPersons2Response {

    @Element(name = "query-person-infos")
    protected QueryPersonInfos queryPersonInfos;
    @Element(name = "query-persons-cursor")
    protected String queryPersonsCursor;

    /**
     * Gets the value of the queryPersonInfos property.
     * 
     * @return
     *     possible object is
     *     {@link QueryPersonInfos }
     *     
     */
    public QueryPersonInfos getQueryPersonInfos() {
        return queryPersonInfos;
    }

    /**
     * Sets the value of the queryPersonInfos property.
     * 
     * @param value
     *     allowed object is
     *     {@link QueryPersonInfos }
     *     
     */
    public void setQueryPersonInfos(QueryPersonInfos value) {
        this.queryPersonInfos = value;
    }

    /**
     * Gets the value of the queryPersonsCursor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQueryPersonsCursor() {
        return queryPersonsCursor;
    }

    /**
     * Sets the value of the queryPersonsCursor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQueryPersonsCursor(String value) {
        this.queryPersonsCursor = value;
    }

}
