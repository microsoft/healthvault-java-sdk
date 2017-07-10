 /**
 * 
 */
package com.microsoft.healthvault.things.store;

 import com.microsoft.healthvault.things.thing.Thing2;

 import java.util.List;

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
