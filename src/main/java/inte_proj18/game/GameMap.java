package inte_proj18.game;

import java.util.HashMap;
import java.util.Map;

public class GameMap {
	private int width;
	private int height;
	private Map<Position, Object> mapObjects;
	
	public GameMap(int width, int height) {
		this.width=width;
		this.height=height;
		mapObjects = new HashMap();
//		mapObjects.put(key, value)
	}
	
	public int getWidth(){
		return width;
	}
	public int getHeight(){
		return height;
	}
	
	public Map getGameMapObjects() {
		return mapObjects;
	}

}
