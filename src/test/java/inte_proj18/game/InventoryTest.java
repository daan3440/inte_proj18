package inte_proj18.game;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InventoryTest {
	final static String itemName = "Excalibur";

	Inventory inventory;
	HashMap<Item, Integer> itemsInInventory;
	Item item;

	@BeforeEach
	public void createInventoryTest() {
		itemsInInventory = new HashMap<Item, Integer>();
		inventory = new Inventory(itemsInInventory);
		item = new Item("Excalibur");
		inventory.addItemToInventory(item);
	}

	@Test
	public void getItemsInInventoryTest() {
		assertEquals(inventory.getItemsInInventory(), itemsInInventory);
	}

	@Test
	public void addItemToInventoryTest() {
		int quantity = itemsInInventory.get(item);
		inventory.addItemToInventory(item);
		assertTrue(itemsInInventory.get(item) == quantity + 1);
	}

	@Test

	public void removeItemFromInventoryTest() {
		inventory.addItemToInventory(item);
		int quantity = itemsInInventory.get(item);
		inventory.removeItemFromInventory(item);
		assertTrue(itemsInInventory.get(item) == quantity - 1);
	}

	@Test
	public void removeItemFromInventoryWithOneItemTest() {
		inventory.removeItemFromInventory(item);
		assertTrue(inventory.getItemsInInventory().isEmpty());
	}

	@Test // Antons
	public void createInventoryNotNullTest() {
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

	@Test
	public void emptyPlaceTest() {
		Inventory inventory = new Inventory();
		inventory.addItem(new Item(itemName));
		assertEquals(inventory.getEmptyPlace(), 1);
	}

	@Test
	public void noEmptyPlaceTest() {
		Inventory inventory = new Inventory();
		for (int i = 0; i < 10; i++) {
			inventory.addItem(new Item(itemName));
		}
		assertEquals(inventory.getEmptyPlace(), -1);
	}
	
	@Test
	public void removeNonExistingItemHashTest() { // Rename title maybe
		Inventory inventory = new Inventory();
		assertEquals(inventory.removeItemFromInventory(new Item()) , false);
	}
	
	@Test
	public void removingItemWithNewInstanceTest() {
		Inventory inventory = new Inventory();
		inventory.addItemToInventory(new Item(itemName, 100));
		inventory.addItemToInventory(new Item(itemName, 100));
		assertTrue(inventory.removeItemFromInventory(new Item(itemName, 100)));
	}
	
	@Test
	public void correctQuantityWithNewInstanceTest() {
		Inventory inventory = new Inventory();
		inventory.addItemToInventory(new Item(itemName, 100));
		inventory.addItemToInventory(new Item(itemName, 100));
		inventory.removeItemFromInventory(new Item(itemName, 100));
		assertEquals(inventory.getItemsInInventory().get(new Item(itemName, 100)).intValue() , 1);
	}
	
}
