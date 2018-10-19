package inte_proj18.game;

public class MovableObject extends GameObject {
	private int maxHP;
	private int HP;

	public MovableObject(String name, int maxHP) {
		super(name);
		this.maxHP = maxHP;
		HP = maxHP;
	}

	public int getHP() {
		return HP;
	}

	public void setHP(int newHP) {
		if (newHP > maxHP || newHP < 0)
			throw new IllegalArgumentException();

		HP = newHP;
	}
	
	private void checkHitPoints(int hitPoints) {
		if (hitPoints <= 0)
			throw new IllegalArgumentException();
	}

	public void takeDamage(int hitPoints) {
		checkHitPoints(hitPoints);

		HP -= hitPoints;
		if (HP <= 0)
			HP = 0;
	}

}
