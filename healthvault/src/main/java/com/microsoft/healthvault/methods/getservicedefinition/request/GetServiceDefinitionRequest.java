package com.microsoft.healthvault.methods.getservicedefinition.request;

import com.microsoft.healthvault.methods.request.HVMethodRequest;
import com.microsoft.healthvault.methods.request.HVRequestInfo;

import org.joda.time.Instant;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;

import java.util.Date;

@Root(name = "info")
@HVMethodRequest(methodName = "GetServiceDefinition", methodVersion="2")
@Order(elements = {
        "updated-date",
        "response-sections"
})
public class GetServiceDefinitionRequest implements HVRequestInfo {
    @Element(name = "updated-date", required = false)
    protected Date updatedDate;

    @Element(name="response-sections")
    protected ResponseSections responseSections;

    public ResponseSections getResponseSections() {
        return responseSections;
    }

    public void setResponseSections(ResponseSections responseSections) {
        this.responseSections = responseSections;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}
