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
		this.setPresupuesto(presupuesto);;
		this.setDisponibilidad(disponibilidad);;
		this.preferencia = preferencia;
		this.itinerario = new LinkedList<Comprable>();
	}

	public void comprar(Comprable producto) {
		this.presupuesto -= producto.getPrecio();
		this.disponibilidad -= producto.getDuracion();
		itinerario.add(producto);
	}
	//no tendrá que devolver un booleano?

	private void setPresupuesto(int presupuesto) {
		if(presupuesto <= 0)
			throw new MontoInvalidoException("El presupuesto debe ser mayor a 0");
		this.presupuesto = presupuesto;
	}

	private void setDisponibilidad(double disponibilidad) {
		if(disponibilidad <= 0)
			throw new TiempoInvalidoException("La disponibilidad debe ser mayor a 0");
		this.disponibilidad = disponibilidad;
	}
}
