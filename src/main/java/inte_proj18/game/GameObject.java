package inte_proj18.game;

public class GameObject {
	private String name;
	private Position pos = new Position(19, 19);

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
}
