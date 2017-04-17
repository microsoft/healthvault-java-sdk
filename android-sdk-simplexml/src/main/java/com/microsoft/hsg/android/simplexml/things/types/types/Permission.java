package com.microsoft.hsg.android.simplexml.things.types.types;

/**
 * <p>Java class for Permission.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Permission">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="All"/>
 *     &lt;enumeration value="Read"/>
 *     &lt;enumeration value="Update"/>
 *     &lt;enumeration value="Create"/>
 *     &lt;enumeration value="Delete"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
public enum Permission {

    All,
    Read,
    Update,
    Create,
    Delete
}
