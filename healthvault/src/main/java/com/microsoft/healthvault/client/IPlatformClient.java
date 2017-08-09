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
import com.microsoft.healthvault.methods.getservicedefinition.request.ResponseSection;
import com.microsoft.healthvault.methods.getservicedefinition.response.GetServiceDefinitionResponseInfo;
import com.microsoft.healthvault.types.Guid;
import com.microsoft.healthvault.types.Location;
import com.microsoft.healthvault.types.PersonInfo;

import org.joda.time.Instant;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface IPlatformClient extends IClient {
    /**
     * Gets the instance where a HealthVault account should be created for the specified account location.
     *
     * @param preferredLocation A user's preferred geographical location, used to select the best
     *        instance in which to create a new HealthVault account. If there is a
     *        location associated with the credential that will be used to log
     *        into the account, that location should be used.
     *
     * @return A {@link HealthServiceInstance} object represents the selected instance, or null if no
     * suitable instance exists.
     */
    HealthServiceInstance selectInstanceAsync(Location preferredLocation);

    /**
     * Gets information about the HealthVault service.
     *
     * @return A {@link ServiceInfo} instance that contains the service version, SDK assemblies
     * versions and URLs, method information, and so on.
     */
    GetServiceDefinitionResponseInfo getServiceDefinitionAsync();

    /**
     * Gets information about the HealthVault service only if it has been updated since the
     * specified update time.
     *
     * @param lastUpdatedTime the time of the last update to an existing cached copy of {@link ServiceInfo}
     *
     * @return If there were updates to the service information since the specified <b>lastUpdatedTime</b>
     * a {@link ServiceInfo} instance that contains the service version, SDK assembly versions and URLs,
     * method information, and so on. Otherwise, if there were no updates, returns <code>null</code>.
     */
    GetServiceDefinitionResponseInfo getServiceDefinitionAsync(Instant lastUpdatedTime);

    /**
     * Gets information about the HealthVault service corresponding to the specified categories.
     * @param responseSections A list of one or more {@link ResponseSection} which specify
     *        the categories of information to be populated in the {@link ServiceInfo}.
     * @return A {@link ServiceInfo} instance that contains some or all of the service version,
     * SDK assemblies versions and URLs, method information, and so on, depending on which
     * information categories were specified.
     */
    GetServiceDefinitionResponseInfo getServiceDefinitionAsync(List<ResponseSection> responseSections);

    /**
     * Gets information about the HealthVault service corresponding to the specified
     * categories if the requested information has been updated since the specified
     * update time.
     * @param responseSections A list of one or more {@link ResponseSection} which specify the
     * categories of information to be populated in the {@link ServiceInfo}.
     * @param lastUpdatedTime The time of the last update to an existing cached copy of {@link ServiceInfo}.
     * @return If there were updates to the service information since the specified <b>lastUpdatedTime</b>,
     * a {@link ServiceInfo} instance that contains some or all of the service version,
     * SDK  assemblies versions and URLs, method information, and so on, depending on which
     * information categories were specified.  Otherwise, if there were no updates, returns
     * <code>null</code>.
     */
    GetServiceDefinitionResponseInfo getServiceDefinitionAsync(List<ResponseSection> responseSections, Instant lastUpdatedTime);

    /**
     * Gets the definitions for one or more thing type definitions supported by HealthVault.
     * @param typeIds A collection of health item type IDs whose details are being requested.
     *                <code>Null</code> indicates that all health item types should be returned.
     * @param sections A collection of ThingTypeSections enumeration values that indicate the type
     *                 of details to be returned for the specified health item record(s).
     * @param imageTypes A collection of strings that identify which health item record images should be
     * retrieved.
     * <p>
     * This requests an image of the specified mime type should be returned. For example,
     * to request a GIF image, "image/gif" should be specified. For icons, "image/vnd.microsoft.icon"
     * should be specified. Note, not all health item records will have all image types and
     * some may not have any images at all.
     *
     * If '*' is specified, all image types will be returned.
     * </p>
     * @param lastClientRefreshDate An {@link Instant} that specifies the time of the last refresh
     *     made by the client.
     * @return The type definitions for the specified types, or empty if the
     *     <b>typeIds</b> parameter does not represent a known unique type identifier.
     */
    Map<Guid, ThingTypeDefinition> getHealthRecordItemTypeDefinitionAsync(
            ArrayList<Guid> typeIds,
            ThingTypeSections sections,
            ArrayList<String> imageTypes,
            Instant lastClientRefreshDate);

    /**
     * Creates a new application instance. This is the first step in the SODA authentication flow.
     * @return Information about the newly created application instance.
     */
    ApplicationCreationInfo newApplicationCreationInfoAsync();

    /**
     * Gets information about people authorized for an application.
     * @return A list of {@link PersonInfo} objects representing people authorized for the application.
     */
    ArrayList<PersonInfo> getAuthorizedPeople();

    /**
     * Gets information about people authorized for an application.
     * @param settings The {@link GetAuthorizedPeopleSettings} object used to configure the object
     *                 returned by this method.
     * @return A list of {@link PersonInfo} objects representing people authorized for the application.
     */
    ArrayList<PersonInfo> getAuthorizedPeople(GetAuthorizedPeopleSettings settings);

    /**
     * Removes authorization for the given record.
     * @param recordId The identifier of the record to remove authorization for.
     */
    void RemoveApplicationRecordAuthorizationAsync(Guid recordId);
}
