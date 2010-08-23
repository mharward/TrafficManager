package trafficLight.roads;

import java.util.HashSet;
import java.util.Set;


public class Intersection extends RoadPart {

	private Set<TrafficLight> roads;
	
	public Intersection() {
		roads = new HashSet<TrafficLight>();
	}
	
	public boolean addRoad(TrafficLight iRoad) {
		return roads.add(iRoad);
	}

	public Set<TrafficLight> getRoads() {
		return roads;
	}
}
