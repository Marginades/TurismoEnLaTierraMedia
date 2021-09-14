package parqueDeDiversiones;

public class Atraccion implements Comprable{

	private String nombre;
	private int costo;
	private double duracion;
	private int entradasVendidas = 0;
	private int cupoMaximo;
	private TipoDeAtraccion tipo;

	//Constructor
	public Atraccion(String nombre, int costo, double duracion, int cupoMaximo,
			TipoDeAtraccion tipo) {
		this.nombre = nombre;
		this.setCosto(costo);
		this.setDuracion(duracion);
		this.setCupoMaximo(cupoMaximo);
		this.tipo = tipo;
	}
	
	
	//Metodos Overrride de Comprable
	@Override
	public String getNombre() { return nombre;	}
	
	@Override
	public double getCosto() { return this.costo; 	}

	@Override
	public double getDuracion() { return this.duracion; }
	
	@Override
	public TipoDeAtraccion getTipo() { return tipo; }

	@Override
	public boolean hayCupo() {
		return this.entradasVendidas < this.cupoMaximo;
	}
	
	public int getCupoMaximo() { return this.cupoMaximo; }
	
	public int getEntradasVendidas() { return this.entradasVendidas; }

	//Setters con excepciones
	private void setCosto(int costo) {
		if (costo < 0)
			throw new MontoInvalidoException("El monto debe ser mayor a 0");
		this.costo = costo;
	}

	private void setDuracion(double duracion) {
		if(duracion <= 0)
			throw new DuracionInvalidaException("La duracion debe ser mayor a 0");
		this.duracion = duracion;
	}

	private void setCupoMaximo(int cupoMaximo) {
		if(cupoMaximo <= 0)
			throw new CupoMaximoInvalidoException("El cupo debe ser mayor a 0");
		this.cupoMaximo = cupoMaximo;
	}
	
	//Modifica el atributo entradasVendidas
	public void comprarLugar() {
		if(!this.hayCupo())
			throw new CupoMaximoAlcanzadoException("No Hay Mas Lugar");
		this.entradasVendidas += 1;
	}
	
	@Override
	public boolean esPromocion(){
		return false;
	}
	
	//Imprimir
	@Override
	public String toString() {
		return "Llevá " + this.nombre + " por " + this.costo + " monedas de oro" + "(Duración: " + this.duracion + ")";
	}

}