/**
 * 
 */
package datos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import mundo.Estudiante;

/**
 * @author Rubén
 *
 */
public class GestorEstudiantes
{
	//objeto para leer archivos
	
	public GestorEstudiantes()
	{
		File archivo = new File("C:\\Users\\user\\Documents\\Universidad\\Programacion\\Java\\SDGDA-GIT\\finalpoo\\finalpoo\\informacion\\estudiantes.txt");
		if (!archivo.exists()) {
		    
			try {
				FileWriter archivoEstudiantes = new FileWriter("C:\\Users\\user\\Documents\\Universidad\\Programacion\\Java\\SDGDA-GIT\\finalpoo\\finalpoo\\informacion\\estudiantes.txt");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public boolean agregar_estudiante(Estudiante nuevoEstudiante)
	{
		return true;
	}
	
	public boolean modificar_estudiante(Estudiante estudiante)
	{
		return true;
	}
	public ArrayList<Estudiante> ver_estudiante()
	{
		return new ArrayList<Estudiante>() ;
	}
	public ArrayList<Estudiante> buscar_estudiante()
	{
		return new ArrayList<Estudiante>() ;
	}
}
