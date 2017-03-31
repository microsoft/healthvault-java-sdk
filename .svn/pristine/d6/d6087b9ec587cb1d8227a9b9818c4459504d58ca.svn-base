/*
 * Copyright 2011 Microsoft Corp.
 * 
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.microsoft.hsg.android.simplexml;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Base64;

import com.microsoft.hsg.Connection;
import com.microsoft.hsg.HVAccessor;
import com.microsoft.hsg.HVRequestException;
import com.microsoft.hsg.HVSystemException;
import com.microsoft.hsg.Request;
import com.microsoft.hsg.Response;
import com.microsoft.hsg.SimpleSendStrategy;
import com.microsoft.hsg.android.simplexml.methods.getauthorizedpeople.request.GetAuthorizedPeopleParameters;
import com.microsoft.hsg.android.simplexml.methods.getauthorizedpeople.request.GetAuthorizedPeopleRequest;
import com.microsoft.hsg.android.simplexml.methods.getauthorizedpeople.response.GetAuthorizedPeopleResponse;
import com.microsoft.hsg.android.simplexml.methods.getauthorizedpeople.response.GetAuthorizedPeopleResponseInfo;
import com.microsoft.hsg.android.simplexml.methods.request.RequestTemplate;
import com.microsoft.hsg.android.simplexml.things.types.types.PersonInfo;
import com.microsoft.hsg.android.simplexml.things.types.types.Record;

/**
 * The Class HealthVaultService.
 */
public class HealthVaultApp {
    
    /** The instance. */
    private static HealthVaultApp instance;
    
    /** The settings. */
    private HealthVaultSettings settings;
    
    private Vocabs vocabs;
    
	private List<PersonInfo> personInfoList;
    
    private List<Record> recordList;
    
    private Record currentRecord;
    
    /**
     * Initialize.
     * 
     * @param ctx the ctx
     */
    public static HealthVaultApp getInstance(Context ctx) {
        if (instance == null) {
        	HealthVaultSettings settings = new HealthVaultFileSettings(ctx);
        	HealthVaultApp service = new HealthVaultApp(settings);
        	service.initializeFromSettings(settings);
        	instance = service;
        }
        
        return instance;
    }
    
    public static void setInstance(HealthVaultApp app) {
    	instance = app;
    }
    
    /**
     * Gets the single instance of HealthVaultService.
     * 
     * @return single instance of HealthVaultService
     */
    public static HealthVaultApp getInstance() {
    	return instance;
    }
    
    /**
     * Instantiates a new health vault service.
     * 
     * @param ctx the ctx
     */
    public HealthVaultApp(HealthVaultSettings settings) {
        this.settings = settings;
        vocabs = new Vocabs();
        ConfigureLog4J.configure();
        initializeFromSettings(settings);
    }

    private void initializeFromSettings(HealthVaultSettings settings) {
    	String serializedAuthorizedRecords = settings.getAuthorizedRecordsResponse();
    	
    	if (serializedAuthorizedRecords == null) {
    		return;
    	}
    	
    	GetAuthorizedPeopleResponseInfo response = XmlSerializer.safeRead(
    			GetAuthorizedPeopleResponseInfo.class, serializedAuthorizedRecords);
    	
    	if (response != null) {
    		populatePersonInfo(response);
    	}
    }
    
    public Record getCurrentRecord() {
		return currentRecord;
	}

	public void setCurrentRecord(Record currentRecord) {
		this.currentRecord = currentRecord;
	}

	public List<Record> getRecordList() {
		return Collections.unmodifiableList(recordList);
	}
    /**
     * Gets the settings.
     * 
     * @return the settings
     */
    public HealthVaultSettings getSettings() {
        return settings;
    }
    
    public Vocabs getVocabs() {
        return vocabs;
    }
    
    /**
     * Connect.
     * 
     * @return the intent
     */
    public void start(final Context ctx, final HealthVaultInitializationHandler healthVaultInitializationHandler) {
         
            
    	 new AsyncTask<Context, Void, Intent>() {
            private Exception exception;
            
            protected Intent doInBackground(Context... context) {
                try {    
                    Intent intent = getNextIntent(context[0]);
                    if (intent == null) {
                    	resolvePersonInfoList();
                    } else {
                    	return intent;
                    }
                } catch(Exception e) {
                    exception = e;
                }
                return null;
            }
           
           @Override
           protected void onPostExecute(Intent intent) {
               if (exception != null) {
            	   healthVaultInitializationHandler.onError(exception);
               } else {
                   if (intent != null) {
                       ctx.startActivity(intent);
                   }
                   else
                   {
                       healthVaultInitializationHandler.onConnected();
                   }
               }
           }
        }.execute(ctx);
    }
    
