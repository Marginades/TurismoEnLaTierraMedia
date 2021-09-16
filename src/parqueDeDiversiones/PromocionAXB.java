package parqueDeDiversiones;

import java.util.LinkedList;
import java.util.List;

public class PromocionAXB extends Promocion {
	private Comprable atraccionGratis;

	public PromocionAXB(TipoDeAtraccion tipo, String nombre, Comprable atraccionGratis,
			LinkedList<Comprable> atracciones) {
		super(tipo, atracciones, nombre);
		this.setAtraccionGratis(atraccionGratis);
	}

	public Comprable getAtraccionGratis() {
		return this.atraccionGratis;
	}
	
	@Override
	protected List<Comprable> getAtracciones() {
		LinkedList<Comprable> atraccionesTotales = new LinkedList<Comprable>();
		atraccionesTotales.addAll(this.atracciones);
		atraccionesTotales.add(this.getAtraccionGratis());
		return atraccionesTotales;
	}

	@Override
	public String toString() {
		String impresion = "Pack " + this.nombre + ", comprando:\n";
		for (Comprable a : atracciones) {
			impresion += a.getNombre() + "\n";
		}
		impresion += this.atraccionGratis.getNombre() + " es gratis\nTotal: " + this.getCosto();
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
		if (!(this.getTipo() == atraccionGratis.getTipo()))
			throw new TipoInvalidoException("La atraccion debe ser del mismo tipo que la promoción");
		this.atraccionGratis = atraccionGratis;
	}

	@Override
	public boolean esOContiene(Comprable atraccion) {
		if (!atraccion.equals(this.atraccionGratis)) {

			for (Comprable a : this.atracciones) {
				if (atraccion.equals(a)) {
					return true;
				}
			}

			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean esComprablePor(Usuario user) {
		return false;
	}

	@Override
	public void comprarLugar() {
		for (Comprable a : this.atracciones) {
			a.comprarLugar();
		}
		this.atraccionGratis.comprarLugar();
	}

	@Override
	public int getEntradasVendidas() {
		int entradas = 0;
		for (Comprable atraccion : this.atracciones) {
			entradas += atraccion.getEntradasVendidas();
		}
		return entradas + atraccionGratis.getEntradasVendidas();
	}
}
