package trafficLight.roads;

public class RoadSection extends RoadPart {
	
	//Deprecated??
	private RoadSectionEnd rse1;
	private RoadSection rs1;
	
	private RoadSectionEnd rse2;
	private RoadSection rs2;
	
	public void setSectionEnd(RoadSectionEnd rse1, RoadSection rs1,
			RoadSectionEnd rse2, RoadSection rs2) {
		this.rs1 = rs1;
		this.rse1 = rse1;
		this.rs2 = rs2;
		this.rse2 = rse2;
	}

}
