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
		
		LinkedList<Comprable> degustacion = new LinkedList<Comprable>();
		degustacion.add((Comprable) lothorien);
		degustacion.add((Comprable) laComarca);
		
		LinkedList<Comprable> paisaje = new LinkedList<Comprable>();
		paisaje.add((Comprable) minasTirith);
		paisaje.add((Comprable) abismoDeHelm);
		
		//agregar otro pack degustacion
		
		Comprable packDegustacion = new PromocionAbsoluta(TipoDeAtraccion.DEGUSTACION, "Pack Degustación", 36, degustacion);
		Comprable packPaisajes = new PromocionAXB(TipoDeAtraccion.PAISAJE, "Pack Contemplación",(Comprable) erebor, paisaje);
		
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
