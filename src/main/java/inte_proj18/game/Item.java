package inte_proj18.game;

public class Item extends ImmovableObject{
	
	private int value;
	private double price;
	
	public Item() {
		
	}

	public Item(String name) {
		super(name);
	}
	
	public Item(String name, int value) {
		super(name);
		this.value = value;
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
