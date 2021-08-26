package parqueDeDiversiones;

public class Atraccion {

		private String nombre = "";
		private int costo;
		private double duracion;
		private int cupoMaximo;
		private TiposDeAtracciones tipo;
		
		public Atraccion(String nombre, int costo, double duracion, int cupoMaximo, TiposDeAtracciones tipo) {
		
			this.nombre = nombre;
			this.costo = costo;
			this.duracion = duracion;
			this.cupoMaximo = cupoMaximo;
			this.tipo = tipo;
		}
		
		
}
