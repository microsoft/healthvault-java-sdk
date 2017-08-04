package com.microsoft.healthvault.methods.getapplicationsettings.request;

import com.microsoft.healthvault.methods.request.HVMethodRequest;
import com.microsoft.healthvault.methods.request.HVRequestInfo;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;

@Root(name = "info")
@HVMethodRequest(methodName="GetApplicationSettings", methodVersion="1")
public class GetApplicationSettingsRequest
        implements HVRequestInfo {
}