    private Intent getNextIntent(Context ctx) {
        Intent intent = null;
        
        switch(settings.getConnectionStatus())
        {
            case Connected:
                try {
                    getConnection().authenticate();
                } catch (HVRequestException e) {
                    if (e.getResponseCode() == 6) {
                        intent = createApplication(ctx);
                    }
                }
                break;
            case NotConnected:
                intent = createApplication(ctx);
                break;
        }

        return intent;
    }
    
    /**
     * Gets the connection status.
     * 
     * @return the connection status
     */
    public ConnectionStatus getConnectionStatus() {
        return settings.getConnectionStatus();
    }
    
    /**
     * Gets the app id.
     * 
     * @return the app id
     */
    public String getAppId() {
        return settings.getAppId();
    }
    
    /**
     * Reset.
     */
    public void reset() {
        settings.clear();
        settings.save();
        ConnectionFactory.reset();
    }
    
    /**
     * Creates the application.
     * 
     * @return the intent
     */
    private Intent createApplication(Context ctx) throws HVSystemException
    {    
        Connection connection = ConnectionFactory.getUnauthenticatedConnection();
        connection.setAppId(settings.getMasterAppId());
        HVAccessor accessor = new HVAccessor();
        accessor.setSendStrategy(new SimpleSendStrategy());
        Request request = new Request();
        request.setMethodName("NewApplicationCreationInfo");
        accessor.send(request, connection);
        Response response = accessor.getResponse();
         
        String appId = null;
        String appToken = null;
        String sharedSecret = null;
        
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(false);
            XmlPullParser parser= factory.newPullParser();    
            parser.setInput(response.getInputStream(), "utf8");
            
            XmlUtils.nextStartTag(parser, "response");
            XmlUtils.nextStartTag(parser, "status");
            XmlUtils.skipSubTree(parser);
            XmlUtils.nextStartTag(parser, "wc:info");
            
            while( parser.nextTag() == XmlPullParser.START_TAG ) {
              if("app-id".equals(parser.getName())) {
                  appId = parser.nextText();
              } else if ("app-token".equals(parser.getName())) {
                 appToken = parser.nextText();
              } else if ("shared-secret".equals(parser.getName())) {
                 sharedSecret = parser.nextText();
              } else {
                 XmlUtils.skipSubTree(parser);
              }
            }
        }catch(Exception e) {
            throw new HVSystemException(e);
        }
        
        settings.setAppId(appId);
        settings.setAuthenticationSecret(sharedSecret);
        settings.save();
        
        return createApplicationInShellIntent(
                ctx,
                appToken, 
                settings.getMasterAppId());
    }
    
    /**
     * Creates the application in shell intent.
     * 
     * @param appToken the app token
     * @param appId the app id
     * 
     * @return the intent
     */
    private Intent createApplicationInShellIntent(
            Context ctx, String appToken, String appId)
    {
        return ShellActivity.createCreateApplicationIntent(
            ctx,
            appToken,
            appId);
    }
    
    /**
     * Gets the person info list.
     * 
     * @return the person info list
     */
    public List<PersonInfo> getPersonInfoList()
    {    
    	return Collections.unmodifiableList(personInfoList);
    }
   
    /**
     * Gets the connection.
     * 
     * @return the connection
     */
    public Connection getConnection()
    {
        return ConnectionFactory.getConnection(
            settings.getAppId(),
            Base64.decode(settings.getAuthenticationSecret(), Base64.DEFAULT));
    }
    
    public boolean isAppConnected() {
    	return this.getConnectionStatus() == ConnectionStatus.Connected;
    }
    
    /**
     * The Enum ConnectionStatus.
     */
    public enum ConnectionStatus {
        
        /** The Not connected. */
        NotConnected,
        
        /** The Connecting. */
        Connecting,
        
        /** The Connected. */
        Connected
    }

	public void resolvePersonInfoList() {
        RequestTemplate requestTemplate = new RequestTemplate(getConnection());
		
		GetAuthorizedPeopleRequest request = new GetAuthorizedPeopleRequest(
				new GetAuthorizedPeopleParameters());
		
		GetAuthorizedPeopleResponse response = requestTemplate.makeRequest(
				request, 
				GetAuthorizedPeopleResponse.class);
		
		GetAuthorizedPeopleResponseInfo info = response.getInfo();
		settings.setAuthorizedRecordsResponse(XmlSerializer.safeWrite(info));
		settings.save();
    	
		populatePersonInfo(info);
	}
			
	private void populatePersonInfo(GetAuthorizedPeopleResponseInfo response) {
		personInfoList = response.getResponseResults().getPersonInfoList();
		
		recordList = new ArrayList<Record>();
		
		for (PersonInfo pi : personInfoList) {
			for (Record r : pi.getRecords()) {
				recordList.add(r);
			}
		}
		
		if (recordList.size() > 0) {
			currentRecord = recordList.get(0);
		}
    }
}
