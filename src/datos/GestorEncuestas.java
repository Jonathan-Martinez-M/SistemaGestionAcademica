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

import mundo.Encuesta;

/**
 * @author Andrés
 *
 */
public class GestorEncuestas {

	private File archivo;
	
	private File archivoM;
	
	private BufferedWriter buff;
	
	private BufferedWriter buffM;
	//objeto para leer archivos
	
	public GestorEncuestas() {
		
		archivo = new File(Constantes.RUTA + "\\encuestas.txt");
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
	
	public static ArrayList<Encuesta> almacenar_encuestas(Encuesta nuevaEncuesta){
			
				
		return new ArrayList<Encuesta>();
	}
	
	public static ArrayList<Encuesta> ver_encuestas(){
		
		return new ArrayList<Encuesta>();
	}
}
