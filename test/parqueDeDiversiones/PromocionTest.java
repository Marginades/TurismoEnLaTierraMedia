package parqueDeDiversiones;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.LinkedList;
import java.util.List;

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
	
	List<Atraccion> aventura;
	List<Atraccion> degustacion;
	List<Atraccion> paisaje;
	
	Comprable packAventura;
	Comprable packDegustacion;
	Comprable packPaisajes;
	
	
	@Before
	public void setUp() throws Exception {
		//ATRACCIONES
		moria = new Atraccion("Moria", 10, 2, 6, TipoDeAtraccion.AVENTURA);
		minasTirith = new Atraccion("Minas Tirith", 5, 2.5, 25, TipoDeAtraccion.PAISAJE);
		laComarca = new Atraccion("La Comarca", 3, 6.5, 150, TipoDeAtraccion.DEGUSTACION);
		mordor = new Atraccion("Mordor", 25, 3, 4, TipoDeAtraccion.AVENTURA);
		abismoDeHelm = new Atraccion("Abismo de Helm", 5, 2, 15, TipoDeAtraccion.PAISAJE);
		lothorien = new Atraccion("Lothorien", 12, 1, 30, TipoDeAtraccion.DEGUSTACION);
		erebor = new Atraccion("Erebor", 12, 3, 32, TipoDeAtraccion.PAISAJE);
		bosqueNegro = new Atraccion("Bosque Negro", 3, 4, 12, TipoDeAtraccion.AVENTURA);
		
		//LISTA DE ATRACCIONES
		aventura = new LinkedList<Atraccion>();
		aventura.add((Atraccion) bosqueNegro);
		aventura.add((Atraccion) mordor);
		
		degustacion = new LinkedList<Atraccion>();
		degustacion.add((Atraccion) lothorien);
		degustacion.add((Atraccion) laComarca);
		
		paisaje = new LinkedList<Atraccion>();
		paisaje.add((Atraccion) minasTirith);
		paisaje.add((Atraccion) abismoDeHelm);
		
		//PROMOCIONES
		packAventura = new PromocionPorcentual(aventura, TipoDeAtraccion.AVENTURA, "", 0.2);
		packDegustacion = new PromocionAbsoluta(degustacion, TipoDeAtraccion.DEGUSTACION, "", 36);
		packPaisajes = new PromocionAXB(paisaje, TipoDeAtraccion.PAISAJE, "", (Atraccion) erebor);
	}

	@Test
	public void creacionGeneralTest() {
		assertNotNull(packAventura);
		assertNotNull(packDegustacion);
		assertNotNull(packPaisajes);
	}
	
	@Test
	public void creacionTestPromocionPorcentual() {
		fail("Not yet implemented");
	}
	
	@Test
	public void creacionTestPromocionAbsoluta() {
		fail("Not yet implemented");
	}
	
	@Test
	public void creacionTestPromocionAXB() {
		fail("Not yet implemented");
	}

}
