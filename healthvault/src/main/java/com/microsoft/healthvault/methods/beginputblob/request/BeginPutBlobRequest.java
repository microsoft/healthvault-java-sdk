package com.microsoft.healthvault.methods.beginputblob.request;

import com.microsoft.healthvault.methods.request.HVMethodRequest;
import com.microsoft.healthvault.methods.request.HVRequestInfo;

import org.simpleframework.xml.Root;

@Root(name = "info")
@HVMethodRequest(methodName="BeginPutBlob", methodVersion="1")
public class BeginPutBlobRequest implements HVRequestInfo{
}
