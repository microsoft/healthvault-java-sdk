package com.microsoft.hsg.android.simplexml.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import junit.framework.TestCase;

import android.util.Base64;

import com.microsoft.hsg.android.simplexml.ConnectionFactory;
import com.microsoft.hsg.android.simplexml.HealthVaultApp;
import com.microsoft.hsg.android.simplexml.things.store.impl.ThingStoreProvider;
import com.microsoft.hsg.android.simplexml.things.thing.Thing2;
import com.microsoft.hsg.android.simplexml.things.thing.ThingType;
import com.microsoft.hsg.android.simplexml.things.types.allergy.Allergy;
import com.microsoft.hsg.android.simplexml.things.types.appointment.Appointment;
import com.microsoft.hsg.android.simplexml.things.types.base.CodableValue;
import com.microsoft.hsg.android.simplexml.things.types.base.ConcentrationValue;
import com.microsoft.hsg.android.simplexml.things.types.base.DisplayValue;
import com.microsoft.hsg.android.simplexml.things.types.base.NonNegativeDouble;
import com.microsoft.hsg.android.simplexml.things.types.base.WeightValue;
import com.microsoft.hsg.android.simplexml.things.types.cholesterol.Cholesterol;
import com.microsoft.hsg.android.simplexml.things.types.condition.Condition;
import com.microsoft.hsg.android.simplexml.things.types.dates.DateTime;
import com.microsoft.hsg.android.simplexml.things.types.medication.Medication;
import com.microsoft.hsg.android.simplexml.things.types.weight.Weight;

import com.microsoft.hsg.android.simplexml.things.types.immunization.Immunization;

public class DummyThingStoreProviderTest extends TestCase {

	ThingStoreProvider provider;
	
	public DummyThingStoreProviderTest() {
	}
	
	private void Init()
	{
		if (provider == null) {
		HVSettings settings = new HVSettings();
		HealthVaultApp app = new HealthVaultApp(settings);
		HealthVaultApp.setInstance(app);
	    provider = new ThingStoreProvider(
		    "3402dc9e-a444-4d96-8004-8b9a165c71f3",
	        "29a42ebb-397c-4fb5-a6ac-17b17c0c82b7");
		provider.setConnection(
				ConnectionFactory.getConnection(
			            "90976b0c-e0c2-467e-b65c-ed9117aa94e9",
			            Base64.decode("JpGYZ54MRAhy2Gw9uoWCfxTG97ufR3v7kZ/i2JG+Utw=", Base64.DEFAULT)));
		}
	}
	
	public void getThingsTest() {
		Init();

		List<Thing2> things = provider.getThingsByType(Allergy.ThingType);
		things = provider.getThingsByType(Appointment.ThingType);
		things = provider.getThingsByType(Condition.ThingType);
		things = provider.getThingsByType(Medication.ThingType);
		things = provider.getThingsByType(Weight.ThingType);
	}
	
	public void putThingsTest() {
		Init();
		
		Thing2 thing = new Thing2();
		thing.setData(new Weight(52));
		
		ArrayList<Thing2> l = new ArrayList<Thing2>();
		l.add(thing);
	
		provider.putThings(l);
	}
	
	public void getImmunizationTest() {
		Init();
		List<Thing2> things = provider.getThingsByType(Immunization.ThingType);
	}
	
	public void putImmunizationTest() {
		Init();
		
		Immunization immunization = new Immunization();
		
		CodableValue cv = new CodableValue();
		cv.setText("someText");
		
		immunization.setName(cv);
		
		ThingType type = new ThingType();
		type.setValue(Immunization.ThingType);
		
		Thing2 thing = new Thing2();
		thing.setData(immunization);
		thing.setTypeId(type);
		
		ArrayList<Thing2> l = new ArrayList<Thing2>();
		l.add(thing);
		
		provider.putThings(l);
	}
	
	public void getCholesterolTest() {
		Init();
		List<Thing2> things = provider.getThingsByType(Cholesterol.ThingType);
	}
	
	public void putCholesterolTest() {
		Init();
		
		Cholesterol cholesterol = new Cholesterol();
		cholesterol.setWhen(DateTime.fromCalendar(Calendar.getInstance()));
		
		ConcentrationValue ldl = new ConcentrationValue();
		// NonNegativeDouble value = new NonNegativeDouble(20);
		ldl.setValue(20);
		
		DisplayValue disVal = new DisplayValue();
		disVal.setText("someval");
		disVal.setUnits("someunits");
		ldl.setDisplayValue(disVal);
		
		cholesterol.setLdl(ldl);
		
		ThingType type = new ThingType();
		type.setValue(Cholesterol.ThingType);
		
		Thing2 thing = new Thing2();
		thing.setData(cholesterol);
		thing.setTypeId(type);
		
		ArrayList<Thing2> l = new ArrayList<Thing2>();
		l.add(thing);
		
		provider.putThings(l);
	}
	
	public void getAllergyThingsTest() {
		Init();

		List<Thing2> things = provider.getThingsByType(Allergy.ThingType);
	}
}
