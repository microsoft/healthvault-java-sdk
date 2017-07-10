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

package com.microsoft.hsg.android.healthvault.things.types;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;

import com.microsoft.hsg.android.healthvault.things.thing.AbstractThing;
import com.microsoft.hsg.android.healthvault.things.types.base.ConcentrationValue;
import com.microsoft.hsg.android.healthvault.things.types.dates.DateTime;

@Order(elements = { 
	"when",
	"ldl", 
	"hdl",
	"total", 
	"triglycerides" })
@Root(name = "cholesterol-profile")
public class Cholesterol extends AbstractThing {
	public static final String ThingType = "98f76958-e34f-459b-a760-83c1699add38";

	@Element(name = "when", required = true)
	protected DateTime when;

	@Element(name = "ldl", required = false)
	protected ConcentrationValue ldl;

	@Element(name = "hdl", required = false)
	protected ConcentrationValue hdl;

	@Element(name = "total", required = false)
	protected ConcentrationValue total;

	@Element(name = "triglycerides", required = false)
	protected ConcentrationValue triglycerides;

	public DateTime getWhen() {
		return when;
	}

	public void setWhen(DateTime value) {
		this.when = value;
	}

	public ConcentrationValue getLdl() {
		return ldl;
	}

	public void setLdl(ConcentrationValue value) {
		this.ldl = value;
	}

	public ConcentrationValue getHdl() {
		return hdl;
	}

	public void setHdl(ConcentrationValue value) {
		this.hdl = value;
	}

	public ConcentrationValue getTotal() {
		return total;
	}

	public void setTotal(ConcentrationValue value) {
		this.total = value;
	}

	public ConcentrationValue getTriglycerides() {
		return triglycerides;
	}

	public void setTriglycerides(ConcentrationValue value) {
		this.triglycerides = value;
	}
	
	@Override
	public String getThingType() {
		return ThingType;
	}
}