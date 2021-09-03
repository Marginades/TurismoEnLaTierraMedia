package parqueDeDiversiones;

import java.util.LinkedList;
import java.util.List;

public class Usuario {
	private String nombre;
	private int presupuesto;
	private double disponibilidad;
	private TiposDeAtracciones preferencia;
	private List<Comprable> itinerario;

	public Usuario(String nombre, int presupuesto, double disponibilidad, 
			TiposDeAtracciones preferencia) {
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.disponibilidad = disponibilidad;
		this.preferencia = preferencia;
		this.itinerario = new LinkedList<Comprable>();
	}

	public void comprar(Comprable producto) {
		this.presupuesto -= producto.getPrecio();
		this.disponibilidad -= producto.getDuracion();
		itinerario.add(producto);
	}
}
