//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.11.03 at 08:13:46 PM PST 
//


package com.microsoft.hsg.methods.jaxb.getthings.request;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.microsoft.hsg.methods.jaxb.getthings.request package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.microsoft.hsg.methods.jaxb.getthings.request
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ThingFilterSpec }
     * 
     */
    public ThingFilterSpec createThingFilterSpec() {
        return new ThingFilterSpec();
    }

    /**
     * Create an instance of {@link ThingRequestGroup }
     * 
     */
    public ThingRequestGroup createThingRequestGroup() {
        return new ThingRequestGroup();
    }

    /**
     * Create an instance of {@link ThingFormatSpec }
     * 
     */
    public ThingFormatSpec createThingFormatSpec() {
        return new ThingFormatSpec();
    }

    /**
     * Create an instance of {@link GetThingsRequest }
     * 
     */
    public GetThingsRequest createInfo() {
        return new GetThingsRequest();
    }

}