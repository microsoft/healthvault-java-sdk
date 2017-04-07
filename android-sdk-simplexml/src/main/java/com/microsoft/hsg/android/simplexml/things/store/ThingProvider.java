 /**
 * 
 */
package com.microsoft.hsg.android.simplexml.things.store;

import java.util.List;

import com.microsoft.hsg.android.simplexml.things.thing.Thing2;

/**
 * @author robmay
 *
 */
public interface ThingProvider {
	
	/**
	 * Right now this returns all the Thing wrapper data too.  We
	 * can cut this down with another method to just return the 
	 * Thing data (e.g. Weight, Allergy, ...)
	 * @param thing
	 * @return
	 */
	public List<Thing2> getThingsByType(String thingType);
	
	public void putThings(List<Thing2> things);

}
