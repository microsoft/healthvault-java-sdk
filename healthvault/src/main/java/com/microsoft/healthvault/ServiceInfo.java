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

import org.joda.time.Instant;

import java.net.URL;
import java.util.ArrayList;
import java.util.Map;

public class ServiceInfo {
    private URL mHealthServiceUrl;
    private String mVersion;
    private HealthServiceShellInfo mHealthServiceShellInfo;
    private ArrayList<HealthServiceMethodInfo> mMethods;
    private ArrayList<URL> mIncludedSchemaUrls;
    private Map<String, String> mConfigurationValues;
    private Map<String, HealthServiceInstance> mServiceInstances;
    private HealthServiceInstance mCurrentInstance;
    private Instant mLastUpdated;

    public URL getHealthServiceUrl() {
        return mHealthServiceUrl;
    }

    private void setHealthServiceUrl(URL healthServiceUrl) {
        mHealthServiceUrl = healthServiceUrl;
    }

    public String getVersion() {
        return mVersion;
    }

    private void setVersion(String version) {
        mVersion = version;
    }

    public HealthServiceShellInfo getHealthServiceShellInfo() {
        return mHealthServiceShellInfo;
    }

    private void setHealthServiceShellInfo(HealthServiceShellInfo healthServiceShellInfo) {
        mHealthServiceShellInfo = healthServiceShellInfo;
    }

    public ArrayList<HealthServiceMethodInfo> getMethods() {
        return mMethods;
    }

    private void setMethods(ArrayList<HealthServiceMethodInfo> methods) {
        mMethods = methods;
    }

    public ArrayList<URL> getIncludedSchemaUrls() {
        return mIncludedSchemaUrls;
    }

    private void setIncludedSchemaUrls(ArrayList<URL> includedSchemaUrls) {
        mIncludedSchemaUrls = includedSchemaUrls;
    }

    public Map<String, String> getConfigurationValues() {
        return mConfigurationValues;
    }

    private void setConfigurationValues(Map<String, String> configurationValues) {
        mConfigurationValues = configurationValues;
    }

    public Map<String, HealthServiceInstance> getServiceInstances() {
        return mServiceInstances;
    }

    public HealthServiceInstance getCurrentInstance() {
        return mCurrentInstance;
    }

    private void setCurrentInstance(HealthServiceInstance currentInstance) {
        mCurrentInstance = currentInstance;
    }

    public Instant getLastUpdated() {
        return mLastUpdated;
    }

    private void setLastUpdated(Instant lastUpdated) {
        mLastUpdated = lastUpdated;
    }
}
