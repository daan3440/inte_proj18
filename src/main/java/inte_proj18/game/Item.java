package inte_proj18.game;

public class Item {
	
	private String name;
	private int value;
	private double price;
	
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

	public double buyPrice() {
		price = getValue() * 1.2;
		return price;
	}
	
	public double sellPrice() {
		price = getValue() * 0.8;
		return price;
	}
}
