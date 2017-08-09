//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.08 at 12:00:41 PM PDT 
//


package com.microsoft.healthvault.generated.methods.GetDataConnectionsPrivileged.response;

import java.util.Date;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;
import java.util.ArrayList;
import java.util.List;


/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.methods.response.GetDataConnectionsPrivileged" xmlns:wc-dataConnection="urn:com.microsoft.wc.DataConnection" xmlns:wc-types="urn:com.microsoft.wc.types"&gt;
 *                     Data connection list.
 *                 &lt;/summary&gt;
 * </pre>
 * 
 * 
 * <p>Java class for DataConnections complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DataConnections">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="data-connection" type="{urn:com.microsoft.wc.methods.response.GetDataConnectionsPrivileged}DataConnection" maxOccurs="unbounded" minOccurs="0"/>
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
    "dataConnection"
})
public class DataConnections {

    @Element(name = "data-connection")
    protected List<DataConnection> dataConnection;

    /**
     * Gets the value of the dataConnection property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dataConnection property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDataConnection().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DataConnection }
     * 
     * 
     */
    public List<DataConnection> getDataConnection() {
        if (dataConnection == null) {
            dataConnection = new ArrayList<DataConnection>();
        }
        return this.dataConnection;
    }

}
