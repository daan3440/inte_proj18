package inte_proj18.game;

public class GameObject {
	private String name;
	private Position pos;

	public GameObject(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setPosition(Position pos) {
		this.pos = pos;
	}

	public Position getPosition() {
		return pos;
	}
	
	public void enterMap(GameMap gameMap) {
		pos = gameMap.placeObject(this);
	}
}
