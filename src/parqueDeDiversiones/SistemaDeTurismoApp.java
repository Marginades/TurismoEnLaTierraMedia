package parqueDeDiversiones;


import java.util.List;
import java.util.Scanner;

public class SistemaDeTurismoApp {

	private static List<Comprable> productos;
	private static List<Usuario> usuarios;

	public static void main(String[] args) {
		// lectura de un archivo
		productos = AdministradorDeArchivos.cargarProductos();
		usuarios = AdministradorDeArchivos.cargarUsuarios();
		Scanner sc = new Scanner(System.in);
		for (Usuario user : usuarios) {
			if (!user.estaEnCero()) {
				productos.sort(new ComparadorDeComprables(user.getPreferencia()));
				for (Comprable producto : productos) {
					if (user.puedeComprar(producto)) {
						System.out.println(producto);

						if (sc.nextLine() == "si") {
							user.comprar(producto);
						} else
							continue;
					}
				} 
			}
		}
		sc.close();
	}
}

