package com.microsoft.hsg.android.simplexml.methods.getauthorizedpeople.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict=false, name="response")
public class GetAuthorizedPeopleResponse {

    @Element(required=true)
    private Status status;

    @Element(required=true)
    private GetAuthorizedPeopleResponseInfo info;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public GetAuthorizedPeopleResponseInfo getInfo() {
        return info;
    }

    public void setInfo(GetAuthorizedPeopleResponseInfo info) {
        this.info = info;
    }
}
