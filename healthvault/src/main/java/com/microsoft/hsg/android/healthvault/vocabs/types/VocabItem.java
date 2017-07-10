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

package com.microsoft.hsg.android.healthvault.vocabs.types;

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
