package inte_proj18.game;

public class Position {
	private int x , y;
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Position(Position pos) {
		this(pos.x, pos.y);
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public String toString() {
		return "{" + x + "," + y + "}";
	}
	
	public boolean equals(Object object) {
		if (object instanceof Position)
			if (this.x == ((Position) object).getX() && this.y == ((Position) object).getY())
					return true;
		return false;
	}
}
