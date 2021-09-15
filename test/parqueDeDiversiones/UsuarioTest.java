package parqueDeDiversiones;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UsuarioTest {
	
	Usuario user;

	@Before
	public void setUp() throws Exception {
		user = new Usuario("Jorge", 0, 0, TipoDeAtraccion.AVENTURA);
	}

	@Test
	public void testEstaEnCero() {
		assertTrue(user.estaEnCero());
	}

}
