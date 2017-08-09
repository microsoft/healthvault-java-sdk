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

import com.microsoft.healthvault.HealthServiceResponseData;
import com.microsoft.healthvault.HealthVaultApp;
import com.microsoft.healthvault.IHealthVaultConnection;
import com.microsoft.healthvault.methods.HealthVaultMethods;
import com.microsoft.healthvault.methods.getvocabulary2.request.GetVocabulary2Request;
import com.microsoft.healthvault.methods.getvocabulary2.request.VocabGetParams;
import com.microsoft.healthvault.methods.getvocabulary2.response.GetVocabulary2KeyResponse;
import com.microsoft.healthvault.methods.getvocabulary2.response.GetVocabulary2Response;
import com.microsoft.healthvault.methods.getvocabulary2.response.VocabCodeSet;
import com.microsoft.healthvault.methods.getvocabulary2.response.VocabKey;
import com.microsoft.healthvault.methods.request.RequestTemplate;
import com.microsoft.healthvault.methods.searchvocabulary.request.SearchVocabularyRequest;
import com.microsoft.healthvault.methods.searchvocabulary.request.VocabMatchType;
import com.microsoft.healthvault.methods.searchvocabulary.request.VocabSearch;
import com.microsoft.healthvault.methods.searchvocabulary.response.SearchVocabularyResponse;
import com.microsoft.healthvault.types.VocabFamily;
import com.microsoft.healthvault.types.VocabIdentifier;
import com.microsoft.healthvault.types.VocabItem;
import com.microsoft.healthvault.types.VocabName;

import java.util.ArrayList;

public class VocabularyClient extends Client implements IVocabularyClient {
    private IHealthVaultConnection connection;

    public VocabularyClient(IHealthVaultConnection connection) {
        this.connection = connection;
    }

    @Override
    public ArrayList<VocabKey> getVocabularyKeysAsync() {
        RequestTemplate requestTemplate = new RequestTemplate(HealthVaultApp.getInstance().getConnection());

        GetVocabulary2Request request = new GetVocabulary2Request();
        GetVocabulary2KeyResponse response = requestTemplate.makeRequest(
                request,
                GetVocabulary2KeyResponse.class);

        return response.getInfo().hasVocabs() ? response.getInfo().getVocabs() : null;
    }

    @Override
    public ArrayList<VocabCodeSet> getVocabularyAsync(VocabIdentifier key, boolean cultureIsFixed) {
        ArrayList<VocabIdentifier> list = new ArrayList<VocabIdentifier>();
        list.add(key);
        return getVocabulariesAsync(list, cultureIsFixed);
    }

    @Override
    public ArrayList<VocabCodeSet> getVocabulariesAsync(ArrayList<VocabIdentifier> vocabularyKeys, boolean cultureIsFixed) {
        RequestTemplate requestTemplate = new RequestTemplate(HealthVaultApp.getInstance().getConnection());

        VocabGetParams getParams = new VocabGetParams(vocabularyKeys);
        getParams.setFixedCulture(cultureIsFixed);

        GetVocabulary2Request request = new GetVocabulary2Request(getParams);

        GetVocabulary2Response response = requestTemplate.makeRequest(
                request,
                GetVocabulary2Response.class);

        return response.getInfo().getVocabs();
    }

    @Override
    public ArrayList<VocabItem> searchVocabularyAsync(VocabIdentifier vocabKey, String searchValue, VocabMatchType searchType, int maxResults) {
        RequestTemplate requestTemplate = new RequestTemplate(HealthVaultApp.getInstance().getConnection());

        VocabSearch search = new VocabSearch(searchValue);

        if (maxResults > 0) {
            search.setMaxResults(maxResults);
        }

        search.setVocabMatchType(searchType);

        SearchVocabularyRequest request = new SearchVocabularyRequest();
        request.setVocabSearch(search);
        request.setVocabKey(vocabKey);

        SearchVocabularyResponse response = requestTemplate.makeRequest(
                request,
                SearchVocabularyResponse.class);

        return response.getInfo().matches.getItems();
    }
}
