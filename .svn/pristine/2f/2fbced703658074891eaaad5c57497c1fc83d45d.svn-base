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
import org.simpleframework.xml.Root;

import com.microsoft.hsg.android.simplexml.ServerStatusCode;

@Order(elements = {
	"code",
	"error"
})

@Root(name="status")
public class ResponseStatus {

	@Element(name="code", required=true)
	protected int statusCode;
	
	@Element(name="error", required=false)
	protected ServerError error;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public ServerError getError() {
		return error;
	}

	public void setError(ServerError error) {
		this.error = error;
	}
	
	public Boolean hasError() 
	{
		return statusCode !=0 || error != null;
	}
	
	public Boolean isStatusCredentialsExpired() 
	{
		return statusCode == ServerStatusCode.AuthenticatedSessionTokenExpired.getStatus();
	}
	
	public Boolean isStatusInvalidOnlineToken() 
	{
		return statusCode == ServerStatusCode.CredentialTokenExpired.getStatus();
	}
	
	public Boolean isStatusServerFailure() 
	{
		return statusCode == ServerStatusCode.Failed.getStatus() ||
		    statusCode == ServerStatusCode.RequestTimedOut.getStatus();
	}
	
	public Boolean isStatusAccessDenied() 
	{
		return statusCode == ServerStatusCode.AccessDenied.getStatus() ||
			statusCode == ServerStatusCode.InvalidApp.getStatus();
	}
}
