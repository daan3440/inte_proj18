package inte_proj18.game;

public class Item extends ImmovableObject{
	
	private int value;
	
	public Item() {
		
	}

	public Item(String name) {
		super("T");
	}
	
	public Item(String name, int value) {
		super(name);
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}

}
