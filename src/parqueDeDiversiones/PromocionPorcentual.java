package parqueDeDiversiones;

public class PromocionPorcentual extends Promocion{
	private double descuento;

	public PromocionPorcentual(Atraccion[] atracciones, TiposDeAtracciones tipo, String nombre, double descuento) {
		super(atracciones, tipo, nombre);
		this.descuento = descuento;
	}

	@Override
	public String toString() {
		String impresion = "Pack " + this.nombre + ": ";
		for (int i = 0; i < atracciones.length - 1; i++) {
			impresion += atracciones[i].getNombre() + ", ";
		}
		impresion += "y " + atracciones[atracciones.length - 1].getNombre() +
				" con un " + this.descuento + "% de descuento si se llevan ambas";
		return impresion;
	}

	@Override
	public int getPrecio() {
		int precio = 0;
		for(Atraccion a : atracciones) {
			precio += a.getPrecio();
		}
		precio -= Math.round(precio * this.descuento);
		return precio;
	}
}