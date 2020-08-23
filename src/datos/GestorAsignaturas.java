/**
 * 
 */
package datos;

import java.io.*;
import java.util.ArrayList;

import mundo.Asignatura;

/**
 * @author Andr�s
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
	
	public static boolean agregar_asignatura(Asignatura nuevaAsignatura) 
	{
		FileWriter flwriter = null;
		try
		{
			//adem�s de la ruta del archivo recibe un par�metro de tipo boolean, que le indican que se va a�adir m�s registros 
			flwriter = new FileWriter(Constantes.RUTA + "\\estudiantes.txt", true);
			BufferedWriter bfwriter = new BufferedWriter(flwriter);
		
			//escribe los datos en el archivo
			bfwriter.write(nuevaAsignatura.getNombre() + "," + nuevaAsignatura.getCodigo() + "\n");
			bfwriter.close();
 
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public static boolean modificar_asignatura(Asignatura asignatura) {
		
		return true;
	}
	
	public static ArrayList<Asignatura> ver_estudiantes(){
		
		return new ArrayList<Asignatura>();
	}
}
