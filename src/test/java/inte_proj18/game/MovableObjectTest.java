package inte_proj18.game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MovableObjectTest {
	public static final String VALID_NAME = "ValidName";
	private MovableObject movableObject;
	private Position pos;

	@BeforeEach
	void setUp() {
		movableObject = new MovableObject(VALID_NAME, 100);
		pos = new Position(10, 10);
	}

	@Test
	void getHpTest() {
		assertEquals(movableObject.getHP(), 100);
	}

	@Test
	void setHPTest() {
		movableObject.setHP(90);
		assertEquals(movableObject.getHP(), 90);
	}

	@Test
	void setHPOutOfUpperRangeTest() {
		assertThrows(IllegalArgumentException.class, () -> {
			movableObject.setHP(110);
		});
	}

	@Test
	void setHPOutOfUnderRangeTest() {
		assertThrows(IllegalArgumentException.class, () -> {
			movableObject.setHP(-10);

		});
	}
	
	@Test
	void enterMapTest() {
		movableObject.enterMap(new GameMap(100, 100));
		assertEquals(movableObject.getPosition(), pos);
	}

}
