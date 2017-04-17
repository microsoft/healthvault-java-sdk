package com.microsoft.hsg.android.simplexml.things.thing;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URISyntaxException;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;

import com.microsoft.hsg.android.simplexml.things.types.types.Record;

/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:d="urn:com.microsoft.wc.dates" xmlns:ds="" xmlns:this="urn:com.microsoft.wc.thing" xmlns:wc-auth="urn:com.microsoft.wc.auth" xmlns:wc-types="urn:com.microsoft.wc.types"/&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;remarks xmlns="http://www.w3.org/2001/XMLSchema" xmlns:d="urn:com.microsoft.wc.dates" xmlns:ds="" xmlns:this="urn:com.microsoft.wc.thing" xmlns:wc-auth="urn:com.microsoft.wc.auth" xmlns:wc-types="urn:com.microsoft.wc.types"/&gt;
 * </pre>
 * 
 * 
 * <p>Java class for BlobPayloadItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BlobPayloadItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="blob-info" type="{urn:com.microsoft.wc.thing}BlobInfo"/>
 *         &lt;element name="content-length" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;choice minOccurs="0">
 *           &lt;element name="base64data" type="{urn:com.microsoft.wc.types}stringnz"/>
 *           &lt;element name="blob-ref-url" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *         &lt;/choice>
 *         &lt;element name="legacy-content-encoding" type="{urn:com.microsoft.wc.types}stringz1024" minOccurs="0"/>
 *         &lt;element name="current-content-encoding" type="{urn:com.microsoft.wc.types}stringz1024" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@Order(elements = {
    "blob-info",
    "content-length",
    "base64data",
    "blob-ref-url",
    "legacy-content-encoding",
    "current-content-encoding"
})
public class BlobPayloadItem {

    @Element(name = "blob-info", required = true)
    protected BlobInfo blobInfo;

    @Element(name = "content-length", required=false)
    protected Long contentLength;

    @Element(name = "base64data", required=false)
    protected String base64Data;

    @Element(name = "blob-ref-url", required=false)
    protected String blobRefUrl;

    @Element(name = "legacy-content-encoding", required=false)
    protected String legacyContentEncoding;

    @Element(name = "current-content-encoding", required=false)
    protected String currentContentEncoding;

    /**
     * Gets the value of the blobInfo property.
     * 
     * @return
     *     possible object is
     *     {@link BlobInfo }
     *     
     */
    public BlobInfo getBlobInfo() {
        return blobInfo;
    }

    /**
     * Sets the value of the blobInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link BlobInfo }
     *     
     */
    public void setBlobInfo(BlobInfo value) {
        this.blobInfo = value;
    }

    /**
     * Gets the value of the contentLength property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getContentLength() {
        return contentLength;
    }

    /**
     * Sets the value of the contentLength property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setContentLength(Long value) {
        this.contentLength = value;
    }

    /**
     * Gets the value of the base64Data property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBase64Data() {
        return base64Data;
    }

    /**
     * Sets the value of the base64Data property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBase64Data(String value) {
        this.base64Data = value;
    }

    /**
     * Gets the value of the blobRefUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBlobRefUrl() {
        return blobRefUrl;
    }

    /**
     * Sets the value of the blobRefUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBlobRefUrl(String value) {
        this.blobRefUrl = value;
    }

    /**
     * Gets the value of the legacyContentEncoding property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLegacyContentEncoding() {
        return legacyContentEncoding;
    }

    /**
     * Sets the value of the legacyContentEncoding property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLegacyContentEncoding(String value) {
        this.legacyContentEncoding = value;
    }

    /**
     * Gets the value of the currentContentEncoding property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrentContentEncoding() {
        return currentContentEncoding;
    }

    /**
     * Sets the value of the currentContentEncoding property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentContentEncoding(String value) {
        this.currentContentEncoding = value;
    }
    
    public String getName() {
    	return blobInfo != null ? blobInfo.getName() : "";
    }
    
    public void download(Record record, OutputStream destination) throws URISyntaxException, IOException {
    	record.downloadBlob(this, destination);
    }
}
