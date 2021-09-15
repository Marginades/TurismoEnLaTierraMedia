package parqueDeDiversiones;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AtraccionesTest {
	Comprable moria;
	Comprable minasTirith;
	Comprable laComarca;
	Comprable mordor;
	Comprable abismoDeHelm;
	Comprable lothorien;
	Comprable erebor;
	Comprable bosqueNegro;
	Comprable atraccionMalConstruida;

	@Before
	public void setUp() throws Exception {
		moria = new Atraccion("Moria", 10, 2, 6, TipoDeAtraccion.AVENTURA);
		minasTirith = new Atraccion("Minas Tirith", 5, 2.5, 25, TipoDeAtraccion.PAISAJE);
		laComarca = new Atraccion("La Comarca", 3, 6.5, 150, TipoDeAtraccion.DEGUSTACION);
		mordor = new Atraccion("Mordor", 25, 3, 4, TipoDeAtraccion.AVENTURA);
		abismoDeHelm = new Atraccion("Abismo de Helm", 5, 2, 15, TipoDeAtraccion.PAISAJE);
		lothorien = new Atraccion("Lothorien", 12, 1, 30, TipoDeAtraccion.DEGUSTACION);
		erebor = new Atraccion("Erebor", 12, 3, 32, TipoDeAtraccion.PAISAJE);
		bosqueNegro = new Atraccion("Bosque Negro", 3, 4, 12, TipoDeAtraccion.AVENTURA);
	}

	// Constructor
	@Test
	public void CreacionTest() {
		assertNotNull(abismoDeHelm);
		assertEquals(moria.getNombre(), "Moria");
		assertEquals(moria.getCosto(), 10, 0);
		assertEquals(moria.getDuracion(), 2, 0);
		assertEquals(((Atraccion) moria).getCupoMaximo(), 6);
		assertEquals(moria.getTipo(), TipoDeAtraccion.AVENTURA);
	}

	// Excepciones en la construccion
	@Test(expected = MontoInvalidoException.class)
	public void ExcepcionesCostoInvalidoTest() {
		atraccionMalConstruida = new Atraccion("Una", -5, 4, 12, TipoDeAtraccion.AVENTURA);
	}

	@Test(expected = DuracionInvalidaException.class)
	public void ExcepcionesDuracionInvalidaTest() {
		atraccionMalConstruida = new Atraccion("Una", 5, 0, 12, TipoDeAtraccion.AVENTURA);
	}

	@Test(expected = CupoMaximoInvalidoException.class)
	public void ExcepcionesCupoMaximoInvalidoTest() {
		atraccionMalConstruida = new Atraccion("Una", 5, 5, 0, TipoDeAtraccion.AVENTURA);
	}

	// Pruebas de cupo
	@Test
	public void hayCupoTest() {
		assertTrue(moria.hayCupo());
	}

	@Test
	public void hayCupoLimiteTest() {
		moria.comprarLugar();
		moria.comprarLugar();
		moria.comprarLugar();
		moria.comprarLugar();
		moria.comprarLugar();
		moria.comprarLugar();
		assertFalse(moria.hayCupo());
	}

	@Test(expected = CupoMaximoAlcanzadoException.class)
	public void ComprarLugaresDeMasTest() {
		moria.comprarLugar();
		moria.comprarLugar();
		moria.comprarLugar();
		moria.comprarLugar();
		moria.comprarLugar();
		moria.comprarLugar();
		assertEquals(moria.getEntradasVendidas(), 6);
		moria.comprarLugar();
	}

}
