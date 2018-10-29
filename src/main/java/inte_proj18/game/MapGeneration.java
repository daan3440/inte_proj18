package inte_proj18.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class MapGeneration {

	private ArrayList<Position> emptySpots = new ArrayList<Position>();
	private int height;
	private int width;
	private Position entryPoint;
	private Position exitPoint;
	private Map<Position, GameObject> mapObjects = new HashMap<Position, GameObject>();
	private ArrayList<Position> pathPoints = new ArrayList<Position>();
	private Set<Position> pathWay = new HashSet<>();
	private GameMap gameMap;
	private double partImmovableObjects = 0.4;
	private double partEnemies = 0.2;
	private double partItems = 0.01;

	public MapGeneration(int height, int width, double partImmovableObjects, double partEnemies, double partItems) {
		this.height = height;
		this.width = width;
		this.partImmovableObjects = partImmovableObjects;
		this.partEnemies = partEnemies;
		this.partItems = partItems;
		createEntryAndExitPoints();
	
		fillEmptySpots();
		drawWallFrame();

	
		removeMapObjectsFromEmptySpots();
		createPath();
		generateMapContent();

	}
	
	public void createEntryAndExitPoints() {
		boolean checkDistance = false;
		while (!checkDistance) {
			entryPoint = createEntryPoint();// new Position(width / 2, height - 1);
			exitPoint = createExitPoint();// new Position(width / 2, 1 + 1);
			if (checkDistanceLongEnough()) {
				checkDistance = true;
				emptySpots.remove(entryPoint);
				emptySpots.remove(exitPoint);
			}
		}
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

	public void drawWallFrame() {
		ImmovableObject io = new ImmovableObject(); // TODO
		for (int x = 1; x <= width; x++) {
			mapObjects.put(new Position(x, 1), io);
			mapObjects.put(new Position(x, height), io);
		}
		for (int x = 1; x <= height; x++) {
			mapObjects.put(new Position(1, x), io);
			mapObjects.put(new Position(width, x), io);

		}
	}

	private void removeMapObjectsFromEmptySpots() {
		Set<Position> keysList = mapObjects.keySet();
		for (Position pos : keysList) {
			if (emptySpots.contains(pos)) {
				emptySpots.remove(pos);
			}
		}
	}

	public void createPath() {
		generatePathPoints();
		createPathWay();
	}

	public void generatePathPoints() {
		int countPoints = 8; // TODO - make smart algoritm for amount of points (int) MAX_WIDTH-
		for (int i = 0; i < countPoints; i++) {
			pathPoints.add(getEmptyAndRemoveSpot());
		}

	}

	public void createPathWay() {
		Position start = entryPoint;
		while (!pathPoints.isEmpty()) {
			Position pos = checkNearestPoint(start);
			generatePath(start, pos);
			start = pos;
		}
		generatePath(start, exitPoint);

	}

	public Position createEntryPoint() {
		int checkInt = 1;
		int x = generateRandomNumberInRange(checkInt);
		int y = generateRandomNumberInRange(0);
		return new Position(x, y);

	}

	public Position createExitPoint() {
		int checkInt = 1;
		int x = generateRandomNumberInRange(checkInt);
		int y = generateRandomNumberInRange(0);
		return new Position(x, y);

	}

	private int generateRandomNumberInRange(int checkInt) {
		Random rnd = new Random();
		int i;
		if (checkInt == 1) {
			i = rnd.nextInt((int) (((int) width * 0.999) - ((int) width * 0.02) + 1)) + width;
			return i;
		} else {
			i = rnd.nextInt((int) (((int) height * 0.999) - ((int) height * 0.02) + 1)) + height;
		}
		return i;
	}

	public boolean checkDistanceLongEnough() {
//		return entryPoint.getDistance(exitPoint) > Math.abs((int)width*.8) ;
		return (Math.abs(entryPoint.getX() - exitPoint.getX())
				+ (Math.abs(entryPoint.getY() - exitPoint.getY())) > (Math.abs(1 - width)
						+ Math.abs(1 - height) * ((int) 0.8)));
	}

	public Position checkNearestPoint(Position pos) {
		Position nPoint = pathPoints.get(0);
		for (Position p : pathPoints) {
			if (pos.getDistance(nPoint) > pos.getDistance(p))
				nPoint = p;
		}
		pathPoints.remove(nPoint);
		return nPoint;
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
			pathWay.add(pos);
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
			pathWay.add(pos);
			x++;
		}
		Position pos = new Position(x, y);
		emptySpots.remove(pos);
		pathWay.add(pos);
	}

	public void generateMapContent() {
		generateGameMapEnvironment();
		emptySpots.addAll(pathWay);
		Collections.shuffle(emptySpots);
		generateItems();
		generateEnemies();
	}

	public void generateGameMapEnvironment() {
		double d = (emptySpots.size() * partImmovableObjects);
		int x = (int) d;

		for (int i = 0; i < x; i++) {
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
		int x = (int) (emptySpots.size() * partItems);
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
		int x = (int) (emptySpots.size() * partEnemies);
		for (int i = x; i >= 0; i--) {
			Position pos = emptySpots.get(0);
			mapObjects.put(pos, createEnemy(pos));
			emptySpots.remove(0);
		}
	}

	private Enemy createEnemy(Position pos) {
		return new Enemy(pos, gameMap);
	}

	private Position getEmptyAndRemoveSpot() {
		Position pos = emptySpots.get(0);
		emptySpots.remove(0);
		return pos;
	}

	public void clearEmptySpots() {
		emptySpots.clear();
	}

	public int getEmptySpotsSize() {
		return emptySpots.size();
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public boolean mapObjectsContainsKey(Position pos) {
		return mapObjects.containsKey(pos);
	}

	public boolean emptySpotsContains(Position pos) {
		return emptySpots.contains(pos);
	}

	public Set<Position> getMapObjectsKeySet() {
		return mapObjects.keySet();
	}

	public ArrayList<Position> getPathPoints() {
		return pathPoints;
	}

	public void clearPathPoints() {
		pathPoints.clear();
	}

	public boolean isPathPointsEmpty() {
		return pathPoints.isEmpty();
	}

	public void removeFromEmptySpots(Position pos) {
		emptySpots.remove(pos);
	}

	public void addPathPoints(Position pos) {
		pathPoints.add(pos);
	}

	public void setEntryPoint(Position pos) {
		this.entryPoint = pos;
	}

	public void setExitPoint(Position pos) {
		this.exitPoint = pos;
	}

	public void clearPathWay() {
		pathWay.clear();
	}

	public Set<Position> getPathWay() {
		return pathWay;
	}

	public GameObject getMapObjectsEntry(Position pos) {
		return mapObjects.get(pos);
	}

	public void addArrayListToPathPoints(ArrayList<Position> list) {
		pathPoints.addAll(list);
	}

	public Map<Position, GameObject> getMapObjects() {
		return mapObjects;
	}

	public Position getEntryPoint() {
		return entryPoint;
	}

	public Position getExitPoint() {
		return exitPoint;
	}

}
