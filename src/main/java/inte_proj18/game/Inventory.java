package inte_proj18.game;

public class Inventory {

	private final int ArraySize = 10;
	private Item[] items;

	public Inventory() {
		items = new Item[10];
	}

	public Item[] getItemsArray() {
		return items;
	}

	public Item getItem(String itemName) {
		for (int i = 0; i < items.length; i++) {
			if (items[i] != null && items[i].getName().equals(itemName)) {
				return items[i];
			}
		}
		return null;
	}

	public void addItem(Item item) {
		items[0] = item;
	}

	public boolean removeItem(String itemName) {
		for (int i = 0; i < items.length; i++) {
			if (items[i] != null && items[i].getName().equals(itemName)) {
				items[i] = null;
				return true;
			}
		}
		return false;
	}

}
