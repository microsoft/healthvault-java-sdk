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

package com.microsoft.healthvault.types;

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
