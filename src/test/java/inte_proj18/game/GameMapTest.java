package inte_proj18.game;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameMapTest {
	GameMap gamemap;
	Player player;
	Wallet wallet;
	Inventory inventory;

	@BeforeEach
	void createGameMapTest() {
		gamemap = new GameMap(64, 64);
		player = new Player("Stina III", wallet, inventory);
	}

	@Test
	public void createGameMapCheckWidthTest() {
		assertEquals(gamemap.getWidth(), 64);
	}

	@Test
	public void fillEmptySpotsArrayListTest() {
		gamemap.getEmptySpots().clear();
		gamemap.fillEmptySpots();
		int emptySpotsSize = gamemap.getEmptySpots().size();
		assertEquals(emptySpotsSize, gamemap.getHeight() * gamemap.getWidth());
	}

	@Test
	public void checkPathPointsInEmptySpotsTest() {
		boolean pathPointInEmptySpot = false;
		for (Position pos : gamemap.getPathPoints()) {
			pathPointInEmptySpot = gamemap.getEmptySpots().contains(pos);
		}
		assertFalse(pathPointInEmptySpot);
	}

	@Test
	public void makePathPointsTest() {
		gamemap.getPathPoints().clear();
		gamemap.generatePathPoints();
		assertFalse(gamemap.getPathPoints().isEmpty());
	}

	@Test
	public void checkPointsWithLowestDifferenceTest() {
		Position sevenFive = new Position(7, 5);
		gamemap.getPathPoints().clear();
		ArrayList<Position> testPositionDifference = new ArrayList<>(
				Arrays.asList(new Position(1,1), new Position(8, 5), sevenFive, new Position(3, 3)));
		gamemap.getPathPoints().addAll(testPositionDifference);
		assertEquals(gamemap.checkNearestPoint(new Position(7,6)), sevenFive);
	}
	
	@Test
	public void checkPathRemovalFromEmptySpotsTest() {
		Position a = new Position(1,1);
		Position b = new Position(8,7);
		gamemap.getEmptySpots().clear();
		gamemap.fillEmptySpots();
		int epsize = gamemap.getEmptySpots().size();
		gamemap.getEmptySpots().remove(a);
		gamemap.getEmptySpots().remove(b);
		gamemap.generatePath(a, b);
		assertEquals(gamemap.getEmptySpots().size(),epsize-14);
	}
	
	@Test
	public void checkPathRemovalFromEmptySpotsNewValuesTest() {
		Position a = new Position(1,1);
		Position b = new Position(3,2);
		gamemap.getEmptySpots().clear();
		gamemap.fillEmptySpots();
		int epsize = gamemap.getEmptySpots().size();
		gamemap.getEmptySpots().remove(a);
		gamemap.getEmptySpots().remove(b);
		gamemap.generatePath(a, b);
		assertEquals(gamemap.getEmptySpots().size(),epsize-4);
	}
	
	@Test
	public void setEntryPointTest() {
		Position pos = new Position(10,10);
		gamemap.setEntryPoint(pos);
		assertEquals(gamemap.getEntryPoint(),pos);
		
	}
	
	@Test
	public void setExitPointTest() {
		Position pos = new Position(10,10);
		gamemap.setExitPoint(pos);
		assertEquals(gamemap.getExitPoint(),pos);
		
	}
	
	@Test
	public void createPathWayTest() {
		Position a = new Position(1,1);
		Position b = new Position(3,2);
		Position c = new Position(5,4);
		Position d = new Position(6,7);
		gamemap.getEmptySpots().clear();
		gamemap.fillEmptySpots();
		gamemap.getEmptySpots().remove(a);
		gamemap.getEmptySpots().remove(b);
		gamemap.getEmptySpots().remove(c);
		gamemap.getEmptySpots().remove(d);
		int preSize =  gamemap.getEmptySpots().size();
		gamemap.getPathPoints().clear();
		gamemap.setEntryPoint(a);
		gamemap.getPathPoints().add(b);
		gamemap.getPathPoints().add(c);
		gamemap.setExitPoint(d);
		
		gamemap.createPathWay();
		assertEquals(gamemap.getEmptySpots().size(), preSize-8);
	}
		
	@Test
	public void checkCorrectPathPositionRemovedFromEmptySpotsTest() {
		Position a = new Position(1,1);
		Position b = new Position(8,7);
		gamemap.getEmptySpots().clear();
		gamemap.fillEmptySpots();
		gamemap.getEmptySpots().remove(a);
		gamemap.getEmptySpots().remove(b);
		gamemap.generatePath(a, b);
		assertFalse(gamemap.getEmptySpots().contains(new Position(2,7)));
	}

//	@Test
//	public void checkCorrectAmountOfPlacedImmovableObjects() {
//		gamemap.getGameMapObjects().clear();
//		int oldSize = gamemap.getEmptySpots().size();
//		gamemap.generateMapContent();
//		assertEquals((int)(oldSize*0.4), gamemap.getEmptySpots().size());
//	}
	@Test
	public void mapObjectNotInEmptySpotTest() {
		Set<Position> keysList = gamemap.getGameMapObjects().keySet();
		boolean mapObjectInEmptySpot = false;
		for (Position pos : keysList) {
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
		assertThrows(IllegalArgumentException.class, () -> {
			gamemap = new GameMap(50, 78);
		});
	}

	@Test
	public void underMinHeightTest() {
		assertThrows(IllegalArgumentException.class, () -> {
			gamemap = new GameMap(64, 2);
		});

	}

	@Test
	public void overMaxWidthTest() {
		assertThrows(IllegalArgumentException.class, () -> {
			gamemap = new GameMap(789, 230);
		});
	}

	@Test
	public void overMaxHeightTest() {
		assertThrows(IllegalArgumentException.class, () -> {
			gamemap = new GameMap(230, 789);
		});
	}

	@Test
	public void createGameMapCheckHeightTest() {
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
