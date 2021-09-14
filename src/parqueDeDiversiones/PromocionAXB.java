package parqueDeDiversiones;

import java.util.LinkedList;
import java.util.List;

public class PromocionAXB extends Promocion{
	private Comprable atraccionGratis;

	public PromocionAXB(TipoDeAtraccion tipo, String nombre, Comprable atraccionGratis, LinkedList<Comprable> atracciones) {
		super(tipo, atracciones, nombre);
		this.setAtraccionGratis(atraccionGratis);
	}

	public Comprable getAtraccionGratis() { return this.atraccionGratis; }

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

	private void setAtraccionGratis(Comprable atraccionGratis) {
		if(!(this.getTipo() == atraccionGratis.getTipo()))
			throw new TipoInvalidoException("La atraccion debe ser del mismo tipo que la promoción");
		this.atraccionGratis = atraccionGratis;
	}
	
	@Override
	public boolean esOContiene(Comprable c) {
		return super.esOContiene(c) && this.atraccionGratis.equals(c);
	}


	@Override
	public boolean esComprablePor(Usuario user) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public void comprarLugar() {
		for (Comprable a : this.atracciones) {
			a.comprarLugar(); 
		}
		this.atraccionGratis.comprarLugar();
	}
}