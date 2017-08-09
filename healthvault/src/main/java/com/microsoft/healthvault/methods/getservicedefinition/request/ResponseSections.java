package com.microsoft.healthvault.methods.getservicedefinition.request;

import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementMap;

import java.util.List;


public class ResponseSections {
    @ElementList(name="response-sections", inline = true)
    List<ResponseSection> sections;

    public List<ResponseSection> getSections() {
        return sections;
    }

    public void setSections(List<ResponseSection> sections) {
        this.sections = sections;
    }
}
