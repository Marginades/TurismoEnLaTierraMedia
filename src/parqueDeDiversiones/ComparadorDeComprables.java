package parqueDeDiversiones;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ComparadorDeComprables implements Comparator<Comprable>{
	private TipoDeAtraccion preferencia;

	public ComparadorDeComprables(TipoDeAtraccion preferencia) {
		this.preferencia = preferencia;
	}

	@Override
	public int compare(Comprable c1, Comprable c2) {
			if(this.preferencia == c1.getTipo() && this.preferencia != c2.getTipo())
				return -1;
			else if(this.preferencia != c1.getTipo() && this.preferencia == c2.getTipo())
				return 1;
			else {
				if(c1.esPromocion() && !c2.esPromocion())
					return -1;
				else if(!c1.esPromocion() && c2.esPromocion())
					return 1;
				else {
					if (c1.getCosto() > c2.getCosto())
						return -1;
					else if(c1.getCosto() < c2.getCosto())
						return 1;
					else{
						return -1 * Double.compare(c1.getDuracion(), c2.getDuracion());
				}	
			}
		}
	}
	
	
	public static void main(String[] args) {
		Usuario norbert = new Usuario("Norbert", 20, 5.5, TipoDeAtraccion.AVENTURA);
		
		Comprable moria = new Atraccion("Moria", 10, 2, 6, TipoDeAtraccion.AVENTURA);
		Comprable minasTirith = new Atraccion("Minas Tirith", 5, 2.5, 25, TipoDeAtraccion.PAISAJE);
		Comprable laComarca = new Atraccion("La Comarca", 5, 6.5, 150, TipoDeAtraccion.DEGUSTACION);
		Comprable mordor = new Atraccion("Mordor", 25, 3, 4, TipoDeAtraccion.AVENTURA);
			
		List<Comprable> atracciones = new LinkedList<Comprable>();
		atracciones.add(moria);
		atracciones.add(minasTirith);
		atracciones.add(laComarca);
		atracciones.add(mordor);
		
		for (Comprable c : atracciones) System.out.println(c);
		
		atracciones.sort(new ComparadorDeComprables(norbert.getPreferencia()));
		
		System.out.println("\nordenar\n");
		
		for (Comprable c : atracciones) System.out.println(c);
	}
}
