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
import com.microsoft.healthvault.ServiceInfo;
import com.microsoft.healthvault.ServiceInfoSections;
import com.microsoft.healthvault.ThingTypeDefinition;
import com.microsoft.healthvault.ThingTypeSections;
import com.microsoft.healthvault.types.Guid;
import com.microsoft.healthvault.types.Location;
import com.microsoft.healthvault.types.PersonInfo;

import org.joda.time.Instant;

import java.util.ArrayList;
import java.util.Map;

public class PlatformClient extends Client implements IPlatformClient {
    @Override
    public HealthServiceInstance selectInstanceAsync(Location preferredLocation) {
        return null;
    }

    @Override
    public ServiceInfo getServiceDefinitionAsync() {
        return null;
    }

    @Override
    public ServiceInfo getServiceDefinitionAsync(Instant lastUpdatedTime) {
        return null;
    }

    @Override
    public ServiceInfo getServiceDefinitionAsync(ServiceInfoSections responseSections) {
        return null;
    }

    @Override
    public ServiceInfo getServiceDefinitionAsync(ServiceInfoSections responseSections, Instant lastUpdatedTime) {
        return null;
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
        return null;
    }

    @Override
    public ArrayList<PersonInfo> getAuthorizedPeople() {
        return null;
    }

    @Override
    public ArrayList<PersonInfo> getAuthorizedPeople(GetAuthorizedPeopleSettings settings) {
        return null;
    }

    @Override
    public void RemoveApplicationRecordAuthorizationAsync(Guid recordId) {

    }
}
