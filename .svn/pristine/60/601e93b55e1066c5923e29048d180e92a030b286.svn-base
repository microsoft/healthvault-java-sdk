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
package com.microsoft.hsg.android.simplexml.methods.getvocabulary2.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import com.microsoft.hsg.android.simplexml.methods.request.HVMethodRequest;
import com.microsoft.hsg.android.simplexml.methods.request.HVRequestInfo;

@Root(name = "info")
@HVMethodRequest(methodName="GetVocabulary", methodVersion="2")
public class GetVocabulary2Request implements HVRequestInfo {
	
	@Element(name="vocabulary-parameters")
	protected VocabGetParams vocabularyParameters;

	public VocabGetParams getVocabularyParameters() {
		return vocabularyParameters;
	}

	public void setVocabularyParameters(VocabGetParams vocabularyParameters) {
		this.vocabularyParameters = vocabularyParameters;
	}

	public GetVocabulary2Request(VocabGetParams vocabularyParameters) {
		this.vocabularyParameters = vocabularyParameters;
	}
}
