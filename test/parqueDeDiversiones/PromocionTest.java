package parqueDeDiversiones;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

public class PromocionTest {

	Comprable moria;
	Comprable minasTirith;
	Comprable laComarca;
	Comprable mordor;
	Comprable abismoDeHelm;
	Comprable lothorien;
	Comprable erebor;
	Comprable bosqueNegro;
	Comprable atraccionMalConstruida;

	LinkedList<Comprable> aventura;
	LinkedList<Comprable> degustacion;
	LinkedList<Comprable> paisaje;

	Comprable packAventura;
	Comprable packDegustacion;
	Comprable packPaisajes;

	@Before
	public void setUp() throws Exception {
		// ATRACCIONES
		moria = new Atraccion("Moria", 10, 2, 6, TipoDeAtraccion.AVENTURA);
		mordor = new Atraccion("Mordor", 25, 3, 4, TipoDeAtraccion.AVENTURA);
		bosqueNegro = new Atraccion("Bosque Negro", 3, 4, 12, TipoDeAtraccion.AVENTURA);

		erebor = new Atraccion("Erebor", 12, 3, 32, TipoDeAtraccion.PAISAJE);
		minasTirith = new Atraccion("Minas Tirith", 5, 2.5, 25, TipoDeAtraccion.PAISAJE);
		abismoDeHelm = new Atraccion("Abismo de Helm", 5, 2, 15, TipoDeAtraccion.PAISAJE);

		lothorien = new Atraccion("Lothorien", 35, 1, 30, TipoDeAtraccion.DEGUSTACION);
		laComarca = new Atraccion("La Comarca", 3, 6.5, 150, TipoDeAtraccion.DEGUSTACION);
		
		// LISTA DE ATRACCIONES
		aventura = new LinkedList<Comprable>();
		aventura.add((Atraccion) bosqueNegro);
		aventura.add((Atraccion) mordor);

		degustacion = new LinkedList<Comprable>();
		degustacion.add((Atraccion) lothorien);
		degustacion.add((Atraccion) laComarca);

		paisaje = new LinkedList<Comprable>();
		paisaje.add((Atraccion) minasTirith);
		paisaje.add((Atraccion) abismoDeHelm);
		
		//PROMOCIONES
		packAventura = new PromocionPorcentual(TipoDeAtraccion.AVENTURA, "Pack Aventura", 0.2, aventura);
		packDegustacion = new PromocionAbsoluta(TipoDeAtraccion.DEGUSTACION, "Pack Degustación", 36, degustacion);
		packPaisajes = new PromocionAXB(TipoDeAtraccion.PAISAJE, "Pack Contemplación", (Comprable) erebor, paisaje);
	}

	// Testeo de constructores
	@Test
	public void creacionGeneralTest() {
		assertNotNull(packAventura);
		assertNotNull(packDegustacion);
		assertNotNull(packPaisajes);
	}

	@Test
	public void creacionTestPromocionPorcentual() {
		assertEquals(packAventura.getTipo(), TipoDeAtraccion.AVENTURA);
		assertEquals("Pack Aventura", packAventura.getNombre());
		assertTrue(((Promocion) packAventura).getAtracciones().equals(aventura));
		assertEquals(((PromocionPorcentual) packAventura).getDescuento(), 0.2, 0);
	}

	@Test
	public void creacionTestPromocionAbsoluta() {
		assertEquals(packDegustacion.getTipo(), TipoDeAtraccion.DEGUSTACION);
		assertEquals("Pack Degustación",packDegustacion.getNombre());
		assertEquals(((Promocion) packDegustacion).getAtracciones(), degustacion);
		assertEquals(((PromocionAbsoluta) packDegustacion).getDescuento(), 36);
	}

	@Test
	public void creacionTestPromocionAXB() {
		assertEquals(packPaisajes.getTipo(), TipoDeAtraccion.PAISAJE);
		assertEquals("Pack Contemplación", packPaisajes.getNombre());
		assertEquals(((Promocion) packPaisajes).getAtracciones().size(), 3);
		assertEquals(((PromocionAXB) packPaisajes).getAtraccionGratis(), (Atraccion) erebor);
	}

	// Testeo de getCosto en los 3 tipos de promociones
	@Test
	public void getCostoTestPromocionPorcentual() {
		assertEquals(22.4, packAventura.getCosto(), 0);
	}

	@Test
	public void getCostoTestPromocionAbsoluta() {
		assertEquals(2, packDegustacion.getCosto(), 0);
	}

	@Test
	public void getCostoTestPromocionAXB() {
		assertEquals(10, packPaisajes.getCosto(), 0);
	}

	// Testeo de getCosto en los 3 tipos de promociones
	@Test
	public void getDuracioTestPromocionPorcentual() {
		assertEquals(7, packAventura.getDuracion(), 0);
	}

	@Test
	public void getDuracioTestPromocionAbsoluta() {
		assertEquals(7.5, packDegustacion.getDuracion(), 0);
	}

	@Test
	public void getDuracioTestPromocionAXB() {
		assertEquals(7.5, packPaisajes.getDuracion(), 0);
	}

	// Testeo de hayCupo en los 3 tipos de promociones
	@Test
	public void hayCupoTestPromocionPorcentual() {
		assertTrue(packAventura.hayCupo());
	}

	@Test
	public void hayCupoTestPromocionAbsoluta() {
		assertTrue(packDegustacion.hayCupo());
	}

	@Test
	public void hayCupoTestPromocionAXB() {
		assertTrue(packPaisajes.hayCupo());
	}

	// Testeo de comprarLugar en los 3 tipos de promociones
	@Test
	public void comprarLugarTestPromocionPorcentual() {
		packAventura.comprarLugar();
		assertEquals(1, mordor.getEntradasVendidas());
		assertEquals(1, bosqueNegro.getEntradasVendidas());
		assertEquals(0, laComarca.getEntradasVendidas());
	}

	@Test
	public void comprarLugarTestPromocionAbsoluta() {
		packDegustacion.comprarLugar();
		assertEquals(0, bosqueNegro.getEntradasVendidas());
		assertEquals(1, laComarca.getEntradasVendidas());
		assertEquals(1, lothorien.getEntradasVendidas());
	}

	@Test
	public void comprarLugarTestPromocionAXB() {
		packPaisajes.comprarLugar();
		assertEquals(0, bosqueNegro.getEntradasVendidas());
		assertEquals(1, minasTirith.getEntradasVendidas());
		assertEquals(1, abismoDeHelm.getEntradasVendidas());
		assertEquals(1, erebor.getEntradasVendidas());
	}
	
	@Test
	public void esOContienePromocion_siContiene() {
		assertTrue(packAventura.esOContiene(mordor));
	}
	@Test
	public void esOContienePromocion_noContiene() {
		assertFalse(packAventura.esOContiene(lothorien));
	}
	
	@Test
	public void esOContienePromocionAXB_siContiene() {
		assertTrue(packPaisajes.esOContiene(abismoDeHelm));
		assertTrue(packPaisajes.esOContiene(erebor));
	}
	@Test
	public void esOContienePromocionAXB_noContiene() {
		assertFalse(packPaisajes.esOContiene(mordor));
	}

}
