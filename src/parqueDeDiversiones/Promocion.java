package parqueDeDiversiones;

import java.util.List;

public abstract class Promocion implements Comprable{
	protected List <Atraccion> atracciones;
	protected TipoDeAtraccion tipo;
	protected String nombre;


	protected List<Atraccion> getAtracciones() {
		return atracciones;
	}

	protected String getNombre() {
		return nombre;
	}

	public Promocion(List<Atraccion> atracciones, TipoDeAtraccion tipo, String nombre) {
		this.setAtracciones(atracciones);
		this.tipo = tipo;
		this.nombre = nombre;
	}

	@Override
	public boolean hayCupo() {
		for (Atraccion a : this.atracciones) {
			if (!a.hayCupo()) {
				return false;	
			}
		}
		return true;
	}

	@Override
	public double getDuracion() {
		double duracion = 0;
		for (Atraccion a : this.atracciones) {
				duracion += a.getDuracion();	
		}
		return duracion;
	}

	@Override
	public TipoDeAtraccion getTipo() {
		return this.tipo;
	}

	private List<Atraccion> setAtracciones(List<Atraccion> atracciones) {
		for (Atraccion a : atracciones) {
			if(a.getTipo() == this.tipo) {
				atracciones.add(a);
			}else throw new TipoInvalidoException("Una de las atracciones ingresadas no es del mismo tipo que la promcion");
		}
		return this.atracciones;
	}
}