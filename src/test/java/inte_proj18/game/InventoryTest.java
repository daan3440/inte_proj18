package inte_proj18.game;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InventoryTest {
	
	
	Inventory inventory;
	HashMap<Item, Integer> itemsInInventory;
	Item item;
	
	@BeforeEach
	public void createInventoryTest() {
		itemsInInventory = new HashMap<Item, Integer>();
		inventory = new Inventory(itemsInInventory);
		item = new Item("Excalibur");
	}
	
	@Test 
	public void getItemsInInventoryTest() {
		assertEquals(inventory.getItemsInInventory(), itemsInInventory );
	}
	
	@Test
	public void addItemToInventoryTest() {
		inventory.addItemToInventory(item);
		int quantity = itemsInInventory.get(item);
		inventory.addItemToInventory(item);
		assertTrue(itemsInInventory.get(item) == quantity + 1);
	}
}
 