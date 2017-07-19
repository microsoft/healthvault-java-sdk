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
import com.microsoft.healthvault.restapi.MicrosoftHealthVaultRESTAPI;
import com.microsoft.healthvault.types.Guid;
import com.microsoft.healthvault.types.PersonInfo;
import com.microsoft.healthvault.types.Record;

import org.apache.commons.lang3.concurrent.ConcurrentUtils;

import java.util.concurrent.Future;

public class HealthVaultSodaConnection extends HealthVaultConnectionBase implements IHealthVaultSodaConnection {
    /// TODO: (mikenev) fix the implements

    private PersonInfo personInfo;
    private static final String authenticationLock = "";

    @Override
    public Future<Void> authenticateAsync() {
        synchronized(authenticationLock) {
            /// TODO: (mikenev) Read properties from local storage
            /// TODO: (mikenev) create application if needed
            /// TODO: (mikenev) actually authenticate.

            if (getSessionCredential() == null) {
                SessionCredential creds = new SessionCredential();
                creds.setSharedSecret("3e+Hv1dq0CxH2Sp/s0Dqv8RTv/oGfyFEvTwqkvI/DSU=");
                //creds.setToken("");
            }

            if (personInfo == null) {
                getAndSavePersonInfoAsync();
            }
        }

        return ConcurrentUtils.constantFuture(null);
    }

    @Override
    public PersonInfo getPersonInfo() {
        if (personInfo == null) {

        }

        return personInfo;
    }

    @Override
    public MicrosoftHealthVaultRESTAPI createRestClient(Record record) {
        HealthVaultConfiguration config = this.getConfiguration();
        HealthVaultRestClient client = new HealthVaultRestClient(this, config, record);
        return client.getClient();
    }

    private void getAndSavePersonInfoAsync() {

    }
}
