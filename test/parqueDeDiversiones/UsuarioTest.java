package parqueDeDiversiones;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UsuarioTest {
	
	Usuario userEn0;

	@Before
	public void setUp() throws Exception {
		userEn0 = new Usuario("Pepito", 0, 0, TipoDeAtraccion.AVENTURA);
	}

	@Test
	public void testEstaEnCero() {
		assertTrue(userEn0.estaEnCero());
	}
	
}
