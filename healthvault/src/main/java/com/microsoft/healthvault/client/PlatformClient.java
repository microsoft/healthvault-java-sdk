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

import com.microsoft.healthvault.ApplicationCreationInfo;
import com.microsoft.healthvault.GetAuthorizedPeopleSettings;
import com.microsoft.healthvault.HealthServiceInstance;
import com.microsoft.healthvault.HealthVaultApp;
import com.microsoft.healthvault.ServiceInfo;
import com.microsoft.healthvault.ServiceInfoSections;
import com.microsoft.healthvault.ThingTypeDefinition;
import com.microsoft.healthvault.ThingTypeSections;
import com.microsoft.healthvault.methods.getservicedefinition.request.GetServiceDefinitionRequest;
import com.microsoft.healthvault.methods.getservicedefinition.request.ResponseSection;
import com.microsoft.healthvault.methods.getservicedefinition.request.ResponseSections;
import com.microsoft.healthvault.methods.getservicedefinition.response.GetServiceDefinitionResponse;
import com.microsoft.healthvault.methods.getservicedefinition.response.GetServiceDefinitionResponseInfo;
import com.microsoft.healthvault.methods.newapplicationcreationinfo.request.NewApplicationCreationInfoRequest;
import com.microsoft.healthvault.methods.newapplicationcreationinfo.response.NewApplicationCreationInfoResponse;
import com.microsoft.healthvault.methods.request.RequestTemplate;
import com.microsoft.healthvault.methods.selectinstance.request.SelectInstanceRequest;
import com.microsoft.healthvault.methods.selectinstance.response.SelectInstanceResponse;
import com.microsoft.healthvault.types.Guid;
import com.microsoft.healthvault.types.Location;
import com.microsoft.healthvault.types.PersonInfo;

import org.joda.time.Instant;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PlatformClient extends Client implements IPlatformClient {
    @Override
    public HealthServiceInstance selectInstanceAsync(Location preferredLocation) {
        RequestTemplate requestTemplate = new RequestTemplate(HealthVaultApp.getInstance().getConnection());

        SelectInstanceRequest request = new SelectInstanceRequest();
        request.setPreferredLocation(preferredLocation);

        SelectInstanceResponse response = requestTemplate.makeRequest(
                request, SelectInstanceResponse.class);

        return response.getInfo().getSelectedInstance();
    }

    @Override
    public GetServiceDefinitionResponseInfo getServiceDefinitionAsync() {
        return getServiceDefinitionAsync(getDefaultResponseSections(), null);
    }

    @Override
    public GetServiceDefinitionResponseInfo getServiceDefinitionAsync(Instant lastUpdatedTime) {
        return getServiceDefinitionAsync(getDefaultResponseSections(), lastUpdatedTime);
    }

    @Override
    public GetServiceDefinitionResponseInfo getServiceDefinitionAsync(List<ResponseSection> responseSections) {
        return getServiceDefinitionAsync(responseSections, null);
    }

    @Override
    public GetServiceDefinitionResponseInfo getServiceDefinitionAsync(List<ResponseSection> responseSections, Instant lastUpdatedTime) {
        RequestTemplate requestTemplate = new RequestTemplate(HealthVaultApp.getInstance().getConnection());

        ResponseSections sections = new ResponseSections();
        sections.setSections(responseSections);

        GetServiceDefinitionRequest request = new GetServiceDefinitionRequest();
        request.setResponseSections(sections);

        if (lastUpdatedTime != null) {
            request.setUpdatedDate(lastUpdatedTime.toDate());
        }

        GetServiceDefinitionResponse response = requestTemplate.makeRequest(
                request, GetServiceDefinitionResponse.class);

        return response.getInfo();
    }

    private List<ResponseSection> getDefaultResponseSections() {
        ArrayList<ResponseSection> responseSectionList = new ArrayList<>();
        responseSectionList.add(ResponseSection.PLATFORM);
        responseSectionList.add(ResponseSection.SHELL);
        responseSectionList.add(ResponseSection.TOPOLOGY);
        responseSectionList.add(ResponseSection.XML_OVER_HTTP_METHODS);
        responseSectionList.add(ResponseSection.MEANINGFUL_USE);

        return responseSectionList;
    }

    @Override
    public Map<Guid, ThingTypeDefinition> getHealthRecordItemTypeDefinitionAsync(
            ArrayList<Guid> typeIds,
            ThingTypeSections sections,
            ArrayList<String> imageTypes,
            Instant lastClientRefreshDate) {
        return null;
    }

    @Override
    public ApplicationCreationInfo newApplicationCreationInfoAsync() {
        RequestTemplate requestTemplate = new RequestTemplate(HealthVaultApp.getInstance().getConnection());


        NewApplicationCreationInfoRequest request = new NewApplicationCreationInfoRequest();

        NewApplicationCreationInfoResponse response = requestTemplate.makeRequest(
                request, NewApplicationCreationInfoResponse.class);

        return null;
    }

    @Override
    public ArrayList<PersonInfo> getAuthorizedPeople() {
        // not implemented, use the PersonClient for this.
        return null;
    }

    @Override
    public ArrayList<PersonInfo> getAuthorizedPeople(GetAuthorizedPeopleSettings settings) {
        // not implemented, use the PersonClient for this.
        return null;
    }

    @Override
    public void RemoveApplicationRecordAuthorizationAsync(Guid recordId) {

    }
}
