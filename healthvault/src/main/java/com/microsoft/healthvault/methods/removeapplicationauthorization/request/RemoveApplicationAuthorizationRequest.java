package com.microsoft.healthvault.methods.removeapplicationauthorization.request;

import com.microsoft.healthvault.methods.request.HVMethodRequest;
import com.microsoft.healthvault.methods.request.HVRequestInfo;

import org.simpleframework.xml.Root;

@Root(name = "info")
@HVMethodRequest(methodName="RemoveApplicationAuthorization", methodVersion="1")
public class RemoveApplicationAuthorizationRequest implements HVRequestInfo {
}
