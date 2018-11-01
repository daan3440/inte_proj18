package inte_proj18.game;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MapGenerationTest {

	MapGeneration mg;
	GameMap gameMap;

	@BeforeEach
	void setUp() {
		mg = new MapGeneration(64, 64, 0.4, 0.2, 0.01);

	}

	@Test
	public void mapObjectNotInEmptySpotTest() {
		Set<Position> keysList = mg.getMapObjectsKeySet();
		boolean mapObjectInEmptySpot = false;
		for (Position pos : keysList) {
			mapObjectInEmptySpot = mg.emptySpotsContains(pos);
		}
		assertFalse(mapObjectInEmptySpot);

	}

	@Test
	public void createGameMapCheckWidthTest() {
		assertEquals(mg.getWidth(), 64);
	}

	@Test
	public void createGameMapCheckHeightTest() {
		assertEquals(mg.getHeight(), 64);

	}

	// kommer aldrig misslyckas
	@Test
	public void checkPathPointsInEmptySpotsTest() {
		boolean pathPointInEmptySpot = false;
		for (Position pos : mg.getPathPoints()) {
			pathPointInEmptySpot = mg.emptySpotsContains(pos);
		}
		assertFalse(pathPointInEmptySpot);
	}

	@Test
	public void fillEmptySpotsArrayListTest() {
		mg.clearEmptySpots();
		mg.fillEmptySpots();
		int emptySpotsSize = mg.getEmptySpotsSize();
		assertEquals(emptySpotsSize, mg.getHeight() * mg.getWidth());
	}

	@Test
	public void makePathPointsTest() {
		mg.clearPathPoints();
		mg.generatePathPoints();
		assertFalse(mg.isPathPointsEmpty());
	}

	@Test
	public void createPathWayTest() {
		Position a = new Position(1, 1);
		Position b = new Position(3, 2);
		Position c = new Position(5, 4);
		Position d = new Position(6, 7);
		mg.clearEmptySpots();
		mg.fillEmptySpots();
		mg.removeFromEmptySpots(a);
		mg.removeFromEmptySpots(b);
		mg.removeFromEmptySpots(c);
		mg.removeFromEmptySpots(d);
		int preSize = mg.getEmptySpotsSize();
		mg.clearPathPoints();
		mg.setEntryPoint(a);
		mg.addPathPoints(b);
		mg.addPathPoints(c);
		mg.setExitPoint(d);
		mg.clearPathWay();
		mg.createPathWay();
		assertEquals(mg.getEmptySpotsSize(), preSize - 8);
	}

	@Test
	public void checkPathRemovalFromEmptySpotsTest() {
		Position a = new Position(1, 1);
		Position b = new Position(8, 7);
		mg.clearEmptySpots();
		;
		mg.fillEmptySpots();
		int epsize = mg.getEmptySpotsSize();
		mg.removeFromEmptySpots(a);
		mg.removeFromEmptySpots(b);
		mg.generatePath(a, b);
		assertEquals(mg.getEmptySpotsSize(), epsize - 14);
	}

	@Test
	public void checkCorrectPathPositionRemovedFromEmptySpotsTest() {
		Position a = new Position(1, 1);
		Position b = new Position(8, 7);
		mg.clearEmptySpots();
		mg.fillEmptySpots();
		mg.removeFromEmptySpots(a);
		mg.removeFromEmptySpots(b);
		mg.generatePath(a, b);
		assertFalse(mg.emptySpotsContains(new Position(2, 7)));
	}

	@Test
	public void checkCorrectAmountOfEnvironmentTest() {
		// Vi såg en Fail men lyckade inte återskapa problemet.
		mg.clearEmptySpots();
		int oldSize = mg.getEmptySpotsSize();
		mg.generateGameMapEnvironment();
		int x = (int) (oldSize * 0.6);
		assertEquals(x, mg.getEmptySpotsSize());
	}

	@Test
	public void doesPathWayObjectExistInGameMapObjects() {
		boolean check = false;
		for (Position pos : mg.getPathWay()) {
			if (mg.mapObjectsContainsKey(pos)) {
				check = !(mg.getMapObjectsEntry(pos) instanceof Enemy || mg.getMapObjectsEntry(pos) instanceof Item);
			}
		}
		assertFalse(check);

	}

	@Test
	public void checkCorrectAmountOfPlacedItemsTest() {
		int oldSize = mg.getEmptySpotsSize();
		mg.generateItems();
		assertEquals((int) (oldSize * 0.99), mg.getEmptySpotsSize());
	}

	@Test
	public void checkCorrectAmountEnemiesTest() {
		mg.clearEmptySpots();
		mg.clearPathWay();
		mg.fillEmptySpots();
		int oldSize = mg.getEmptySpotsSize();
		mg.generateEnemies();

		assertEquals((int) (oldSize * 0.8), mg.getEmptySpotsSize());
	}

	@Test
	public void checkPointsWithLowestDifferenceTest() {
		Position sevenFive = new Position(7, 5);
		mg.clearPathPoints();
		ArrayList<Position> testPositionDifference = new ArrayList<>(
				Arrays.asList(new Position(1, 1), new Position(8, 5), sevenFive, new Position(3, 3)));
		mg.addArrayListToPathPoints(testPositionDifference);
		assertEquals(mg.getNearestPoint(new Position(7, 6)), sevenFive);
	}

	// borde göras om?
	@Test
	public void frameOfMapTest() {
		Position pos = new Position(mg.getWidth(), mg.getHeight());
		assertTrue(mg.mapObjectsContainsKey(pos));
	}
	@Test
	public void checkDistanceIsLongEnoughBetweenEntryAndExitPoint() {
		mg.setEntryPoint(new Position(1,1));
		mg.setExitPoint(new Position(52,52));
		assertTrue(mg.checkDistanceIsWithinLimit());
	}
	@Test
	public void checkDistanceNotTooShortBetweenEntryAndExitPoint() {
		mg.setEntryPoint(new Position(1,1));
		mg.setExitPoint(new Position(3,5));
		assertFalse(mg.checkDistanceIsWithinLimit());
	}
	@Test
	public void checkDistanceNotTooLongBetweenEntryAndExitPoint() {
		// set Point that are Too far Apart
		mg.setEntryPoint(new Position(1,1));
		mg.setExitPoint(new Position(64,64));
		//assert
		assertFalse(mg.checkDistanceIsWithinLimit());
	}
		
	//Bara som referens
	@Test
	public void printGameMapTest() {
//				for (Position p: gamemap.getPathWay()) {
//					System.out.println(p.getX()+","+ p.getY());
//				}

		for (int y = 1; y <= mg.getHeight(); y++) {
			for (int x = 1; x <= mg.getWidth(); x++) {
				GameObject go = mg.getMapObjectsEntry(new Position(x, y));
				if (go == null) {// (!gamemap.getPathWay().contains(pos)) {
					if (mg.getEntryPoint().equals(new Position(x, y)))
						System.out.print("\033[33m @"); //[33m yellow
					else if (mg.getExitPoint().equals(new Position(x, y)))
						System.out.print("\033[34m Ω"); //[34m blue
					else if (mg.getPathWay().contains(new Position(x, y)))
						System.out.print("\033[32m ·"); //[32m green
					else
						System.out.print("\033[0m  "); //[0m clears all - default
				} else {
					if (go instanceof Item)
						System.out.print("\033[35m $"); //[35m magenta
					if (go instanceof Enemy)
						System.out.print("\033[31m †"); //[31m red
					if (go instanceof ImmovableObject && !(go instanceof Item))
						System.out.print("\033[0m #"); //[0m clears all - default
					if (go instanceof Player)
						System.out.print("\033[36m M"); //[36m cyan
				}

			}
			System.out.println();

		}

	}

}
