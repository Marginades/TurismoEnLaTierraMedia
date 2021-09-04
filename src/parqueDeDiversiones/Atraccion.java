package parqueDeDiversiones;

public class Atraccion implements Comprable{

	private String nombre = "";
	private int costo;
	private double duracion;
	private int entradasVendidas = 0;
	private int cupoMaximo;
	private TiposDeAtracciones tipo;


	public Atraccion(String nombre, int costo, double duracion, int cupoMaximo,
			TiposDeAtracciones tipo) {
		this.nombre = nombre;
		this.setCosto(costo);
		this.setDuracion(duracion);
		this.setCupoMaximo(cupoMaximo);
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public boolean hayCupo() {
		return this.entradasVendidas < this.cupoMaximo;
	}

	@Override
	public int getPrecio() {
		return this.costo;
	}

	@Override
	public double getDuracion() {
		return this.duracion;
	}

	@Override
	public TiposDeAtracciones getTipo() {
		return tipo;
	}

	@Override
	public String toString() {
		return "Llevá " + this.nombre + " por " + this.costo + " monedas de oro";
	}

	private void setCosto(int costo) {
		if (costo <= 0)
			throw new MontoInvalidoException("El monto debe ser mayor a 0");
		this.costo = costo;
	}

	private void setDuracion(double duracion) {
		if(duracion <= 0)
			throw new TiempoInvalidoException("La duracion debe ser mayor a 0");
		this.duracion = duracion;
	}

	private void setCupoMaximo(int cupoMaximo) {
		if(cupoMaximo <= 0)
			throw new CupoMaximoInvalidoException("El cupo debe ser mayor a 0");
		this.cupoMaximo = cupoMaximo;
	}

}