package inte_proj18.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GameMap {
	private static final int MIN_WIDTH = 64;
	private static final int MIN_HEIGHT = 64;
	private static final int MAX_WIDTH = 256;
	private static final int MAX_HEIGHT = 256;
	private static final double PART_IMMOVABLEOBJECTS = 0.4;
	private static final double PART_ITEMS = 0.2;
	private static final double PART_ENEMIES = 0.2;

	private int width;
	private int height;
	private Map<Position, GameObject> mapObjects = new HashMap<Position, GameObject>();
	private Position entrypoint;
	private Position exitpoint;
	private ArrayList<Position> emptySpots = new ArrayList<Position>();// kommer inte att motsvara tomma spots efter att
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

		createPathWay();

		generateMapContent();
	}

	public void createPathWay() {
//		pathPoints
		Position start = entrypoint;

		for (int i = 0; i < pathPoints.size(); i++) {
			generatePath(start, pathPoints.get(i));
			start = pathPoints.get(i);
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
			emptySpots.remove(new Position(a.getX(), y));
			y++;
		}
		if (a.getX() > b.getX()) {
			Position temp = a;
			a = b;
			b = temp;
		}

		int x = a.getX();
		while (b.getX() != x) {
			emptySpots.remove(new Position(x, y));
			x++;
		}
	}

	public void generateMapContent() {
		generateImmovableObjects();
	}

	private void generateImmovableObjects() {
		int x = (int) (emptySpots.size() * PART_IMMOVABLEOBJECTS);
		for (int i = x; i > x; i--) {
			Position pos = emptySpots.get(0);
			mapObjects.put(pos, createImmovableObject(pos));
			emptySpots.remove(0);
		}
	}

	private ImmovableObject createImmovableObject(Position pos) {
		return new ImmovableObject();
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

	public Map getGameMapObjects() {
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
	public Position placeMovableObject(MovableObject movableObject) {
		Position movableObjectPosition;
		if (movableObject instanceof Player)
			movableObjectPosition = entrypoint;
		else
			movableObjectPosition = emptySpots.get(0);
		
		mapObjects.put(movableObjectPosition, movableObject);
		return movableObjectPosition;
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