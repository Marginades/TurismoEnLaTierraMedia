package parqueDeDiversiones;

import java.util.List;

public abstract class Promocion implements Comprable{
	protected List <Atraccion> atracciones;
	protected TipoDeAtraccion tipo;
	protected String nombre;

	//Constructor
	public Promocion(List<Atraccion> atracciones, TipoDeAtraccion tipo, String nombre) {
		this.setAtracciones(atracciones);
		this.tipo = tipo;
		this.nombre = nombre;
	}
	
	@Override
	public String getNombre() { return nombre; }
	
	protected List<Atraccion> getAtracciones() { return atracciones; }
	
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
	public int getEntradasVendidas() {
		int entradas = 0;
		for (Atraccion atraccion : this.atracciones) {
				entradas += atraccion.getEntradasVendidas();
		}
		return entradas;
	}

	@Override
	public int getCupoMaximo() {
		return 0;
		//el cupo de la atraccion con menos cupo maximo dentro de la promocion 
	}

	@Override
	public void comprarLugar() {
		for (Atraccion a : this.atracciones) {
			a.comprarLugar(); //este metodo ya captura la excepcion en la clase atraccion
		}
	}

	private List<Atraccion> setAtracciones(List<Atraccion> atracciones) {
		for (Atraccion a : atracciones) {
			if(a.getTipo() != tipo) {
				throw new TipoInvalidoException("Una de las atracciones ingresadas no es del mismo tipo que la promcion");
			}
			atracciones.add(a);
		}
		return this.atracciones;
	}
}