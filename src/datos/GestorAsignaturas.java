/**
 * 
 */
package datos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import mundo.Asignatura;

/**
 * @author Andrés
 *
 */
public class GestorAsignaturas {
	
	//objeto para leer archivos
	
	public GestorAsignaturas() {
		
		File archivo = new File("C:\\Users\\user\\Documents\\Universidad\\Programacion\\Java\\SDGDA-GIT\\finalpoo\\finalpoo\\informacion\\estudiantes.txt");
		if (!archivo.exists()) {
		    
			try {
				FileWriter archivoAsignatura = new FileWriter("C:\\Users\\user\\Documents\\Universidad\\Programacion\\Java\\SDGDA-GIT\\finalpoo\\finalpoo\\informacion\\estudiantes.txt");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public boolean agregar_asignatura(Asignatura nuevaAsignatura) {
		
		return true;
	}
	
	public boolean modificar_asignatura(Asignatura asignatura) {
		
		return true;
	}
	
	public ArrayList<Asignatura> ver_estudiantes(){
		
		return new ArrayList<Asignatura>();
	}
}
