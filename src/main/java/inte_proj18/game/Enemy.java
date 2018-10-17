package inte_proj18.game;

public class Enemy extends MovableObject {

	public Enemy(String name, int HP) {
		super(name, HP);
	}
	
	private void checkHitPoints(int hitPoints) {
		if(hitPoints<=0) 
			throw new IllegalArgumentException();
	}

	public void takeDamage(int hitPoints){
		checkHitPoints(hitPoints);
		
		int HP = this.getHP() - hitPoints;
		if(HP<=0) 
			this.setHP(0);
		 else 
			 this.setHP(HP);
	}
	
//	public void enterMap(GameMap gameMap) {
//		this.gameMap = gameMap;
//		pos = new Position(10, 10); // ska tas från gameMap, där det finns något som tilldelar enemy sina
//									// startpositioner.
//		// kallar på en placeEnemy/Object i gamemap för att komma in i hashMap
//	}

}
