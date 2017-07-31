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

package com.microsoft.healthvault.methods.getvocabulary2.request;

import com.microsoft.healthvault.vocabulary.VocabularyKey;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

@Order(elements = {
	"vocabulary-key",
	"fixed-culture"
})

@Root(name="vocabulary-parameters")
public class VocabGetParams {
	
	@ElementList(entry = "vocabulary-key", inline = true)
	protected ArrayList<VocabularyKey> vocabIds;
	
	@Element(name = "fixed-culture", required = true)
	protected Boolean fixedCulture;
	
	public ArrayList<VocabularyKey> getVocabIds() {
		return vocabIds;
	}

	public void setVocabIds(ArrayList<VocabularyKey> vocabIds) {
		this.vocabIds = vocabIds;
	}
	
	public Boolean isFixedCulture() {
		return fixedCulture;
	}

	public void setFixedCulture(Boolean value) {
		this.fixedCulture = value;
	}

	public VocabGetParams(ArrayList<VocabularyKey> vocabIds,
			Boolean fixedCulture) {
		this.vocabIds = vocabIds;
		this.fixedCulture = fixedCulture;
	}

	public VocabGetParams(ArrayList<VocabularyKey> vocabIds) {
		this(vocabIds, false);
	}
	
	public VocabGetParams() {
	}
}
