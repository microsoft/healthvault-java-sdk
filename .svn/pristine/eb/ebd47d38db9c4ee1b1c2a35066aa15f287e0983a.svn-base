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
package com.microsoft.hsg.android.simplexml.methods.searchvocabulary.response;

import java.util.ArrayList;

import org.simpleframework.xml.ElementList;

import com.microsoft.hsg.android.simplexml.vocabs.types.VocabItem;

public class VocabQueryResult {
	
	@ElementList(entry="code-item", inline=true, required=false)
	protected ArrayList<VocabItem> items;

	public ArrayList<VocabItem> getItems() {
		return items;
	}

	public void setItems(ArrayList<VocabItem> items) {
		this.items = items;
	}
	
    public Boolean hasItems()
    {
        return !(items == null || items.isEmpty());
    }
}
