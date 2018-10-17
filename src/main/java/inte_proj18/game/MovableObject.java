package inte_proj18.game;

public class MovableObject extends GameObject {
	private Position pos;
	private int maxHP;
	private int HP;
	private GameMap gameMap;

	public MovableObject(String name, int maxHP) {
		super(name);
		this.maxHP = maxHP;
		HP = maxHP;
	}

	public int getHP() {
		return HP;
	}

	public void setHP(int newHP) {
		if (newHP > maxHP || newHP < 0)
			throw new IllegalArgumentException();

		HP = newHP;
	}

	public Position getPosition() {
		return pos;
	}

	public void enterMap(GameMap gameMap) {
		this.gameMap = gameMap;
		pos = new Position(10, 10); // ska tas från gameMap, där det finns något som tilldelar enemy sina
									// startpositioner.
		// kallar på en placeEnemy/Object i gamemap för att komma in i hashMap
		// TODO enterMap bör vara abstrakt här men olika i enemy respektive Player på
		// hur den
		// ska får sin startposition från gameMap alternativ Game.

	}

//	public void enterMap(GameMap gameMap) {
//		this.gameMap = gameMap;
//		pos = getEntryPoint();
//		gameMap.placePlayer(this);
//	}

//	private abstract Position getEntryPoint();
//  TODO bör vara i ha separata entryPoint metoder i gameMap för fiende och spelare.

	private void checkHitPoints(int hitPoints) {
		if (hitPoints <= 0)
			throw new IllegalArgumentException();
	}

	public void takeDamage(int hitPoints) {
		checkHitPoints(hitPoints);

		HP -= hitPoints;
		if (HP <= 0)
			HP = 0;
	}

}
