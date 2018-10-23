package inte_proj18.game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlayerTest {

	private Player player;
	private Position pos;
	private GameMap gamemap;

	Wallet wallet;
	Inventory inventory;

	@BeforeEach
	void setUp() {
		player = new Player("stina", wallet, inventory);
		gamemap = new GameMap(64, 64);
		player.enterMap(gamemap);
		pos = player.getPosition();
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
	public void playerWalletTest() {
		assertEquals(player.getWallet(), wallet);
	}
	
	@Test
	public void playerInventoryTest() {
		assertEquals(player.getInventory(), inventory);
	}

	@Test
	public void enteredGameMapWithPositionTest() {
		assertEquals(player.getPosition(), pos);

	}

	@Test
	public void enteredGameMapWithGameMapTest() {
		assertEquals(player.getGameMap(), gamemap);

	}

	@Test
	public void playerMoveUpTest() {
		gamemap.getGameMapObjects().clear();
		player.moveUp();
		Position posUp = new Position(pos.getX(), pos.getY() - 1);
		assertEquals(player.getPosition(), posUp);

	}
	@Test
	public void playerMoveDownTest() {
		gamemap.getGameMapObjects().clear();
		player.moveDown();
		Position posDown = new Position(pos.getX(), pos.getY()+1);
		assertEquals(player.getPosition(), posDown);
	}

	@Test
	public void playerMoveRightTest() {
		gamemap.getGameMapObjects().clear();
		player.moveRight();
		Position posRight = new Position(pos.getX() + 1, pos.getY());
		assertEquals(player.getPosition(), posRight);
	}

	@Test
	public void playerMoveLeftTest() {
		gamemap.getGameMapObjects().clear();
		player.moveLeft();
		Position posLeft = new Position(pos.getX() - 1, pos.getY());
		assertEquals(player.getPosition(), posLeft);
	}
	
	//Kolla denna imorgon 
//	@Test
//	public void playerCollisionDetectionTest() {
//		gamemap.getGameMapObjects().clear();
//		player.moveDown();
//		Position posDown = new Position(pos.getX(), pos.getY() + 1);
//		assertNotEquals(player.getPosition(), posDown);
//	}

	@Test
	public void takeDamageTest() {
		int oldhp = player.getHP();
		int dmg = 10;
		player.takeDamage(dmg);
		assertEquals(player.getHP(), oldhp - dmg);
	}

	@Test
	public void takeMoreThanHPDamageTest() {
		int dmg = 110;
		player.takeDamage(dmg);
		assertEquals(player.getHP(), 0);
	}

	@Test
	public void upHpTest() {
		player.takeDamage(10);
		int oldhp = player.getHP();
		int heal = 10;
		player.heal(heal);
		assertEquals(player.getHP(), oldhp + heal);
	}

	@Test
	public void overMaxHPHeal() {
		int heal = 10;
		player.heal(heal);
		assertEquals(player.getHP(), player.getMaxHP());
	}

//	@Test
//	public void increaseMaxHPTest() {
//		int oldMaxHP = player.getMaxHP();
//		player.enterMap(pos, gamemap);
//		int newMaxHP = (int) (oldMaxHP*1.1);
//		assertEquals(player.getMaxHP(), newMaxHP );
//	}
}
