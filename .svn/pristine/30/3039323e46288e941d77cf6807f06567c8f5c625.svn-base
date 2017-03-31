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
package com.microsoft.hsg.android.simplexml.things.types.base;

import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.Root;

@Root(name=LabTestResultsData.RootElement)
public class LabTestResultsData {

	public static final String RootElement = "lab-panel";
	
	@ElementArray(name="test-results")
	protected TestResultData[] data;

	public TestResultData[] getData() {
		return data;
	}

	public void setData(TestResultData[] data) {
		this.data = data;
	}
}
