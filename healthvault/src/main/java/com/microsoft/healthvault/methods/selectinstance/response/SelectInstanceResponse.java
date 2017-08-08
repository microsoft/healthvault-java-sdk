package com.microsoft.healthvault.methods.selectinstance.response;

import com.microsoft.healthvault.methods.getservicedefinition.response.GetServiceDefinitionResponseInfo;
import com.microsoft.healthvault.methods.response.Response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "response", strict=false)
public class SelectInstanceResponse extends Response {
    @Element(required=true)
    private SelectInstanceResponseInfo info;

    public SelectInstanceResponseInfo getInfo() {
        return info;
    }

    public void setInfo(SelectInstanceResponseInfo info) {
        this.info = info;
    }
}


