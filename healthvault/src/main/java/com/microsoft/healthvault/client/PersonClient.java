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

import com.microsoft.healthvault.ApplicationSettings;
import com.microsoft.healthvault.HealthServiceResponseData;
import com.microsoft.healthvault.HealthVaultApp;
import com.microsoft.healthvault.IHealthVaultConnection;
import com.microsoft.healthvault.SessionCredential;
import com.microsoft.healthvault.methods.HealthVaultMethods;
import com.microsoft.healthvault.methods.getauthorizedpeople.request.GetAuthorizedPeopleParameters;
import com.microsoft.healthvault.methods.getauthorizedpeople.request.GetAuthorizedPeopleRequest;
import com.microsoft.healthvault.methods.getauthorizedpeople.response.GetAuthorizedPeopleResponse;
import com.microsoft.healthvault.methods.getauthorizedpeople.response.GetAuthorizedPeopleResponseInfo;
import com.microsoft.healthvault.methods.getauthorizedpeople.response.GetAuthorizedPeopleResponseResults;
import com.microsoft.healthvault.methods.request.RequestTemplate;
import com.microsoft.healthvault.types.Guid;
import com.microsoft.healthvault.types.PersonInfo;
import com.microsoft.healthvault.types.Record;
import com.microsoft.hsg.Connection;

import java.util.List;
import java.util.concurrent.Future;

public class PersonClient extends Client implements IPersonClient {
    private IHealthVaultConnection connection;

    public PersonClient(IHealthVaultConnection connection) {
        this.connection = connection;
    }

    @Override
    public ApplicationSettings getApplicationSettingsAsync() {
        return null;
    }

    @Override
    public List<PersonInfo> getAuthorizedPeopleAsync() {
        RequestTemplate requestTemplate = new RequestTemplate(HealthVaultApp.getInstance().getConnection());
        GetAuthorizedPeopleRequest request = new GetAuthorizedPeopleRequest(new GetAuthorizedPeopleParameters());
        GetAuthorizedPeopleResponse response = requestTemplate.makeRequest(request, GetAuthorizedPeopleResponse.class);
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
        return null;
    }
}
