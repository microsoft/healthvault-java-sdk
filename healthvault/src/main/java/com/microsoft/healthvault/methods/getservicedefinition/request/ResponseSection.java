package com.microsoft.healthvault.methods.getservicedefinition.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.convert.Convert;

@Root(name = "section")
@Convert(ResponseSectionConverter.class)
public enum ResponseSection {

    PLATFORM("platform"),
    SHELL("shell"),
    TOPOLOGY("topology"),
    XML_OVER_HTTP_METHODS("xml-over-http-methods"),
    MEANINGFUL_USE("meaningful-use");

    private final String value;

    ResponseSection(String v) {
        value = v;
    }

    public String value() {
        return value.toLowerCase().replace('_', '-');
    }

    public static ResponseSection fromValue(String v) {
        for (ResponseSection c: ResponseSection.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
