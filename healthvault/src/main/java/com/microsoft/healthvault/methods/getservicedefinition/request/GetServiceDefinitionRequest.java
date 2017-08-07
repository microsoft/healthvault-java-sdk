package com.microsoft.healthvault.methods.getservicedefinition.request;

import com.microsoft.healthvault.methods.request.HVMethodRequest;
import com.microsoft.healthvault.methods.request.HVRequestInfo;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "info")
@HVMethodRequest(methodName = "GetServiceDefinition", methodVersion="2")
@Order(elements = {
        "response-sections"
})
public class GetServiceDefinitionRequest implements HVRequestInfo {
    @Element(name="response-sections")
    protected ResponseSections responseSections;

    public ResponseSections getResponseSections() {
        return responseSections;
    }

    public void setResponseSections(ResponseSections responseSections) {
        this.responseSections = responseSections;
    }
}
