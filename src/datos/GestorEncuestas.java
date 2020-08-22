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
			try {
				buff.write("El fichero de texto ya estaba creado.");
				buffM.write("El fichero de texto ya estaba creado.");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			
			try {
				buff = new BufferedWriter(new FileWriter(archivo));
				buffM = new BufferedWriter(new FileWriter(archivoM));
				buff.write("Acabo de crear el fichero de texto.");
				buffM.write("Acabo de crear el fichero de texto.");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		try {
			buff.close();
			buffM.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}


	}
	
	public ArrayList<Encuesta> almacenar_encuestas(){
		
		return new ArrayList<Encuesta>();
	}
	
	public ArrayList<Encuesta> ver_encuestas(){
		
		return new ArrayList<Encuesta>();
	}
}
