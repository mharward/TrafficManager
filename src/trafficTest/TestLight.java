package trafficTest;

import trafficLight.light.Light;
import trafficLight.light.LightColour;
import trafficLight.light.LightState;
import trafficLight.light.LightType;
import junit.framework.TestCase;

public class TestLight extends TestCase {

	public void testLight1() {
		Light a = new Light(LightColour.GREEN, LightType.LEFT);
		assertNotNull(a);
		assertEquals(LightState.OFF,a.getState());
		assertEquals(LightColour.GREEN,a.getLcolour());
		assertEquals(LightType.LEFT,a.getLtype());
		a.setState(LightState.ON);
		assertEquals(LightState.ON,a.getState());
		assertEquals(true, a.toString().length() > 10);
		
		assertTrue(a.equals(a));
		assertFalse(a.equals(null));
		assertFalse(a.equals(new Object()));
		assertFalse(a.equals(new Light(LightColour.RED, LightType.RIGHT)));
		assertTrue(a.equals(new Light(LightColour.GREEN, LightType.LEFT)));
	}
}
