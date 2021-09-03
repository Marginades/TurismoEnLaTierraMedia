package parqueDeDiversiones;

public class PromocionAXB extends Promocion{
	private Atraccion atraccionGratis;

	public PromocionAXB(Atraccion[] atracciones, TiposDeAtracciones tipo, String nombre, Atraccion atraccionGratis) {
		super(atracciones, tipo, nombre);
		this.atraccionGratis = atraccionGratis;
	}

	@Override
	public String toString() {
		String impresion = "Pack " + this.nombre + ": comprando";
		for (int i = 0; i < atracciones.length - 1; i++) {
			impresion += atracciones[i].getNombre() + ", ";
		}
		impresion += "y " + atracciones[atracciones.length - 1].getNombre() +
				", " + this.atraccionGratis + " es gratis";
		return impresion;
	}

	@Override
	public boolean hayCupo() {
		boolean hayCupo = false;
		for (Atraccion a : atracciones) {
			if (a.hayCupo()) {
				hayCupo = true;
			}else if(atraccionGratis.hayCupo()){
				hayCupo = true;
			}else
				hayCupo = false;
		}
		return hayCupo;
	}

	@Override
	public int getPrecio() {
		int precio = 0;
		for(Atraccion a : atracciones) {
			precio += a.getPrecio();
		}
		return precio;
	}

	@Override
	public double getDuracion() {
		double duracion = 0;
		for (Atraccion a : atracciones) {
				duracion += a.getDuracion();
		}
		duracion += atraccionGratis.getDuracion();
		return duracion;
	}
}