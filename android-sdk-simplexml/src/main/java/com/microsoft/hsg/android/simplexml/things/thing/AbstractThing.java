package com.microsoft.hsg.android.simplexml.things.thing;

public abstract class AbstractThing implements HealthVaultThing {
	
	private Thing2 thing;

	@Override
	public Thing2 getThing() {
		if (thing == null) {
			thing = new Thing2();
			thing.setData(this);
		}
		
		return thing;
	}
	
	void setThing(Thing2 thing) {
		this.thing = thing;
	}
}
