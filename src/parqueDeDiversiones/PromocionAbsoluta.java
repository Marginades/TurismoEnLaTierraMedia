package parqueDeDiversiones;

import java.util.List;

public class PromocionAbsoluta extends Promocion {
	private int precio;

	public PromocionAbsoluta(List<Atraccion> atracciones, TipoDeAtraccion tipo, String nombre, int precio) {
		super(atracciones, tipo, nombre);
		this.setPrecio(precio);
	}

	@Override
	public String toString() {
		String impresion = "Pack " + this.nombre + ": llevá";
		for (Atraccion a : atracciones) {
			impresion += a.getNombre() + ", ";
		}
		impresion += " a tan solo" + this.precio;
		return impresion;
	}

	@Override
	public int getCosto() {
		return this.precio;
	}

	private void setPrecio(int precio) {
		if (precio <= 0)
			throw new MontoInvalidoException("El monto debe ser mayor a 0");
		this.precio = precio;
	}
}