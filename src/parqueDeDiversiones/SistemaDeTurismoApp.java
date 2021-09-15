package parqueDeDiversiones;


import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class SistemaDeTurismoApp {

	private static List<Comprable> productos;
	private static List<Usuario> usuarios;

	public static void main(String[] args) throws IOException {
		// lectura de un archivo
		productos = AdministradorDeArchivos.cargarProductos();
		usuarios = AdministradorDeArchivos.cargarUsuarios();
		/*for (Comprable p : productos) {
			System.out.println(p);
		}*/
		Scanner sc = new Scanner(System.in);
		for (Usuario user : usuarios) {
			System.out.println("¡Hola " + user.getNombre() + "!");
			if (!user.estaEnCero()) {
				productos.sort(new ComparadorDeComprables(user.getPreferencia()));
				for (Comprable producto : productos) {
					if (user.puedeComprar(producto)) {
						System.out.println(producto);
						System.out.println("Responde si o no");
						if (sc.nextLine() == "si") {
							user.comprar(producto);
						} else
							continue;
					}
				} 
			}
			System.out.println("Gracias " + user.getNombre() + " ¡que disfrutes tus excursiones!");
		}
		sc.close();
		
		AdministradorDeArchivos.escribirItinerario(usuarios, "itinerarios.csv");
	}
}

