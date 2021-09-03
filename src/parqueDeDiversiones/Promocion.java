package parqueDeDiversiones;

public abstract class Promocion implements Comprable{
	protected Atraccion[] atracciones;
	protected TiposDeAtracciones tipo;
	protected String nombre;


	public Promocion(Atraccion[] atracciones, TiposDeAtracciones tipo, String nombre) {
		this.setAtracciones(atracciones);
		this.tipo = tipo;
		this.nombre = nombre;
	}

	@Override
	public boolean hayCupo() {
		boolean hayCupo = false;
		for (Atraccion a : this.atracciones) {
			if (a.hayCupo()) {
				hayCupo = true;	
			}
		}
		return hayCupo;
	}

	@Override
	public double getDuracion() {
		double duracion = 0;
		for (Atraccion a : this.atracciones) {
				duracion += a.getDuracion();	
		}
		return duracion;
	}

	public TiposDeAtracciones getTipo() {
		return this.tipo;
	}

	private Atraccion[] setAtracciones(Atraccion [] atracciones) {
		for (int i = 0; i < atracciones.length; i++) {
			if(atracciones[i].getTipo() == this.tipo) {
				atracciones[i] = this.atracciones[i];
			}else throw new Error("Las atracciones ingresadas no son del mismo tipo");
		}
		return this.atracciones;
	}
}