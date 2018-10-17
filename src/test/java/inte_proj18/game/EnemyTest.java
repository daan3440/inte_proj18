package inte_proj18.game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EnemyTest {
	public static final String VALID_NAME = "ValidName";
	Enemy enemy;
	
	@BeforeEach
	void setUp() {
		enemy = new Enemy();
	}
	
//	@Test
//	void hitTest() {
//		enemy.hit(10);
//		assertEquals(enemy.getHP(), 90);
//	}
}
