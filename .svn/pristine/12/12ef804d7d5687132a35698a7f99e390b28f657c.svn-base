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

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;

@Order(elements = {
	"mmolPerL",
    "display"
})

public class ConcentrationValue {

	@Element(name = "mmolPerL", required = true)
	protected NonNegativeDouble value;

	@Element(name = "display", required = false)
	protected DisplayValue displayValue;

	public Double getValue() {
		return value == null ? null : value.getValue();
	}

	public void setValue(double value) {
		this.value = new NonNegativeDouble(value);
	}

	public DisplayValue getDisplayValue() {
		return displayValue;
	}

	public void setDisplayValue(DisplayValue value) {
		this.displayValue = value;
	}

	@Override
	public String toString() {
		return displayValue != null 
				&& (displayValue.text != null && displayValue.text.length() > 0) 
				? displayValue.text
				: value.toString();
	}
}
