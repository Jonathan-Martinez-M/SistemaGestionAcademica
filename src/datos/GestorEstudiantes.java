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
	
	private static BufferedWriter buff;
	
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
			bfwriter.write(nuevoEstudiante.getContrasegna() + "," + nuevoEstudiante.getNombres() + "," + nuevoEstudiante.getApellidos() + 
					"," + nuevoEstudiante.getCiudad() + "," + nuevoEstudiante.getBarrio() + "\n");
			bfwriter.close();
 
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	
	public static boolean modificar_estudiante(Estudiante estudianteviejo , Estudiante estudiantenuevo) {
		
		String nombre = estudianteviejo.getContrasegna() + "," + estudianteviejo.getNombres() + "," + estudianteviejo.getApellidos() + 
				"," + estudianteviejo.getCiudad() + "," + estudianteviejo.getBarrio();
		
		Scanner entrada = null;
		
		File archivo = new File(Constantes.RUTA + "\\estudiantes.txt");
		
		int numeroLinea = 0;
		
		int almacenarLinea = 0;
		
		ArrayList<String> lineasTxt = new ArrayList<String>();
		
		try {
			entrada = new Scanner(archivo);
			while (entrada.hasNext()) { //mientras no se llegue al final del fichero
				numeroLinea++;
                String linea = entrada.nextLine();  //se lee una línea
                lineasTxt.add(linea);
                if (linea.contains(nombre)) {   //si la línea contiene el texto buscado se muestra por pantalla         
                   
                	almacenarLinea = numeroLinea;
                }
                
            }
			lineasTxt.remove(almacenarLinea-1);
			lineasTxt.add(almacenarLinea-1 ,estudiantenuevo.getContrasegna() + "," + estudiantenuevo.getNombres() + "," + 
			estudiantenuevo.getApellidos() + "," + estudiantenuevo.getCiudad() + "," + estudiantenuevo.getBarrio());
			buff = new BufferedWriter(new FileWriter(archivo));
			for(int i = 0; i < lineasTxt.size() ; i++ )
			{
				buff.write(lineasTxt.get(i));
			}
			
			buff.close();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
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
                
                Estudiante estudianteAgregar = new Estudiante(null, delimitar.next(), delimitar.next(), delimitar.next(), delimitar.next(), delimitar.next(), null);
                
                estudiantes.add(estudianteAgregar);
                
                
            }
			entrada.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return estudiantes;
	}
	
}
