package com.microsoft.hsg.android.simplexml.test;

import com.microsoft.hsg.android.simplexml.HealthVaultApp;

public class TestApp {
	
	private HealthVaultApp app;
	
	public TestApp() {
		setUp();
	}
	
	public HealthVaultApp getHVApp() {
		return app;
	}
	
	private void setUp()
	{
        HVSettings settings = new HVSettings();
        settings.setAppId("90976b0c-e0c2-467e-b65c-ed9117aa94e9");
        settings.setAuthenticationSecret("JpGYZ54MRAhy2Gw9uoWCfxTG97ufR3v7kZ/i2JG+Utw=");
		app = new HealthVaultApp(settings);
		app.resolvePersonInfoList();
		HealthVaultApp.setInstance(app);
	}
}
