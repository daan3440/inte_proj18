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
		tHW = new TwoHandedWeapon("TwoHandedWeapon");
		ba = new BodyArmor("BodyArmor");
		h = new Helmet("Helmet");
		s = new Shield("Shield");
		oHW = new OneHandedWeapon("OneHandedWeapon");
		fW = new FootWear("FootWear");
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
		assertEquals(eq.getAttackModifier(), 1.15);
	}

	@Test
	void getAttackModifierWhenTwoHandedNotEquipedTest() {
		assertEquals(eq.getAttackModifier(), 1);
	}

	@Test
	void getPerceptionModifierWhenHelmetEquipedTest() {
		eq.setHelmet(h);
		assertEquals(eq.getPerceptionModifier(), 1);
	}

	@Test
	void getPerceptionModifierWhenHelmetNotEquipedTest() {
		assertEquals(eq.getPerceptionModifier(), 1.10);
	}

	@Test
	void getSpeedModifierWhenOnlyFootWearEquipedTest() {
		eq.setFootWear(fW);
		assertEquals(eq.getSpeedModifier(), 1.2);
	}

	@Test
	void getSpeedModifierWhenFootWearAndBodyArmorEquipedTest() {
		eq.setFootWear(fW);
		eq.setBodyArmor(ba);
		assertEquals(eq.getSpeedModifier(), 1.1);
	}
	
	@Test
	void getSpeedModifierWhenFootWearAndHelmetEquipedTest() {
		eq.setFootWear(fW);
		eq.setHelmet(h);
		assertEquals(eq.getSpeedModifier(), 1.1);
	}
	
	@Test
	void getSpeedModifierWhenFootWearNotEquipedTest() {
		assertEquals(eq.getSpeedModifier(), 1);
	}
	
	@Test
	void getDefenceModifierWhenShieldAndFullArmorEquipedTest() {
		eq.setFootWear(fW);
		eq.setHelmet(h);
		eq.setBodyArmor(ba);
		eq.setShield(s);
		assertEquals(eq.getDefenceModifier(), 1.4);
	}
	
	@Test
	void getDefenceModifierWhenNoShieldAndFullArmorEquipedTest() {
		eq.setFootWear(fW);
		eq.setHelmet(h);
		eq.setBodyArmor(ba);
		assertEquals(eq.getDefenceModifier(), 1.3);
	}
	@Test
	void getDefenceModifierWhenOnlyShieldEquipedTest() {
		eq.setShield(s);
		assertEquals(eq.getDefenceModifier(), 1.1);
	}
	
	@Test
	void getDefenceModifierWhenNoShieldAndNoFootWearEquipedTest() {
		eq.setHelmet(h);
		eq.setBodyArmor(ba);
		assertEquals(eq.getDefenceModifier(), 1);
	}
	
	@Test
	void getDefenceModifierWhenNoShieldAndNoHelmetEquipedTest() {
		eq.setFootWear(fW);
		eq.setBodyArmor(ba);
		assertEquals(eq.getDefenceModifier(), 1);
	}
	
	@Test
	void equipOneHandedWeaponWhenTwoHandedEquiped() {
		eq.setTwoHandedWeapon(tHW);
		eq.setOneHandedWeapon(oHW);
		assertNull(eq.getTwoHandedWeapon());
	}
	
	@Test
	void equipShieldWhenTwoHandedEquiped() {
		eq.setTwoHandedWeapon(tHW);
		eq.setShield(s);
		assertNull(eq.getTwoHandedWeapon());
	}
	
	@Test
	void equipTwoHandedWeapoWhenOneHandedEquipedTest() {
		eq.setOneHandedWeapon(oHW);
		eq.setTwoHandedWeapon(tHW);
		assertNull(eq.getOneHandedWeapon());
	}
	
	@Test
	void equipTwoHandedWeapoWhenShieldEquipedTest() {
		eq.setShield(s);
		eq.setTwoHandedWeapon(tHW);
		assertNull(eq.getShield());
	}
	
	
}
