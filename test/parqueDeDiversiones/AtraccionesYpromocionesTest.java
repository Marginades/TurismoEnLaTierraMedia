package parqueDeDiversiones;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AtraccionesYpromocionesTest {
	Comprable moria;
	Comprable minasTirith;
	Comprable laComarca;
	Comprable mordor;
	Comprable abismoDeHelm;
	Comprable lothorien;
	Comprable erebor;
	Comprable bosqueNegro;
	
	@Before
	public void setUp() {
		moria = new Atraccion("Moria", 10, 2, 6, TiposDeAtracciones.AVENTURA);
		minasTirith = new Atraccion("Minas Tirith", 5, 2.5, 25, TiposDeAtracciones.PAISAJE);
		laComarca = new Atraccion("La Comarca", 3, 6.5, 150, TiposDeAtracciones.DEGUSTACION);
		mordor = new Atraccion("Mordor", 25, 3, 4, TiposDeAtracciones.AVENTURA);
		abismoDeHelm = new Atraccion("Abismo de Helm", 5, 2, 15, TiposDeAtracciones.PAISAJE);
		lothorien = new Atraccion("Lothorien", 12, 1, 30, TiposDeAtracciones.DEGUSTACION);
		erebor = new Atraccion("Erebor", 12, 3, 32, TiposDeAtracciones.PAISAJE);
		bosqueNegro = new Atraccion("Bosque Negro", 3, 4, 12, TiposDeAtracciones.AVENTURA);
	}
	
	@Test
	public void test() {		
	}

}
