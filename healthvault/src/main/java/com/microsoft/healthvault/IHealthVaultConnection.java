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

import com.microsoft.healthvault.client.*;
import com.microsoft.healthvault.methods.HealthVaultMethods;
import com.microsoft.healthvault.restapi.MicrosoftHealthVaultRESTAPI;
import com.microsoft.healthvault.restapi.implementation.MicrosoftHealthVaultRESTAPIImpl;
import com.microsoft.healthvault.types.Guid;
import com.microsoft.healthvault.types.PersonInfo;
import com.microsoft.healthvault.types.Record;

/**
 * Represents a connection for an application to the HealthVault service
 */
public interface IHealthVaultConnection {

    /**
     * Gets the application identifier.
     * @return The application identifier.
     */
    public Guid getApplicationId();

    /**
     * Gets the person information for this account.
     * @return the person information for this account.
     */
    public PersonInfo getPersonInfo();

    /**
     * Authenticates the connection.
     * Implementation should depend on the application platform - SODA vs WEB.
     */
    public void authenticate();

    /**
     * Gets SessionCredential
     * @return The SessionCredential.
     */
    public SessionCredential getSessionCredential();

    /**
     * Sets SessionCredential
     */
    public void setSessionCredential(SessionCredential credential);

    /**
     * Gets a client that can be used to access things associated with a particular record.
     * @return An instance implementing IThingClient
     */
    public IThingClient createThingClient();

    /**
     * A client that can be used to access vocabularies.
     * @return An instance implementing IVocabularyClient
     */
    public IVocabularyClient createVocabularyClient();

    /**
     * A client that can be used to access information and records associated with the currently athenticated user.
     * @return An instance implementing IPersonClient
     */
    public IPersonClient createPersonClient();

    /**
     * A client that can be used to access information and records associated with the currently athenticated user.
     * @return An instance implementing IPlatformClient
     */
    public IPlatformClient createPlatformClient();

    /**
     * A client that can be used to access the HealthVault REST APIs.
     * @param record the record for the REST calls.
     * @return an instance implementing MicrosoftHealthVaultRESTAPI
     */
    public MicrosoftHealthVaultRESTAPI createRestClient(Record record);
}
