package inte_proj18.game;

public class MovableObject extends GameObject {
	private int maxHP;
	private int HP;
	private GameMap gameMap;
	private Position pos;

	public MovableObject(String name, int maxHP) {
		super(name);
		this.maxHP = maxHP;
		HP = maxHP;
	}

	public int getHP() {
		return HP;
	}
	
	public GameMap getGameMap() {
		return gameMap;
	}
	
	public void setPosition(Position pos) {
		this.pos = pos;
	}

	public Position getPosition() {
		return pos;
	}
	
	public void enterMap(Position pos) {
		this.pos = pos;
	}
	
	public void setGameMap(GameMap gameMap) {
		this.gameMap = gameMap;
	}

	public void setHP(int newHP) {
		if (newHP > maxHP || newHP < 0)
			throw new IllegalArgumentException();

		HP = newHP;
	}
	
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
