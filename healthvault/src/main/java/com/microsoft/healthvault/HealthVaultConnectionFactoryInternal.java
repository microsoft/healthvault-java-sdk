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

import com.microsoft.healthvault.types.Guid;

import java.security.InvalidParameterException;
import java.util.ArrayList;

class HealthVaultConnectionFactoryInternal implements IHealthVaultConnectionFactory {
    private static String sLock = "";
    private IHealthVaultSodaConnection cachedConnection;

    @Override
    public IHealthVaultSodaConnection GetOrCreateSodaConnection(HealthVaultConfiguration configuration) {
        synchronized (sLock) {
            if (cachedConnection != null) {
                ValidateConfiguration(cachedConnection.Configuration, configuration);
                return cachedConnection;
            }

            ArrayList<String> missingProperties = new ArrayList<String>();

            Guid masterApplicationId = configuration.getMasterApplicationId();
            HealthVaultSodaConnection connection = new HealthVaultSodaConnection();
            connection.setConfiguration(configuration);
            cachedConnection = connection;
        }

        return cachedConnection;
    }

    private static void ValidateConfiguration(HealthVaultConfiguration currentConfiguration, HealthVaultConfiguration configuration) {
        if (currentConfiguration != null && currentConfiguration.getMasterApplicationId() != configuration.getMasterApplicationId()) {
            throw new InvalidParameterException("Cannot auth with a different master app id");
            /// TODO: use resources for this string.
        }
    }

}
