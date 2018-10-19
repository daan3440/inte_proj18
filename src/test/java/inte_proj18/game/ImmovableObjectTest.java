package inte_proj18.game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ImmovableObjectTest {
	static final String VALIDNAME = "#";
	ImmovableObject io;
	@BeforeEach
	void setUp() {
	io = new ImmovableObject();	
	}
	

	@Test
	void getImmovableNameTest() {
		assertEquals(io.getName(),VALIDNAME);
	}

}
