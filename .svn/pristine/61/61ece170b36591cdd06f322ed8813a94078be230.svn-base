package com.microsoft.hsg.android.simplexml.things.types.base;

import java.util.ArrayList;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Order;

/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:d="urn:com.microsoft.wc.dates" xmlns:t="urn:com.microsoft.wc.thing.types" xmlns:wct="urn:com.microsoft.wc.types"&gt;
 *                     A value that may have codes from one or more Microsoft 
 *                     Health vocabularies associated with it.
 *                 &lt;/summary&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;remarks xmlns="http://www.w3.org/2001/XMLSchema" xmlns:d="urn:com.microsoft.wc.dates" xmlns:t="urn:com.microsoft.wc.thing.types" xmlns:wct="urn:com.microsoft.wc.types"&gt;
 *                     A codable value represents a value that may reference a
 *                     coded value in one or more of the Microsoft Health 
 *                     vocabularies. Though it does not require the value to
 *                     be in a vocabulary.&lt;br/&gt;&lt;br/&gt;
 *                     For example, aerobic session data has a mode element
 *                     of type codable-value. Although many common forms of
 *                     aerobic session mode can be found in the Microsoft
 *                     Health Lexicon using the 'aerobic-activities' vocabulary,
 *                     not all possible activities can be found there. If the
 *                     activity does exist in the vocabulary it is recommended
 *                     that applications add the coded-value for that code as
 *                     a 'code' element and set the 'text' element to the 
 *                     display value for that code. If the activity does not
 *                     exist in the vocabulary the 'code' element should not
 *                     be specified and the 'text' element should contain the
 *                     data the user entered.&lt;br/&gt;&lt;br/&gt;
 *                   By using the coded-value when available the data can
 *                   be easily localized by Microsoft HealthVault and
 *                   can also be utilized by applications that are mining the
 *                   data based on certain code values.&lt;/remarks&gt;
 * </pre>
 * 
 * 
 * <p>Java class for codable-value complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="codable-value">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="code" type="{urn:com.microsoft.wc.thing.types}coded-value" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@Order(elements = {
    "text",
    "code"
})
public class CodableValue {
	
	@Element(required=true)
    protected String text;
    
    @ElementList(required=false, inline = true, entry="code")
    protected ArrayList<CodedValue> code;

	/**
	 * Instantiates a new codable value.
	 */
	public CodableValue()
	{
	}
	
	/**
	 * Instantiates a new codable value.
	 * 
	 * @param text the text
	 */
	public CodableValue(String text)
	{
		this.text = text;
	}
	
	/**
	 * Instantiates a new codable value.
	 * 
	 * @param text the text
	 * @param code the code
	 */
	public CodableValue(String text, CodedValue code)
	{
		this.text = text;
		this.getCode().add(code);
	}

    /**
     * Gets the value of the text property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the value of the text property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setText(String value) {
        this.text = value;
    }

    /**
     * Gets the value of the code property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the object.
     * This is why there is not a <CODE>set</CODE> method for the code property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CodedValue }
     * 
     * 
     */
    public ArrayList<CodedValue> getCode() {
        if (code == null) {
            code = new ArrayList<CodedValue>();
        }
        return this.code;
    }

}
