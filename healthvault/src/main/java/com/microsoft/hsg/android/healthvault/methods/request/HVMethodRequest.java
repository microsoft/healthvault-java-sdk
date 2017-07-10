/**
 * 
 */
package com.microsoft.hsg.android.healthvault.methods.request;

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
