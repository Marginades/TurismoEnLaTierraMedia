package parqueDeDiversiones;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ParaIgnaTest {
	Usuario u1;
	Atraccion a1, a2, a3, a4;
	Promocion p1, p2, p3, p4;

	LinkedList<Comprable> l1, l2, l3;

	@Before
	public void setUp() throws Exception {
		u1 = new Usuario("Pepito", 100, 100, TipoDeAtraccion.AVENTURA);

		a1 = new Atraccion("a1", 10, 3, 6, TipoDeAtraccion.AVENTURA);
		a2 = new Atraccion("a2", 4, 2.5, 25, TipoDeAtraccion.AVENTURA);
		a3 = new Atraccion("a3", 2, 1, 150, TipoDeAtraccion.AVENTURA);
		a4 = new Atraccion("a4", 8, 4, 4, TipoDeAtraccion.AVENTURA);

		l1 = new LinkedList<Comprable>();
		l1.add(a1);
		l1.add(a2);

		l2 = new LinkedList<Comprable>();
		l2.add(a1);
		l2.add(a3);

		l3 = new LinkedList<Comprable>();
		l3.add(a2);
		l3.add(a4);

		p1 = new PromocionAbsoluta(TipoDeAtraccion.AVENTURA, "", 10, l1);
		p2 = new PromocionPorcentual(TipoDeAtraccion.AVENTURA, "", 0.3, l2);
		p3 = new PromocionAXB(TipoDeAtraccion.AVENTURA, "", a2, l2);
		p4 = new PromocionAbsoluta(TipoDeAtraccion.AVENTURA, "", 5, l3);
	}
	
	@Test
	public void testInicialComprarAtraccion() {
		u1.comprar(a1);
		assertEquals(1, a1.getEntradasVendidas());
		assertEquals(90, u1.getPresupuesto(), 0);
		assertEquals(97, u1.getDisponibilidad(), 0);
		assertEquals(1, u1.getItinerario().size());
		assertEquals(a1, u1.getItinerario().get(0));
	}
	
	@Test
	public void testInicialComprarPromocionAbsoluta() {
		u1.comprar(p1);
		assertEquals(1, a1.getEntradasVendidas());
		assertEquals(1, a2.getEntradasVendidas());
		assertEquals(0, a3.getEntradasVendidas());
		
		assertEquals(96, u1.getPresupuesto(), 0);
		assertEquals(94.5, u1.getDisponibilidad(), 0);
		
		assertEquals(2, u1.getItinerario().size());
		assertEquals(a1, u1.getItinerario().get(0));
		assertEquals(a2, u1.getItinerario().get(1));
	}
	
	@Test
	public void testInicialComprarPromocionPorcentual() {
		u1.comprar(p2);
		assertEquals(1, a1.getEntradasVendidas());
		assertEquals(0, a2.getEntradasVendidas());
		assertEquals(1, a3.getEntradasVendidas());
		
		assertEquals(91.6, u1.getPresupuesto(), 0);
		assertEquals(96, u1.getDisponibilidad(), 0);
		
		assertEquals(2, u1.getItinerario().size());
		assertEquals(a1, u1.getItinerario().get(0));
		assertEquals(a3, u1.getItinerario().get(1));
	}
	
	@Test
	public void testInicialComprarPromocionAXB() {
		u1.comprar(p3);
		assertEquals(1, a1.getEntradasVendidas());
		assertEquals(1, a2.getEntradasVendidas());
		assertEquals(1, a3.getEntradasVendidas());
		assertEquals(0, a4.getEntradasVendidas());
		
		assertEquals(88, u1.getPresupuesto(), 0);
		assertEquals(93.5, u1.getDisponibilidad(), 0);
				
		assertEquals(3, u1.getItinerario().size());
		assertEquals(a1, u1.getItinerario().get(0));
		assertEquals(a3, u1.getItinerario().get(1));
		assertEquals(a2, u1.getItinerario().get(2));
	}

	@Test
	public void testParaIgna1() {
		// Test nro1
		//Si compra a1 no deberia poder comprar p2 porque incluye a1.
		u1.comprar(a1);
		assertTrue(u1.yaCompro(a1));
		assertFalse(u1.puedeComprar(p2));
	}
	
	@Test
	public void testParaIgna2() {
		// Test nro2
		u1.comprar(p1);
		assertTrue(u1.yaCompro(a1));
		assertTrue(u1.yaCompro(a2));
		assertFalse(u1.puedeComprar(a2));
	}
	
	@Test
	public void testParaIgna3() {
		// Test nro3
		u1.comprar(p1);
		assertFalse(u1.puedeComprar(p2));     
	}
	
	@Test
	public void testParaIgna4() {
		// Test nro4
		u1.comprar(p3);
		assertFalse(u1.puedeComprar(p4));
	}

}
