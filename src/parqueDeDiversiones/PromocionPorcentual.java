package parqueDeDiversiones;

import java.util.List;

public class PromocionPorcentual extends Promocion{
	private double descuento;

	public PromocionPorcentual(List<Atraccion> atracciones, TiposDeAtracciones tipo, String nombre, double descuento) {
		super(atracciones, tipo, nombre);
		this.setDescuento(descuento);
	}

	@Override
	public String toString() {
		String impresion = "Pack " + this.nombre + ": ";
		for (Atraccion a : atracciones) {
			impresion += a.getNombre() + ", ";
		}
		impresion += " con un " + this.descuento + "% de descuento si se llevan ambas";
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
	
	private void setDescuento(double descuento) {
		if(descuento <= 0 || descuento >= 1)
			throw new DescuentoInvalidoException("El descuento ingresado debe ser menor a 1 y mayor a 0");
		this.descuento = descuento;
	}
}