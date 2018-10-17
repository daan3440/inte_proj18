package inte_proj18.game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameObjectTest {
	public static final String VALID_NAME = "ValidForObject";
	private GameObject gameObject;
	private GameObject mObject;
	
	
	@BeforeEach
	void setUp() {
		gameObject = new GameObject(VALID_NAME);
		mObject = new MovableObject(VALID_NAME, 100);
	}
	@Test
	void getNameTest() {
		assertEquals(gameObject.getName(), VALID_NAME);
	}
	
	@Test
	void setPositionTest() {
		Position pos = new Position(1,1);
		mObject.setPosition(pos);
		assertEquals(mObject.getPosition(), pos);
		
	}
}
