package inte_proj18.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GameMap {
	private static final double MAX_PART_IMMOVABLEOBJECTS = 0.6;
	private static final double MIN_PART_IMMOVABLEOBJECTS = 0.1;
	private static final double MAX_PART_ENEMIES = 0.3;
	private static final double MIN_PART_ENEMIES = 0.01;
	private static final double MAX_PART_ITEMS = 0.05;
	private static final double MIN_PART_ITEMS = 0.005;
	private static final int MIN_WIDTH = 16;
	private static final int MIN_HEIGHT = 16;
	private static final int MAX_WIDTH = 256;
	private static final int MAX_HEIGHT = 256;

	private static final double DEFAULT_PART_IMMOVABLEOBJECTS = 0.4;
	private static final double DEFAULT_PART_ITEMS = 0.01;
	private static final double DEFAULT_PART_ENEMIES = 0.2;

	private Map<Position, GameObject> mapObjects;
	private Position entrypoint;
	private Position exitPoint;


	public GameMap(int width, int height) {
		this(width,height,DEFAULT_PART_IMMOVABLEOBJECTS,DEFAULT_PART_ENEMIES,DEFAULT_PART_ITEMS);
			}
	
	public GameMap(int width, int height, double partImmovableObjects, double partEnemies, double partItems) {
		if(immovableObjectsOutOfRange(partImmovableObjects)||enemiesOutOfRange(partEnemies)||itemsOutOfRange(partItems)) {
			throw new IllegalArgumentException("Map Object parts invalid!");	
		}
		if (width < MIN_WIDTH || width > MAX_WIDTH || height < MIN_HEIGHT || height > MAX_HEIGHT) {
			throw new IllegalArgumentException("Map size invalid");
		}
		
		MapGeneration mg = new MapGeneration(width,height,partImmovableObjects,partEnemies,partItems);
		mapObjects = mg.getMapObjects();
		this.entrypoint = mg.getEntryPoint();
		this.exitPoint = mg.getExitPoint();


	}
	
	public boolean immovableObjectsOutOfRange(double d) {
		return d < MIN_PART_IMMOVABLEOBJECTS || d > MAX_PART_IMMOVABLEOBJECTS;
	}
	
	public boolean enemiesOutOfRange(double d) {
		return d < MIN_PART_ENEMIES || d > MAX_PART_ENEMIES;
	}

	public boolean itemsOutOfRange(double d) {
		return d < MIN_PART_ITEMS || d > MAX_PART_ITEMS;
	}	

	public Position getEntryPoint() {
		return entrypoint;
	}

	public Position getExitPoint() {
		return exitPoint;
	}

	public Map<Position, GameObject> getGameMapObjects() {
		return mapObjects;
	}

	// Stub för move i player.
	public boolean checkPosition(Position pos) {
		return !mapObjects.containsKey(pos);
	}

	public void makeMove(Position oldpos, Position newPos) {
		GameObject go = mapObjects.get(oldpos);
		mapObjects.remove(oldpos);
		mapObjects.put(newPos, go);
	}

	// Stub för placeObject metod för enterMap GameObject
	public Position placePlayer(Player player) {
		mapObjects.put(entrypoint, player);
		return entrypoint;
	}


}