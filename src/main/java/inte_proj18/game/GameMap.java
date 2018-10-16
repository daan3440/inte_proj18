package inte_proj18.game;

public class GameMap {
	private int width;
	private int height;
	public GameMap(int width, int height) {
		this.width=width;
		this.height=height;
	}
	
	public int getWidth(){
		return width;
	}
	public int getHeight(){
		return height;
	}
	
	//Stub för move i player.
	public boolean checkPosition() {
		return true;
	}

}
