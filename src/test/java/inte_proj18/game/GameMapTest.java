package inte_proj18.game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameMapTest {
	GameMap gamemap;
	Player player;
	Wallet wallet;
	Inventory inventory;
	String name = "ValidGameMapName";

	@BeforeEach
	void setUpGameMap() {
		gamemap = new GameMap(name, 64, 64);
		player = new Player("Stina III", wallet, inventory);
	}

	@Test
	public void checkInvalidLongNameTest() {
		String nameLong = "ThisNameIsInvalidAndTooLongTwiceThisNameIsInvalidAndTooLongTwice";
		assertThrows(IllegalArgumentException.class, () -> {
			gamemap = new GameMap(nameLong, 64, 64);
		});
	}

	@Test
	public void checkInvalidShortNameTest() {
		String nameShort = "No";
		assertThrows(IllegalArgumentException.class, () -> {
			gamemap = new GameMap(nameShort, 64, 64);
		});
	}

	@Test
	public void checkAspectOutOfRangeWidthTest() {
		assertThrows(IllegalArgumentException.class, () -> {
			gamemap = new GameMap(name, 16, 65);
		});
	}
	@Test
	public void checkAspectOutOfRangeHeightTest() {
		assertThrows(IllegalArgumentException.class, () -> {
			gamemap = new GameMap(name, 65, 16);
		});
	}

	@Test
	public void underMinWidthTest() {
		assertThrows(IllegalArgumentException.class, () -> {
			gamemap = new GameMap(name, 1, 16);
		});
	}

	@Test
	public void underMinHeightTest() {
		assertThrows(IllegalArgumentException.class, () -> {
			gamemap = new GameMap(name, 64, 2);
		});

	}

	@Test
	public void overMaxWidthTest() {
		assertThrows(IllegalArgumentException.class, () -> {
			gamemap = new GameMap(name, 789, 230);
		});
	}

	@Test
	public void overMaxHeightTest() {
		assertThrows(IllegalArgumentException.class, () -> {
			gamemap = new GameMap(name, 230, 789);
		});
	}

	@Test
	public void overMaxPartImmovableObjectsTest() {
		assertThrows(IllegalArgumentException.class, () -> {
			gamemap = new GameMap(name, 230, 789, 0.9, 0.2, 0.01);
		});
	}

	@Test
	public void underMinPartImmovableObjectsTest() {
		assertThrows(IllegalArgumentException.class, () -> {
			gamemap = new GameMap(name, 230, 789, 0.01, 0.2, 0.01);
		});
	}

	@Test
	public void overMaxPartEnemiesTest() {
		assertThrows(IllegalArgumentException.class, () -> {
			gamemap = new GameMap(name, 230, 789, 0.45, 0.6, 0.01);
		});
	}

	@Test
	public void underMinPartEnemiesTest() {
		assertThrows(IllegalArgumentException.class, () -> {
			gamemap = new GameMap(name, 230, 789, 0.45, 0.00, 0.01);
		});
	}

	@Test
	public void overMaxPartItemsTest() {
		assertThrows(IllegalArgumentException.class, () -> {
			gamemap = new GameMap(name, 230, 789, 0.45, 0.2, 0.1);
		});
	}

	@Test
	public void underMinPartItemsTest() {
		assertThrows(IllegalArgumentException.class, () -> {
			gamemap = new GameMap(name, 230, 789, 0.45, 0.2, 0.0);
		});
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
	public void getExitPointTest() {
		assertEquals(gamemap.getExitPoint(), new Position(64/ 2, 1 + 1));
	}

	// Utkommenterat pga jobbigt att se men kvar som referens vid behov
//	@Test
//	public void printGameMapTest() {
////		for (Position p: gamemap.getPathWay()) {
////			System.out.println(p.getX()+","+ p.getY());
////		}
//
//
//			for (int y = 1; y <= gamemap.getHeight(); y++) {
//					for (int x = 1; x <= gamemap.getWidth(); x++) {
//				GameObject go = gamemap.getGameMapObjects().get(new Position(x, y));
//				if (go == null) {// (!gamemap.getPathWay().contains(pos)) {
//					if (gamemap.getEntryPoint().equals(new Position(x, y)))
//						System.out.print("S");
//					else if (gamemap.getExitPoint().equals(new Position(x, y)))
//						System.out.print("X");
//					else if (gamemap.getPathWay().contains(new Position(x, y)))
//						System.out.print(" ");
//					else
//						System.out.print(" ");
//				} else {
//					if (go instanceof Item)
//					System.out.print("*");
//					if (go instanceof Enemy)
//						System.out.print("W");
//					if (go instanceof ImmovableObject && !(go instanceof Item))
//						System.out.print("#");
//					if (go instanceof Player)
//						System.out.print("M");
//				}
//
//			}
//			System.out.println();
//
//		}
//
//	}

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