package com.microsoft.healthvault.methods.querypermissions.response;

import com.microsoft.healthvault.methods.response.Response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "response", strict=false)
public class QueryPermissionsResponse extends Response {

	@Element(name="info", required=true)
	private QueryPermissionsInfo info;
	
	public QueryPermissionsInfo getInfo() {
		return info;
	}
}
