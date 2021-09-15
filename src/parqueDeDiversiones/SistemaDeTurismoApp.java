package parqueDeDiversiones;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;

public class SistemaDeTurismoApp {

	private static List<Comprable> productos;
	private static List<Usuario> usuarios;
	
	
	static FileReader fr;
	static BufferedReader br;

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
		// for de usuarios productos.sort
		// recorremos lista de comprables y mostramos los que puede comprar
		// fijarnos si acepta con
		// sc = Scanner(System.in)
		// sc.nextLine()
		// si se acepta usuario.comprar

		// metodo estaEn0 (para usuario)
	}
}

