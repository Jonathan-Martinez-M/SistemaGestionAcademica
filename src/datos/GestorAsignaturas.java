/**
 * 
 */
package datos;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import mundo.Asignatura;
import mundo.Encuesta;
import mundo.Estudiante;
import mundo.Matricula;

/**
 * @author Andrés
 *
 * Clase encargada del manejo de datos en BD de las asignaturas y las matrículas 
 */
public class GestorAsignaturas
{
	private File archivoAsignaturas;	
	private File archivoMatriculas;
	private static BufferedWriter buff;	
	private BufferedWriter buffM;
	
	private static ArrayList<Matricula> matriculas;
	//objeto para leer archivos
	
	public GestorAsignaturas() {
		
		archivoAsignaturas = new File(Constantes.RUTA + "\\asignaturas.txt");
		archivoMatriculas = new File(Constantes.RUTA + "\\matriculas.txt");
		
		if(archivoAsignaturas.exists() && archivoMatriculas.exists())
		{
			
		}
		else {
			
			try {
				buff = new BufferedWriter(new FileWriter(archivoAsignaturas));
				buffM = new BufferedWriter(new FileWriter(archivoMatriculas));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}
	
	public static boolean agregar_asignatura(Asignatura nuevaAsignatura) 
	{
		
		ArrayList<Asignatura> asignaturas =  ver_asignatura();
		
		boolean verificacion = true;
		
		for(int i = 0; i<asignaturas.size(); i++)
		{
			if(nuevaAsignatura.getCodigo().equals(asignaturas.get(i).getCodigo()))
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
				flwriter = new FileWriter(Constantes.RUTA + "\\asignaturas.txt", true);
				BufferedWriter bfwriter = new BufferedWriter(flwriter);
			
				//escribe los datos en el archivo
				bfwriter.write(nuevaAsignatura.getNombre() + "," + nuevaAsignatura.getCodigo() + "\r\n");
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
	
	public static boolean modificar_asignatura(Asignatura asignaturaVieja , Asignatura asignaturaNueva) {
		
		String nombre = asignaturaVieja.getNombre() + "," + asignaturaVieja.getCodigo();
		
		Scanner entrada = null;
		
		File archivo = new File(Constantes.RUTA + "\\asignaturas.txt");
		
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
			lineasTxt.add(almacenarLinea-1 , asignaturaNueva.getNombre() + "," + asignaturaNueva.getCodigo());
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
	
	public static ArrayList<Asignatura> ver_asignatura(){
		
		
		Scanner entrada = null;
		
		ArrayList<Asignatura> asignaturas = new ArrayList<Asignatura>();
		
		File archivo = new File(Constantes.RUTA + "\\asignaturas.txt");
		
		try {
			
			entrada = new Scanner(archivo);
			while (entrada.hasNext()) { //mientras no se llegue al final del fichero
                String linea = entrada.nextLine();  //se lee una línea
                
                Scanner delimitar = new Scanner(linea);
                
                delimitar.useDelimiter("\\s*,\\s*");
                
                Asignatura asignaturaAgregar = new Asignatura(delimitar.next(), delimitar.next(), null);
                
                asignaturas.add(asignaturaAgregar);
                
                
            }
			entrada.close();
			
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
	
public static ArrayList<Matricula> ver_matricula(){
		
		
		Scanner entrada = null;
		
		ArrayList<Matricula> matricula = new ArrayList<Matricula>();
		
		File archivo = new File(Constantes.RUTA + "\\matriculas.txt");
		
		try {
			
			entrada = new Scanner(archivo);
			while (entrada.hasNext()) { //mientras no se llegue al final del fichero
                String linea = entrada.nextLine();  //se lee una línea
                
                Scanner delimitar = new Scanner(linea);
                
                delimitar.useDelimiter("\\s*,\\s*");
                
                Matricula matriculaAgregar = new Matricula(delimitar.next(), delimitar.next(), new Encuesta(null, null));
                
                matricula.add(matriculaAgregar);
            }
			entrada.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return matricula;
	}
}
