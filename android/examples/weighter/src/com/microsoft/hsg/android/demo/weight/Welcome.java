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

package com.microsoft.hsg.android.demo.weight;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.microsoft.hsg.android.HealthVaultFileSettings;
import com.microsoft.hsg.android.HealthVaultInitializationHandler;
import com.microsoft.hsg.android.HealthVaultService;
import com.microsoft.hsg.android.HealthVaultSettings;

public class Welcome 
	extends Activity
	implements HealthVaultInitializationHandler {

    private HealthVaultService service;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        
        service = HealthVaultService.initialize(this);
        HealthVaultSettings settings = service.getSettings();
        
        if (settings.getConnectionStatus() == HealthVaultService.ConnectionStatus.Connected)
        {
        	OnConnected();
        }
        else
        {
		    settings.setMasterAppId("c6ba979f-c342-4408-a2bc-0dfb43b2bf8d");
		    settings.setServiceUrl("https://platform.healthvault-ppe.com/platform/wildcat.ashx");
		    settings.setShellUrl("https://account.healthvault-ppe.com");
		    settings.setIsMultiInstanceAware(true);   
        }
        
        
        Button go = (Button) findViewById(R.id.goButton);
        go.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            	service.connect(Welcome.this, Welcome.this);
            }
        });
    }

    @Override
    protected void onResume() {
    	if (service.getSettings().getConnectionStatus() == HealthVaultService.ConnectionStatus.Connected) {
        	OnConnected();
        }
    	
        InitializeControls();
        super.onResume();
    }
    
    private void InitializeControls() {
        TextView msg = (TextView)findViewById(R.id.welcomeText);
        switch(service.getConnectionStatus()) {
        case Connected:
            msg.setText("Work With Your Weight");
            break;
        case NotConnected:
            msg.setText("Connect this application to HealthVault");
            break;
        }
    }

	@Override
	public void OnConnected() {
		Intent intent = new Intent(Welcome.this, WeightActivity.class);
        startActivity(intent);
        finish();
	}

	@Override
	public void onError(Exception e) {
		 Toast.makeText(
                 Welcome.this, 
                 e.getMessage(), 
                 Toast.LENGTH_LONG).show();
		
	}
}
