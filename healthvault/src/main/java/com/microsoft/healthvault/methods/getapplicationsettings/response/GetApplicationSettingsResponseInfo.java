package com.microsoft.healthvault.methods.getapplicationsettings.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;

public class GetApplicationSettingsResponseInfo {
    @Element(name="app-settings", required = false)
    protected String appSettings;

    @Element(name="selected-record-id", required = false)
    protected String selectedRecordId;


    public String getAppSettings() {
        return appSettings;
    }

    public void setAppSettings(String appSettings) {
        this.appSettings = appSettings;
    }

    public String getSelectedRecordId() {
        return selectedRecordId;
    }

    public void setSelectedRecordId(String selectedRecordId) {
        this.selectedRecordId = selectedRecordId;
    }
}
