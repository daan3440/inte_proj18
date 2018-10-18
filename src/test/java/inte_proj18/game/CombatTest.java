package inte_proj18.game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class CombatTest {
	Combat combat=new Combat();
	
	@BeforeEach
	void setUp() {
		combat = new Combat();
	}
	@Test
	void calculateDamagetest() {
		assertEquals(combat.calculateDamage(10), 10);
	}
	
}
