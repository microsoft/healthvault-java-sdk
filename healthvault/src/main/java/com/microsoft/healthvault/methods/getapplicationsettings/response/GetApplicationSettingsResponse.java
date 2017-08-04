package com.microsoft.healthvault.methods.getapplicationsettings.response;

import com.microsoft.healthvault.methods.getauthorizedpeople.response.Status;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict=false, name="response")
public class GetApplicationSettingsResponse {

    @Element(required=true)
    private Status status;

    @Element(required=true)
    private GetApplicationSettingsResponseInfo info;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public GetApplicationSettingsResponseInfo getInfo() {
        return info;
    }

    public void setInfo(GetApplicationSettingsResponseInfo info) {
        this.info = info;
    }
}
