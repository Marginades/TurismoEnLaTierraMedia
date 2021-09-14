package parqueDeDiversiones;

import java.util.LinkedList;
import java.util.List;

public class PromocionAXB extends Promocion{
	private Atraccion atraccionGratis;

	public PromocionAXB(TipoDeAtraccion tipo, String nombre, Atraccion atraccionGratis, LinkedList<Comprable> atracciones) {
		super(tipo, atracciones, nombre);
		this.setAtraccionGratis(atraccionGratis);
	}
	
	public Atraccion getAtraccionGratis() { return this.atraccionGratis; }

	@Override
	public String toString() {
		String impresion = "Pack " + this.nombre + ": comprando";
		for (Comprable a : atracciones) {
			impresion += a.getNombre() + ", ";
		}
		impresion += this.atraccionGratis + " es gratis";
		return impresion;
	}

	@Override
	public boolean hayCupo() {
		return super.hayCupo() && atraccionGratis.hayCupo();
	}

	@Override
	public double getCosto() {
		return super.getCosto();
	}

	@Override
	public double getDuracion() {
		return super.getDuracion() + atraccionGratis.getDuracion();
	}

	private void setAtraccionGratis(Atraccion atraccionGratis) {
		if(!(this.getTipo() == atraccionGratis.getTipo()))
			throw new TipoInvalidoException("La atraccion debe ser del mismo tipo que la promoción");
		this.atraccionGratis = atraccionGratis;
	}
	
	
}