/**
 * 
 */
package datos;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import mundo.Asignatura;
import mundo.Encuesta;
import mundo.Matricula;

/**
 * @author Andrés
 *
 */
public class GestorAsignaturas {
	
	private File archivo;
	
	private File archivoM;
	
	private BufferedWriter buff;
	
	private BufferedWriter buffM;
	
	private static ArrayList<Matricula> matriculas;
	//objeto para leer archivos
	
	public GestorAsignaturas() {
		
		archivo = new File(Constantes.RUTA + "\\asignaturas.txt");
		archivoM = new File(Constantes.RUTA + "\\matriculas.txt");
		
		if(archivo.exists() && archivoM.exists())
		{
			
		}
		else {
			
			try {
				buff = new BufferedWriter(new FileWriter(archivo));
				buffM = new BufferedWriter(new FileWriter(archivoM));
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
			//además de la ruta del archivo recibe un parámetro de tipo boolean, que le indican que se va añadir más registros 
			flwriter = new FileWriter(Constantes.RUTA + "\\asignaturas.txt", true);
			BufferedWriter bfwriter = new BufferedWriter(flwriter);
		
			//escribe los datos en el archivo
			bfwriter.write(nuevaAsignatura.getNombre() + "," + nuevaAsignatura.getCodigo() + "\r "+"\n");
			bfwriter.close();
			return true;
 
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
		
	}
	
	public static boolean modificar_asignatura(Asignatura asignatura) {
		
		String nombre = asignatura.getNombre() + "," + asignatura.getCodigo();
		
		Scanner entrada = null;
		
		File archivo = new File(Constantes.RUTA + "\\asignaturas.txt");
		
		try {
			entrada = new Scanner(archivo);
			while (entrada.hasNext()) { //mientras no se llegue al final del fichero
                String linea = entrada.nextLine();  //se lee una línea
                if (linea.contains(nombre)) {   //si la línea contiene el texto buscado se muestra por pantalla         
                   
                }
            }
			
			return true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
	}
	
	public static ArrayList<String> ver_asignatura(){
		
		
		Scanner entrada = null;
		
		ArrayList<String> asignaturas = new ArrayList<String>();
		
		File archivo = new File(Constantes.RUTA + "\\asignaturas.txt");
		
		try {
			
			entrada = new Scanner(archivo);
			while (entrada.hasNext()) { //mientras no se llegue al final del fichero
                String linea = entrada.nextLine();  //se lee una línea
                
                asignaturas.add(linea);       
            }
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return asignaturas;
	}
	
	public static boolean almacenar_matricula(Matricula m){
		
		FileWriter flwriter = null;
		try
		{
			//además de la ruta del archivo recibe un parámetro de tipo boolean, que le indican que se va añadir más registros 
			flwriter = new FileWriter(Constantes.RUTA + "\\matriculas.txt", true);
			BufferedWriter bfwriter = new BufferedWriter(flwriter);
		
			//escribe los datos en el archivo
			bfwriter.write(m.getPertenece_a_estudiante() + "," + m.getDe_la_asignatura() + "," + m.getEncuesta().getIdentificador());
			bfwriter.close();	
			return true;
 
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
	}
}
