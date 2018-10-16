package inte_proj18.game;

public class Player {
	public static final int INITIALHP = 100;
	private String name;
	private Position pos;
	private GameMap gameMap;
	private int hp;
	private int maxHP;

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
	public void moveUp() {
		int  newY = pos.getY()+1;
		Position newPos = new Position(pos.getX(), newY);
		pos = newPos;
	}
	public int getHP() {
		return hp;
	}
	
	public void takeDmg(int hit) {
		//TODO lägg till defense
		hp-=hit;
		if (hp<=0) {
			hp = 0;
			//TODO lägg till för död
		}
	}
	public void heal(int heal) {
		hp+=heal;
		if(hp>maxHP) {
			hp=maxHP;
		}
	}
	
	public int getMaxHP() {
		return maxHP;
	}
	
//	private void increaseMaxHP() {
//		maxHP= (maxHP/10)*11;
//	}

}
