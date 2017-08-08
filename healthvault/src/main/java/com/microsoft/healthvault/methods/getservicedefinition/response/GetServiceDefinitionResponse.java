package com.microsoft.healthvault.methods.getservicedefinition.response;

import com.microsoft.healthvault.methods.response.Response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;

@Root(name = "response", strict=false)
public class GetServiceDefinitionResponse extends Response {
    @Element(required=true)
    private GetServiceDefinitionResponseInfo info;

    public GetServiceDefinitionResponseInfo getInfo() {
        return info;
    }

    public void setInfo(GetServiceDefinitionResponseInfo info) {
        this.info = info;
    }
}


