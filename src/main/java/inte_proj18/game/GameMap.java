
package inte_proj18.game;

import java.util.HashMap;
import java.util.Map;

public class GameMap {
	private int width;
	private int height;
	private Map<Position, Object> mapObjects = new HashMap<Position,Object>();
	private Position entrypoint;

	public GameMap(int width, int height) {
		this.width = width;
		this.height = height;
		entrypoint = new Position(20,20);
	}
	
	public Position getEntryPoint() {
		return entrypoint;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Map getGameMapObjects() {
		return mapObjects;
	}

	// Stub för move i player.
	public boolean checkPosition(Position pos) {
//		return !mapObjects.containsKey(pos);
		return true;
	}
	
	public void makeMove(Position oldpos, Position newPos) {
		Object o = mapObjects.get(oldpos);
		mapObjects.remove(oldpos);
		mapObjects.put(newPos, o);
	}
	
	public void placePlayer(Player p) {
		mapObjects.put(p.getPosition(),p);
	}
	
	public void drawWallFrame() {
		Object o = new Object();
		for(int x= 0; x<=width; x++) {
			mapObjects.put(new Position(x, 0), o);
			mapObjects.put(new Position(x, height), o);

		}
		for(int x= 0; x<=width; x++) {
			mapObjects.put(new Position(0, x), o);
			mapObjects.put(new Position(width, x), o);
			
		}
	}
	
}