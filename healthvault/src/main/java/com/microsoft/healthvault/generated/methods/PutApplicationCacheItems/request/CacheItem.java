//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.08 at 12:00:41 PM PDT 
//


package com.microsoft.healthvault.generated.methods.PutApplicationCacheItems.request;

import java.util.Date;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;


/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.methods.PutApplicationCacheItems" xmlns:wc-types="urn:com.microsoft.wc.types"&gt;
 *                     A cache item to be inserted or updated.
 *                 &lt;/summary&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;remarks xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.methods.PutApplicationCacheItems" xmlns:wc-types="urn:com.microsoft.wc.types"&gt;
 *                     When overwrite is false, and old data version identifier is not
 *                     specified, it will be inserted if an item with the same key does
 *                     not exist.  If an item with the same key already exists, the
 *                     new cache item is ignored and the response will not include the
 *                     key for it.
 * 
 *                     When overwrite is true, the item will be inserted if new, or an
 *                     existing item will be updated.  The response will include the
 *                     cache item key in both cases.
 * 
 *                     An old data version identifier may be specified, which allows
 *                     for optimistic concurrency control. The cache item will only
 *                     update an existing cache item with a matching key and only
 *                     if the specified old data version identifier matches the version
 *                     identifier for data currently cached.  Otherwise, if the version
 *                     identifiers do not match, or if the item does not exist, the
 *                     optimistic concurrency condition is considered not met, and the
 *                     operation is considered unsuccessful.
 * 
 *                     If overwrite is true, the old data version identifier must not
 *                     be specified.
 *                 &lt;/remarks&gt;
 * </pre>
 * 
 * 
 * <p>Java class for CacheItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CacheItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="time-to-live" type="{urn:com.microsoft.wc.methods.PutApplicationCacheItems}CacheItemTtl"/>
 *         &lt;element name="data" type="{urn:com.microsoft.wc.methods.PutApplicationCacheItems}CacheItemData"/>
 *       &lt;/sequence>
 *       &lt;attribute name="key" use="required" type="{urn:com.microsoft.wc.types}stringnz256" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@Root(name="")
@Order(elements = {
    "timeToLive",
    "data"
})
public class CacheItem {

    @Element(name = "time-to-live", required = true)
    protected CacheItemTtl timeToLive;
    @Element(required = true)
    protected CacheItemData data;
    @Element(name = "key", required = true)
    protected String key;

    /**
     * Gets the value of the timeToLive property.
     * 
     * @return
     *     possible object is
     *     {@link CacheItemTtl }
     *     
     */
    public CacheItemTtl getTimeToLive() {
        return timeToLive;
    }

    /**
     * Sets the value of the timeToLive property.
     * 
     * @param value
     *     allowed object is
     *     {@link CacheItemTtl }
     *     
     */
    public void setTimeToLive(CacheItemTtl value) {
        this.timeToLive = value;
    }

    /**
     * Gets the value of the data property.
     * 
     * @return
     *     possible object is
     *     {@link CacheItemData }
     *     
     */
    public CacheItemData getData() {
        return data;
    }

    /**
     * Sets the value of the data property.
     * 
     * @param value
     *     allowed object is
     *     {@link CacheItemData }
     *     
     */
    public void setData(CacheItemData value) {
        this.data = value;
    }

    /**
     * Gets the value of the key property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKey() {
        return key;
    }

    /**
     * Sets the value of the key property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKey(String value) {
        this.key = value;
    }

}
