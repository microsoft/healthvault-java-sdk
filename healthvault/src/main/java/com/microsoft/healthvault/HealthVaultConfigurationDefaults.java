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

import org.joda.time.Interval;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Default values for HealthVault configuration
 */
public class HealthVaultConfigurationDefaults {

    /**
    * The default number of internal retries.
    */
    public static final int RetryOnInternal500Count = 2;

    /**
    * Default URL for Shell application
    */
    public static final URL ShellUrl = makeUrl("https://account.healthvault.com");

    /**
    * Default URL for HealthVault application
    */
    public static final URL HealthVaultRootUrl = makeUrl("https://platform.healthvault.com/platform/wildcat.ashx");

    /**
    * Default Rest URL for HealthVault application
    */
    public static final URL RestUrl = makeUrl("https://data.microsofthealth.net");

    /**
     * The Default Rest API Version
     */
    public static final String RestVersion = "1.0-rc";

    /**
    * Default sleep duration in seconds.
    */
    public static final Interval RetryOnInternal500SleepDuration = new Interval(0, 60 * 1000);

    /**
    * The default request time to live value.
    */
    public static final Interval RequestTimeToLiveDuration = new Interval(0, 30 * 60 * 1000);

    /**
    * The default request time out value.
    */
    public static final Interval RequestTimeoutDuration = new Interval(0, 30 * 1000);

    /**
     * The default flag indicating the app is multi-instance aware.
     */
    public static final Boolean IsMultiInstanceAware = true;

    private static URL makeUrl(String urlString) {
        try {
            return new URL(urlString);
        } catch (MalformedURLException e) {
            return null;
        }
    }
}
