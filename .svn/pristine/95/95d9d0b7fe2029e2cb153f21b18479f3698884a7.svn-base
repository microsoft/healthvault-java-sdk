/*
 * Copyright 2011 Microsoft Corp.
 * 
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.microsoft.hsg.android.simplexml.methods.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;

@Order(elements = {
	"message",
	"context",
	"error-info"
})

public class ServerError {
	
	@Element
	protected String message;
	
	@Element(required=false)
	protected ServerErrorContext context;
	
	@Element(name="error-info", required=false)
	protected String errorInfo;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ServerErrorContext getContext() {
		return context;
	}

	public void setContext(ServerErrorContext context) {
		this.context = context;
	}

	public String getErrorInfo() {
		return errorInfo;
	}

	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}
}
