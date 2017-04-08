package com.microsoft.hsg.android.simplexml.methods.getthings3.request;

import org.simpleframework.xml.Element;
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
 * <p>Java class for BlobPayloadRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BlobPayloadRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="blob-filters" type="{urn:com.microsoft.wc.methods.GetThings3}BlobFilters" minOccurs="0"/>
 *         &lt;element name="blob-format">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="blob-format-spec" type="{urn:com.microsoft.wc.methods.GetThings3}BlobFormatSpec"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@Order(elements = {
    "blob-filters",
    "blob-format"
})
public class BlobPayloadRequest {

    @Element(name = "blob-filters", required=false)
    protected BlobFilters blobFilters;

    @Element(name = "blob-format", required = true)
    protected BlobPayloadRequest.BlobFormat blobFormat;

    /**
     * Gets the value of the blobFilters property.
     * 
     * @return
     *     possible object is
     *     {@link BlobFilters }
     *     
     */
    public BlobFilters getBlobFilters() {
        return blobFilters;
    }

    /**
     * Sets the value of the blobFilters property.
     * 
     * @param value
     *     allowed object is
     *     {@link BlobFilters }
     *     
     */
    public void setBlobFilters(BlobFilters value) {
        this.blobFilters = value;
    }

    /**
     * Gets the value of the blobFormat property.
     * 
     * @return
     *     possible object is
     *     {@link BlobPayloadRequest.BlobFormat }
     *     
     */
    public BlobPayloadRequest.BlobFormat getBlobFormat() {
        return blobFormat;
    }

    /**
     * Sets the value of the blobFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link BlobPayloadRequest.BlobFormat }
     *     
     */
    public void setBlobFormat(BlobPayloadRequest.BlobFormat value) {
        this.blobFormat = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="blob-format-spec" type="{urn:com.microsoft.wc.methods.GetThings3}BlobFormatSpec"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @Order(elements = {
        "blob-format-spec"
    })
    public static class BlobFormat {

        @Element(name = "blob-format-spec", required = true)
        protected BlobFormatSpec blobFormatSpec;

        /**
         * Gets the value of the blobFormatSpec property.
         * 
         * @return
         *     possible object is
         *     {@link BlobFormatSpec }
         *     
         */
        public BlobFormatSpec getBlobFormatSpec() {
            return blobFormatSpec;
        }

        /**
         * Sets the value of the blobFormatSpec property.
         * 
         * @param value
         *     allowed object is
         *     {@link BlobFormatSpec }
         *     
         */
        public void setBlobFormatSpec(BlobFormatSpec value) {
            this.blobFormatSpec = value;
        }

    }

}
