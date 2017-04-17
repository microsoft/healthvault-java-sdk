package com.microsoft.hsg.android.simplexml.methods.getauthorizedpeople.request;

import org.simpleframework.xml.Order;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import com.microsoft.hsg.android.simplexml.methods.request.HVMethodRequest;
import com.microsoft.hsg.android.simplexml.methods.request.HVRequestInfo;

/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.methods.GetAuthorizedPeople" xmlns:wc-types="urn:com.microsoft.wc.types"&gt;
 *             The element of the request that contains the method
 *             specific parameters.
 *           &lt;/summary&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;remarks xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.methods.GetAuthorizedPeople" xmlns:wc-types="urn:com.microsoft.wc.types"&gt;
 *             All requests contain the info element to pass parameters
 *             that are specific to each method. If the method does not
 *             define an info element, the method does not take any
 *             parameters.
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
 *         &lt;element name="parameters" type="{urn:com.microsoft.wc.methods.GetAuthorizedPeople}GetAuthorizedPeopleParameters"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@Root(name = "info")
@HVMethodRequest(methodName="GetAuthorizedPeople", methodVersion="1")
@Order(elements = {
    "parameters"
})
public class GetAuthorizedPeopleRequest 
	implements HVRequestInfo {

    @Element(required = true)
    protected GetAuthorizedPeopleParameters parameters;

    /**
     * Gets the value of the parameters property.
     * 
     * @return
     *     possible object is
     *     {@link GetAuthorizedPeopleParameters }
     *     
     */
    public GetAuthorizedPeopleParameters getParameters() {
        return parameters;
    }
    
    public GetAuthorizedPeopleRequest(GetAuthorizedPeopleParameters parameters) {
    	this.parameters = parameters;
    }

    /**
     * Sets the value of the parameters property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetAuthorizedPeopleParameters }
     *     
     */
    public void setParameters(GetAuthorizedPeopleParameters value) {
        this.parameters = value;
    }
}
