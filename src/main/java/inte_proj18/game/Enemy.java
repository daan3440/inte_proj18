package inte_proj18.game;

public class Enemy extends MovableObject {
	
	public Enemy(Position pos, GameMap gameMap) {
		super("Namn", 100); //TODO Ska ändras vid införande specifika fiendeklasser
		setGameMap(gameMap);
		setPosition(pos);
	}
	
}
