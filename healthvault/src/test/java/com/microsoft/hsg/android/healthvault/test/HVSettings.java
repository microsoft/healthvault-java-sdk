package com.microsoft.hsg.android.healthvault.test;

import com.microsoft.hsg.android.healthvault.Constants;
import com.microsoft.hsg.android.healthvault.HealthVaultApp.ConnectionStatus;
import com.microsoft.hsg.android.healthvault.HealthVaultSettings;

import org.joda.time.DateTime;

public class HVSettings implements HealthVaultSettings {
	
	private String mAppId;
	private String mAuthSecret;
	private DateTime mExpiration;

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
	public String getRestUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setRestUrl(String url) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getAppId() {
		return mAppId;
	}

	@Override
	public void setAppId(String appid) {
		mAppId = appid;
	}

	@Override
	public void setSessionExpiration() {
		mExpiration = DateTime.now().plusHours(Constants.SessionExpirationHours);
	}

	@Override
	public DateTime getSessionExpiration() {
		return mExpiration;
	}

	public boolean isSessionExpiraed() {
		return mExpiration.isBeforeNow();
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
		return mAuthSecret;
	}

	@Override
	public void setAuthenticationSecret(String secret) {
		mAuthSecret = secret;
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
