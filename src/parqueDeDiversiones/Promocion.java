package parqueDeDiversiones;

import java.util.List;

public abstract class Promocion implements Comprable {
	protected List<Comprable> atracciones;
	protected TipoDeAtraccion tipo;
	protected String nombre;

	// Constructor
	public Promocion(TipoDeAtraccion tipo, List<Comprable> atracciones, String nombre) {
		this.tipo = tipo;
		this.nombre = nombre;
		this.atracciones = this.setAtracciones(atracciones);
	}

	private List<Comprable> setAtracciones(List<Comprable> atracciones) {
		for (Comprable a : atracciones) {
			if (a.getTipo() != this.tipo) {
				throw new TipoInvalidoException(
						"Una de las atracciones ingresadas no es del mismo tipo que la promcion");
			}
		}
		return atracciones;
	}

	protected List<Comprable> getAtracciones() {
		return this.atracciones;
	}

	// Metodos Overrride de Comprable
	@Override
	public String getNombre() {
		return this.nombre;
	}

	@Override
	public TipoDeAtraccion getTipo() {
		return this.tipo;
	}

	@Override
	public double getCosto() {
		int contador = 0;
		for (Comprable atraccion : this.atracciones) {
			contador += atraccion.getCosto();
		}
		return contador;
	}

	@Override
	public double getDuracion() {
		double duracion = 0;
		for (Comprable a : this.atracciones) {
			duracion += a.getDuracion();
		}
		return duracion;
	}

	@Override
	public boolean hayCupo() {
		for (Comprable a : this.atracciones) {
			if (!a.hayCupo()) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int getEntradasVendidas() { 
		int entradas = 0;
		for (Comprable atraccion : this.atracciones) {
			entradas += atraccion.getEntradasVendidas();
		}
		return entradas;
	}

	@Override
	public void comprarLugar() {
		for (Comprable a : this.atracciones) {
			a.comprarLugar(); // este metodo ya captura la excepcion en la clase atraccion
		}
	}

	public boolean esPromocion() {
		return true;
	}

	@Override
	public boolean esOContiene(Comprable atraccion) {
		for (Comprable a : this.atracciones) {
			if (atraccion.equals(a)) {
				return true;
			}
		}

		return false;
	}
	
	//Imprimir
	@Override
	public String toString() {
		return "Llevá " + this.getNombre() + " por " + this.getCosto() + " monedas de oro \n Responde si o no";
	}
}