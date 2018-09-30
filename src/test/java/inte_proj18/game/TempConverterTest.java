package inte_proj18.game;

import static org.junit.Assert.*;
import static inte_proj18.game.TempConverter.celsiusToFarenheit;

import org.junit.Test;

/**
 * Många verktyg kräver att saker och ting är döpta på rätt sätt. 
 */
public class TempConverterTest{

	@Test
	public void testOneCelsius() {
		assertEquals(33.8, celsiusToFarenheit(1), 0.01);
	}

	@Test
	public void testOneHundredCelsius() {
		assertEquals(212, celsiusToFarenheit(100), 0.01);
	}

}