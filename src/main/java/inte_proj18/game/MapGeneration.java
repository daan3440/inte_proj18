package inte_proj18.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapGeneration {
	
	private final static int NUMBER_OF_PATH_POINTS = 8;
		
	private ArrayList<Position> emptySpots = new ArrayList<Position>();
	private int height;
	private int width;
	
	private Position entryPoint;
	private Position exitPoint;
	
	private Map<Position, GameObject> mapObjects = new HashMap<Position, GameObject>();
	private ArrayList<Position> pathPoints = new ArrayList<Position>();
	private Set<Position> pathWay = new HashSet<>();
	
	private double partImmovableObjectsOnMap;
	private double partEnemiesOnMap;
	private double partItemsOnMap;
	
	
	public MapGeneration(int height, int width, double partImmovableObjectsOnMap, double partEnemiesOnMap, double partItemsOnMap) {
		this.height = height;
		this.width = width;
		this.partImmovableObjectsOnMap = partImmovableObjectsOnMap;
		this.partEnemiesOnMap = partEnemiesOnMap;
		this.partItemsOnMap = partItemsOnMap;
		entryPoint = new Position(width / 2, height - 1);
		exitPoint = new Position(width / 2, 1 + 1);
		
		
		fillEmptySpots();
		drawWallFrame();
		

		emptySpots.remove(entryPoint);
		emptySpots.remove(exitPoint);
		removeMapObjectsFromEmptySpots();
		createPath();
		generateMapContent();
	}

	protected void fillEmptySpots() {
		for(int x = 1; x <=width;x++) {
			for(int y = 1; y <=height; y++) 
				emptySpots.add(new Position(x,y));
		}
		Collections.shuffle(emptySpots);
	}
	
	protected void drawWallFrame() {
		ImmovableObject immovableObj = new ImmovableObject(); 
		for (int x = 1; x <= width; x++) {
			mapObjects.put(new Position(x, 1), immovableObj);
			mapObjects.put(new Position(x, height), immovableObj);
		}

		for (int x = 1; x <= height; x++) {
			mapObjects.put(new Position(1, x), immovableObj);
			mapObjects.put(new Position(width, x), immovableObj);

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
	
	protected void createPath() {
		generatePathPoints();
		createPathWay();
	}
	
	protected void generatePathPoints() {
		for (int i = 0; i < NUMBER_OF_PATH_POINTS; i++) {
			pathPoints.add(getEmptySpotAndRemoveSpot());
		}

	}
	
	protected void createPathWay() {
		Position start = entryPoint;
		while (!pathPoints.isEmpty()) {
			Position pos = getNearestPoint(start);
			generatePath(start, pos);
			start = pos;
		}
		generatePath(start, exitPoint);

	}

	
	protected Position getNearestPoint(Position pos) {
		Position nPoint = pathPoints.get(0);
		for (Position p : pathPoints) {
			if (pos.getDistance(nPoint) > pos.getDistance(p))
				nPoint = p;
		}
		pathPoints.remove(nPoint);
		return nPoint;
	}


	protected void generatePath(Position a, Position b) {
		int y = buildYAxisPath(a,b);
		int x = buildXAxisPath(a,b,y);
		//Tar bort punkten där x- och y-ledet korsas.
		Position pos = new Position(x, y);
		emptySpots.remove(pos);
		pathWay.add(pos);
	}
	
	private int buildYAxisPath(Position a, Position b) {
		//Byter så a är positionen som är högst upp (lägst y-värde).
				if (a.getY() > b.getY()) {
					Position temp = a;
					a = b;
					b = temp;
				}
				//Skapar en väg mellan as och bs y-värde.
				int y = a.getY();
				while (b.getY() != y) {
					Position pos = new Position(a.getX(), y);
					emptySpots.remove(pos);
					pathWay.add(pos);
					y++;
				}
				return y;
	}
	private int buildXAxisPath(Position a, Position b, int y) {
		//Byter så a är positionen som är längst till vänster (lägst x-värde).
		if (a.getX() > b.getX()) {
			Position temp = a;
			a = b;
			b = temp;
		}
		//Skapar en väg mellan as och bs x-värde.
		int x = a.getX();
		while (b.getX() != x) {
			Position pos = new Position(x, y);
			emptySpots.remove(pos);
			pathWay.add(pos);
			x++;
		}
	return x;
	}
	
	protected void generateMapContent() {
		generateGameMapEnvironment();
		emptySpots.addAll(pathWay);
		Collections.shuffle(emptySpots);
		generateItems();
		generateEnemies();
	}
	
	protected void generateGameMapEnvironment() {
		int x = (int) (emptySpots.size() * partImmovableObjectsOnMap);

		for (int i = 0; i < x; i++) {
			Position pos = emptySpots.get(0);
			mapObjects.put(pos, createImmovableObject());
			emptySpots.remove(0);
		}
	}
	
	private ImmovableObject createImmovableObject() {
		return new ImmovableObject();
	}
	
	protected void generateItems() {
		int x = (int) (emptySpots.size() * partItemsOnMap);
		for (int i = x; i >= 0; i--) {
			Position pos = emptySpots.get(0);
			mapObjects.put(pos, createItem());
			emptySpots.remove(0);
		}
	}

	private Item createItem() {
		return new Item();
	}

	protected void generateEnemies() {
		int x = (int) (emptySpots.size() * partEnemiesOnMap);
		for (int i = x; i >= 0; i--) {
			Position pos = emptySpots.get(0);
			mapObjects.put(pos, createEnemy(pos));
			emptySpots.remove(0);
		}
	}

	private Enemy createEnemy(Position pos) {
		return new Enemy(pos);
	}

	private Position getEmptySpotAndRemoveSpot() {
		Position pos = emptySpots.get(0);
		emptySpots.remove(0);
		return pos;
	}
	
	//Metoderna här under är get metoder och metoder som används av testklassen
	
	protected void clearEmptySpots(){
		emptySpots.clear();
	}
		
	protected int getEmptySpotsSize() {
		return emptySpots.size();
	}
	
	protected int getWidth() {
		return width;
	}

	protected int getHeight() {
		return height;
	}
	
	protected boolean mapObjectsContainsKey(Position pos) {
		return mapObjects.containsKey(pos);
	}
	
	protected boolean emptySpotsContains(Position pos) {
		return emptySpots.contains(pos);
	}
	
	protected Set<Position> getMapObjectsKeySet(){
		return mapObjects.keySet();
	}
	
	protected ArrayList<Position> getPathPoints(){
		return pathPoints;
	}
	
	protected void clearPathPoints() {
		pathPoints.clear();
	}
	
	protected boolean isPathPointsEmpty() {
		return pathPoints.isEmpty();
	}
	
	protected void removeFromEmptySpots(Position pos) {
		emptySpots.remove(pos);
	}
	
	protected void addPathPoints(Position pos) {
		pathPoints.add(pos);
	}
	
	protected void setEntryPoint(Position pos) {
		this.entryPoint = pos;
	}

	protected void setExitPoint(Position pos) {
		this.exitPoint = pos;
	}
	
	protected void clearPathWay() {
		pathWay.clear();
	}
	
	protected Set<Position> getPathWay(){
		return pathWay;
	}
	
	protected GameObject getMapObjectsEntry(Position pos) {
		return mapObjects.get(pos);
	}
	
	protected void addArrayListToPathPoints(ArrayList<Position> list) {
		pathPoints.addAll(list);
	}
	
	protected Map<Position,GameObject> getMapObjects(){
		return mapObjects;
	}
	
	protected Position getEntryPoint() {
		return entryPoint;
	}

	protected Position getExitPoint() {
		return exitPoint;
	}
}
