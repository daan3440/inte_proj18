package inte_proj18.game;

public class Position {

	final private int x , y;

	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	public int getDifference(Position pos) {
		return Math.abs((this.x-pos.x))+ Math.abs((this.y-pos.y));
	}
	
	public int hashCode() {
		return x*7867+y;

	}
	
	public boolean equals(Object object) {
		if (object instanceof Position)
			if (this.x == ((Position) object).getX() && this.y == ((Position) object).getY())
					return true;
		return false;
	}


}
