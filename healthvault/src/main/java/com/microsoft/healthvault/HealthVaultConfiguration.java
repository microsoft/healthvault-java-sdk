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
import org.joda.time.Interval;
import java.net.URL;

/**
 * Gives access to the configuration file for the application and exposes some of the settings directly.
 */
public class HealthVaultConfiguration {
    private URL mDefaultHealthVaultShellUri;
    private URL mDefaultHealthVaultUri;
    private URL mRestHealthVaultRootUri;
    private String mRestHealthVaultVersion;
    private Interval mRequestTimeoutDuration;
    private Interval mRequestTimeToLiveDuration;
    private int mRetryOnInternal500Count;
    private Interval mRetryOnInternal500SleepDuration;
    private int mInlineBlobHashBlockSize;
    private Guid mMasterApplicationId;

    public HealthVaultConfiguration() {
        mDefaultHealthVaultUri = HealthVaultConfigurationDefaults.HealthVaultRootUrl;
        mDefaultHealthVaultShellUri = HealthVaultConfigurationDefaults.ShellUrl;
        mRestHealthVaultRootUri = HealthVaultConfigurationDefaults.RestUrl;
        mRequestTimeoutDuration = HealthVaultConfigurationDefaults.RequestTimeoutDuration;
        mRequestTimeToLiveDuration = HealthVaultConfigurationDefaults.RequestTimeToLiveDuration;
        mRetryOnInternal500Count = HealthVaultConfigurationDefaults.RetryOnInternal500Count;
        mRetryOnInternal500SleepDuration = HealthVaultConfigurationDefaults.RetryOnInternal500SleepDuration;
        mRestHealthVaultVersion = HealthVaultConfigurationDefaults.RestVersion;
        /// TODO: BlobHasher.
    }

    public URL getDefaultHealthVaultShellUri() {
        return mDefaultHealthVaultShellUri;
    }

    public void setDefaultHealthVaultShellUri(URL defaultHealthVaultShellUri) {
        mDefaultHealthVaultShellUri = defaultHealthVaultShellUri;
    }

    public URL getDefaultHealthVaultUri() {
        return mDefaultHealthVaultUri;
    }

    public void setDefaultHealthVaultUri(URL defaultHealthVaultUri) {
        mDefaultHealthVaultUri = defaultHealthVaultUri;
    }

    public URL getRestHealthVaultRootUri() {
        return mRestHealthVaultRootUri;
    }

    public void setRestHealthVaultRootUri(URL restHealthVaultRootUri) {
        mRestHealthVaultRootUri = restHealthVaultRootUri;
    }

    public String getRestHealthVaultVersion() {
        return mRestHealthVaultVersion;
    }

    public void setRestHealthVaultVersion(String restHealthVaultVersion) {
        mRestHealthVaultVersion = restHealthVaultVersion;
    }

    public Interval getRequestTimeoutDuration() {
        return mRequestTimeoutDuration;
    }

    public void setRequestTimeoutDuration(Interval requestTimeoutDuration) {
        mRequestTimeoutDuration = requestTimeoutDuration;
    }

    public Interval getRequestTimeToLiveDuration() {
        return mRequestTimeToLiveDuration;
    }

    public void setRequestTimeToLiveDuration(Interval requestTimeToLiveDuration) {
        mRequestTimeToLiveDuration = requestTimeToLiveDuration;
    }

    public int getRetryOnInternal500Count() {
        return mRetryOnInternal500Count;
    }

    public void setRetryOnInternal500Count(int retryOnInternal500Count) {
        mRetryOnInternal500Count = retryOnInternal500Count;
    }

    public Interval getRetryOnInternal500SleepDuration() {
        return mRetryOnInternal500SleepDuration;
    }

    public void setRetryOnInternal500SleepDuration(Interval retryOnInternal500SleepDuration) {
        mRetryOnInternal500SleepDuration = retryOnInternal500SleepDuration;
    }

    public int getInlineBlobHashBlockSize() {
        return mInlineBlobHashBlockSize;
    }

    public void setInlineBlobHashBlockSize(int inlineBlobHashBlockSize) {
        mInlineBlobHashBlockSize = inlineBlobHashBlockSize;
    }

    public Guid getMasterApplicationId() {
        return mMasterApplicationId;
    }

    public void setMasterApplicationId(Guid masterApplicationId) {
        mMasterApplicationId = masterApplicationId;
    }
}
