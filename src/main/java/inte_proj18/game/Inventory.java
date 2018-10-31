package inte_proj18.game;

import java.util.HashMap;

public class Inventory {

	private final int ArraySize = 10;
	private Item[] items;

	private HashMap<Item, Integer> itemsInInventory = new HashMap<Item, Integer>();

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

	public int getEmptyPlace() {
		int emptyPlace = -1;

		for (int i = 0; i < ArraySize; i++) {
			if (items[i] == null) {
				return i;
			}
		}
		return emptyPlace;
	}

	public Inventory(HashMap<Item, Integer> inventory) {
		this.itemsInInventory = inventory;
	}

	public HashMap<Item, Integer> getItemsInInventory() {
		return itemsInInventory;
	}

	public void addItemToInventory(Item item) {
		int quantity = 1;
		if (itemsInInventory.containsKey(item)) {
			quantity += itemsInInventory.get(item);
		}
		itemsInInventory.put(item, quantity);
	}

	public boolean removeItemFromInventory(Item item) {
		if (itemsInInventory.containsKey(item)) {
			int quantity = itemsInInventory.get(item);
			if (quantity == 1) {
				itemsInInventory.remove(item);
				return true;
			}
			else {
				itemsInInventory.put(item, quantity - 1);
				return true;
			}
		}
		return false;
	}

}
