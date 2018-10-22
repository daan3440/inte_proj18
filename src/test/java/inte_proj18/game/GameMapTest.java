package inte_proj18.game;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
				Arrays.asList(new Position(1, 1), new Position(8, 5), sevenFive, new Position(3, 3)));
		gamemap.getPathPoints().addAll(testPositionDifference);
		assertEquals(gamemap.checkNearestPoint(new Position(7, 6)), sevenFive);
	}

	@Test
	public void checkPathRemovalFromEmptySpotsTest() {
		Position a = new Position(1, 1);
		Position b = new Position(8, 7);
		gamemap.getEmptySpots().clear();
		gamemap.fillEmptySpots();
		int epsize = gamemap.getEmptySpots().size();
		gamemap.getEmptySpots().remove(a);
		gamemap.getEmptySpots().remove(b);
		gamemap.generatePath(a, b);
		assertEquals(gamemap.getEmptySpots().size(), epsize - 14);
	}

	@Test
	public void checkPathRemovalFromEmptySpotsNewValuesTest() {
		Position a = new Position(1, 1);
		Position b = new Position(3, 2);
		gamemap.getEmptySpots().clear();
		gamemap.fillEmptySpots();
		int epsize = gamemap.getEmptySpots().size();
		gamemap.getEmptySpots().remove(a);
		gamemap.getEmptySpots().remove(b);
		gamemap.generatePath(a, b);
		assertEquals(gamemap.getEmptySpots().size(), epsize - 4);
	}

	@Test
	public void setEntryPointTest() {
		Position pos = new Position(10, 10);
		gamemap.setEntryPoint(pos);
		assertEquals(gamemap.getEntryPoint(), pos);

	}

	@Test
	public void setExitPointTest() {
		Position pos = new Position(10, 10);
		gamemap.setExitPoint(pos);
		assertEquals(gamemap.getExitPoint(), pos);

	}

	@Test
	public void createPathWayTest() {
		Position a = new Position(1, 1);
		Position b = new Position(3, 2);
		Position c = new Position(5, 4);
		Position d = new Position(6, 7);
		gamemap.getEmptySpots().clear();
		gamemap.fillEmptySpots();
		gamemap.getEmptySpots().remove(a);
		gamemap.getEmptySpots().remove(b);
		gamemap.getEmptySpots().remove(c);
		gamemap.getEmptySpots().remove(d);
		int preSize = gamemap.getEmptySpots().size();
		gamemap.getPathPoints().clear();
		gamemap.setEntryPoint(a);
		gamemap.getPathPoints().add(b);
		gamemap.getPathPoints().add(c);
		gamemap.setExitPoint(d);
		gamemap.getPathWay().clear();
		gamemap.createPathWay();
		assertEquals(gamemap.getEmptySpots().size(), preSize - 8);
	}

	@Test
	public void checkCorrectPathPositionRemovedFromEmptySpotsTest() {
		Position a = new Position(1, 1);
		Position b = new Position(8, 7);
		gamemap.getEmptySpots().clear();
		gamemap.fillEmptySpots();
		gamemap.getEmptySpots().remove(a);
		gamemap.getEmptySpots().remove(b);
		gamemap.generatePath(a, b);
		assertFalse(gamemap.getEmptySpots().contains(new Position(2, 7)));
	}

	@Test
	public void checkCorrectAmountEnemiesTest() {
		gamemap.getEmptySpots().clear();
		gamemap.getPathWay().clear();
		gamemap.fillEmptySpots();
		gamemap.createPathWay();
		int oldSize = gamemap.getEmptySpots().size();
		int pathWaySize = gamemap.getPathWay().size();
		gamemap.getEmptySpots().addAll(gamemap.getPathWay());
		Collections.shuffle(gamemap.getEmptySpots());

		gamemap.generateEnemies();

		assertEquals((int) ((oldSize + pathWaySize) * 0.8), gamemap.getEmptySpots().size());
	}

	@Test
	public void checkCorrectAmountOfEnvironmentTest() {
		// Vi såg en Fail men lyckade inte återskapa problemet.
		gamemap.getEmptySpots().clear();
		int oldSize = gamemap.getEmptySpots().size();
		gamemap.generateGameMapEnvironment();
		int x = (int) (oldSize * 0.6);
		assertEquals(x, gamemap.getEmptySpots().size());
	}

	@Test
	public void checkCorrectAmountOfPlacedItemsTest() {
		int oldSize = gamemap.getEmptySpots().size();
		gamemap.generateItems();
		assertEquals((int) (oldSize * 0.99), gamemap.getEmptySpots().size());
	}

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
			gamemap = new GameMap(1, 16);
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
	public void overMaxPartImmovableObjectsTest() {
		assertThrows(IllegalArgumentException.class, () -> {
			gamemap = new GameMap(230, 789,0.9,0.2,0.01);
		});
	}
	
	@Test
	public void underMinPartImmovableObjectsTest() {
		assertThrows(IllegalArgumentException.class, () -> {
			gamemap = new GameMap(230, 789,0.01,0.2,0.01);
		});
	}
	

	@Test
	public void overMaxPartEnemiesTest() {
		assertThrows(IllegalArgumentException.class, () -> {
			gamemap = new GameMap(230, 789,0.45,0.6,0.01);
		});
	}
	
	@Test
	public void underMinPartEnemiesTest() {
		assertThrows(IllegalArgumentException.class, () -> {
			gamemap = new GameMap(230, 789,0.45,0.00,0.01);
		});
	}
	
	@Test
	public void overMaxPartItemsTest() {
		assertThrows(IllegalArgumentException.class, () -> {
			gamemap = new GameMap(230, 789,0.45,0.2,0.1);
		});
	}
	
	@Test
	public void underMinPartItemsTest() {
		assertThrows(IllegalArgumentException.class, () -> {
			gamemap = new GameMap(230, 789,0.45,0.2,0.0);
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

	//Utkommenterat pga jobbigt att se men kvar som referens vid behov
//	@Test
//	public void printGameMapTest() {
////		for (Position p: gamemap.getPathWay()) {
////			System.out.println(p.getX()+","+ p.getY());
////		}
//
//		for (int x = 1; x <= gamemap.getWidth(); x++) {
//
//			for (int y = 1; y <= gamemap.getHeight(); y++) {
//				GameObject go = gamemap.getGameMapObjects().get(new Position(x, y));
//				if (go == null) {// (!gamemap.getPathWay().contains(pos)) {
//					if (gamemap.getEntryPoint().equals(new Position(x, y)))
//						System.out.print("S ");
//					else if (gamemap.getExitPoint().equals(new Position(x, y)))
//						System.out.print("X ");
//					else if (gamemap.getPathWay().contains(new Position(x, y)))
//						System.out.print("— ");
//					else
//						System.out.print("  ");
//				} else {
//					System.out.print(go.getName() + " ");
//				}
//
//			}
//			System.out.println();
//
//		}
//
//	}

	@Test
	public void doesPathWayObjectExistInGameMapObjects() {
		boolean check = false;
		for (Position pos : gamemap.getPathWay()) {
			if (gamemap.getGameMapObjects().containsKey(pos)) {
				check = !(gamemap.getGameMapObjects().get(pos) instanceof Enemy
						|| gamemap.getGameMapObjects().get(pos) instanceof Item);
			}
		}
		assertFalse(check);

	}

	@Test
	public void removeOldPositionTest() {
		gamemap.getGameMapObjects().clear();
		player.enterMap(gamemap);
		player.moveUp();
		assertFalse(gamemap.getGameMapObjects().containsKey(gamemap.getEntryPoint()));
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
