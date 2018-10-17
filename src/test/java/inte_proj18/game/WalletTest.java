package inte_proj18.game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class WalletTest {

	@Test
	public void getAndSetMoneyTest() {
		Wallet wallet = new Wallet();
		wallet.setMoney(100);
		assertEquals(wallet.getMoney(), 100);
	}


}
