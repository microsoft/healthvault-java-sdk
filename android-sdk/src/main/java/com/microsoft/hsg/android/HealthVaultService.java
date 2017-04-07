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

package com.microsoft.hsg.android;

import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import android.app.ProgressDialog;
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

/**
 * The Class HealthVaultService.
 */
public class HealthVaultService {
    
    /** The instance. */
    private static HealthVaultService instance;
    
    /** The settings. */
    private HealthVaultSettings settings;
    
    /**
     * Initialize.
     * 
     * @param ctx the ctx
     */
    public static HealthVaultService initialize(Context ctx) {
        if (instance == null) {
        	HealthVaultSettings settings = new HealthVaultFileSettings(ctx);
        	HealthVaultService service = new HealthVaultService(settings);
        	instance = service;
        }
        
        return instance;
    }
    
    public static HealthVaultService initialize(HealthVaultSettings settings) {
    	HealthVaultService service = new HealthVaultService(settings);
    	instance = service;
    	
    	return instance;
    }
    
    /**
     * Gets the single instance of HealthVaultService.
     * 
     * @return single instance of HealthVaultService
     */
    public static HealthVaultService getInstance() {
    	return instance;
    }
    
    /**
     * Instantiates a new health vault service.
     * 
     * @param ctx the ctx
     */
    private HealthVaultService(HealthVaultSettings settings) {
        this.settings = settings;
    }
    
    /**
     * Gets the settings.
     * 
     * @return the settings
     */
    public HealthVaultSettings getSettings() {
        return settings;
    }
    
    /**
     * Connect.
     * 
     * @return the intent
     */
    public void connect(final Context ctx, final HealthVaultInitializationHandler handler) {
    	 final ProgressDialog progress = ProgressDialog.show(
                ctx, 
                "",
                "Please wait...", 
                true);
            
    	 new AsyncTask<Context, Void, Intent>() {
            private Exception exception;
            
            protected Intent doInBackground(Context... context) {
                try {    
                    return getNextIntent(context[0]);
                } catch(Exception e) {
                    exception = e;
                }
                return null;
            }
           
           @Override
           protected void onPostExecute(Intent intent) {
               progress.dismiss();
               if (exception != null) {
            	   handler.onError(exception);
               } else {
                   if (intent != null) {
                       ctx.startActivity(intent);
                   }
                   else
                   {
                       handler.OnConnected();
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
        Connection connection = getConnection();
        HVAccessor accessor = new HVAccessor();
        Request request = new Request();
        request.setMethodName("GetAuthorizedPeople");
        request.setInfo("<info><parameters/></info>");
        accessor.send(request, connection);
        Response response = accessor.getResponse();
        
        ArrayList<PersonInfo> personInfoList = new ArrayList<PersonInfo>();
        
        try {
        
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(false);
            XmlPullParser parser= factory.newPullParser();    
            parser.setInput(response.getInputStream(), "utf8");
            
            XmlUtils.nextStartTag(parser, "response");
            XmlUtils.nextStartTag(parser, "status");
            XmlUtils.skipSubTree(parser);
            XmlUtils.nextStartTag(parser, "wc:info");
            XmlUtils.nextStartTag(parser, "response-results");
            
            while( parser.nextTag() == XmlPullParser.START_TAG) {
                if("person-info".equals(parser.getName())) {
                    personInfoList.add(new PersonInfo(parser));
                } 
                else
                {
                    XmlUtils.skipSubTree(parser);
                }
            }
        } catch( Exception e) {
            throw new HVSystemException(e);
        }
        return personInfoList;
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
}
