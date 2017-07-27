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
import com.microsoft.healthvault.types.Guid;
import com.microsoft.healthvault.types.PersonInfo;
import com.microsoft.healthvault.types.Record;

import java.util.List;
import java.util.concurrent.Future;

/**
 * An interface for the HealthVault person client. Used to access information and records associated with the currently authenticated user.
 */
public interface IPersonClient extends IClient {
    /**
     * Gets the information about the person specified.
     *
     * This method always calls the HealthVault service to get the latest
     * information. It is recommended that the calling application cache
     * the return value and only call this method again if it needs to
     * refresh the cache.
     *
     * @return Information about the person's HealthVault account.
     */
    PersonInfo getPersonInfoAsync();

    /**
     * Gets information about people authorized for an application.
     * @return A list of PersonInfo objects representing people authorized for the application.
     */
    List<PersonInfo> getAuthorizedPeopleAsync();

    /**
     * Gets the application settings for the current application and person.
     * @return The complete set application settings including the XML settings, selected record ID, etc.
     */
    ApplicationSettings getApplicationSettingsAsync();


    /**
     * Gets the info for the specified records.
     * @param recordIds The unique identifiers for the records to retrieve.
     * @return A list of the records matching the specified record identifiers and authorized for the authenticated person.
     */
    List<Record> getAuthorizedRecordsAsync(List<Guid> recordIds);
}