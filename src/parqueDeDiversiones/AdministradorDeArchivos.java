package parqueDeDiversiones;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class AdministradorDeArchivos {

	private List<Atraccion> atracciones = new LinkedList<Atraccion>();
	private List<Promocion> promociones = new LinkedList<Promocion>();
	private List<Usuario> usuarios = new LinkedList<Usuario>();

	public List<Atraccion> cargarAtracciones() {

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

	public List<Promocion> cargarPromociones() {

		FileReader fr = null;
		BufferedReader br = null;
		try {

			fr = new FileReader("Promociones.txt");
			br = new BufferedReader(fr);
			String linea;
			while ((linea = br.readLine()) != null) {
				String[] propiedadesDeLaPromocion = linea.split("-");

				if (propiedadesDeLaPromocion[0] == "AXB") {
					String[] listaDeAtracciones = propiedadesDeLaPromocion[3].split("/");
					LinkedList<Atraccion> atraccionesDeLaPromo = new LinkedList<Atraccion>();
					TipoDeAtraccion tipoPromocion = TipoDeAtraccion.valueOf(propiedadesDeLaPromocion[1]);
					String nombrePromocion = propiedadesDeLaPromocion[2];

					for (int i = 0; i < listaDeAtracciones.length; i++) {
						for (Atraccion c : atracciones) {
							if (listaDeAtracciones[i] == c.getNombre()) {
								atraccionesDeLaPromo.add(c);
							}
						}
					}
					promociones.add(new PromocionAXB(tipoPromocion, nombrePromocion, atraccionesDeLaPromo,
							atraccionesDeLaPromo.getLast()));
					atraccionesDeLaPromo = null;
				}

				if (propiedadesDeLaPromocion[0] == "PORCENTUAL") {
					String[] listaDeAtracciones = propiedadesDeLaPromocion[4].split("/");
					LinkedList<Atraccion> atraccionesDeLaPromo = new LinkedList<Atraccion>();
					TipoDeAtraccion tipoPromocion = TipoDeAtraccion.valueOf(propiedadesDeLaPromocion[1]);
					String nombrePromocion = propiedadesDeLaPromocion[2];
					Double descuentoPorcentual = Double.parseDouble(propiedadesDeLaPromocion[3]);
					for (int i = 0; i < listaDeAtracciones.length; i++) {
						for (Atraccion c : atracciones) {
							if (listaDeAtracciones[i] == c.getNombre()) {
								atraccionesDeLaPromo.add(c);
							}
						}
					}
					promociones.add(new PromocionPorcentual(tipoPromocion, nombrePromocion, descuentoPorcentual,
							atraccionesDeLaPromo));
					atraccionesDeLaPromo = null;
				}
				if (propiedadesDeLaPromocion[0] == "ABSOLUTA") {
					String[] listaDeAtracciones = propiedadesDeLaPromocion[4].split("/");
					LinkedList<Atraccion> atraccionesDeLaPromo = new LinkedList<Atraccion>();
					TipoDeAtraccion tipoPromocion = TipoDeAtraccion.valueOf(propiedadesDeLaPromocion[1]);
					String nombrePromocion = propiedadesDeLaPromocion[2];
					int descuentoAbsoluto = Integer.parseInt(propiedadesDeLaPromocion[3]);
					for (int i = 0; i < listaDeAtracciones.length; i++) {
						for (Atraccion c : atracciones) {
							if (listaDeAtracciones[i] == c.getNombre()) {
								atraccionesDeLaPromo.add(c);
							}
						}
					}
					promociones.add(new PromocionAbsoluta(tipoPromocion, nombrePromocion, descuentoAbsoluto,
							atraccionesDeLaPromo));
					atraccionesDeLaPromo = null;
				}

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


	public List<Usuario> cargarUsuarios() {

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
}
