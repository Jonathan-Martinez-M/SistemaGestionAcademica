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
	
	public static boolean agregar_estudiante(Estudiante nuevoEstudiante)
	{
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
