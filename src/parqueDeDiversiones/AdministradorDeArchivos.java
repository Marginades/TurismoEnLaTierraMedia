package parqueDeDiversiones;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class AdministradorDeArchivos {

	private static List<Comprable> atracciones = new LinkedList<Comprable>();
	private static List<Comprable> promociones = new LinkedList<Comprable>();
	private static List<Comprable> productos = new LinkedList<Comprable>();
	private static List<Usuario> usuarios = new LinkedList<Usuario>();
	
	public static Comprable pescadorDeAtracciones(String atraccion) {
		
		Comprable a1 = null;
		
		for (Comprable c : AdministradorDeArchivos.atracciones) {
				if (atraccion.equals(c.getNombre())) {
					a1 = c;
				}

			}
		return a1;

		}

	public static List<Comprable> cargarAtracciones() {

		FileReader fr = null;
		BufferedReader br = null;
		try {

			fr = new FileReader("atracciones.txt");
			br = new BufferedReader(fr);

			String linea;
			while ((linea = br.readLine()) != null) {
				String[] propiedadesDeLaAtraccion = linea.split("-");
				String nombreAtraccion = propiedadesDeLaAtraccion[0];
				int costoAtraccion = Integer.parseInt(propiedadesDeLaAtraccion[1]);
				double duracionAtraccion = Double.parseDouble(propiedadesDeLaAtraccion[2]);
				int cupoAtraccion = Integer.parseInt(propiedadesDeLaAtraccion[3]);
				TipoDeAtraccion tipoAtraccion = TipoDeAtraccion.valueOf(propiedadesDeLaAtraccion[4]);

				atracciones.add(new Atraccion(nombreAtraccion, costoAtraccion, duracionAtraccion, cupoAtraccion,
						tipoAtraccion));

			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				
				if (fr != null) {

					fr.close();

				}
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
		return atracciones;
	}

	public static List<Comprable> cargarPromociones() {

		FileReader fr = null;
		BufferedReader br = null;
		try {

			fr = new FileReader("Promociones.txt");
			br = new BufferedReader(fr);
			String linea;
			while ((linea = br.readLine()) != null) {

				String[] propiedadesDeLaPromocion = linea.split("-");
				String[] listaDeAtracciones = propiedadesDeLaPromocion[4].split("/");
				LinkedList<Comprable> atraccionesDeLaPromo = new LinkedList<Comprable>();
				TipoDeAtraccion tipoPromocion = TipoDeAtraccion.valueOf(propiedadesDeLaPromocion[1]);
				String nombrePromocion = propiedadesDeLaPromocion[2];
				
				for (int i = 0; i < listaDeAtracciones.length; i++) {
					atraccionesDeLaPromo.add(AdministradorDeArchivos.pescadorDeAtracciones(listaDeAtracciones[i]));	
				}
				
				if (propiedadesDeLaPromocion[0] == "AXB") {
					Comprable atraccionGratis= AdministradorDeArchivos.pescadorDeAtracciones(propiedadesDeLaPromocion[3]);
					promociones.add(new PromocionAXB(tipoPromocion, nombrePromocion, atraccionGratis, atraccionesDeLaPromo));

				}else if (propiedadesDeLaPromocion[0] == "PORCENTUAL") {
					Double descuentoPorcentual = Double.parseDouble(propiedadesDeLaPromocion[3]);
					promociones.add(new PromocionPorcentual(tipoPromocion, nombrePromocion, descuentoPorcentual,
							atraccionesDeLaPromo));
				}

				else if (propiedadesDeLaPromocion[0] == "ABSOLUTA") {
					int descuentoAbsoluto = Integer.parseInt(propiedadesDeLaPromocion[3]);
					promociones.add(new PromocionAbsoluta(tipoPromocion, nombrePromocion, descuentoAbsoluto,
							atraccionesDeLaPromo));

				}
				
				atraccionesDeLaPromo = null;
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null) {

					fr.close();

				}
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}

		return promociones;
	}

	public static List<Usuario> cargarUsuarios() {

		FileReader fr = null;
		BufferedReader br = null;

		try {

			fr = new FileReader("usuarios.txt");
			br = new BufferedReader(fr);

			String linea;
			while ((linea = br.readLine()) != null) {
				String[] propiedadesDelUsuario = linea.split("-");
				String nombre = propiedadesDelUsuario[0];
				int presupuesto = Integer.parseInt(propiedadesDelUsuario[1]);
				double disponibilidad = Double.parseDouble(propiedadesDelUsuario[2]);
				TipoDeAtraccion preferencia = TipoDeAtraccion.valueOf(propiedadesDelUsuario[3]);

				usuarios.add(new Usuario(nombre, presupuesto, disponibilidad, preferencia));

			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null) {

					fr.close();

				}
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
		return usuarios;
	}
	
	public static List<Comprable> cargarProductos(){
		productos.addAll(cargarPromociones());
		productos.addAll(cargarAtracciones());
		return productos;
	}
}
