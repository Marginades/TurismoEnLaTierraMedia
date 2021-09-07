package parqueDeDiversiones;

import java.util.List;

public abstract class Promocion implements Comprable{
	protected List<Atraccion> atracciones;
	protected TipoDeAtraccion tipo;
	protected String nombre;

	//Constructor
	public Promocion(TipoDeAtraccion tipo, List<Atraccion> atracciones, String nombre) {
		this.tipo = tipo;
		this.nombre = nombre;
		this.atracciones = this.setAtracciones(atracciones);
	}
	
	private List<Atraccion> setAtracciones(List<Atraccion> atracciones) {
		for (Atraccion a : atracciones) {
			if(a.getTipo() != this.tipo) {
				throw new TipoInvalidoException("Una de las atracciones ingresadas no es del mismo tipo que la promcion");
			}
		}
		return atracciones;
	}
	
	protected List<Atraccion> getAtracciones() { return this.atracciones; }
	
	//Metodos Overrride de Comprable
	@Override
	public String getNombre() { return this.nombre; }
	
	@Override
	public TipoDeAtraccion getTipo() { return this.tipo; }
	
	@Override
	public int getCosto() {
		int contador = 0;
		for (Atraccion atraccion : this.atracciones) {
			contador += atraccion.getCosto();
		}
		return contador;
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
	public boolean hayCupo() {
		for (Atraccion a : this.atracciones) {
			if (!a.hayCupo()) {
				return false;	
			}
		}
		return true;
	}
	
	@Override
	public int getEntradasVendidas() { //aca hay algo raro revisar. Esto devuelve todas las entradas de cada atraccion, no solo las cubiertas por la promocion
		int entradas = 0;
		for (Atraccion atraccion : this.atracciones) {
				entradas += atraccion.getEntradasVendidas();
		}
		return entradas;
	}

	@Override
	public void comprarLugar() {
		for (Atraccion a : this.atracciones) {
			a.comprarLugar(); //este metodo ya captura la excepcion en la clase atraccion
		}
	}
}