package inte_proj18.game;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

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
	public void fillEmptySpotsArrayList() {
		gamemap.getEmptySpots().clear();
		gamemap.fillEmptySpots();
		int emptySpotsSize = gamemap.getEmptySpots().size();
		assertEquals(emptySpotsSize,gamemap.getHeight()*gamemap.getWidth());
	}
	
	@Test
	public void mapObjectNotInEmptySpotTest() {
		Set<Position> keysList = gamemap.getGameMapObjects().keySet();
		boolean mapObjectInEmptySpot = false;
		for(Position pos: keysList) {
			mapObjectInEmptySpot = gamemap.getEmptySpots().contains(pos);
		}
		assertFalse(mapObjectInEmptySpot);
	
	}

//	@Test
//	public void generateEntryAndExitTest() {
//		Position exit = gamemap.getExitPoint();
//		Position entry = gamemap.getEntryPoint();
//		int distance = Math.abs(exit.getX()+exit.getY()) - (entry.getX()+entry.getY());
//		assertEquals()
//		
//		//ekvivalensklass
//	}
	
	@Test
	public void underMinWidthTest() {
		assertThrows(IllegalArgumentException.class,() -> {gamemap = new GameMap(50,78);});
	}

	@Test
	public void underMinHeightTest() {
		assertThrows(IllegalArgumentException.class,() -> {gamemap = new GameMap(64,2);});
		
	}
	
	@Test
	public void overMaxWidthTest() {
		assertThrows(IllegalArgumentException.class,() -> {gamemap = new GameMap(789,230);});
	}
	
	@Test
	public void overMaxHeightTest() {
		assertThrows(IllegalArgumentException.class,() -> {gamemap = new GameMap(230,789);});
	}
	
	@Test
	public void createGameMapCheckHeight() {
		assertEquals(gamemap.getHeight(), 64);

	}

	@Test
	public void isHashMapNotEmptyTest() {
		assertFalse(gamemap.getGameMapObjects().isEmpty());
	}

	@Test
	public void placePlayerTest() {
		player.enterMap(gamemap);
		assertTrue(gamemap.getGameMapObjects().containsKey(player.getPosition()));

	}

	@Test
	public void frameOfGameMapTest() {
		// implementera så att checkPosition är falsk så händer inget.
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