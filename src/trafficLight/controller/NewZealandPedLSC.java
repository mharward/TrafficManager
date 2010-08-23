package trafficLight.controller;

import trafficLight.light.LightColour;
import trafficLight.light.LightState;
import trafficLight.light.LightType;
import trafficLight.roads.TrafficLight;

public class NewZealandPedLSC extends LightSetController{

	private static final boolean multilight = false;
	
	@Override
	public void error(TrafficLight ir, LightType lt) {
		setActiveColour(ir, LightColour.RED, lt, LightState.OFF,
				false);
	}

	@Override
	public void go(TrafficLight ir, LightType lt) {
		setActiveColour(ir, LightColour.GREEN, lt, LightState.ON,
				false);
	}

	@Override
	public void prepareToGo(TrafficLight ir, LightType lt) {
		setActiveColour(ir, LightColour.RED, lt, LightState.ON,
				false);
	}

	@Override
	public void prepareToStop(TrafficLight ir, LightType lt) {
		setActiveColour(ir, LightColour.RED, lt, LightState.FLASH,
				false);
	}

	@Override
	public void stop(TrafficLight ir, LightType lt) {
		setActiveColour(ir, LightColour.RED, lt, LightState.ON,
				false);
	}

	@Override
	public void inactive(TrafficLight ir, LightType lt) {
		setActiveColour(ir, LightColour.RED, lt, 
				LightState.OFF, false);
	}

}
