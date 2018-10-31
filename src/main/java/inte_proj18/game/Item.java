package inte_proj18.game;

public class Item extends ImmovableObject {

	private int value;
	private double price;
	private double buyRate;
	private double sellRate;

	public Item() {

	}

	public Item(String name) {
		super(name);
	}

	public Item(String name, int value) {
		super(name);
		this.value = value;
		buyRate = 1.2d;
		sellRate = 0.8d;
	}
	
	public Item(String name, int value, double buyRate, double sellRate) {
		super(name);
		this.value = value;
		this.buyRate = buyRate;
		this.sellRate = sellRate;
	}

	public int getValue() {
		return value;
	}
	
	public double getBuyRate() {
		return buyRate;
	}
	
	public double getSellRate() {
		return sellRate;
	}

	public double buyPrice() {
		price = getValue() * buyRate;
		return price;
	}

	public double sellPrice() {
		price = getValue() * sellRate;
		return price;
	}
	
	public int hashCode() {
		int temp = 0;
		for(int i = 0; i < getName().length(); i++) {
			temp += getName().charAt(i);
		}
		return value + temp;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Item) {
			return ((Item) o).getName().equals(getName());
		}
		return false;
	}
}
