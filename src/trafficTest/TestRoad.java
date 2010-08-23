package trafficTest;

import trafficLight.lightSet.FullLightSet;
import trafficLight.roads.DeadEnd;
import trafficLight.roads.Road;
import trafficLight.roads.RoadSection;
import trafficLight.roads.TrafficLight;
import junit.framework.TestCase;

public class TestRoad extends TestCase {

	public void testRoad1() {
		Road r = new Road("Main Street");
		assertNotNull(r);
		assertEquals("Main Street", r.getName());
		RoadSection rs1 = new RoadSection();
		RoadSection rs2 = new RoadSection();
		RoadSection rs3 = new RoadSection();
		
		rs1.setSectionEnd(new DeadEnd(), null,
				new TrafficLight(new FullLightSet()), rs2);
		rs2.setSectionEnd(new TrafficLight(new FullLightSet()), rs3,
				new TrafficLight(new FullLightSet()), rs1);
		rs3.setSectionEnd(new DeadEnd(), null,
				new TrafficLight(new FullLightSet()), rs3);
		
		r.addPart(rs1);
		r.addPart(rs2);
		r.addPart(rs3);
		
		assertEquals(null,r.before(rs1));
		assertEquals(rs2,r.after(rs1));
		assertEquals(rs2,r.before(rs3));
		assertEquals(null,r.after(rs3));
		
	}
	
	public void testRoad2() {
		
	}
}
