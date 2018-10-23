package inte_proj18.game;

public class Shop {

	public void buyProduct(Player player, Item item) {
		if (player.getWallet().getMoney() >= item.buyPrice()) {
			player.getInventory().addItemToInventory(item);
			player.getWallet().setMoney(player.getWallet().getMoney() - item.buyPrice());
		}
	}

	public void sellProduct(Player player, Item item) {
		if (player.getInventory().getItemsInInventory().containsKey(item)) {
			player.getInventory().removeItemFromInventory(item);
			player.getWallet().setMoney(player.getWallet().getMoney() + item.sellPrice());
		}
	}

}
