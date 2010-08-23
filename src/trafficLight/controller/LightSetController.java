package trafficLight.controller;

import java.util.Set;

import trafficLight.light.Light;
import trafficLight.light.LightColour;
import trafficLight.light.LightState;
import trafficLight.light.LightType;
import trafficLight.lightSet.ProvidedLightSet;
import trafficLight.roads.TrafficLight;

/**
 * <p> This abstract superclass details the possible operations a light
 * can face and provides a static generalised method for carrying
 * them out.</p>
 * 
 * <p><b>NB. This class should be refactored so that new traffic light
 * schema can be added without altering the source code. This 
 * could be achieved with XML, but is beyond the scope of the current
 * project (Ver.0.1 - 11/8/2010)</b></p>
 * 
 * @author Matthew Harward
 * @version 0.1
 */

public abstract class LightSetController {
	
	public abstract void go(TrafficLight ir, LightType lt);
	public abstract void stop(TrafficLight ir, LightType lt);
	public abstract void prepareToStop(TrafficLight ir, LightType lt);
	public abstract void prepareToGo(TrafficLight ir, LightType lt);
	public abstract void error(TrafficLight ir, LightType lt);
	public abstract void inactive(TrafficLight ir, LightType lt);
	
	/**
	 * <p>This static method sets the active colour for a particular 
	 * light type on a single incoming road.</p>
	 * 
	 * @param ir the road.
	 * @param lc the colour to be set active.
	 * @param lt the type to be changed.
	 * @param multilight this boolean variable determines if multiple
	 * lights of the same type may be active at any point.
	 */
	protected static void setActiveColour(TrafficLight ir, LightColour lc,
			LightType lt, LightState lstate, boolean multitype) {
		//Modify the state of the FullLightSet
		Set<Light> ls = ir.getFls().getLights();
		for(Light l : ls) {
			if(l.getLtype().equals(lt)) {
				if(l.getLcolour().equals(lc)) {
					l.setState(lstate);
				}
				//Will turn off all other lights if multitype is off.
				else if (!multitype) {
					l.setState(LightState.OFF);
				}
			}
		}
		
		//Modify the state of all ProvidedLightSets to match.
		for(ProvidedLightSet pls : ir.getPlsSet()) {
			pls.setToMatch();
		}
	}
	
}
