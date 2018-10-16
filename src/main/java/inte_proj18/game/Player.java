package inte_proj18.game;

public class Player {
	public static final int INITIALHP = 100;
	private String name;
	private Position pos;
	private GameMap gameMap;
	private int hp;
	private int maxHP; // currentMaxHP?

	public Player(String name) {
		this.name = name;
		hp = maxHP = INITIALHP;
	}

	public String getName() {
		return name;
	}

	public void enterMap(Position pos, GameMap gameMap) {
		this.pos = pos;
		this.gameMap = gameMap;
		// increaseMaxHP(); bör ta ett värde för vilken nivå man är på.
	}

	public Position getPosition() {
		return pos;
	}

	public GameMap getGameMap() {
		return gameMap;
	}

	//TODO Beautify
	public void moveUp() {
		int newY = pos.getY() + 1;
		Position newPos = new Position(pos.getX(), newY);
		executeMove(newPos);
	}
	
	private void executeMove(Position newPos) {
		if (gameMap.checkPosition(newPos)) {
			gameMap.makeMove(pos, newPos);
			pos = newPos;
		}
		
	}

//	public void moveDown() {
//		if (gameMap.checkPosition()) {
//			Position newPos = new Position(pos.getX(), pos.getY() - 1);
//			pos = newPos;
//		}
//	}
//	
//	public void moveRight() {
//		if(gameMap.checkPosition()) {
//			Position newPos = new Position(pos.getX()+1, pos.getY());
//			pos = newPos;
//		}
//	}
//	public void moveLeft() {
//		if(gameMap.checkPosition()) {
//			Position newPos = new Position(pos.getX()-1, pos.getY());
//			pos = newPos;
//		}
//	}

	public int getHP() {
		return hp;
	}

	public void takeDmg(int hitPoints) {
		// TODO lägg till defense
		hp -= hitPoints;
		if (hp <= 0) {
			hp = 0;
			// TODO lägg till för död
		}
	}

	public void heal(int heal) {
		hp += heal;
		if (hp > maxHP) {
			hp = maxHP;
		}
	}

	public int getMaxHP() {
		return maxHP;
	}

//	private void increaseMaxHP() {
//		maxHP= (maxHP/10)*11;
//	}

}
