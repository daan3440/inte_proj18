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
	public void itemsExistTest() {
		Inventory inventory = new Inventory();
		assertNotNull(inventory.items);
	}
	
}
