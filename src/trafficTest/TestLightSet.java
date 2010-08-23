package trafficTest;

import junit.framework.TestCase;
import trafficLight.controller.EnglandLSC;
import trafficLight.controller.NewZealandLSC;
import trafficLight.light.Light;
import trafficLight.light.LightColour;
import trafficLight.light.LightState;
import trafficLight.light.LightType;
import trafficLight.lightSet.FullLightSet;
import trafficLight.lightSet.ProvidedLightSet;
import trafficLight.roads.Intersection;
import trafficLight.roads.TrafficLight;

public class TestLightSet extends TestCase {

	public void testLightSet1() {
		Intersection is = new Intersection();
		FullLightSet fls = new FullLightSet();
		is.addRoad(new TrafficLight(fls));
		fls.addLight(new Light(LightColour.GREEN, LightType.FULL));
		fls.addLight(new Light(LightColour.ORANGE, LightType.FULL));
		fls.addLight(new Light(LightColour.RED, LightType.FULL));
		ProvidedLightSet pls = new ProvidedLightSet(fls);
		pls.duplicateFullLightSet();
		fls.addLight(new Light(LightColour.GREEN, LightType.LEFT));
		assertTrue(fls.getLights().size() == 4);
		assertTrue(pls.getLights().size() == 3);
		for(Light l : fls.getLights()) {
			assertEquals(LightState.OFF,l.getState());
		}
		for(Light l2 : pls.getLights()) {
			assertEquals(LightState.OFF,l2.getState());
		}
		for(Light l3 : fls.getLights()) {
			l3.setState(LightState.ON);
			assertEquals(LightState.ON,l3.getState());
		}
		for(Light l4 : pls.getLights()) {
			assertEquals(LightState.OFF,l4.getState());
		}
		pls.setToMatch();
		for(Light l5 : pls.getLights()) {
			assertEquals(LightState.ON,l5.getState());
		}	
	}
	
	public void testLightController1() {
		Intersection is = new Intersection();
		FullLightSet fls = new FullLightSet();
		TrafficLight ir = new TrafficLight(fls);
		is.addRoad(ir);
		fls.addLight(new Light(LightColour.GREEN, LightType.FULL));
		fls.addLight(new Light(LightColour.ORANGE, LightType.FULL));
		fls.addLight(new Light(LightColour.RED, LightType.FULL));
		
		NewZealandLSC lsc = new NewZealandLSC();
		lsc.error(ir, LightType.FULL);
		for(Light l : ir.getFls().getLights()) {
			assertTrue(l.getLtype().equals(LightType.FULL));
			if(l.getLcolour().equals(LightColour.ORANGE))
				assertTrue(l.getState().equals(LightState.FLASH));
			else
				assertTrue(l.getState().equals(LightState.OFF));
		}
		
		lsc.go(ir, LightType.FULL);
		for(Light l : ir.getFls().getLights()) {
			if(l.getLcolour().equals(LightColour.GREEN))
				assertTrue(l.getState().equals(LightState.ON));
			else
				assertTrue(l.getState().equals(LightState.OFF));
		}
		
		lsc.stop(ir, LightType.FULL);
		for(Light l : ir.getFls().getLights()) {
			if(l.getLcolour().equals(LightColour.RED))
				assertTrue(l.getState().equals(LightState.ON));
			else
				assertTrue(l.getState().equals(LightState.OFF));
		}
		
		EnglandLSC elsc = new EnglandLSC();
		
		elsc.prepareToGo(ir, LightType.FULL);
		for(Light l : ir.getFls().getLights()) {
			if(l.getLcolour().equals(LightColour.RED) || 
					l.getLcolour().equals(LightColour.ORANGE))
				assertTrue(l.getState().equals(LightState.ON));
			else
				assertTrue(l.getState().equals(LightState.OFF));
		}
	}
}
