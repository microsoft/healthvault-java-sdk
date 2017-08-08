package com.microsoft.healthvault.methods.newapplicationcreationinfo.response;

import com.microsoft.healthvault.methods.getservicedefinition.response.GetServiceDefinitionResponseInfo;
import com.microsoft.healthvault.methods.response.Response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "response", strict=false)
public class NewApplicationCreationInfoResponse extends Response {
    @Element(required=true)
    private NewApplicationCreationInfoResponseInfo info;

    public NewApplicationCreationInfoResponseInfo getInfo() {
        return info;
    }

    public void setInfo(NewApplicationCreationInfoResponseInfo info) {
        this.info = info;
    }
}


