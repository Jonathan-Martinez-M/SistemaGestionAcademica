/**
 * 
 */
package datos;

import java.io.*;
import java.util.ArrayList;

import mundo.Asignatura;

/**
 * @author Andrés
 *
 */
public class GestorAsignaturas {
	
	private File archivo;
	
	private BufferedWriter buff;
	//objeto para leer archivos
	
	public GestorAsignaturas() {
		
		archivo = new File(Constantes.RUTA + "\\estudiantes.txt");
		
		if(archivo.exists())
		{
			try {
				buff.write("El fichero de texto ya estaba creado.");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			
			try {
				buff = new BufferedWriter(new FileWriter(archivo));
				buff.write("Acabo de crear el fichero de texto.");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		try {
			buff.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}
	
	public boolean agregar_asignatura(Asignatura nuevaAsignatura) 
	{
		return true;
	}
	
	public boolean modificar_asignatura(Asignatura asignatura) {
		
		return true;
	}
	
	public ArrayList<Asignatura> ver_estudiantes(){
		
		return new ArrayList<Asignatura>();
	}
}
