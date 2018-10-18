package inte_proj18.game;

public class Item {
	
	private String name;
	private int value;
	
	public Item() {
		
	}

	public Item(String name) {
		this.name = name;
	}
	
	public Item(String name, int value) {
		this.name = name;
		this.value = value;
	}


	public String getName() {
		return name;
	}
	
	public int getValue() {
		return value;
	}

}
