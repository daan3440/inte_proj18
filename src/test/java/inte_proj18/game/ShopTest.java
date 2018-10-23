package inte_proj18.game;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShopTest {

	Item item;
	Inventory inventory;
	Player player;
	Wallet wallet;
	Shop shop;
	HashMap<Item, Integer> itemsInInventory;

	@BeforeEach
	void makeSale() {
		item = new Item("Excalibur", 100);
		HashMap<Item, Integer> itemsInInventory = new HashMap<Item, Integer>();
		inventory = new Inventory(itemsInInventory);
		inventory.addItemToInventory(item);
		wallet = new Wallet(200);
		player = new Player("Eva", wallet, inventory);
		shop = new Shop();
	}

	@Test
	public void addItemToInventoryTest(){
		int quantity = inventory.getItemsInInventory().get(item);
		shop.buyProduct(player, item);
		assertTrue(inventory.getItemsInInventory().get(item) == quantity + 1);
	}

	@Test
	public void moneyReducedTest() {
		shop.buyProduct(player, item);
		assertEquals(wallet.getMoney(), 200 - item.buyPrice());
	}

	@Test
	public void moneyIncreasedTest() {
		shop.sellProduct(player, item);
		assertEquals(wallet.getMoney(), 200 + item.sellPrice());
	}
	
	@Test
	public void itemRemovedFromInventoryTest() {
		inventory.addItemToInventory(item);
		int quantity = inventory.getItemsInInventory().get(item);
		shop.sellProduct(player, item);
		assertTrue(inventory.getItemsInInventory().get(item) == quantity - 1);
	}
	
	
}
