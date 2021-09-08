package parqueDeDiversiones;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class AdministradorDeArchivos {
	
	private List<Atraccion> atracciones = new LinkedList<Atraccion>();
	private List<Usuario> usuarios = new LinkedList<Usuario>();
	
public List<Atraccion> cargarAtracciones() {
		
		FileReader fr = null;
		BufferedReader br = null;	
	
	try
	{
		
		
		fr = new FileReader("atracciones.txt");
		br = new BufferedReader(fr);
	
		
		String linea;
		while ((linea = br.readLine()) != null) {
			String[] propiedadesDeLaAtraccion = linea.split("-");
			String nombre = propiedadesDeLaAtraccion[0];
			int costo = Integer.parseInt(propiedadesDeLaAtraccion[1]);
			double duracion = Double.parseDouble(propiedadesDeLaAtraccion[2]);
			int cupo = Integer.parseInt(propiedadesDeLaAtraccion[3]);
			TipoDeAtraccion tipo = TipoDeAtraccion.valueOf(propiedadesDeLaAtraccion[4]);

			
			atracciones.add(new Atraccion(nombre, costo, duracion, cupo, tipo));
		
		
				
		}

	}catch(IOException e) {
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


public List<Usuario> cargarUsuarios() {
	
	FileReader fr = null;
	BufferedReader br = null;	

try
{
	
	
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

}catch(IOException e) {
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
