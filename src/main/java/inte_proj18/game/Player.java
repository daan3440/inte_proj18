package inte_proj18.game;

public class Player extends MovableObject{
	public static final int INITIALHP = 100;
	private int maxHP; // currentMaxHP?

	public Player(String name) {
		super(name, INITIALHP);
		maxHP = INITIALHP;
	}

	public void enterMap(GameMap gameMap) {
		setGameMap(gameMap);
		setPosition(gameMap.placePlayer(this));
		//pos = gameMap.getEntryPoint();
		//gameMap.placePlayer(this);
		// increaseMaxHP(); bör ta ett värde för vilken nivå man är på.
	}

	// TODO Beautify
	public void moveUp() {
		int newY = getPosition().getY() - 1;
		Position newPos = new Position(getPosition().getX(), newY);
		executeMove(newPos);
	}

	public void moveDown() {
		int newY = getPosition().getY() + 1;
		Position newPos = new Position(getPosition().getX(), newY);
		executeMove(newPos);
	}

	public void moveLeft() {
		int newX = getPosition().getX() -1;
		Position newPos = new Position(newX,getPosition().getY());
		executeMove(newPos);
	}

	public void moveRight() {
		int newX = getPosition().getX() + 1;
		Position newPos = new Position(newX,getPosition().getY());
		executeMove(newPos);
	}

	private void executeMove(Position newPos) {
		if (getGameMap().checkPosition(newPos)) {
			getGameMap().makeMove(getPosition(), newPos);
			setPosition(newPos);
		}

	}

	public void heal(int heal) {
		int hp = this.getHP() + heal;
		if (hp > maxHP)
			this.setHP(maxHP);
		else 
			this.setHP(hp);
	}

	public int getMaxHP() {
		return maxHP;
	}

//	private void increaseMaxHP() {
//		maxHP= (maxHP/10)*11;
//	}

}
