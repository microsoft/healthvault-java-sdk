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
package com.microsoft.hsg.android.simplexml.vocabs.types;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;



@Order(elements = {
    "code-value",
    "display-text",
    "abbreviation-text",
    "info-xml"
})

public class VocabItem {
	
	@Element(name="code-value", required = true)
	protected String code;
	
	@Element(name="display-text", required = false)
	protected String displayText;
	
	@Element(name="abbreviation-text", required = false)
	protected String abbrv;
	
	@Element(name="info-xml", required = false)
	public VocabData data;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDisplayText() {
		return displayText;
	}

	public void setDisplayText(String displayText) {
		this.displayText = displayText;
	}

	public String getAbbrv() {
		return abbrv;
	}

	public void setAbbrv(String abbrv) {
		this.abbrv = abbrv;
	}

	public VocabData getData() {
		return data;
	}

	public void setData(VocabData data) {
		this.data = data;
	}
}
