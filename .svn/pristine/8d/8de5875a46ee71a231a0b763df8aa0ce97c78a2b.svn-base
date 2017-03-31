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
package com.microsoft.hsg.android.simplexml.things.types.immunization;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;

import com.microsoft.hsg.android.simplexml.things.thing.AbstractThing;
import com.microsoft.hsg.android.simplexml.things.types.base.CodableValue;
import com.microsoft.hsg.android.simplexml.things.types.base.Person;
import com.microsoft.hsg.android.simplexml.things.types.dates.ApproxDate;

@Order(elements = { 
	"name", 
	"administration-date", 
	"administrator",
	"manufacturer", 
	"lot", 
	"route", 
	"expiration-date",
	"sequence",
	"adverse-event", 
	"consent" })
@Root(name = "immunization")
public class Immunization extends AbstractThing {
	public static final String ThingType = "cd3587b5-b6e1-4565-ab3b-1c3ad45eb04f";
	
	@Element(name = "name", required = true)
	protected CodableValue name;

	@Element(name = "administration-date", required = false)
	protected ApproxDate administrationDate;

	@Element(name = "administrator", required = false)
	protected Person administrator;

	

	@Element(name = "manufacturer", required = false)
	protected CodableValue manufacturer;

	@Element(name = "lot", required = false)
	protected String lot;

	@Element(name = "route", required = false)
	protected String route;

	@Element(name = "expiration-date", required = false)
	protected ApproxDate expirationDate;

	@Element(name = "sequence", required = false)
	protected String sequence;
	
	@Element(name = "anatomic-surface", required = false)
	protected CodableValue anatomicSurface;

	@Element(name = "adverse-event", required = false)
	protected String adverseEvent;

	@Element(name = "consent", required = false)
	protected String consent;
	
	public CodableValue getName() {
		return name;
	}

	public void setName(CodableValue value) {
		this.name = value;
	}

	public ApproxDate getAdministrationDate() {
		return administrationDate;
	}

	public void setAdministrationDate(ApproxDate value) {
		this.administrationDate = value;
	}

	public Person getAdministrator() {
		return administrator;
	}

	public void setAdministrator(Person value) {
		this.administrator = value;
	}

	public CodableValue getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(CodableValue value) {
		this.manufacturer = value;
	}

	public String getLot() {
		return lot;
	}

	public void setLot(String value) {
		this.lot = value;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String value) {
		this.route = value;
	}

	public ApproxDate getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(ApproxDate value) {
		this.expirationDate = value;
	}
	
	public String getSequence() {
		return sequence;
	}
	
	public void setSequence(String value) {
		this.sequence = value;
	}
	
	public CodableValue getAnatomicSurface() {
		return anatomicSurface;
	}
	
	public void setAnatomicSurface(CodableValue value) {
		this.anatomicSurface = value;
	}
	
	public String getAdverseEvent() {
		return adverseEvent;
	}
	
	public void setAdverseEvent(String value) {
		this.adverseEvent = value;
	}
	
	public String getConsent() {
		return consent;
	}
	
	public void setConsent(String value) {
		this.consent = value;
	}
	
	@Override
	public String getThingType() {
		return ThingType;
	}
}
