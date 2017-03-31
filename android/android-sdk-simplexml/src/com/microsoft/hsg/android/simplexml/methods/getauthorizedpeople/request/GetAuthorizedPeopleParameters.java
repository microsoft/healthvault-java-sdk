package com.microsoft.hsg.android.simplexml.methods.getauthorizedpeople.request;

import java.math.BigInteger;
import java.util.Date;

import org.simpleframework.xml.Order;
import org.simpleframework.xml.Element;

/**
 * <p>Java class for GetAuthorizedPeopleParameters complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetAuthorizedPeopleParameters">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="person-id-cursor" type="{urn:com.microsoft.wc.types}guid" minOccurs="0"/>
 *         &lt;element name="authorizations-created-since" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="num-results" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@Order(elements = {
    "person-id-cursor",
    "authorizations-created-since",
    "num-results"
})
public class GetAuthorizedPeopleParameters {

    @Element(name = "person-id-cursor", required=false)
    protected String personIdCursor;

    @Element(name = "authorizations-created-since", required=false)
    protected Date authorizationsCreatedSince;

    @Element(name = "num-results", required=false)
    protected BigInteger numResults;

    /**
     * Gets the value of the personIdCursor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPersonIdCursor() {
        return personIdCursor;
    }

    /**
     * Sets the value of the personIdCursor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPersonIdCursor(String value) {
        this.personIdCursor = value;
    }

    /**
     * Gets the value of the authorizationsCreatedSince property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public Date getAuthorizationsCreatedSince() {
        return authorizationsCreatedSince;
    }

    /**
     * Sets the value of the authorizationsCreatedSince property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAuthorizationsCreatedSince(Date value) {
        this.authorizationsCreatedSince = value;
    }

    /**
     * Gets the value of the numResults property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumResults() {
        return numResults;
    }

    /**
     * Sets the value of the numResults property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumResults(BigInteger value) {
        this.numResults = value;
    }
}
