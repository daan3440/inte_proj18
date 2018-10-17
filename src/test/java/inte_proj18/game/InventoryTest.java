package inte_proj18.game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InventoryTest {
	
	final static String itemName = "Excalibur";

	@Test
	public void createInventoryTest() {
		assertNotNull(new Inventory());
	}

	@Test
	public void itemArrayExistTest() {
		Inventory inventory = new Inventory();
		assertNotNull(inventory.getItemsArray());
	}

	@Test
	public void addAndGetItemFromArrayTest() {
		Inventory inventory = new Inventory();
		Item item = new Item(itemName);
		inventory.addItem(item);
		assertEquals(inventory.getItem(item.getName()).getName(), "Excalibur");
	}


	@Test
	public void removeItemTest() {
		Inventory inventory = new Inventory();
		Item item = new Item(itemName);
		inventory.addItem(item);
		assertEquals(inventory.removeItem(itemName), item);
	}

	@Test
	public void removeNonExistingItemTest() {
		Inventory inventory = new Inventory();
		inventory.removeItem(itemName);
		assertEquals(inventory.removeItem(itemName), null);
	}

	@Test
	public void getNonExistingItemTest() {
		Inventory inventory = new Inventory();
		assertNull(inventory.getItem(itemName));
	}
	
	@Test
	public void addToManyItemsTest() {
		Inventory inventory = new Inventory();
		for (int i = 0; i < 10; i++) {
			inventory.addItem(new Item());
		}
		assertFalse(inventory.addItem(new Item()));
	}

}
