/**
 * 
 */
package com.microsoft.hsg.methods.jaxb;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author robmay
 *
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface JaxbRequest {
	String methodName();
	String methodVersion();
	String responseNS();
}
