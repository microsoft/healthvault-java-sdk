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

package com.microsoft.healthvault.client;

import com.microsoft.healthvault.HealthVaultApp;
import com.microsoft.healthvault.IHealthVaultConnection;
import com.microsoft.healthvault.methods.getapplicationsettings.request.GetApplicationSettingsRequest;
import com.microsoft.healthvault.methods.getapplicationsettings.response.GetApplicationSettingsResponse;
import com.microsoft.healthvault.methods.getauthorizedpeople.request.GetAuthorizedPeopleParameters;
import com.microsoft.healthvault.methods.getauthorizedpeople.request.GetAuthorizedPeopleRequest;
import com.microsoft.healthvault.methods.getauthorizedpeople.response.GetAuthorizedPeopleResponse;
import com.microsoft.healthvault.methods.getauthorizedpeople.response.GetAuthorizedPeopleResponseInfo;
import com.microsoft.healthvault.methods.getauthorizedpeople.response.GetAuthorizedPeopleResponseResults;
import com.microsoft.healthvault.methods.getauthorizedrecords.request.GetAuthorizedRecordsRequest;
import com.microsoft.healthvault.methods.getauthorizedrecords.response.GetAuthorizedRecordsResponse;
import com.microsoft.healthvault.methods.request.RequestTemplate;
import com.microsoft.healthvault.methods.setapplicationsettings.request.AppSettings;
import com.microsoft.healthvault.methods.setapplicationsettings.request.SetApplicationSettingsRequest;
import com.microsoft.healthvault.methods.setapplicationsettings.response.SetApplicationSettingsResponse;
import com.microsoft.healthvault.types.Guid;
import com.microsoft.healthvault.types.PersonInfo;
import com.microsoft.healthvault.types.Record;

import java.util.HashMap;
import java.util.List;

public class PersonClient extends Client implements IPersonClient {
    private IHealthVaultConnection connection;

    public PersonClient(IHealthVaultConnection connection) {
        this.connection = connection;
    }

    @Override
    public HashMap<String, String> getApplicationSettingsAsync() {
        RequestTemplate requestTemplate = new RequestTemplate(HealthVaultApp.getInstance().getConnection());
        requestTemplate.setPersonId(this.connection.getPersonInfo().getPersonId());

        GetApplicationSettingsRequest request = new GetApplicationSettingsRequest();
        GetApplicationSettingsResponse response = requestTemplate.makeRequest(
                request, GetApplicationSettingsResponse.class);

        return response.getInfo().getAppSettings().getSettings();
    }

    @Override
    public void setApplicationSettingsAsync(HashMap<String, String> settings) {
        RequestTemplate requestTemplate = new RequestTemplate(HealthVaultApp.getInstance().getConnection());
        requestTemplate.setPersonId(this.connection.getPersonInfo().getPersonId());

        SetApplicationSettingsRequest request = new SetApplicationSettingsRequest();
        AppSettings appSettings = new AppSettings();
        appSettings.setSettings(settings);
        request.setAppSettings(appSettings);

        SetApplicationSettingsResponse response = requestTemplate.makeRequest(
                request, SetApplicationSettingsResponse.class);
    }

    @Override
    public List<PersonInfo> getAuthorizedPeopleAsync() {
        RequestTemplate requestTemplate = new RequestTemplate(HealthVaultApp.getInstance().getConnection());
        GetAuthorizedPeopleRequest request = new GetAuthorizedPeopleRequest(new GetAuthorizedPeopleParameters());
        GetAuthorizedPeopleResponse response = requestTemplate.makeRequest(
                request, GetAuthorizedPeopleResponse.class);
        GetAuthorizedPeopleResponseInfo info = response.getInfo();
        GetAuthorizedPeopleResponseResults results = info.getResponseResults();
        return results.getPersonInfoList();
    }

    @Override
    public PersonInfo getPersonInfoAsync()
    {
        List<PersonInfo> personInfoList = getAuthorizedPeopleAsync();

        if (personInfoList.size() > 0) {
            return personInfoList.get(0);
        }

        return null;
    }

    @Override
    public List<Record> getAuthorizedRecordsAsync(List<Guid> recordIds) {
        RequestTemplate requestTemplate = new RequestTemplate(HealthVaultApp.getInstance().getConnection());
        requestTemplate.setPersonId(this.connection.getPersonInfo().getPersonId());
        GetAuthorizedRecordsRequest request = new GetAuthorizedRecordsRequest();

        for(Guid guid : recordIds)
        {
            request.getId().add(guid.get().toString());
        }

        GetAuthorizedRecordsResponse response = requestTemplate.makeRequest(
                request, GetAuthorizedRecordsResponse.class);

        return response.getInfo().record;
    }
}
