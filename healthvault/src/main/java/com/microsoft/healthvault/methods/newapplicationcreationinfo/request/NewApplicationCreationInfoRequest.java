package com.microsoft.healthvault.methods.newapplicationcreationinfo.request;

import com.microsoft.healthvault.methods.request.HVMethodRequest;
import com.microsoft.healthvault.methods.request.HVRequestInfo;

import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;


@Root(name = "info")
@HVMethodRequest(methodName = "NewApplicationCreationInfo", methodVersion = "1")
public class NewApplicationCreationInfoRequest implements HVRequestInfo {

}
