package inte_proj18.game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameMapTest {
	GameMap gamemap;
	Player player;

	@BeforeEach
	void createGameMap() {
		gamemap = new GameMap(64, 64);
		player = new Player("Stina III");
	}

	@Test
	public void createGameMapCheckWidth() {
		assertEquals(gamemap.getWidth(), 64);

	}

	@Test
	public void createGameMapCheckHeight() {
		assertEquals(gamemap.getHeight(), 64);

	}

	@Test
	public void isHashMapEmptyTest() {
		assertTrue(gamemap.getGameMapObjects().isEmpty());
	}

	@Test
	public void placePlayerTest() {
		player.enterMap(gamemap);
		assertTrue(gamemap.getGameMapObjects().containsKey(player.getPosition()));

	}

	@Test
	public void frameOfGameMapTest() {
		// implementera så att chekcPosition är falsk så händer inget.
		gamemap.drawWallFrame();
		Position pos = new Position(gamemap.getWidth(), gamemap.getHeight());
		assertTrue(gamemap.getGameMapObjects().containsKey(pos));
	}

	@Test
	public void fillMapTest() {

	}

	@Test
	public void removeOldPositionTest() {
		player.enterMap(gamemap);
		Position pos = player.getPosition();
		player.moveUp();
		assertFalse(gamemap.getGameMapObjects().containsKey(pos));
	}// Ekvivalensklasser tillämpades här

	@Test
	public void changePlayerPositionTest() {
		player.enterMap(gamemap);
		player.moveUp();
		assertTrue(gamemap.getGameMapObjects().containsKey(player.getPosition()));
	}

	@Test
	public void changePositionTest() {
		Position old = new Position(11, 11);
		Position newpos = new Position(11, old.getY() + 1);
		gamemap.makeMove(old, newpos);
		assertFalse(gamemap.getGameMapObjects().containsKey(old));
	}

}
