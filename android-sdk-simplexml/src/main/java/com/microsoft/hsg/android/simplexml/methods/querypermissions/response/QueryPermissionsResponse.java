package com.microsoft.hsg.android.simplexml.methods.querypermissions.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import com.microsoft.hsg.android.simplexml.methods.response.Response;

@Root(name = "response", strict=false)
public class QueryPermissionsResponse extends Response {

	@Element(name="info", required=true)
	private QueryPermissionsInfo info;
	
	public QueryPermissionsInfo getInfo() {
		return info;
	}
}
