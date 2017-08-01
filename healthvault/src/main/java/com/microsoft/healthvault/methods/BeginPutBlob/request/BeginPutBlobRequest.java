package com.microsoft.healthvault.methods.BeginPutBlob.request;

import com.microsoft.healthvault.client.request.HVMethodRequest;
import com.microsoft.healthvault.client.request.HVRequestInfo;

import org.simpleframework.xml.Root;

@Root(name = "info")
@HVMethodRequest(methodName="BeginPutBlob", methodVersion="1")
public class BeginPutBlobRequest implements HVRequestInfo {
}