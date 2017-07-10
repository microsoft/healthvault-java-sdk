/*
 *  Copyright (c) Microsoft Corporation
 *
 *	All rights reserved. 
 *
 *	MIT License
 *	Permission is hereby granted, free of charge, to any person obtaining a copy of this software
 *  and associated documentation files (the ""Software""), to deal in the Software without
 *  restriction, including without limitation the rights to use, copy, modify, merge, publish,
 *  distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom
 *  the Software is furnished to do so, subject to the following conditions:
 *
 *	The above copyright notice and this permission notice shall be included in all copies or
 *  substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED *AS IS*, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING
 *  BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 *  NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 *  DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.microsoft.hsg.android.healthvault.methods.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;

import com.microsoft.hsg.android.healthvault.ServerStatusCode;

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
