package inte_proj18.game;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PositionTest {
	
	@Test
	void createPostionTest() {
		Position pos1 = new Position(1,1);
		assertNotNull(pos1);
	}

}
