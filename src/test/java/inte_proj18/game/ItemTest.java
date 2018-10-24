package inte_proj18.game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ItemTest {

	Item item;

	@BeforeEach
	public void createItem() {
		item = new Item("Excalibur", 100);

	}

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
		assertEquals(item.getValue(), 100);
	}

	@Test
	public void itemBuyPriceTest() {
		assertEquals(item.buyPrice(), item.getValue() * 1.2);
	}

	@Test
	public void itemSellPriceTest() {
		assertEquals(item.sellPrice(), item.getValue() * 0.8);
	}
	
	@Test
	public void itemBuyRateTest() {
		Item item = new Item("", 100, 1.21d, 0.5d);
		assertEquals(item.getBuyRate() , 1.21d);
	}
	
	@Test
	public void itemSellRateTest() {
		Item item = new Item("", 100, 1.21d, 0.5d);
		assertEquals(item.getSellRate() , 0.5d);
	}
	
	@Test
	public void itemCompareToNonItem() {
		assertEquals(item.equals(null) , false);
	}

}