package parqueDeDiversiones;

import java.util.LinkedList;
import java.util.List;

public class PromocionPorcentual extends Promocion{
	private double descuento;

	public PromocionPorcentual(TipoDeAtraccion tipo, String nombre, double descuento, LinkedList<Comprable> atracciones) {
		super(tipo, atracciones, nombre);
		this.setDescuento(descuento);
	}
	
	public double getDescuento() { return this.descuento; }

	@Override
	public String toString() {
		String impresion = "Pack " + this.nombre + ": ";
		for (Comprable a : atracciones) {
			impresion += a.getNombre() + ", ";
		}
		impresion += " con un " + this.descuento + "% de descuento si se llevan ambas";
		return impresion;
	}

	@Override
	public double getCosto() {
		double precio = super.getCosto();
		double descuento = precio * this.descuento;
		return precio - descuento;
	}
	
	private void setDescuento(double descuento) {
		if(descuento <= 0 || descuento >= 1)
			throw new DescuentoInvalidoException("El descuento ingresado debe ser menor a 1 y mayor a 0");
		this.descuento = descuento;
	}
}