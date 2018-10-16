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
		player = new Player("stina");
		gamemap = new GameMap(64, 64,player);

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
		Position posUp = new Position(pos.getX(), pos.getY()+1);
		assertEquals(player.getPosition(), posUp);
		
	}
	
//	@Test
//	public void playerMoveDownTest() {
//		player.enterMap(pos, gamemap);
//		player.moveDown();
//		Position posDown = new Position(pos.getX(),pos.getY()-1);
//		assertEquals(player.getPosition(), posDown);
//	}
//	@Test
//	public void playerMoveRigtTest() {
//		player.enterMap(pos, gamemap);
//		player.moveRight();
//		Position posRight = new Position(pos.getX() +1,pos.getY());
//		assertEquals(player.getPosition(), posRight);
//	}
//	
//	@Test
//	public void playerMoveLeftTest() {
//		player.enterMap(pos, gamemap);
//		player.moveLeft();
//		Position posLeft = new Position(pos.getX()-1,pos.getY());
//		assertEquals(player.getPosition(), posLeft);
//	}
	
	@Test
	public void takeDamageTest() {
		int oldhp = player.getHP();
		int dmg = 10;
		player.takeDmg(dmg);
		assertEquals(player.getHP(), oldhp-dmg);
	}
	
	
	@Test
	public void takeMoreThanHPDamageTest() {
		int dmg = 110;
		player.takeDmg(dmg);
		assertEquals(player.getHP(), 0);
	}

	@Test
	public void upHpTest() {
		player.takeDmg(10);
		int oldhp = player.getHP();
		int heal = 10;
		player.heal(heal);
		assertEquals(player.getHP(), oldhp+heal);
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





