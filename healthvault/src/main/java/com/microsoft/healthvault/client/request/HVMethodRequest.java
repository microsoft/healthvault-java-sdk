package com.microsoft.healthvault.client.request;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface HVMethodRequest {
    String methodName();
    String methodVersion();
}