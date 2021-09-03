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
		this.costo = costo;
		this.duracion = duracion;
		this.cupoMaximo = cupoMaximo;
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

	public TiposDeAtracciones getTipo() {
		return tipo;
	}
}