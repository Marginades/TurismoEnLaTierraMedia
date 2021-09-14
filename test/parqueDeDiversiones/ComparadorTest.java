package parqueDeDiversiones;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ComparadorTest {
	List <Comprable> productos = new LinkedList<Comprable>();
	Usuario norbert;
	
	@Before
	public void setUp() {
		norbert = new Usuario("Norbert", 20, 5.5, TipoDeAtraccion.DEGUSTACION);
		
		Comprable moria = new Atraccion("Moria", 10, 2, 6, TipoDeAtraccion.AVENTURA);
		Comprable minasTirith = new Atraccion("Minas Tirith", 5, 2.5, 25, TipoDeAtraccion.PAISAJE);
		Comprable laComarca = new Atraccion("La Comarca", 5, 6.5, 150, TipoDeAtraccion.DEGUSTACION);
		Comprable erebor = new Atraccion("Erebor", 12, 3, 32, TipoDeAtraccion.PAISAJE);
		Comprable abismoDeHelm = new Atraccion("Abismo de Helm", 5, 2, 15, TipoDeAtraccion.PAISAJE);
		Comprable lothorien = new Atraccion("Lothorien", 35, 1, 30, TipoDeAtraccion.DEGUSTACION);
		
		List<Atraccion> degustacion = new LinkedList<Atraccion>();
		degustacion.add((Atraccion) lothorien);
		degustacion.add((Atraccion) laComarca);
		
		List<Atraccion> paisaje = new LinkedList<Atraccion>();
		paisaje.add((Atraccion) minasTirith);
		paisaje.add((Atraccion) abismoDeHelm);
		
		//agregar otro pack degustacion
		
		Comprable packDegustacion = new PromocionAbsoluta(TipoDeAtraccion.DEGUSTACION, degustacion, "Pack Degustación", 36);
		Comprable packPaisajes = new PromocionAXB(TipoDeAtraccion.PAISAJE, paisaje, "Pack Contemplación", (Atraccion) erebor);
		
		productos.add(moria);
		productos.add(minasTirith);
		productos.add(laComarca);
		productos.add(erebor);
		productos.add(abismoDeHelm);
		productos.add(lothorien);
		productos.add(packDegustacion);
		productos.add(packPaisajes);
	}
	
	@Test
	public void test() {
		for(Comprable p : productos) System.out.println(p);
		productos.sort(new ComparadorDeComprables(norbert.getPreferencia()));
		System.out.println("\nordenar\n");
		for(Comprable p : productos) System.out.println(p);
	}

}
