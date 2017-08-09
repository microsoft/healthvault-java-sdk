//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.08 at 12:00:41 PM PDT 
//


package com.microsoft.healthvault.generated.methods.GetServiceDefinition2.response;

import java.util.Date;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;
import java.util.ArrayList;
import java.util.List;
import com.microsoft.healthvault.generated.types.Instance;


/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.methods.response.GetServiceDefinition2" xmlns:wc-types="urn:com.microsoft.wc.types"&gt;
 *                     Information about each of the HealthVault instances in the
 *                     global HealthVault ecosystem.
 *                 &lt;/summary&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;remarks xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.methods.response.GetServiceDefinition2" xmlns:wc-types="urn:com.microsoft.wc.types"&gt;
 *                     An instance is a single deployment of HealthVault services
 *                     and health record storage primarily for users from a
 *                     particular region or constituent population.
 *                 &lt;/remarks&gt;
 * </pre>
 * 
 * 
 * <p>Java class for InstanceList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InstanceList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="instance" type="{urn:com.microsoft.wc.types}Instance" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="current-instance-id" type="{urn:com.microsoft.wc.types}string255nw" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@Root(name="")
@Order(elements = {
    "instance"
})
public class InstanceList {

    @Element(required = true)
    protected List<Instance> instance;
    @Element(name = "current-instance-id")
    protected String currentInstanceId;

    /**
     * Gets the value of the instance property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the instance property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInstance().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Instance }
     * 
     * 
     */
    public List<Instance> getInstance() {
        if (instance == null) {
            instance = new ArrayList<Instance>();
        }
        return this.instance;
    }

    /**
     * Gets the value of the currentInstanceId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrentInstanceId() {
        return currentInstanceId;
    }

    /**
     * Sets the value of the currentInstanceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentInstanceId(String value) {
        this.currentInstanceId = value;
    }

}
