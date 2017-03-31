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
package com.microsoft.hsg.android.simplexml.things.types.cholesterol;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;

import com.microsoft.hsg.android.simplexml.things.thing.AbstractThing;
import com.microsoft.hsg.android.simplexml.things.thing.HealthVaultThing;
import com.microsoft.hsg.android.simplexml.things.types.base.ConcentrationValue;
import com.microsoft.hsg.android.simplexml.things.types.dates.DateTime;

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