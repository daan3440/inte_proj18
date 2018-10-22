package inte_proj18.game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameObjectTest {
	public static final String VALID_NAME = "ValidForObject";
	private GameObject gameObject;
	private GameMap gameMap;

	@BeforeEach
	void setUp() {
		gameObject = new GameObject(VALID_NAME);
		gameMap = new GameMap(64, 64);
	}

	@Test
	void getNameTest() {
		assertEquals(gameObject.getName(), VALID_NAME);
	}

}
