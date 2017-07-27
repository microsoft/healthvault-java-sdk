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

import com.microsoft.healthvault.methods.getvocabulary2.response.VocabCodeSet;
import com.microsoft.healthvault.methods.searchvocabulary.request.VocabMatchType;
import com.microsoft.healthvault.types.VocabIdentifier;
import com.microsoft.healthvault.types.VocabItem;

import java.util.ArrayList;

public interface IVocabularyClient extends IClient {
    /**
     * Retrieves a collection of key information for identifying and describing the vocabularies in the system.
     * @return A collection of keys identifying the vocabularies in the system.
     */
    ArrayList<VocabIdentifier> getVocabularyKeysAsync();

    /**
     * A collection of keys identifying the vocabularies in the system.
     * @param key The key for the vocabulary to fetch.
     * @param cultureIsFixed HealthVault looks for the vocabulary items for the culture info
     *          specified by the system.
     *          <p>If <b>cultureIsFixed</b> is set to <code>false</code> and if items are not found
     *          for the specified culture, items for the default fallback culture are returned.</p>
     *          <p>If <b>cultureIsFixed</b> is set to <code>true</code>, fallback will not occur,
     *          and if items are not found for the specified culture, empty strings are returned.</p>
     * @return The specified vocabulary and its items, or empty strings.
     */
    ArrayList<VocabCodeSet> getVocabularyAsync(VocabIdentifier key, boolean cultureIsFixed);

    /**
     * Retrieves lists of vocabulary items for the specified vocabularies in the user's current culture.
     * @param vocabularyKeys A list of identifiers for the vocabularies to fetch.
     * @param cultureIsFixed HealthVault looks for the vocabulary items for the culture info
     *          specified by the system.
     *          <p>If <b>cultureIsFixed</b> is set to <code>false</code> and if items are not found
     *          for the specified culture, items for the default fallback culture are returned.</p>
     *          <p>If <b>cultureIsFixed</b> is set to <code>true</code>, fallback will not occur,
     *          and if items are not found for the specified culture, empty strings are returned.</p>
     * @return One of the specified vocabularies and its items, or empty strings.
     */
    ArrayList<VocabCodeSet> getVocabulariesAsync(
            ArrayList<VocabIdentifier> vocabularyKeys,
            boolean cultureIsFixed);

    /**
     * Searches a specific vocabulary and retrieves the matching vocabulary items.
     * @param searchValue The search string to use.
     * @param searchType The type of search to perform.
     * @param maxResults The maximum number of results to return. If zero, all matching results are
     *                   returned, up to a maximum number defined by the service config value with
     *                   key maxResultsPerVocabularyRetrieval.
     * @return A list of {@link VocabIdentifier} populated with entries matching the search criteria.
     */
    ArrayList<VocabItem> searchVocabularyAsync(String searchValue, VocabMatchType searchType, int maxResults);
}
