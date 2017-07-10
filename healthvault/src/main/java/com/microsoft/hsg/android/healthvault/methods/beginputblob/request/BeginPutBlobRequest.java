package com.microsoft.hsg.android.healthvault.methods.beginputblob.request;

import org.simpleframework.xml.Root;

import com.microsoft.hsg.android.healthvault.methods.request.HVMethodRequest;
import com.microsoft.hsg.android.healthvault.methods.request.HVRequestInfo;

@Root(name = "info")
@HVMethodRequest(methodName="BeginPutBlob", methodVersion="1")
public class BeginPutBlobRequest implements HVRequestInfo{
}
