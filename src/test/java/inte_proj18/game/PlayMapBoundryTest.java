package inte_proj18.game;

import static org.junit.Assert.*;
//import static inte_proj18.game.TempConverter.celsiusToFarenheit;

import org.junit.Test;

/**
 * Testar MapBoundry 
 */
public class PlayMapBoundryTest{
	PlayMap ourMap = new PlayMap(64, 64);

	@Test
	public void MapHeightTest() {
		assertEquals(ourMap.width, 64);
	}
	@Test
	public void MapWidthTest() {
		assertEquals(ourMap.width, 64);
	}
	@Test
	public void IsPmPSameAsNOTMine() {
		
		PlayMapPosition testPmp= new PlayMapPosition(64, 64);
		assertFalse(ourMap.playMapArray.contains(testPmp));
		
	}
	

//	@Test
//	public void testOneHundredCelsius() {
//		assertEquals(212, celsiusToFarenheit(100), 0.01);
//	}

}