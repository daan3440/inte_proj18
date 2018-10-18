package inte_proj18.game;

public class Inventory {

	private final int ArraySize = 10;
	private Item[] items;

	public Inventory() {
		items = new Item[ArraySize];
	}

	public Item[] getItemsArray() {
		return items;
	}

	public Item getItem(String itemName) {
		for (int i = 0; i < ArraySize; i++) {
			if (items[i] != null && items[i].getName().equals(itemName)) {
				return items[i];
			}
		}
		return null;
	}

	public boolean addItem(Item item) {
		items[0] = item;
		for (int i = 0; i < ArraySize; i++) {
			if (items[i] == null) {
				items[i] = item;
				return true;
			}
		}
		return false;
	}

	public Item removeItem(String itemName) {
		for (int i = 0; i < ArraySize; i++) {
			if (items[i] != null && items[i].getName().equals(itemName)) {
				Item temp = items[i];
				items[i] = null;
				return temp;
			}
		}
		return null;
	}
	
	public String listItems() {
		String output = "";
		for (int i = 0; i < ArraySize; i++) {
			output = output + "\n" + items[i];
		}
		return output;
	}

}
