package inte_proj18.game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EquipmentTest {
	Equipment eq;
	TwoHandedWeapon tHW;
	BodyArmor ba;
	Helmet h; 
	Shield s;
	OneHandedWeapon oHW;
	FootWear fW;
	
	@BeforeEach
	void setUp() {
		eq = new Equipment();
		tHW =new TwoHandedWeapon("TwoHandedWeapon");
		ba = new BodyArmor("BodyArmor");
		h = new Helmet("Helmet");
		s= new Shield("Shield");
		oHW= new OneHandedWeapon("OneHandedWeapon");
		fW= new FootWear("FootWear");
	}

	@Test
	void setFoorWeartest() {
		
		eq.setFootWear(fW);
		assertEquals(eq.getFootWear(), fW);
		
	}
	
	@Test
	void setOneHandedWeapontest() {
		
		eq.setOneHandedWeapon(oHW);
		assertEquals(eq.getOneHandedWeapon(), oHW);
	}
	
	@Test
	void setShieldtest() {
		
		eq.setShield(s);
		assertEquals(eq.getShield(), s);
	}
	
	@Test
	void setHelmettest() {
		
		eq.setHelmet(h);
		assertEquals(eq.getHelmet(), h);
	}
	
	@Test
	void setBodyArmortest() {
		
		eq.setBodyArmor(ba);
		assertEquals(eq.getBodyArmor(), ba);
	}
	
	@Test
	void setTwoHandedWeapon() {
		eq.setTwoHandedWeapon(tHW);
		assertEquals(eq.getTwoHandedWeapon(), tHW);
	}
	@Test
	void getAttackModifierWhenTwoHandedEquipedTest() {
		eq.setTwoHandedWeapon(tHW);
		assertEquals(eq.getAttackModifier(),1.15);
	}
	@Test
	void getAttackModifierWhenTwoHandedNotEquipedTest() {
		assertEquals(eq.getAttackModifier(),1);
	}
	@Test
	void getPerceptionModifierWhenHelmetEquipedTest() {
		eq.setHelmet(h);
		assertEquals(eq.getPerceptionModifier(),1);
	}
	@Test
	void getPerceptionModifierWhenHelmetNotEquipedTest() {
		assertEquals(eq.getPerceptionModifier(),1.10);
	}
	

}
