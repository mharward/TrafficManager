package trafficLight.lightSet;

import java.util.HashSet;
import java.util.Set;

import trafficLight.light.Light;

/**
 * This class represents a set of lights. It is abstract and
 * subclassed by classes that produce a global or subset of lights.
 * @author Matthew
 *
 */
public abstract class LightSet {
	
	protected Set<Light> lights;
	
	/**
	 * This constructor should only be called by subclasses and
	 * can be used to instantiate an empty light set.
	 */
	protected LightSet() {
		lights = new HashSet<Light>();
	}
	
	/**
	 * This method will attempt to add a new light to the set.
	 * 
	 * @param newLight The light to be added.
	 * @return Whether the adding was successful or not. Adding a new
	 * light will always be successful unless the light is equals
	 * to an existing light in the set.
	 */
	public boolean addLight(Light newLight) {
		return lights.add(newLight);
	}
	
	public Set<Light> getLights() {
		return lights;
	}
	
}
