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

package com.microsoft.hsg.android.healthvault.methods.getvocabulary2.response;

import java.util.ArrayList;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Order;

import com.microsoft.hsg.android.healthvault.vocabs.types.VocabItem;


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
