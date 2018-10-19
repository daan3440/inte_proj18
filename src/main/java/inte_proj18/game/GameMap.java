package inte_proj18.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GameMap {
	private static final int MIN_WIDTH = 16;
	private static final int MIN_HEIGHT = 16;
	private static final int MAX_WIDTH = 256;
	private static final int MAX_HEIGHT = 256;
<<<<<<< HEAD
	private static final double PART_IMMOVABLEOBJECTS = 0.6;
	private static final double PART_ITEMS = 0.01;
	private static final double PART_ENEMIES = 0.1;
=======
	private static final double PART_IMMOVABLEOBJECTS = 0.4;
	private static final double PART_ITEMS = 0.1;
	private static final double PART_ENEMIES = 0.01;
>>>>>>> branch 'grupp_branch' of https://github.com/daan3440/inte_proj18.git

	private int width;
	private int height;
	private Map<Position, GameObject> mapObjects = new HashMap<Position, GameObject>();
	private Position entrypoint;
	private Position exitpoint;
	private ArrayList<Position> emptySpots = new ArrayList<Position>();// kommer inte att motsvara tomma spots efter att
	private Set<Position> pathWaySet = new HashSet<>();
	// saker har börjat röra på sig.
	private ArrayList<Position> pathPoints = new ArrayList<Position>();

	public GameMap(int width, int height) {
		if (width < MIN_WIDTH || width > MAX_WIDTH || height < MIN_HEIGHT || height > MAX_HEIGHT) {
			throw new IllegalArgumentException("Map size invalid");
		}
		this.width = width;
		this.height = height;

		fillEmptySpots();
		drawWallFrame();
		entrypoint = new Position(width / 2, height - 1);
		exitpoint = new Position(width / 2, 1 + 1);
		emptySpots.remove(entrypoint);
		emptySpots.remove(exitpoint);
		removeMapObjectsFromEmptySpots();
		generatePathPoints();

		createPathWay();

		generateMapContent();
	}

	public void generateMapContent() {
		generateGameMapEnvironment();
		generateItems();
		generateEnemies();
	}

	public Set<Position> getPathWay() {
		return pathWaySet;
	}

	public void createPathWay() {
//		pathPoints
		Position start = entrypoint;
		while (!pathPoints.isEmpty()) {
			Position pos = checkNearestPoint(start);
			generatePath(start, pos);
			start = pos;
		}
		generatePath(start, exitpoint);

	}

	public void setEntryPoint(Position pos) {
		this.entrypoint = pos;
	}

	public void setExitPoint(Position pos) {
		this.exitpoint = pos;
	}

	private void removeMapObjectsFromEmptySpots() {
		Set<Position> keysList = mapObjects.keySet();
		for (Position pos : keysList) {
			if (emptySpots.contains(pos)) {
				emptySpots.remove(pos);
			}
		}
	}

	public void generatePathPoints() {
		int countPoints = 8; // TODO - make smart algoritm for amount of points (int) MAX_WIDTH-
		for (int i = 0; i < countPoints; i++) {
			pathPoints.add(getEmptyAndRemoveSpot());
		}

	}

	public Position checkNearestPoint(Position pos) {
		Position nPoint = pathPoints.get(0);
		for (Position p : pathPoints) {
			if (pos.getDifference(nPoint) > pos.getDifference(p))
				nPoint = p;
		}
		pathPoints.remove(nPoint);
		return nPoint;
	}

	private Position getEmptyAndRemoveSpot() {
		Position pos = emptySpots.get(0);
		emptySpots.remove(0);
		return pos;
	}

	public void generatePath(Position a, Position b) {
		if (a.getY() > b.getY()) {
			Position temp = a;
			a = b;
			b = temp;
		}

		int y = a.getY();
		while (b.getY() != y) {
			Position pos = new Position(a.getX(), y);
			emptySpots.remove(pos);
			pathWaySet.add(pos);
			y++;
		}
		if (a.getX() > b.getX()) {
			Position temp = a;
			a = b;
			b = temp;
		}

		int x = a.getX();
		while (b.getX() != x) {
			Position pos = new Position(x, y);
			emptySpots.remove(pos);
			pathWaySet.add(pos);
			x++;
		}
		Position pos = new Position(x, y);
		emptySpots.remove(pos);
		pathWaySet.add(pos);
	}

	// TODO gör till privat
	public void generateGameMapEnvironment() {
		double d =(emptySpots.size() * PART_IMMOVABLEOBJECTS);
		System.out.println(d);
		int x = (int) d;
		System.out.println(x);

		for (int i = 0; i <x; i++) {
			Position pos = emptySpots.get(0);
			mapObjects.put(pos, createImmovableObject(pos));
			emptySpots.remove(0);
		}
	}

	private ImmovableObject createImmovableObject(Position pos) {
		return new ImmovableObject();
	}

	// TODO gör till privat
	public void generateItems() {
		int x = (int)(emptySpots.size() * PART_ITEMS);
		for (int i = x; i >= 0; i--) {
			Position pos = emptySpots.get(0);
			mapObjects.put(pos, createItem(pos));
			emptySpots.remove(0);
		}
	}

	private Item createItem(Position pos) {
		return new Item("Name");
	}

	public void generateEnemies() {
		emptySpots.addAll(pathWaySet);
		Collections.shuffle(emptySpots);
		int x = (int) (emptySpots.size() * PART_ENEMIES);
		for (int i = x; i >= 0; i--) {
			Position pos = emptySpots.get(0);
			mapObjects.put(pos, createEnemy(pos));
			emptySpots.remove(0);
		}
	}

	private Enemy createEnemy(Position pos) {
		return new Enemy(pos, this);
	}

	public void fillEmptySpots() {
		int x = 1;
		while (x <= width) {
			int y = 1;
			while (y <= height) {
				emptySpots.add(new Position(x, y));
				y++;
			}
			x++;
		}
		Collections.shuffle(emptySpots);
	}

	public Position getEntryPoint() {
		return entrypoint;
	}

	public Position getExitPoint() {
		return exitpoint;
	}

	public ArrayList<Position> getEmptySpots() {
		return emptySpots;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Map<Position, GameObject> getGameMapObjects() {
		return mapObjects;
	}

	public ArrayList<Position> getPathPoints() {
		return pathPoints;
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

	// Stub för att fixa enterMap för olika gameObjects

	public void drawWallFrame() {
		ImmovableObject io = new ImmovableObject(); // TODO
		for (int x = 1; x <= width; x++) {
			mapObjects.put(new Position(x, 1), io);
			mapObjects.put(new Position(x, height), io);
		}
		for (int x = 1; x <= width; x++) {
			mapObjects.put(new Position(1, x), io);
			mapObjects.put(new Position(width, x), io);

		}
	}

}