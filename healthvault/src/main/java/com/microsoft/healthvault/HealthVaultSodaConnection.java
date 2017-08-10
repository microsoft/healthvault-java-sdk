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

package com.microsoft.healthvault;

import com.microsoft.healthvault.client.HealthVaultRestClient;
import com.microsoft.healthvault.methods.getauthorizedpeople.request.GetAuthorizedPeopleParameters;
import com.microsoft.healthvault.methods.getauthorizedpeople.request.GetAuthorizedPeopleRequest;
import com.microsoft.healthvault.methods.getauthorizedpeople.response.GetAuthorizedPeopleResponse;
import com.microsoft.healthvault.methods.getauthorizedpeople.response.GetAuthorizedPeopleResponseInfo;
import com.microsoft.healthvault.methods.getauthorizedpeople.response.GetAuthorizedPeopleResponseResults;
import com.microsoft.healthvault.methods.request.RequestTemplate;
import com.microsoft.healthvault.restapi.MicrosoftHealthVaultRESTAPI;
import com.microsoft.healthvault.types.PersonInfo;
import com.microsoft.healthvault.types.Record;
import com.microsoft.hsg.Connection;

import org.joda.time.DateTime;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class HealthVaultSodaConnection extends HealthVaultConnectionBase implements IHealthVaultSodaConnection {
    private PersonInfo personInfo;
    private HealthVaultApp mHealthVaultApp;
    private static final String authenticationLock = "";

    @Override
    public void authenticate() {
        synchronized(authenticationLock) {
            RequestTemplate requestTemplate = new RequestTemplate(HealthVaultApp.getInstance().getConnection());
            GetAuthorizedPeopleRequest request = new GetAuthorizedPeopleRequest(new GetAuthorizedPeopleParameters());
            GetAuthorizedPeopleResponse response = requestTemplate.makeRequest(request, GetAuthorizedPeopleResponse.class);
            GetAuthorizedPeopleResponseInfo info = response.getInfo();
            GetAuthorizedPeopleResponseResults results = info.getResponseResults();
            List<PersonInfo> personInfoList = results.getPersonInfoList();

            if (personInfoList.size() > 0) {
                personInfo = personInfoList.get(0);
                Connection connection = mHealthVaultApp.getConnection();
                SessionCredential credential = getSessionCredential();
                credential.setToken(connection.getSessionToken());
            }
        }
    }

    @Override
    protected void setConfiguration(HealthVaultConfiguration configuration) {
        this.configuration = configuration;
        HealthVaultSettings settings = new HVSettings(configuration, getSessionCredential());
        mHealthVaultApp = new HealthVaultApp(settings);
        HealthVaultApp.setInstance(mHealthVaultApp);
    }

    @Override
    public void setSessionCredential(SessionCredential credential) {
        super.setSessionCredential(credential);
        HealthVaultSettings settings = new HVSettings(configuration, credential);
        mHealthVaultApp = new HealthVaultApp(settings);
        HealthVaultApp.setInstance(mHealthVaultApp);
    }

    @Override
    public PersonInfo getPersonInfo() {
        if (personInfo == null) {
            this.authenticate();
        }

        return personInfo;
    }

    @Override
    public MicrosoftHealthVaultRESTAPI createRestClient(Record record) {
        HealthVaultConfiguration config = this.getConfiguration();
        HealthVaultRestClient client = new HealthVaultRestClient(this, config, record);
        return client.getClient();
    }

    private class HVSettings implements HealthVaultSettings {
        private HealthVaultConfiguration mHealthVaultConfiguration;
        private SessionCredential mSessionCredential;
        private HealthVaultApp.ConnectionStatus mConnectionStatus;
        private String mAuthorizedRecordsResponse;

        public HVSettings(HealthVaultConfiguration configuration, SessionCredential credential) {
            mHealthVaultConfiguration = configuration;
            mSessionCredential = credential;
        }

        @Override
        public boolean getIsMultiInstanceAware() {
            return mHealthVaultConfiguration.getMultiInstanceAware();
        }

        @Override
        public void setIsMultiInstanceAware(boolean isAware) {
            mHealthVaultConfiguration.setMultiInstanceAware(isAware);
        }

        @Override
        public String getServiceUrl() {
            return mHealthVaultConfiguration.getDefaultHealthVaultUri().toString();
        }

        @Override
        public void setServiceUrl(String url) {
            // don't set these.
        }

        @Override
        public String getShellUrl() {
            return mHealthVaultConfiguration.getDefaultHealthVaultShellUri().toString();
        }

        @Override
        public void setShellUrl(String url) {
            // don't set these.
        }

        @Override
        public String getRestUrl() {
            return mHealthVaultConfiguration.getRestHealthVaultRootUri().toString();
        }

        @Override
        public void setRestUrl(String url) {
            // don't set these.
        }

        @Override
        public String getAppId() {
            return mHealthVaultConfiguration.getMasterApplicationId().get().toString();
        }

        @Override
        public void setAppId(String appid) {
            // don't set these.
        }

        @Override
        public String getMasterAppId() {
            return mHealthVaultConfiguration.getMasterApplicationId().get().toString();
        }

        @Override
        public void setMasterAppId(String appId) {
            // don't set these.
        }

        @Override
        public void setSessionExpiration() {
            mSessionCredential.setExpirationUtc();
        }

        @Override
        public DateTime getSessionExpiration() {
            return mSessionCredential.getExpirationUtc();
        }

        @Override
        public boolean isSessionExpiraed() {
            return DateTime.now().isAfter(mSessionCredential.getExpirationUtc().toInstant());
        }

        @Override
        public String getAuthenticationSecret() {
            return mSessionCredential.getSharedSecret();
        }

        @Override
        public void setAuthenticationSecret(String secret) {
            mSessionCredential.setSharedSecret(secret);
        }

        @Override
        public HealthVaultApp.ConnectionStatus getConnectionStatus() {
            return mConnectionStatus;
        }

        @Override
        public void setConnectionStatus(HealthVaultApp.ConnectionStatus status) {
            mConnectionStatus = status;
        }

        @Override
        public boolean getIsMRA() {
            return mHealthVaultConfiguration.getMultiRecordApp();
        }

        @Override
        public void setIsMRA(boolean isAware) {
            mHealthVaultConfiguration.setMultiRecordApp(isAware);
        }

        @Override
        public void setAuthorizedRecordsResponse(String response) {
            mAuthorizedRecordsResponse = response;
        }

        @Override
        public String getAuthorizedRecordsResponse() {
            return mAuthorizedRecordsResponse;
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
}
