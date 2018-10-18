package inte_proj18.game;

public class Player extends MovableObject{
	public static final int INITIALHP = 100;
	private GameMap gameMap;
	private int maxHP; // currentMaxHP?
	private Wallet wallet;
	private Inventory inventory;

	public Player(String name, Wallet wallet, Inventory inventory) {
		super(name, INITIALHP);
		maxHP = INITIALHP;
		this.wallet = wallet;
		this.inventory = inventory;
	}

	public void enterMap(GameMap gameMap) {

		this.gameMap = gameMap;
		super.setPosition(gameMap.placePlayer(this));
		//pos = gameMap.getEntryPoint();
		//gameMap.placePlayer(this);
		// increaseMaxHP(); bör ta ett värde för vilken nivå man är på.
	}

	public GameMap getGameMap() {
		return gameMap;
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
		if (gameMap.checkPosition(newPos)) {
			gameMap.makeMove(getPosition(), newPos);
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
	
	public Wallet getWallet() {
		return wallet;
	}
	
	public Inventory getInventory() {
		return inventory;
	}

//	private void increaseMaxHP() {
//		maxHP= (maxHP/10)*11;
//	}

}
