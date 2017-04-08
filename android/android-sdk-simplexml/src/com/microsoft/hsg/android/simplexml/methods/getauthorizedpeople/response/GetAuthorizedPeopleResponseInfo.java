package com.microsoft.hsg.android.simplexml.methods.getauthorizedpeople.response;

import org.simpleframework.xml.Order;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.methods.response.GetAuthorizedPeople" xmlns:wc-types="urn:com.microsoft.wc.types"&gt;
 *             The element of the response that contains the method
 *             specific return value(s).
 *           &lt;/summary&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;remarks xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.methods.response.GetAuthorizedPeople" xmlns:wc-types="urn:com.microsoft.wc.types"&gt;
 *             All response schemas contain the info element which
 *             contain the return value of the method. If the method
 *             does not define an info element, the method has no
 *             return value.
 *           &lt;/remarks&gt;
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
 *         &lt;element name="response-results" type="{urn:com.microsoft.wc.methods.response.GetAuthorizedPeople}GetAuthorizedPeopleResponse"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@Root(name="info")
@Order(elements = {
    "response-results"
})
public class GetAuthorizedPeopleResponseInfo {

    @Element(name = "response-results", required = true)
    protected GetAuthorizedPeopleResponseResults responseResults;

    /**
     * Gets the value of the responseResults property.
     * 
     * @return
     *     possible object is
     *     {@link GetAuthorizedPeopleResponseResults }
     *     
     */
    public GetAuthorizedPeopleResponseResults getResponseResults() {
        return responseResults;
    }

    /**
     * Sets the value of the responseResults property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetAuthorizedPeopleResponseResults }
     *     
     */
    public void setResponseResults(GetAuthorizedPeopleResponseResults value) {
        this.responseResults = value;
    }
}
