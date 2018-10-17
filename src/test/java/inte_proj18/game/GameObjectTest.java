package inte_proj18.game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameObjectTest {
	public static final String VALID_NAME = "ValidForObject";
	private GameObject gameObject;
	
	
	@BeforeEach
	void setUp() {
		gameObject = new GameObject(VALID_NAME);
	}
	@Test
	void getNameTest() {
		assertEquals(gameObject.getName(), VALID_NAME);
	}
	
	

}
