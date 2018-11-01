package inte_proj18.game;

import java.util.Map;

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

	private static final double DEFAULT_PART_IMMOVABLEOBJECTS = 0.6;
	private static final double DEFAULT_PART_ITEMS = 0.01;
	private static final double DEFAULT_PART_ENEMIES = 0.2;

	private String name;
	private Map<Position, GameObject> mapObjects;
	private Position entrypoint;
	private Position exitPoint;

	public GameMap(String name, int width, int height) {
		this(name, width, height, DEFAULT_PART_IMMOVABLEOBJECTS, DEFAULT_PART_ENEMIES, DEFAULT_PART_ITEMS);
	}

	public GameMap(String name, int width, int height, double partImmovableObjects, double partEnemies,
			double partItems) {
		if (nameLengthCheck(name)) {
			throw new IllegalArgumentException("Name not invalid!");

		}
		if (immovableObjectsOutOfRange(partImmovableObjects) || enemiesOutOfRange(partEnemies)
				|| itemsOutOfRange(partItems)) {
			throw new IllegalArgumentException("Map Object parts invalid!");
		}
		if (width < MIN_WIDTH || width > MAX_WIDTH || height < MIN_HEIGHT || height > MAX_HEIGHT
				|| checkAspect(width, height)) {
			throw new IllegalArgumentException("Map size invalid");
		}

		this.name = name;
		MapGeneration mg = new MapGeneration(width, height, partImmovableObjects, partEnemies, partItems);
		mapObjects = mg.getMapObjects();
		this.entrypoint = mg.getEntryPoint();
		this.exitPoint = mg.getExitPoint();

	}

	private boolean checkAspect(int width, int height) {
		return (width * 4 < height || height * 4 < width);
	}

	private boolean nameLengthCheck(String name) {
		return (name.length() < 3 || name.length() > 32);
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

	public boolean mapDimensionsOutOfRange(int width, int height) {
		return width < MIN_WIDTH || width > MAX_WIDTH || height < MIN_HEIGHT || height > MAX_HEIGHT;
	}

	public int getMinWidth() {
		return MIN_WIDTH;
	}

	public int getMaxWidth() {
		return MAX_WIDTH;
	}

	public int getMinHeight() {
		return MIN_HEIGHT;
	}

	public int getMaxHeight() {
		return MAX_HEIGHT;
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

	public boolean checkPosition(Position pos) {
		return !mapObjects.containsKey(pos);
	}

	public void makeMove(Position oldpos, Position newPos) {
		GameObject go = mapObjects.get(oldpos);
		mapObjects.remove(oldpos);
		mapObjects.put(newPos, go);
	}

	public Position placePlayer(Player player) {
		mapObjects.put(entrypoint, player);
		return entrypoint;
	}
	
	public String getName() {
		return name;
	}

}