package inte_proj18.game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlayerTest {
	Player player;
	Position pos;
	GameMap gamemap;

	@BeforeEach
	void setUp() {
		pos = new Position(32, 32);
		gamemap = new GameMap(64, 64);
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
	public void enteredGameMapWithPositionTest() {
		player.enterMap(pos, gamemap);
		assertEquals(player.getPosition(), pos);	
		
	}
	@Test
	public void enteredGameMapWithGameMapTest() {
		player.enterMap(pos, gamemap);
		assertEquals(player.getGameMap(), gamemap);
		
	}
	@Test
	public void playerMoveUpTest() {
		player.enterMap(pos, gamemap);
		player.moveUp();
		Position posUp = new Position(32, 33);
		assertEquals(player.getPosition(), posUp);
		
	}

}
