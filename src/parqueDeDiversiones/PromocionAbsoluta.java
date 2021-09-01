package parqueDeDiversiones;

public class PromocionAbsoluta extends Promocion {
	private int precio;

	public PromocionAbsoluta(Atraccion[] atracciones, TiposDeAtracciones tipo, String nombre, int precio) {
		super(atracciones, tipo, nombre);
		this.precio = precio;
	}

	@Override
	public String toString() {
		String impresion = "Pack " + this.nombre + ": llevá";
		for (int i = 0; i < atracciones.length - 1; i++) {
			impresion += atracciones[i].getNombre() + ", ";
		}
		impresion += "y " + atracciones[atracciones.length - 1].getNombre() +
				" a tan solo" + this.precio;
		return impresion;
	}

	@Override
	public int getPrecio() {
		return this.precio;
	}
}