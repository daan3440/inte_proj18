package inte_proj18.game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EquipmentTest {
	Equipment eq;
	
	@BeforeEach
	void setUp() {
		eq = new Equipment();
	}

	@Test
	void setFoorWeartest() {
		FootWear fw = new FootWear("Shoe");
		eq.setFootWear(fw);
		assertEquals(eq.getFootWear(), fw);
	}
	
	@Test
	void setOneHandedWeapontest() {
		OneHandedWeapon oHW = new OneHandedWeapon("OneHandedWeapon");
		eq.setOneHandedWeapon(oHW);
		assertEquals(eq.getOneHandedWeapon(), oHW);
	}
	
	@Test
	void setShieldtest() {
		Shield s = new Shield("Shield");
		eq.setShield(s);
		assertEquals(eq.getShield(), s);
	}
	
	@Test
	void setHelmettest() {
		Helmet h = new Helmet("Helmet");
		eq.setHelmet(h);
		assertEquals(eq.getHelmet(), h);
	}
	
	@Test
	void setBodyArmortest() {
		BodyArmor ba = new BodyArmor("BodyArmor");
		eq.setBodyArmor(ba);
		assertEquals(eq.getBodyArmor(), ba);
	}

}
