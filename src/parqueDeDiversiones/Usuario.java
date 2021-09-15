package parqueDeDiversiones;

import java.util.LinkedList;
import java.util.List;

public class Usuario {
	private String nombre;
	private int presupuesto;
	private double disponibilidad;
	private TipoDeAtraccion preferencia;
	private List<Comprable> itinerario;

	public Usuario(String nombre, int presupuesto, double disponibilidad, 
			TipoDeAtraccion preferencia) {
		this.nombre = nombre;
		this.setPresupuesto(presupuesto);;
		this.setDisponibilidad(disponibilidad);;
		this.preferencia = preferencia;
		this.itinerario = new LinkedList<Comprable>();
	}

	public void comprar(Comprable producto) {
		if(this.puedeComprar(producto) && !this.yaCompro(producto)) {
			this.presupuesto -= producto.getCosto();
			this.disponibilidad -= producto.getDuracion();
			itinerario.add(producto);
		}
	}
	
	public boolean puedeComprar(Comprable producto) {
		return this.presupuesto >= producto.getCosto() && this.disponibilidad >= producto.getDuracion();
	}
	
	public boolean yaCompro(Comprable producto) {
		return this.itinerario.contains(producto);
	}
	
	private void setPresupuesto(int presupuesto) {
		if(presupuesto < 0)
			throw new MontoInvalidoException("El presupuesto debe ser mayor a 0");
		this.presupuesto = presupuesto;
	}

	private void setDisponibilidad(double disponibilidad) {
		if(disponibilidad < 0)
			throw new DuracionInvalidaException("La disponibilidad debe ser mayor a 0");
		this.disponibilidad = disponibilidad;
	}
	
	public TipoDeAtraccion getPreferencia() {
		return this.preferencia;
	}
	
	public boolean estaEnCero() {
		return this.disponibilidad == 0 || this.presupuesto == 0;
	}
	
	@Override
	public String toString() {
		return "El usuario " + this.nombre + "tiene preferencia por: " + this.preferencia;
	}
}