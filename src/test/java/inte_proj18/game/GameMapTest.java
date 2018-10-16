package inte_proj18.game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class GameMapTest {
	GameMap gamemap;
	
	@BeforeEach
	void createGameMap(){
		gamemap = new GameMap(64,64);}
	
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
		assertTrue(!gamemap.getGameMapObjects().isEmpty());
	}
	
	@Test
	public void fillMapTest() {
		
	}
	
	@Test
	public void playerOnMapTest() {
		
	}
}
