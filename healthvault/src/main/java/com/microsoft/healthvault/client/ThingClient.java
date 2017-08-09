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

import com.microsoft.healthvault.HealthVaultApp;
import com.microsoft.healthvault.IHealthVaultConnection;
import com.microsoft.healthvault.methods.getthings3.request.GetThings3Request;
import com.microsoft.healthvault.methods.getthings3.request.ThingFilterSpec;
import com.microsoft.healthvault.methods.getthings3.request.ThingRequestGroup2;
import com.microsoft.healthvault.methods.getthings3.response.GetThings3Response;
import com.microsoft.healthvault.methods.putthings2.request.PutThings2Request;
import com.microsoft.healthvault.methods.putthings2.response.PutThings2Response;
import com.microsoft.healthvault.methods.removethings.request.RemoveThingsRequest;
import com.microsoft.healthvault.methods.removethings.response.RemoveThingsResponse;
import com.microsoft.healthvault.methods.request.RequestTemplate;
import com.microsoft.healthvault.thingtypes.AbstractThing;
import com.microsoft.healthvault.thingtypes.HealthVaultThing;
import com.microsoft.healthvault.thingtypes.Thing2;
import com.microsoft.healthvault.thingtypes.ThingKey;
import com.microsoft.healthvault.types.Guid;
import com.microsoft.healthvault.types.PersonInfo;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ThingClient extends Client implements IThingClient {
    private PersonInfo personInfo;
    private IHealthVaultConnection connection;

    public ThingClient(IHealthVaultConnection connection) {
        this.connection = connection;
        this.personInfo = connection.getPersonInfo();
    }

    @Override
    public <T extends AbstractThing> T getThingAsync(Guid recordId, Guid thingId) {
        RequestTemplate requestTemplate = new RequestTemplate(
                HealthVaultApp.getInstance().getConnection(),
                this.personInfo.getPersonId(),
                recordId.get().toString());

        ThingRequestGroup2 requestGroup = new ThingRequestGroup2();
        requestGroup.setFormat(requestGroup.getFormat());
        requestGroup.getThingIdList().add(thingId.get().toString());

        GetThings3Request request = new GetThings3Request();
        request.getGroup().add(requestGroup);

        GetThings3Response response = requestTemplate.makeRequest(
                request,
                GetThings3Response.class);

        List<Thing2> result = response.getInfo().getGroup().get(0).getThing();

        if (result.size() <= 0) { return null; }

        return ((T) result.get(0).getData());
    }

    @Override
    public List<AbstractThing> getThingsAsync(Guid recordId, ThingFilterSpec query){
        List<ThingFilterSpec> queries = new ArrayList<ThingFilterSpec>();
        queries.add(query);

        return getThingsWithFilters(recordId, queries);
    }

    @Override
    public List<AbstractThing> getThingsAsync(Guid recordId, List<ThingFilterSpec> queries)
    {
        return getThingsWithFilters(recordId, queries);
    }

    @Override
    public <T extends AbstractThing> List<T> getThingsOfTypeAsync(Guid recordId, ThingFilterSpec query) {
        List<AbstractThing> things = getThingsAsync(recordId, query);
        List<T> result = new ArrayList<T>();

        for (AbstractThing thing : things) {
            T obj = (T) thing;

            if (obj != null) {
                result.add(obj);
            }
        }

        return result;
    }

    @Override
    public <T extends AbstractThing> List<ThingKey> createThingsAsync(Guid recordId, List<T> things) {
        PutThings2Request request = new PutThings2Request();

        for (T thing : things) {
            request.getThing().add(thing.getThing());
        }

        RequestTemplate template = new RequestTemplate(
                HealthVaultApp.getInstance().getConnection(),
                this.personInfo.getPersonId(),
                recordId.get().toString());

        PutThings2Response response = template.makeRequest(request, PutThings2Response.class);

        ArrayList<ThingKey> result = new ArrayList<ThingKey>();
        result.addAll(response.getInfo().getThingId());
        return result;
    }

    @Override
    public <T extends AbstractThing> void updateThingsAsync(Guid recordId, List<T> things)
    {
        for (T thing : things) {
            if (thing.getThing().getThingId() == null
                    || StringUtils.isBlank(thing.getThing().getThingId().getValue())) {
                throw new IllegalArgumentException();
            }
        }

        createThingsAsync(recordId, things);
    }

    @Override
    public <T extends AbstractThing> void removeThingsAsync(Guid recordId, List<T> things) {
        ArrayList<ThingKey> keys = new ArrayList<ThingKey>();

        for (T thing : things) {
            keys.add(thing.getThing().getThingId());
        }

        RemoveThingsRequest request = new RemoveThingsRequest();
        request.getThingId().addAll(keys);

        RequestTemplate template = new RequestTemplate(
                HealthVaultApp.getInstance().getConnection(),
                this.personInfo.getPersonId(),
                recordId.get().toString());

        template.makeRequest(request, RemoveThingsResponse.class);
    }

    private List<AbstractThing> getThingsWithFilters(Guid recordId, List<ThingFilterSpec> queries) {
        RequestTemplate requestTemplate = new RequestTemplate(
                HealthVaultApp.getInstance().getConnection(),
                this.personInfo.getPersonId(),
                recordId.get().toString());

        ThingRequestGroup2 requestGroup = new ThingRequestGroup2();
        requestGroup.setFormat(requestGroup.getFormat());

        for (ThingFilterSpec query : queries) {
            requestGroup.getFilterList().add(query);
        }

        GetThings3Request request = new GetThings3Request();
        request.getGroup().add(requestGroup);

        GetThings3Response response = requestTemplate.makeRequest(
                request,
                GetThings3Response.class);

        List<Thing2> result = response.getInfo().getGroup().get(0).getThing();

        List<AbstractThing> returnValue = new ArrayList<AbstractThing>();

        for (int i = 0; i < result.size(); i++) {
            returnValue.add(result.get(i).getData());
        }

        return returnValue;
    }
}
