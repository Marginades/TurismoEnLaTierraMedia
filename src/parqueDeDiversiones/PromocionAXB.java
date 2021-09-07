package parqueDeDiversiones;

import java.util.List;

public class PromocionAXB extends Promocion{
	private Atraccion atraccionGratis;

	public PromocionAXB(List<Atraccion> atracciones, TipoDeAtraccion tipo, String nombre, Atraccion atraccionGratis) {
		super(atracciones, tipo, nombre);
		this.setAtraccionGratis(atraccionGratis);
	}

	@Override
	public String toString() {
		String impresion = "Pack " + this.nombre + ": comprando";
		for (Atraccion a : atracciones) {
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
	public int getCosto() {
		int precio = 0;
		for(Atraccion a : atracciones) {
			precio += a.getCosto();
		}
		return precio;
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