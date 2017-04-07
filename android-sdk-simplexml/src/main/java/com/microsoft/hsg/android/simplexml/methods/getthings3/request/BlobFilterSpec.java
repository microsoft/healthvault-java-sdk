package com.microsoft.hsg.android.simplexml.methods.getthings3.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;

/**
 * <p>Java class for BlobFilterSpec complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BlobFilterSpec">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="blob-name" type="{urn:com.microsoft.wc.types}stringnwz64"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@Order(elements = {
    "blob-name"
})
public class BlobFilterSpec {

    @Element(name = "blob-name", required = true)
    protected String blobName;

    /**
     * Gets the value of the blobName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBlobName() {
        return blobName;
    }

    /**
     * Sets the value of the blobName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBlobName(String value) {
        this.blobName = value;
    }
}
