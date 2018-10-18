package inte_proj18.game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ItemTest {
	
	@Test
	public void itemExistTest() {
		assertNotNull(new Item());
	}
	
	@Test
	public void itemNameExistTest() {
		Item item = new Item("Excalibur");
		assertEquals(item.getName(), "Excalibur");
	}
	
	@Test
	public void itemValueExistTest() {
		Item item = new Item("Excalibur", 100);
		assertEquals(item.getValue(), 100);
	}

}
