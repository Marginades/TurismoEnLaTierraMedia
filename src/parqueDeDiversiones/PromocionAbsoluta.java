package parqueDeDiversiones;

import java.util.LinkedList;
import java.util.List;

public class PromocionAbsoluta extends Promocion {
	private int descuento;

	public PromocionAbsoluta(TipoDeAtraccion tipo, String nombre, int descuento, LinkedList<Comprable> atracciones) {
		super(tipo, atracciones, nombre);
		this.setPrecio(descuento);
	}
	
	
	public int getDescuento() { return this.descuento; }

	@Override
	public String toString() {
		String impresion = "Pack " + this.nombre + ": llevá";
		for (Comprable a : atracciones) {
			impresion += a.getNombre() + ", ";
		}
		impresion += " a tan solo" + this.descuento;
		return impresion;
	}

	@Override
	public double getCosto() {
		double precio = super.getCosto();
		return precio - this.descuento;
	}

	private void setPrecio(int precio) {
		if (precio <= 0)
			throw new MontoInvalidoException("El monto debe ser mayor a 0");
		this.descuento = precio;
	}
}