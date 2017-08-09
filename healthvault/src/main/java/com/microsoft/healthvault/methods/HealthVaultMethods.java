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

package com.microsoft.healthvault.methods;

/**
 * The public HealthVault methods that are available for applications to call.
 * The enum values are directly used as method names when calling HealthVault, so do not rename them.
 */
public enum HealthVaultMethods {
    
    /** Pre-allocates a DOPU package id. */
    AllocatePackageId,

    /** Creates a new alternate id for the record and person. */
    AssociateAlternateId,

    /** Begin to stream binary data for a ThingBase. */
    BeginPutBlob,

    /** Begin to stream binary data for a DOPU package. */
    BeginPutConnectPackageBlob,

    /** Creates an application session token for use with the HealthVault service. */
    CreateAuthenticatedSessionToken,
    
    /** Create a new DOPU package. */
    CreateConnectPackage,

    /** Create a new Connect Request. */
    CreateConnectRequest,

    /** Delete a DOPU package which has not yet been picked up. */
    DeletePendingConnectPackage,

    /** Delete a connect request which has not yet been accepted. */
    DeletePendingConnectRequest,

    /** Remove an alternate id for the record and person. */
    DisassociateAlternateId,

    /** Get an alternate ids for the record and person. */
    GetAlternateIds,

    /** Gets information about the registered application including name, description,
     *  authorization rules, and callback url.
     */
    GetApplicationInfo,

    /** Saves application specific information for the logged in user. */
    GetApplicationSettings,

    /** Get a list of accepted connect requests. */
    GetAuthorizedConnectRequests,

    /** Get all people authorized for an application. */
    GetAuthorizedPeople,

    /** Gets all the records that the user has authorized the application use. */
    GetAuthorizedRecords,

    /** Get a list of event subscriptions for the application. */
    GetEventSubscriptions,

    /** Get Meaningful Use Timely Access Report. */
    GetMeaningfulUseTimelyAccessReport,
    
    /** Get Meaningful Use VDT Report. */
    GetMeaningfulUseVDTReport,

    /** Gets information about the logged in user. */
    GetPersonInfo,

    /** Gets generic service information about the HealthVault service. */
    GetServiceDefinition,
    
    /** Gets data from a HealthVault record. */
    GetThings,

    /** Gets information, including schemas, about the data types that can be stored in a health record. */
    GetThingType,

    /** Get a list of updated records for the application. */
    GetUpdatedRecordsForApplication,

    /** Get valid group memberships for the record. */
    GetValidGroupMembership,

    /** Gets information about clinical and other vocabularies that HealthVault supports. */
    GetVocabulary,

    /** Create a new application instance information from a master app id.  First step in SODA authentication. */
    NewApplicationCreationInfo,

    /** Generate a new signup code. */
    NewSignupCode,

    /** Adds or updates data in a health record. */
    PutThings,

    /** Gets the permissions that the application and user have to a health record. */
    QueryPermissions,

    /** Remove the application's record authorization. */
    RemoveApplicationRecordAuthorization,

    /** Removes data from a health record. */
    RemoveThings,

    /** Search a specific vocabulary and retrieve the matching vocabulary items. */
    SearchVocabulary,
    
    /** Get the instance where a HealthVault account should be created for the specified account location. */
    SelectInstance,

    /** Sends an SMTP message on behalf of the logged in user. */
    SendInsecureMessage,

    /** Sends an SMTP message on behalf of the application. */
    SendInsecureMessageFromApplication,

    /** Sets application specific data for the user. */
    SetApplicationSettings,

    /** Subscribe to an event. */
    SubscribeToEvent,

    /** Remove a subscription. */
    UnsubscribeToEvent,

    /** Update a subscription. */
    UpdateEventSubscription,

    /** Update DOPU packages external id. */
    UpdateExternalId
}
