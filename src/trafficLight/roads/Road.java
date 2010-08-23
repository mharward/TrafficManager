package trafficLight.roads;

import java.util.ArrayList;
import java.util.List;

public class Road {
	
	private String title;
	private List<RoadPart> parts;

	public Road(String title) {
		this.title = title;
		this.parts = new ArrayList<RoadPart>();
	}

	public String getName() {
		return title;
	}

	public boolean addPart(RoadPart rp1) {
		boolean added = false;
		if(parts.size() > 0) {
			//Intersections must be followed by a RoadSection and
			//vice-versa.
			RoadPart rp = parts.get(parts.size() - 1);
			if(rp.getClass().equals(Intersection.class) && 
					rp1.getClass().equals(RoadSection.class))
				added = parts.add(rp1);
			else if(rp.getClass().equals(RoadSection.class) && 
					rp1.getClass().equals(Intersection.class))
				added = parts.add(rp1);
		} 
		else {
			added = parts.add(rp1);
		}
		return added;
	}

	public RoadPart after(RoadPart rp) {
		int newPos = parts.indexOf(rp) + 1;
		if(newPos >= parts.size() || newPos < 0)
			return null;
		else
			return parts.get(newPos);
	}

	public RoadPart before(RoadPart rp) {
		int newPos = parts.indexOf(rp) - 1;
		if(newPos >= parts.size() || newPos < 0)
			return null;
		else
			return parts.get(newPos);
	}

}
