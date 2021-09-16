package parqueDeDiversiones;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class SistemaDeTurismoApp {

	private static List<Comprable> productos;
	private static List<Usuario> usuarios;

	public static void main(String[] args) throws IOException {

		productos = AdministradorDeArchivos.cargarProductos();
		usuarios = AdministradorDeArchivos.cargarUsuarios();

		Scanner sc = new Scanner(System.in);
		for (Usuario user : usuarios) {
			System.out.println("¡Hola " + user.getNombre() + "!");
			if (!user.estaEnCero()) {
				productos.sort(new ComparadorDeComprables(user.getPreferencia()));

				for (Comprable producto : productos) {
					boolean respuestaValida = false;
					String respuesta = "";
					if (user.puedeComprar(producto)) {
						
						while (!respuestaValida) {
							System.out.println(producto);
							System.out.println("Responde si o no");
							respuesta = sc.nextLine();
							if (respuesta.equals("si")) {
								user.comprar(producto);
								respuestaValida = true;
								continue;
							} else if (respuesta.equals("no")) {
								respuestaValida = true;
								continue;
							}
						}
					}
				}
				System.out.println("Gracias " + user.getNombre() + " ¡que disfrutes tus excursiones!");
			}
			
		}
		AdministradorDeArchivos.escribirItinerariosPorUsuario();
		sc.close();
	}
}
