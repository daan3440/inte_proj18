package inte_proj18.game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlayerTest {
	Player player;

	@BeforeEach
	void createPlayer() {
		player = new Player("stina");
	}

	@Test
	public void createPlayerCheckNullTest() {
		assertNotNull(player);
	}

	@Test
	public void playerNameTest() {
		assertEquals(player.getName(), "stina");

	}

	@Test
	public void enteredGameMapTest() {
		Position pos = Position (32, 32);
		GameMap gamemap = GameMap(64, 64);
		player.enterMap(pos, gamemap);
		
		
		
	}

}
