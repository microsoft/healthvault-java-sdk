//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.11.03 at 08:22:44 PM PST 
//


package com.microsoft.hsg.methods.jaxb.vocab;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.vocab" xmlns:wc-types="urn:com.microsoft.wc.types"&gt;
 *                     Defines a collection of mappings from one vocabulary to another.
 *                 &lt;/summary&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;remarks xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.vocab" xmlns:wc-types="urn:com.microsoft.wc.types"/&gt;
 * </pre>
 * 
 * 
 * <p>Java class for vocabulary-mapping complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="vocabulary-mapping">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="vocabulary-mapping-item" type="{urn:com.microsoft.wc.vocab}vocabulary-mapping-item" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "vocabulary-mapping", propOrder = {
    "vocabularyMappingItem"
})
public class VocabularyMapping {

    @XmlElement(name = "vocabulary-mapping-item")
    protected List<VocabularyMappingItem> vocabularyMappingItem;

    /**
     * Gets the value of the vocabularyMappingItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vocabularyMappingItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVocabularyMappingItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VocabularyMappingItem }
     * 
     * 
     */
    public List<VocabularyMappingItem> getVocabularyMappingItem() {
        if (vocabularyMappingItem == null) {
            vocabularyMappingItem = new ArrayList<VocabularyMappingItem>();
        }
        return this.vocabularyMappingItem;
    }

}