package inte_proj18.game;

<<<<<<< HEAD
public class GameMapTest {
=======
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
>>>>>>> origin/grupp_branch

}
