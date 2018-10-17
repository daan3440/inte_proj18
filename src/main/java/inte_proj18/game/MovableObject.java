package inte_proj18.game;

public class MovableObject extends GameObject{
	private Position pos;
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
		if(newHP>maxHP)
			throw new IllegalArgumentException();
		
		HP = newHP;
	}
	
	


}
