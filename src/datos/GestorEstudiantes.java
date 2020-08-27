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
import mundo.Barrio;
import mundo.Ciudad;
import mundo.Estudiante;

/**
 * @author Rubén
 *
 */
public class GestorEstudiantes
{
	
	/**
	 * Atriubutos encargados de generar los archivos de texto
	 */
	private File archivo;
	
	private static BufferedWriter buff;
	//objeto para leer archivos
	
	/**
	 * Constructor de la clase GestorEstudiantes
	 */
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
	
	/**
	 * Metodo encargado de agregar un estudiante a la BD
	 * @return boolean
	 */
	public static boolean agregar_estudiante(Estudiante nuevoEstudiante)
	{
		ArrayList<Estudiante> estudiantes =  ver_estudiantes();
		
		boolean verificacion = true;
		
		for(int i = 0; i<estudiantes.size(); i++)
		{
			if(nuevoEstudiante.getCodigo().equals(estudiantes.get(i).getCodigo()))
			{
				verificacion = false;
			}
		}
		if(verificacion)
		{
			FileWriter flwriter = null;
			try
			{
				//además de la ruta del archivo recibe un parámetro de tipo boolean, que le indican que se va añadir más registros 
				flwriter = new FileWriter(Constantes.RUTA + "\\estudiantes.txt", true);
				BufferedWriter bfwriter = new BufferedWriter(flwriter);
			
				//escribe los datos en el archivo
				bfwriter.write(nuevoEstudiante.getCodigo() + "," + nuevoEstudiante.getContrasegna() + "," + nuevoEstudiante.getNombres() + 
						"," + nuevoEstudiante.getApellidos() + "," + nuevoEstudiante.getCiudad() + "," + nuevoEstudiante.getBarrio() + "\r\n");
				bfwriter.close();
				return true;
	 
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
			
		}
		else
		{
			return false;
		}
		
	}
	
	/**
	* Metodo encargado de modificar un estudiante
	* @return boolean	
	*/
	public static boolean modificar_estudiante(Estudiante estudianteviejo , Estudiante estudiantenuevo) {
		
		if(estudianteviejo.getContrasegna().equalsIgnoreCase(estudiantenuevo.getContrasegna()))
		{
			String nombre = estudianteviejo.getCodigo() + "," + estudianteviejo.getContrasegna() + "," + estudianteviejo.getNombres() + 
					"," + estudianteviejo.getApellidos() + "," + estudianteviejo.getCiudad() + "," + estudianteviejo.getBarrio();
			
			Scanner entrada = null;
			
			File archivo = new File(Constantes.RUTA + "\\estudiantes.txt");
			
			int numeroLinea = 0;
			
			int almacenarLinea = 0;
			
			ArrayList<String> lineasTxt = new ArrayList<String>();
			
			try
			{
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
				lineasTxt.add(almacenarLinea-1 ,estudiantenuevo.getCodigo() + "," + estudiantenuevo.getContrasegna() + "," + estudiantenuevo.getNombres() + "," + 
				estudiantenuevo.getApellidos() + "," + estudiantenuevo.getCiudad() + "," + estudiantenuevo.getBarrio());
				buff = new BufferedWriter(new FileWriter(archivo));
				for(int i = 0; i < lineasTxt.size() ; i++ )
				{
					buff.write(lineasTxt.get(i) + "\r\n");
				}
				
				buff.close();
				return true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			
		}
		else {
			return false;
		}
	}
		
	
	/**
	* Metodo encargado de crear una lista de estudiantes que estan en la BD
	* @return ArrayList<Estudiante>
	*/
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
                
                Estudiante estudianteAgregar = new Estudiante(delimitar.next(), delimitar.next(), delimitar.next(), delimitar.next(), delimitar.next(), delimitar.next(), null);
                
                estudiantes.add(estudianteAgregar);
                
                
            }
			entrada.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return estudiantes;
	}
	
	/**
	* Metodo encargado del ingreso de un estudiante a la plataforma
	* @return boolean
	*/
	public static boolean ingresar(String codigo, String contrasegna) {
			
			boolean bandera = false;
			
			ArrayList<Estudiante> estudiante = new ArrayList<Estudiante>();
			
			estudiante = GestorEstudiantes.ver_estudiantes();
			
			for(int i=0; i < estudiante.size() ; i++) {
				
				if((estudiante.get(i).getCodigo()).equals(codigo) && (estudiante.get(i).getContrasegna().equals(contrasegna))) {
					
					bandera = true;
					
					break;
				}
			}
			
		return bandera;
	}
	
	/**
	* Metodo encargado de buscar un estudiante 
	* @return Estudiante
	*/
	public static Estudiante buscarEstudiante(String codigo) {
		
		Estudiante estudiante = null;
		
		ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();
		
		estudiantes = GestorEstudiantes.ver_estudiantes();
		
		for(int i=0; i < estudiantes.size() ; i++) {
			
			if(estudiantes.get(i).getCodigo().equals(codigo)) {
				
				estudiante = estudiantes.get(i);
				
				break;
			}
		}
		
		return estudiante;
	}
	
	
	public static ArrayList<Ciudad> ver_ciudades(){
		
		Scanner entrada = null;
		
		ArrayList<Ciudad> ciudades = new ArrayList<Ciudad>();
		
		File archivo = new File(Constantes.RUTA + "\\Ciudades.txt");
		
		try {
			
			entrada = new Scanner(archivo);
			while (entrada.hasNext()) { //mientras no se llegue al final del fichero
                String linea = entrada.nextLine();  //se lee una línea
                
                Scanner delimitar = new Scanner(linea);
                
                delimitar.useDelimiter("\\s*,\\s*");
                
                Ciudad ciudadesAgregar = new Ciudad(delimitar.next(), delimitar.next());
                
                ciudades.add(ciudadesAgregar);
                
                
            }
			entrada.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ciudades;
	}
	
	public static ArrayList<Barrio> ver_barrios(){
		
		Scanner entrada = null;
		
		ArrayList<Barrio> barrios = new ArrayList<Barrio>();
		
		File archivo = new File(Constantes.RUTA + "\\Barrios.txt");
		
		try {
			
			entrada = new Scanner(archivo);
			while (entrada.hasNext()) { //mientras no se llegue al final del fichero
                String linea = entrada.nextLine();  //se lee una línea
                
                Scanner delimitar = new Scanner(linea);
                
                delimitar.useDelimiter("\\s*,\\s*");
                
                Barrio barriosAgregar = new Barrio(delimitar.next(), delimitar.next());
                
                barrios.add(barriosAgregar);
                
                
            }
			entrada.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return barrios;
	}
	
	public static ArrayList<Barrio> ver_barrios_de_una_ciudad(Ciudad ciudad){
		
		
		ArrayList<Barrio> barrios = new ArrayList<Barrio>();
		
		ArrayList<Barrio> barriosDeLaCiudad = new ArrayList<Barrio>();
		
		barrios = ver_barrios();
		
		for(int i = 0; i<barrios.size(); i++)
		{
			if(ciudad.getIdentificador().equals(barrios.get(i).getIdentificadorCiudad()))
			{
				barriosDeLaCiudad.add(barrios.get(i));
			}
		}
		
		
		
		return barriosDeLaCiudad;
	}
	
}
