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
package com.microsoft.hsg.android.simplexml.methods.getvocabulary2.response;

import java.util.ArrayList;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Order;

import com.microsoft.hsg.android.simplexml.vocabs.types.VocabItem;


@Order(elements = {
    "name",
    "family",
    "version",
    "code-item",
    "is-vocab-truncated"
})

public class VocabCodeSet {

	@Element(name="name", required=true)
	protected String name;
	
	@Element(name="family", required=true)
	protected String family;
	
	@Element(name="version", required=true)
	protected String version;
	
	@ElementList(entry="code-item", inline=true, required=false)
	protected ArrayList<VocabItem> items;
	
	@Element(name="is-vocab-truncated", required=false)
	protected Boolean isTrunctated;

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

	public ArrayList<VocabItem> getItems() {
		return items;
	}

	public void setItems(ArrayList<VocabItem> items) {
		this.items = items;
	}

	public Boolean getIsTrunctated() {
		return isTrunctated;
	}

	public void setIsTrunctated(Boolean isTrunctated) {
		this.isTrunctated = isTrunctated;
	}
}
