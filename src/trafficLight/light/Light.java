package trafficLight.light;

/**
 * This class represents a light in a set of traffic lights.
 * 
 * @author Matthew Harward
 * @version 0.1
 */
public class Light {
	
	private LightColour lcolour;
	private LightType ltype;
	private LightState lstate;

	/**
	 * Basic constructor, assumes light is initially off.
	 */
	public Light(LightColour lcolour, LightType ltype) {
		this.lcolour = lcolour;
		this.ltype = ltype;
		lstate = LightState.OFF;
	}
	
	/**
	 * Full constructor
	 */
	public Light(LightColour lcolour, LightType ltype, 
			LightState lstate) {
		this(lcolour, ltype);
		this.lstate = lstate;
	}
	
	/**
	 * Turn light on/flashing/off.
	 * 
	 * @param illuminated the new status of the light.
	 */
	public void setState(LightState lstate) {
		this.lstate = lstate;
	}

	public LightColour getLcolour() {
		return lcolour;
	}

	public LightType getLtype() {
		return ltype;
	}

	public LightState getState() {
		return lstate;
	}
	
	/**
	 * This method overrides equals. It tests to make sure the two
	 * objects are of the same class, then it tests there colour and
	 * type to determine equality. It does NOT test there current
	 * state.
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		if(!this.getClass().equals(obj.getClass()))
			return false;
		Light a = (Light)obj;
		if(this.getLcolour().equals(a.getLcolour()) &&
				this.getLtype().equals(a.getLtype()))
			return true;
		else return false;
	}
	
	@Override
	public Light clone() {
		Light l = new Light(this.lcolour, this.ltype, this.lstate);
		return l;
	}

	@Override
	public String toString() {
		return "Light [Colour:" + getLcolour() + ", Type:"
				+ getLtype() + ", State:" + getState() + "]";
	}
	
	
}
