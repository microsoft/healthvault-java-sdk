package com.microsoft.hsg.android.simplexml.methods.removeapplicationauthorization.request;

import org.simpleframework.xml.Root;

import com.microsoft.hsg.android.simplexml.methods.request.HVMethodRequest;
import com.microsoft.hsg.android.simplexml.methods.request.HVRequestInfo;

@Root(name = "info")
@HVMethodRequest(methodName="RemoveApplicationAuthorization", methodVersion="1")
public class RemoveApplicationAuthorizationRequest implements HVRequestInfo {
}
