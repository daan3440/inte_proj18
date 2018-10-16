
package inte_proj18.game;

import java.util.HashMap;
import java.util.Map;

public class GameMap {
	private int width;
	private int height;
	private Map<Position, Object> mapObjects;

	public GameMap(int width, int height, Player p) {
		this.width = width;
		this.height = height;
		Position playerpos = new Position(20,20);
		mapObjects = new HashMap();
		p.enterMap(playerpos, this);
		mapObjects.put(playerpos, p);
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
		return !mapObjects.containsKey(pos);
	}
	
	public void makeMove(Position oldpos, Position newPos) {
		Object o = mapObjects.get(oldpos);
		mapObjects.remove(oldpos);
		mapObjects.put(newPos, o);
	}
	
}