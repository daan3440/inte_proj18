package inte_proj18.game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MovableObjectTest {
	public static final String VALID_NAME = "ValidName";
	public static final int INITIAL_HP = 100;

	private MovableObject movableObject;

	@BeforeEach
	void setUp() {
		movableObject = new MovableObject(VALID_NAME, 100);
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
	void hitTest() {
		movableObject.takeDamage(10);
		assertEquals(movableObject.getHP(), 90);
	}

	@Test
	void hitMoreThanHPTest() {
		movableObject.takeDamage(INITIAL_HP + 1);
		assertEquals(movableObject.getHP(), 0);
	}

	@Test
	void hitCeckInputTest() {

		//movableObject.takeDamage(10) behövs för att inte setHPs kolla av indata ska kasta undantag.
		movableObject.takeDamage(10); 
		assertThrows(IllegalArgumentException.class, () -> {
			movableObject.takeDamage(-1);

		});
	}

	@Test
	void setPositionTest() {
		Position pos = new Position(1, 1);
		movableObject.setPosition(pos);
		assertEquals(movableObject.getPosition(), pos);

	}

}
