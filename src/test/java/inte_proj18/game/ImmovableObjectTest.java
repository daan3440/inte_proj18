<<<<<<< HEAD
package inte_proj18.game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ImmovableObjectTest {
	static final String VALIDNAME = "ImmovableObject";
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
=======
package inte_proj18.game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ImmovableObjectTest {
	static final String VALIDNAME = "ImmovableO";
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
>>>>>>> refs/remotes/origin/grupp_branch
