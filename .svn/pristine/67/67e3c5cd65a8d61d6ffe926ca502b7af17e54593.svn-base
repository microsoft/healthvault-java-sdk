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

import java.util.ArrayList;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;

import com.microsoft.hsg.android.simplexml.vocabs.types.VocabIdentifier;

@Order(elements = {
	"vocabulary-key",
	"fixed-culture"
})

@Root(name="vocabulary-parameters")
public class VocabGetParams {
	
	@ElementList(entry = "vocabulary-key", inline = true)
	protected ArrayList<VocabIdentifier> vocabIds;
	
	@Element(name = "fixed-culture", required = true)
	protected Boolean fixedCulture;
	
	public ArrayList<VocabIdentifier> getVocabIds() {
		return vocabIds;
	}

	public void setVocabIds(ArrayList<VocabIdentifier> vocabIds) {
		this.vocabIds = vocabIds;
	}
	
	public Boolean isFixedCulture() {
		return fixedCulture;
	}

	public void setFixedCulture(Boolean value) {
		this.fixedCulture = value;
	}

	public VocabGetParams(ArrayList<VocabIdentifier> vocabIds,
			Boolean fixedCulture) {
		this.vocabIds = vocabIds;
		this.fixedCulture = fixedCulture;
	}

	public VocabGetParams(ArrayList<VocabIdentifier> vocabIds) {
		this(vocabIds, false);
	}
	
	public VocabGetParams() {
	}
}
