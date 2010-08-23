package trafficTest;

import trafficLight.controller.SimpleIC;
import trafficLight.light.Light;
import trafficLight.light.LightColour;
import trafficLight.light.LightState;
import trafficLight.light.LightType;
import trafficLight.lightSet.FullLightSet;
import trafficLight.roads.Intersection;
import trafficLight.roads.TrafficLight;
import junit.framework.TestCase;

public class TestIntersectionController extends TestCase {

	public void testIntersection1() {
		Intersection i = new Intersection();
		
		FullLightSet f1 = new FullLightSet();
		f1.addLight(new Light(LightColour.GREEN, LightType.FULL));
		f1.addLight(new Light(LightColour.ORANGE, LightType.FULL));
		f1.addLight(new Light(LightColour.RED, LightType.FULL));
		TrafficLight r1 = new TrafficLight(f1);
		i.addRoad(r1);
		
		FullLightSet f2 = new FullLightSet();
		f2.addLight(new Light(LightColour.GREEN, LightType.FULL));
		f2.addLight(new Light(LightColour.ORANGE, LightType.FULL));
		f2.addLight(new Light(LightColour.RED, LightType.FULL));
		TrafficLight r2 = new TrafficLight(f2);
		i.addRoad(r2);
		
		FullLightSet f3 = new FullLightSet();
		f3.addLight(new Light(LightColour.GREEN, LightType.FULL));
		f3.addLight(new Light(LightColour.ORANGE, LightType.FULL));
		f3.addLight(new Light(LightColour.RED, LightType.FULL));
		TrafficLight r3 = new TrafficLight(f3);
		i.addRoad(r3);
		
		FullLightSet f4 = new FullLightSet();
		f4.addLight(new Light(LightColour.GREEN, LightType.FULL));
		f4.addLight(new Light(LightColour.ORANGE, LightType.FULL));
		f4.addLight(new Light(LightColour.RED, LightType.FULL));
		TrafficLight r4 = new TrafficLight(f4);
		i.addRoad(r4);
		
		assertTrue(i.getRoads().size() == 4);
	}
	
	public void testIntersectionController1() {
		Intersection i = new Intersection();
		
		FullLightSet f1 = new FullLightSet();
		f1.addLight(new Light(LightColour.GREEN, LightType.FULL));
		f1.addLight(new Light(LightColour.ORANGE, LightType.FULL));
		f1.addLight(new Light(LightColour.RED, LightType.FULL));
		TrafficLight r1 = new TrafficLight(f1);
		i.addRoad(r1);
		
		FullLightSet f2 = new FullLightSet();
		f2.addLight(new Light(LightColour.GREEN, LightType.FULL));
		f2.addLight(new Light(LightColour.ORANGE, LightType.FULL));
		f2.addLight(new Light(LightColour.RED, LightType.FULL));
		TrafficLight r2 = new TrafficLight(f2);
		i.addRoad(r2);
		
		FullLightSet f3 = new FullLightSet();
		f3.addLight(new Light(LightColour.GREEN, LightType.FULL));
		f3.addLight(new Light(LightColour.ORANGE, LightType.FULL));
		f3.addLight(new Light(LightColour.RED, LightType.FULL));
		TrafficLight r3 = new TrafficLight(f3);
		i.addRoad(r3);
		
		FullLightSet f4 = new FullLightSet();
		f4.addLight(new Light(LightColour.GREEN, LightType.FULL));
		f4.addLight(new Light(LightColour.ORANGE, LightType.FULL));
		f4.addLight(new Light(LightColour.RED, LightType.FULL));
		TrafficLight r4 = new TrafficLight(f4);
		i.addRoad(r4);
		
		//TODO Needs reworking!
		
		SimpleIC sic = new SimpleIC();
		sic.go(i, r1);
		for(Light l1 : f1.getLights()) {
			if(l1.getLcolour().equals(LightColour.GREEN))
				assertTrue(l1.getState().equals(LightState.ON));
			else
				assertTrue(l1.getState().equals(LightState.OFF));
		}
		for(Light l1 : f2.getLights()) {
			if(l1.getLcolour().equals(LightColour.RED))
				assertTrue(l1.getState().equals(LightState.ON));
			else
				assertTrue(l1.getState().equals(LightState.OFF));
		}
		for(Light l1 : f3.getLights()) {
			if(l1.getLcolour().equals(LightColour.GREEN))
				assertTrue(l1.getState().equals(LightState.ON));
			else
				assertTrue(l1.getState().equals(LightState.OFF));
		}
		for(Light l1 : f4.getLights()) {
			if(l1.getLcolour().equals(LightColour.RED))
				assertTrue(l1.getState().equals(LightState.ON));
			else
				assertTrue(l1.getState().equals(LightState.OFF));
		}
		sic.prepareToStop(i,r3);
		sic.stop(i,r1);
		sic.error(i,r2);
	}
	
}
