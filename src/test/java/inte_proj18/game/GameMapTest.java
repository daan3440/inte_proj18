package inte_proj18.game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class GameMapTest {
	GameMap gamemap;
	Player player;
	
	@BeforeEach
	void createGameMap(){
		player = new Player("Stina II");
		gamemap = new GameMap(64,64, player);}
	
	@Test
	public void createGameMapCheckWidth(){
		assertEquals(gamemap.getWidth(), 64);
		
	}
	@Test
	public void createGameMapCheckHeight(){
		assertEquals(gamemap.getHeight(), 64);

	}
	
	@Test
	public void isHashMapEmptyTest() {
		assertFalse(gamemap.getGameMapObjects().isEmpty());
	}
	
	@Test
	public void fillMapTest() {
		
	}
	
	@Test
	public void changePositionTest() {
		Position old = new Position(11,11);
		Position newpos = new Position(11,old.getY()+1);
		gamemap.makeMove(old,newpos);
		assertFalse(gamemap.getGameMapObjects().containsKey(old));
	}
	
	
	
	@Test
	public void changePositionViaPlayerTest() {
		Position pos = player.getPosition();
		player.moveUp();
		assertTrue(gamemap.getGameMapObjects().containsKey(player.getPosition())&&!player.getPosition().equals(pos));
	}
	
}
