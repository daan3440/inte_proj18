package inte_proj18.game;

import java.util.HashMap;


public class Inventory {

	private HashMap<Item, Integer> itemsInInventory = new HashMap<Item, Integer>();

	
	public Inventory(HashMap<Item, Integer> inventory) {
		this.itemsInInventory = inventory;
	}
	
	public HashMap<Item, Integer> getItemsInInventory() {
		return itemsInInventory;
	}

	public void addItemToInventory(Item item) {
		int quantity = 1;
		if(itemsInInventory.containsKey(item)) {
			quantity += itemsInInventory.get(item);
		}
		itemsInInventory.put(item, quantity);
	}
	
}
