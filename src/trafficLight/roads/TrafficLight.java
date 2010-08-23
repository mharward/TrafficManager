package trafficLight.roads;

import java.util.HashSet;
import java.util.Set;

import trafficLight.lightSet.FullLightSet;
import trafficLight.lightSet.ProvidedLightSet;

public class TrafficLight extends RoadSectionEnd {
	
	private FullLightSet fls;
	private Set<ProvidedLightSet> plsSet;
	
	public TrafficLight(FullLightSet fls) {
		this.fls = fls;
		plsSet = new HashSet<ProvidedLightSet>();
		
		ProvidedLightSet pls = new ProvidedLightSet(fls);
		pls.duplicateFullLightSet();
		plsSet.add(pls);
	}

	public FullLightSet getFls() {
		return fls;
	}

	public Set<ProvidedLightSet> getPlsSet() {
		return plsSet;
	}
}
