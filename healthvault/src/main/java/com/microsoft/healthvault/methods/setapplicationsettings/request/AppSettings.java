package com.microsoft.healthvault.methods.setapplicationsettings.request;

import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

import java.util.HashMap;

public class AppSettings {
    @ElementMap(name = "settings", key = "name", value="value", inline=true, entry="setting")
    private HashMap<String, String> settings;

    public AppSettings() {
        settings = new HashMap<>();
    }

    public HashMap<String, String> getSettings() {
        return settings;
    }

    public void setSettings(HashMap<String, String> settings) {
        this.settings = settings;
    }
}
