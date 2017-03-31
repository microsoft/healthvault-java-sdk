/**
 * 
 */
package com.microsoft.hsg.android.simplexml.methods.request;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author robmay
 *
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface HVMethodRequest {
	String methodName();
	String methodVersion();
}
