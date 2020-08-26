/**
 * 
 */
package datos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
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
	private File archivo;
	
	private BufferedWriter buff;
	
	public GestorEstudiantes()
	{
		archivo = new File(Constantes.RUTA + "\\estudiantes.txt");
		
		if(archivo.exists())
		{
			
		}
		else {
			
			try {
				buff = new BufferedWriter(new FileWriter(archivo));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	
	}
	
	public static boolean agregar_estudiante(Estudiante nuevoEstudiante)
	{
		FileWriter flwriter = null;
		try
		{
			//además de la ruta del archivo recibe un parámetro de tipo boolean, que le indican que se va añadir más registros 
			flwriter = new FileWriter(Constantes.RUTA + "\\estudiantes.txt", true);
			BufferedWriter bfwriter = new BufferedWriter(flwriter);
		
			//escribe los datos en el archivo
			bfwriter.write(nuevoEstudiante.getNombres() + "," + nuevoEstudiante.getApellidos() + "," + nuevoEstudiante.getCiudad() +
					"," + nuevoEstudiante.getBarrio() + "\n");
			bfwriter.close();
 
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public static boolean modificar_estudiante(Estudiante estudiante)
	{
		return true;
	}
	public static ArrayList<Estudiante> ver_estudiante()
	{
		return new ArrayList<Estudiante>() ;
	}
	public static ArrayList<Estudiante> buscar_estudiante()
	{
		return new ArrayList<Estudiante>() ;
	}
}
