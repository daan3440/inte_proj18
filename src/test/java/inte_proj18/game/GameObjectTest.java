package inte_proj18.game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameObjectTest {
	public static final String VALID_NAME = "ValidForObject";
	private GameObject gameObject;
	private GameObject mObject;
	private GameMap gameMap;
	private Position pos; // passar in för en stub i GameMap kommer behövas ändras när stub byts ut mot
							// riktigt kod.

	@BeforeEach
	void setUp() {
		gameObject = new GameObject(VALID_NAME);
		mObject = new MovableObject(VALID_NAME, 100);
		gameMap = new GameMap(64, 64);
		pos = new Position(21, 21);
	}

	@Test
	void getNameTest() {
		assertEquals(gameObject.getName(), VALID_NAME);
	}

	@Test
	void setPositionTest() {
		Position pos = new Position(1, 1);
		mObject.setPosition(pos);
		assertEquals(mObject.getPosition(), pos);

	}

	@Test
	void gameObjectEnterMapTest() {
		gameObject.enterMap(gameMap);
		assertEquals(gameObject.getPosition(), pos);
	}
	
	@Test
	void getGameMapTest() {
		gameObject.enterMap(gameMap);
		assertEquals(gameObject.getGameMap(), gameMap);
	}
}
