package com.microsoft.hsg.android.simplexml.test;

import com.microsoft.hsg.android.simplexml.HealthVaultApp.ConnectionStatus;
import com.microsoft.hsg.android.simplexml.HealthVaultSettings;

public class HVSettings implements HealthVaultSettings {
	
	private String appId;
	private String authSecret;

	@Override
	public boolean getIsMultiInstanceAware() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setIsMultiInstanceAware(boolean isAware) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getServiceUrl() {
		return "https://platform.healthvault-ppe.com/platform/wildcat.ashx";
	}

	@Override
	public void setServiceUrl(String url) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getShellUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setShellUrl(String url) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getAppId() {
		return appId;
	}

	@Override
	public void setAppId(String appid) {
		this.appId = appid;
	}

	@Override
	public String getMasterAppId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMasterAppId(String appId) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getAuthenticationSecret() {
		return this.authSecret;
	}

	@Override
	public void setAuthenticationSecret(String secret) {
		this.authSecret = secret;
	}

	@Override
	public ConnectionStatus getConnectionStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setConnectionStatus(ConnectionStatus status) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public boolean getIsMRA() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void setIsMRA(boolean isAware) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setAuthorizedRecordsResponse(String response) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getAuthorizedRecordsResponse() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub

	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

}
