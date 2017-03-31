/*
 * Copyright 2011 Microsoft Corp.
 * 
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.microsoft.hsg.android.simplexml.methods.searchvocabulary.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;

import com.microsoft.hsg.android.simplexml.methods.request.HVMethodRequest;
import com.microsoft.hsg.android.simplexml.methods.request.HVRequestInfo;
import com.microsoft.hsg.android.simplexml.vocabs.types.VocabIdentifier;

@Root(name = "info")
@HVMethodRequest(methodName="SearchVocabulary", methodVersion="1")
@Order(elements = {
    "vocabulary-key",
    "text-search-parameters"
})
public class SearchVocabularyRequest implements HVRequestInfo {

	@Element(name="vocabulary-key", required=false)
	protected VocabIdentifier vocabKey;
	
	@Element(name="text-search-parameters", required=true)
	protected VocabSearch vocabSearch;

	public VocabIdentifier getVocabKey() {
		return vocabKey;
	}

	public void setVocabKey(VocabIdentifier vocabKey) {
		this.vocabKey = vocabKey;
	}

	public VocabSearch getVocabSearch() {
		return vocabSearch;
	}

	public void setVocabSearch(VocabSearch vocabSearch) {
		this.vocabSearch = vocabSearch;
	}

	public SearchVocabularyRequest(VocabIdentifier vocabKey,
		VocabSearch vocabSearch) {
		this.vocabKey = vocabKey;
		this.vocabSearch = vocabSearch;
	}

	public SearchVocabularyRequest() {
	}
}
