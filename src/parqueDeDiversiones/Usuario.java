package parqueDeDiversiones;

import java.util.LinkedList;
import java.util.List;

public class Usuario {
	private String nombre;
	private double presupuesto;
	private double disponibilidad;
	private TipoDeAtraccion preferencia;
	private List<Comprable> itinerario;

	public Usuario(String nombre, double presupuesto, double disponibilidad, TipoDeAtraccion preferencia) {
		this.nombre = nombre;
		this.setPresupuesto(presupuesto);
		this.setDisponibilidad(disponibilidad);
		this.preferencia = preferencia;
		this.itinerario = new LinkedList<Comprable>();
	}

	public void comprar(Comprable producto) {
		if (this.puedeComprar(producto)) {
			this.presupuesto -= producto.getCosto();
			this.disponibilidad -= producto.getDuracion();
			producto.comprarLugar();
			this.agregarAlItinerario(producto);
		}
	}

	private void agregarAlItinerario(Comprable producto) {
		if (producto.esPromocion()) {
			this.itinerario.addAll(((Promocion) producto).getAtracciones());
		} else if (!producto.esPromocion()){
			this.itinerario.add(producto);
		}
	}

	public boolean puedeComprar(Comprable producto) {
		return this.presupuesto >= producto.getCosto() && this.disponibilidad >= producto.getDuracion()
				&& !this.yaCompro(producto);
	}

	public boolean yaCompro(Comprable producto) {
		boolean contiene = false;
		if (producto.esPromocion()) {
			for (Comprable atraccion : ((Promocion) producto).getAtracciones()) {
				if (this.itinerario.contains(atraccion)) {
					contiene = true;
				}
			}

		} else if (!producto.esPromocion()) {
			contiene = this.itinerario.contains(producto);
		}
		return contiene;
	}

	private void setPresupuesto(double presupuesto2) {
		if (presupuesto2 < 0)
			throw new MontoInvalidoException("El presupuesto debe ser mayor a 0");
		this.presupuesto = presupuesto2;
	}

	private void setDisponibilidad(double disponibilidad) {
		if (disponibilidad < 0)
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
		
		String impresion = "Itinerario de " + this.nombre;
		for(Comprable p : itinerario) {
			impresion += p.getNombre();
		}
		return impresion;
	}

	protected double getPresupuesto() {
		return presupuesto;
	}

	protected double getDisponibilidad() {
		return disponibilidad;
	}

	protected List<Comprable> getItinerario() {
		return itinerario;
	}
	
	public String getNombre(){
		return nombre;
	}

}
