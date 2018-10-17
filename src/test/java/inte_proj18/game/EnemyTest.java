package inte_proj18.game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EnemyTest {
	public static final String VALID_NAME = "ValidName";
	public static final int INITIAL_HP = 100;
	Enemy enemy;
	
	@BeforeEach
	void setUp() {
		enemy = new Enemy(VALID_NAME, INITIAL_HP);
	}
	
	@Test
	void hitTest() {
		enemy.hit(10);
		assertEquals(enemy.getHP(), 90);
	}
	
	@Test
	void hitMoreThanHPTest() {
		enemy.hit(INITIAL_HP+1);
		assertEquals(enemy.getHP(),0);
	}
	
	@Test
	void hitCeckInputTest() {
		//enemy.hit(10) behövs för att inte setHPs kolla av indata ska kasta undantag.
		enemy.hit(10); 
		assertThrows(IllegalArgumentException.class, () -> {
			enemy.hit(-1);

		});
	}
	
	
}
