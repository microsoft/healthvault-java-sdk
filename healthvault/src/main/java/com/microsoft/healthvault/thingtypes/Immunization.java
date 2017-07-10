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

package com.microsoft.healthvault.thingtypes;

import com.microsoft.healthvault.types.CodableValue;
import com.microsoft.healthvault.types.Person;
import com.microsoft.healthvault.types.ApproxDate;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;

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
