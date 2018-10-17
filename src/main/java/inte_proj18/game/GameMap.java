﻿
package inte_proj18.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class GameMap {
	private static final int MIN_WIDTH = 64;
	private static final int MIN_HEIGHT = 64;
	private static final int MAX_WIDTH = 256;
	private static final int MAX_HEIGHT = 256;
	
	private int width;
	private int height;
	private Map<Position, Object> mapObjects = new HashMap<Position, Object>();
	private Position entrypoint;
	private Position exitpoint;
	private ArrayList<Position> emptySpots = new ArrayList<Position>();//kommer inte att motsvara tomma spots efter att saker har börjat röra på sig.

	public GameMap(int width, int height) {
		if(width < MIN_WIDTH || width > MAX_WIDTH|| height<MIN_HEIGHT||height>MAX_HEIGHT) {
			throw new IllegalArgumentException("Map size invalid");
		}
		this.width = width;
		this.height = height;
		
		
		drawWallFrame();
		entrypoint = new Position(width/2+1, height-1);
		exitpoint = new Position(width/2-1,0+1);
		
		generateMapContent();
	}
	
	public void generateMapContent() {
		Random rnd = new Random();
		
	}

	public Position getEntryPoint() {
		return entrypoint;
	}
	
	public Position getExitPoint() {
		return exitpoint;
	}
	
	public ArrayList<Position> getEmptySpots(){
		return emptySpots;
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
		mapObjects.put(p.getPosition(), p);
	}

	public void drawWallFrame() {
		Object o = new Object();
		for (int x = 0; x <= width; x++) {
			mapObjects.put(new Position(x, 0), o);
			mapObjects.put(new Position(x, height), o);
		}
		for (int x = 0; x <= width; x++) {
			mapObjects.put(new Position(0, x), o);
			mapObjects.put(new Position(width, x), o);

		}
	}

}