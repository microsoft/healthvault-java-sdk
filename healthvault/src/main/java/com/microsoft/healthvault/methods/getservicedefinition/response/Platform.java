package com.microsoft.healthvault.methods.getservicedefinition.response;


import org.simpleframework.xml.Default;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Order;

import java.util.ArrayList;
import java.util.List;

@Order(elements = {
        "url",
        "version",
        "configuration"
})

public class Platform {

    @Element(required = true)
    protected String url;
    @Element(required = true)
    protected String version;
    @ElementList(name="configuration", inline = true)
    protected ArrayList<ConfigurationEntry> configuration;

    /**
     * Gets the value of the url property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the value of the url property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setUrl(String value) {
        this.url = value;
    }

    /**
     * Gets the value of the version property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Gets the value of the configuration property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the configuration property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConfiguration().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ConfigurationEntry }
     *
     *
     */
    public List<ConfigurationEntry> getConfiguration() {
        if (configuration == null) {
            configuration = new ArrayList<ConfigurationEntry>();
        }
        return this.configuration;
    }

}
