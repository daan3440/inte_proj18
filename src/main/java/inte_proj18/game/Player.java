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

	public void enterMap(GameMap gameMap) {

		this.gameMap = gameMap;
		pos = gameMap.getEntryPoint();
		gameMap.placePlayer(this);
		// increaseMaxHP(); bör ta ett värde för vilken nivå man är på.
	}

	public Position getPosition() {
		return pos;
	}

	public GameMap getGameMap() {
		return gameMap;
	}

	// TODO Beautify
	public void moveUp() {
		int newY = pos.getY() - 1;
		Position newPos = new Position(pos.getX(), newY);
		executeMove(newPos);
	}

	public void moveDown() {
		int newY = pos.getY() + 1;
		Position newPos = new Position(pos.getX(), newY);
		executeMove(newPos);
	}

	public void moveLeft() {
		int newX = pos.getX() -1;
		Position newPos = new Position(newX,pos.getY());
		executeMove(newPos);
	}

	public void moveRight() {
		int newX = pos.getX() + 1;
		Position newPos = new Position(newX,pos.getY());
		executeMove(newPos);
	}

	private void executeMove(Position newPos) {
		if (gameMap.checkPosition(newPos)) {
			gameMap.makeMove(pos, newPos);
			pos = newPos;
		}

	}

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
