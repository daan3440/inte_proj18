package inte_proj18.game;

public class Player {
	private String name;
	private Position pos;
	private GameMap gameMap;

	public Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void enterMap(Position pos, GameMap gameMap) {
		this.pos = pos;
		this.gameMap = gameMap;
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

}
