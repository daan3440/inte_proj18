package inte_proj18.game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InventoryTest {

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
		Item item = new Item("Excalibur");
		inventory.addItem(item);
		assertEquals(inventory.getItem(item.getName()).getName(), "Excalibur");
	}


	@Test
	public void removeItemTest() {
		Inventory inventory = new Inventory();
		Item item = new Item("Excalibur");
		inventory.addItem(item);
		assertEquals(inventory.removeItem("Excalibur"), true);
	}

	@Test
	public void removeNonExistingItemTest() {
		Inventory inventory = new Inventory();
		inventory.removeItem("Excalibur");
		assertEquals(inventory.removeItem("Excalibur"), false);
	}

	@Test
	public void getNonExistingItemTest() {
		Inventory inventory = new Inventory();
		assertNull(inventory.getItem("Excalibur"));
	}

}
