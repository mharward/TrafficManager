package trafficLight.lightSet;

import java.util.Collection;

import trafficLight.light.Light;

/**
 * <p>This class represents the sets of lights provided at an
 * intersection. Several light sets may be provided to traffic
 * travelling in one direction. </p>
 * <p> For example: lights heading north in a multi-lane senario
 * may feature on the left, sets of lights with left hand arrows,
 * in the middle all lights, and to the right, right hand arrows.
 * (In a left hand drive situation)</p>
 * <p>A controller should not attempt to change a provided light
 * set directly, instead it should control a FullLightSet.<p>
 * 
 * @author Matthew Harward
 * @version 0.1
 */
public class ProvidedLightSet extends LightSet {
	
	//Could use observer??????????
	
	private FullLightSet setToMirror;
	
	public ProvidedLightSet(FullLightSet mirror) {
		super();
		this.setToMirror = mirror;
	}
	
	/**
	 * Makes sure the Light Set being mirrored also contains this
	 * light. Then attempt to add the light.
	 * @see {@link LightSet#addLight(Light)}
	 */
	@Override
	public boolean addLight(Light newLight){
		if(setToMirror.getLights().contains(newLight))
			return false;
		return super.addLight(newLight);
	}
	
	@SuppressWarnings("unchecked")
	public void duplicateFullLightSet() {
		for(Light l : setToMirror.getLights()) {
			super.lights.add(l.clone());
		}
	}

	/**
	 * This method checks the set it is mirroring and modifies
	 * the object so that all of the lights it holds are in a
	 * consistent state with the mirrored FullLightSet.
	 */
	public void setToMatch() {
		for(Light l : setToMirror.getLights()) {
			for(Light mirrorL : super.lights) {
				if(mirrorL.equals(l)) {
					mirrorL.setState(l.getState());
				}
			}
		}
	}
}
