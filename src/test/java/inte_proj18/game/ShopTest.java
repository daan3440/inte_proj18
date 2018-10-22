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
		HashMap<Item, Integer> itemsInInventory =  new HashMap<Item, Integer>();
		inventory = new Inventory(itemsInInventory);
		wallet = new Wallet(200);
		player = new Player("Eva", wallet, inventory);
		shop = new Shop();
	}

//	@Test
//	public void addItemToInventoryTest(){
//
//	}

	@Test
	public void moneyReducedTest() {
		shop.buyProduct(player, item);
		assertEquals(wallet.getMoney(), 200 - item.buyPrice());	
	}

	@Test
	public void moneyIncreasedTest() {
		
	}

}
