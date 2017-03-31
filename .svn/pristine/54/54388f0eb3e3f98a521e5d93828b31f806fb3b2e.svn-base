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

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;

@Order(elements = {
	"name", 
	"family",
	"version", 
	"code-value"
})

@Root(name = "vocabulary-key")
public class VocabIdentifier {
	
	private String keyString;

	@Element(name = "name", required = true)
	protected String name;
	
	@Element(name = "family", required = false)
	protected String family;
	
	@Element(name = "version", required = false)
	protected String version;
	
	@Element(name = "code-value", required = false)
	protected String codeValue;
	
	@Attribute(name = "xml:lang", required = false)
	protected String language;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getCodeValue() {
		return codeValue;
	}

	public void setCodeValue(String codeValue) {
		this.codeValue = codeValue;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	
	public VocabIdentifier(String family, String name) {
		this.name = name;
		this.family = family;
	}
	
	public VocabIdentifier() {
		
	}
	
	public String GetKey() {
		if(keyString == null) {
			keyString = String.format("{0}_{1}_{2}", name, family, version);
		}
		
		return keyString;
	}
}
