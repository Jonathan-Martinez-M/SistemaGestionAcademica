/**
 * 
 */
package datos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import mundo.Asignatura;
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
	
	
	public static ArrayList<Estudiante> ver_estudiantes()
	{
		Scanner entrada = null;
		
		ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();
		
		File archivo = new File(Constantes.RUTA + "\\estudiantes.txt");
		
		try {
			
			entrada = new Scanner(archivo);
			while (entrada.hasNext()) { //mientras no se llegue al final del fichero
                String linea = entrada.nextLine();  //se lee una línea
                
                Scanner delimitar = new Scanner(linea);
                
                delimitar.useDelimiter("\\s*,\\s*");
                
                Estudiante estudianteAgregar = new Estudiante(null, null, delimitar.next(), delimitar.next(), delimitar.next(), delimitar.next(), null);
                
                estudiantes.add(estudianteAgregar);
                
                
            }
			entrada.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return estudiantes;
	}
	
	
	public static ArrayList<Estudiante> buscar_estudiante()
	{
		return new ArrayList<Estudiante>() ;
	}
}
