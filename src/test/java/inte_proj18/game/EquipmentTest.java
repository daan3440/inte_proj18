package inte_proj18.game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EquipmentTest {
	private Equipment eq;
	private TwoHandedWeapon tHW;
	private BodyArmor ba;
	private Helmet h;
	private Shield s;
	private OneHandedWeapon oHW;
	private FootWear fW;

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
	void setFootWeartest() {
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
	void getAttackModifierWhenTwoHandedEquippedTest() {
		eq.setTwoHandedWeapon(tHW);
		assertEquals(eq.getAttackModifier(), 1.15);
	}

	@Test
	void getAttackModifierWhenTwoHandedNotEquippedTest() {
		assertEquals(eq.getAttackModifier(), 1);
	}

	@Test
	void getPerceptionModifierWhenHelmetEquippedTest() {
		eq.setHelmet(h);
		assertEquals(eq.getPerceptionModifier(), 1);
	}

	@Test
	void getPerceptionModifierWhenHelmetNotEquippedTest() {
		assertEquals(eq.getPerceptionModifier(), 1.10);
	}

	@Test
	void getSpeedModifierWhenOnlyFootWearEquippedTest() {
		eq.setFootWear(fW);
		assertEquals(eq.getSpeedModifier(), 1.2);
	}

	@Test
	void getSpeedModifierWhenFootWearAndBodyArmorEquippedTest() {
		eq.setFootWear(fW);
		eq.setBodyArmor(ba);
		assertEquals(eq.getSpeedModifier(), 1.1);
	}
	
	@Test
	void getSpeedModifierWhenFootWearAndHelmetEquippedTest() {
		eq.setFootWear(fW);
		eq.setHelmet(h);
		assertEquals(eq.getSpeedModifier(), 1.1);
	}
	
	@Test
	void getSpeedModifierWhenFootWearNotEquippedTest() {
		assertEquals(eq.getSpeedModifier(), 1);
	}
	
	@Test
	void getDefenceModifierWhenShieldAndFullArmorEquippedTest() {
		eq.setFootWear(fW);
		eq.setHelmet(h);
		eq.setBodyArmor(ba);
		eq.setShield(s);
		assertEquals(eq.getDefenceModifier(), 1.4);
	}
	
	@Test
	void getDefenceModifierWhenNoShieldAndFullArmorEquippedTest() {
		eq.setFootWear(fW);
		eq.setHelmet(h);
		eq.setBodyArmor(ba);
		assertEquals(eq.getDefenceModifier(), 1.3);
	}
	@Test
	void getDefenceModifierWhenOnlyShieldEquippedTest() {
		eq.setShield(s);
		assertEquals(eq.getDefenceModifier(), 1.1);
	}
	
	@Test
	void getDefenceModifierWhenNoShieldAndNoFootWearEquippedTest() {
		eq.setHelmet(h);
		eq.setBodyArmor(ba);
		assertEquals(eq.getDefenceModifier(), 1);
	}
	
	@Test
	void getDefenceModifierWhenNoShieldAndNoHelmetEquippedTest() {
		eq.setFootWear(fW);
		eq.setBodyArmor(ba);
		assertEquals(eq.getDefenceModifier(), 1);
	}
	
	@Test
	void equipOneHandedWeaponWhenTwoHandedEquipped() {
		eq.setTwoHandedWeapon(tHW);
		eq.setOneHandedWeapon(oHW);
		assertNull(eq.getTwoHandedWeapon());
	}
	
	@Test
	void equipShieldWhenTwoHandedEquipped() {
		eq.setTwoHandedWeapon(tHW);
		eq.setShield(s);
		assertNull(eq.getTwoHandedWeapon());
	}
	
	@Test
	void equipTwoHandedWeapoWhenOneHandedEquippedTest() {
		eq.setOneHandedWeapon(oHW);
		eq.setTwoHandedWeapon(tHW);
		assertNull(eq.getOneHandedWeapon());
	}
	
	@Test
	void equipTwoHandedWeapoWhenShieldEquippedTest() {
		eq.setShield(s);
		eq.setTwoHandedWeapon(tHW);
		assertNull(eq.getShield());
	}
	
	
}
