package com.microsoft.healthvault.methods.getapplicationsettings.response;

import com.microsoft.healthvault.methods.setapplicationsettings.request.AppSettings;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;

public class GetApplicationSettingsResponseInfo {
    @Element(name="app-settings", required = false)
    protected AppSettings appSettings;

    public AppSettings getAppSettings() {
        return appSettings;
    }

    public void setAppSettings(AppSettings appSettings) {
        this.appSettings = appSettings;
    }
}
