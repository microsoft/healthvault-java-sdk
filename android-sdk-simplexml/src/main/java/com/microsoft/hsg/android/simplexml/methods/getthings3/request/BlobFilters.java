package com.microsoft.hsg.android.simplexml.methods.getthings3.request;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Order;

/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.methods.GetThings3" xmlns:wc-method-getthings="urn:com.microsoft.wc.methods.GetThings" xmlns:wc-thing="urn:com.microsoft.wc.thing" xmlns:wc-types="urn:com.microsoft.wc.types"/&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;remarks xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.methods.GetThings3" xmlns:wc-method-getthings="urn:com.microsoft.wc.methods.GetThings" xmlns:wc-thing="urn:com.microsoft.wc.thing" xmlns:wc-types="urn:com.microsoft.wc.types"/&gt;
 * </pre>
 * 
 * 
 * <p>Java class for BlobFilters complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BlobFilters">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="blob-filter" type="{urn:com.microsoft.wc.methods.GetThings3}BlobFilterSpec" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@Order(elements = {
    "blob-filter"
})
public class BlobFilters {

    @ElementList(entry = "blob-filter", required=true, inline=true)
    protected ArrayList<BlobFilterSpec> blobFilter;

    /**
     * Gets the value of the blobFilter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the object.
     * This is why there is not a <CODE>set</CODE> method for the blobFilter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBlobFilter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BlobFilterSpec }
     * 
     * 
     */
    public List<BlobFilterSpec> getBlobFilter() {
        if (blobFilter == null) {
            blobFilter = new ArrayList<BlobFilterSpec>();
        }
        return this.blobFilter;
    }

}
