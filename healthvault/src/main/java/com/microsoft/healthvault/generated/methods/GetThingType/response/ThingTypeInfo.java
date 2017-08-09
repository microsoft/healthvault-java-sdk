//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.08 at 12:00:41 PM PDT 
//


package com.microsoft.healthvault.generated.methods.GetThingType.response;

import java.util.Date;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;
import java.util.ArrayList;
import java.util.List;


/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.methods.response.GetThingType" xmlns:wc-types="urn:com.microsoft.wc.types"&gt;
 *                     Describes the information related to a thing type
 *                 &lt;/summary&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;remarks xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.methods.response.GetThingType" xmlns:wc-types="urn:com.microsoft.wc.types"/&gt;
 * </pre>
 * 
 * 
 * <p>Java class for ThingTypeInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ThingTypeInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{urn:com.microsoft.wc.types}guid"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="uncreatable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="immutable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="singleton" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="xsd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="columns" type="{urn:com.microsoft.wc.methods.response.GetThingType}Columns" minOccurs="0"/>
 *         &lt;element name="transforms" type="{urn:com.microsoft.wc.methods.response.GetThingType}Transforms" minOccurs="0"/>
 *         &lt;element name="transform-source" type="{urn:com.microsoft.wc.methods.response.GetThingType}TransformSource" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="image" type="{urn:com.microsoft.wc.methods.response.GetThingType}Image" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="versions" type="{urn:com.microsoft.wc.methods.response.GetThingType}Versions" minOccurs="0"/>
 *         &lt;element name="effective-date-xpath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="updated-end-date-xpath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="allow-readonly" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
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
    "id",
    "name",
    "uncreatable",
    "immutable",
    "singleton",
    "xsd",
    "columns",
    "transforms",
    "transformSource",
    "image",
    "versions",
    "effectiveDateXpath",
    "updatedEndDateXpath",
    "allowReadonly"
})
public class ThingTypeInfo {

    @Element(required = true)
    protected String id;
    @Element(required = true)
    protected String name;
    protected Boolean uncreatable;
    protected Boolean immutable;
    protected Boolean singleton;
    protected String xsd;
    protected Columns columns;
    protected Transforms transforms;
    @Element(name = "transform-source")
    protected List<TransformSource> transformSource;
    protected List<Image> image;
    protected Versions versions;
    @Element(name = "effective-date-xpath")
    protected String effectiveDateXpath;
    @Element(name = "updated-end-date-xpath")
    protected String updatedEndDateXpath;
    @Element(name = "allow-readonly")
    protected Boolean allowReadonly;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the uncreatable property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isUncreatable() {
        return uncreatable;
    }

    /**
     * Sets the value of the uncreatable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setUncreatable(Boolean value) {
        this.uncreatable = value;
    }

    /**
     * Gets the value of the immutable property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isImmutable() {
        return immutable;
    }

    /**
     * Sets the value of the immutable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setImmutable(Boolean value) {
        this.immutable = value;
    }

    /**
     * Gets the value of the singleton property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSingleton() {
        return singleton;
    }

    /**
     * Sets the value of the singleton property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSingleton(Boolean value) {
        this.singleton = value;
    }

    /**
     * Gets the value of the xsd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXsd() {
        return xsd;
    }

    /**
     * Sets the value of the xsd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXsd(String value) {
        this.xsd = value;
    }

    /**
     * Gets the value of the columns property.
     * 
     * @return
     *     possible object is
     *     {@link Columns }
     *     
     */
    public Columns getColumns() {
        return columns;
    }

    /**
     * Sets the value of the columns property.
     * 
     * @param value
     *     allowed object is
     *     {@link Columns }
     *     
     */
    public void setColumns(Columns value) {
        this.columns = value;
    }

    /**
     * Gets the value of the transforms property.
     * 
     * @return
     *     possible object is
     *     {@link Transforms }
     *     
     */
    public Transforms getTransforms() {
        return transforms;
    }

    /**
     * Sets the value of the transforms property.
     * 
     * @param value
     *     allowed object is
     *     {@link Transforms }
     *     
     */
    public void setTransforms(Transforms value) {
        this.transforms = value;
    }

    /**
     * Gets the value of the transformSource property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the transformSource property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTransformSource().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TransformSource }
     * 
     * 
     */
    public List<TransformSource> getTransformSource() {
        if (transformSource == null) {
            transformSource = new ArrayList<TransformSource>();
        }
        return this.transformSource;
    }

    /**
     * Gets the value of the image property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the image property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Image }
     * 
     * 
     */
    public List<Image> getImage() {
        if (image == null) {
            image = new ArrayList<Image>();
        }
        return this.image;
    }

    /**
     * Gets the value of the versions property.
     * 
     * @return
     *     possible object is
     *     {@link Versions }
     *     
     */
    public Versions getVersions() {
        return versions;
    }

    /**
     * Sets the value of the versions property.
     * 
     * @param value
     *     allowed object is
     *     {@link Versions }
     *     
     */
    public void setVersions(Versions value) {
        this.versions = value;
    }

    /**
     * Gets the value of the effectiveDateXpath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEffectiveDateXpath() {
        return effectiveDateXpath;
    }

    /**
     * Sets the value of the effectiveDateXpath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEffectiveDateXpath(String value) {
        this.effectiveDateXpath = value;
    }

    /**
     * Gets the value of the updatedEndDateXpath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUpdatedEndDateXpath() {
        return updatedEndDateXpath;
    }

    /**
     * Sets the value of the updatedEndDateXpath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUpdatedEndDateXpath(String value) {
        this.updatedEndDateXpath = value;
    }

    /**
     * Gets the value of the allowReadonly property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAllowReadonly() {
        return allowReadonly;
    }

    /**
     * Sets the value of the allowReadonly property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAllowReadonly(Boolean value) {
        this.allowReadonly = value;
    }

}
