package parqueDeDiversiones;

import java.util.List;

public class PromocionAbsoluta extends Promocion {
	private int descuento;

	public PromocionAbsoluta(TipoDeAtraccion tipo, List<Atraccion> atracciones, String nombre, int descuento) {
		super(tipo, atracciones, nombre);
		this.setPrecio(descuento);
	}
	
	public int getDescuento() { return this.descuento; }

	@Override
	public String toString() {
		String impresion = "Pack " + this.nombre + ": llev�";
		for (Atraccion a : atracciones) {
			impresion += a.getNombre() + ", ";
		}
		impresion += " a tan solo" + this.descuento;
		return impresion;
	}

	@Override //REVISAR HAY QUEHACER UNA CUENTA
	public int getCosto() {
		return this.descuento;
	}

	private void setPrecio(int precio) {
		if (precio <= 0)
			throw new MontoInvalidoException("El monto debe ser mayor a 0");
		this.descuento = precio;
	}
}