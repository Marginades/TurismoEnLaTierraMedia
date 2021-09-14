package parqueDeDiversiones;

import java.util.List;
import java.util.Scanner;

public class SistemaDeTurismoApp {
	
	private static List<Comprable> productos;
	private static List<Usuario> usuarios;
	
	public static void main(String[] args) {
		//lectura de un archivo
				productos = AdministradorDeArchivos.cargarProductos();
				usuarios = AdministradorDeArchivos.cargarUsuarios();
				Scanner sc = new Scanner(System.in);
				
				for (Usuario u : usuarios) {
					if(!u.estaEnCero()) {
						productos.sort(new ComparadorDeComprables(u.getPreferencia()));
						for(Comprable p : productos) {
							if (u.puedeComprar(p)) {
								System.out.println(p);
								
								if(sc.nextLine() == "si") {
									u.comprar(p);
								}else
									continue;
							}
						}
					}
				}
				sc.close();
				//for de usuarios productos.sort
				//recorremos lista de comprables y mostramos los que puede comprar
				//fijarnos si acepta con 
				//sc = Scanner(System.in)
				//sc.nextLine()
				//si se acepta usuario.comprar
				
				//metodo estaEn0 (para usuario)
			}
	}

