/**
 * 
 */
package datos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import mundo.Encuesta;

/**
 * @author Andrés
 *
 */
public class GestorEncuestas {

	//objeto para leer archivos
	
	public GestorEncuestas() {
		
		File archivo = new File("C:\\Users\\user\\Documents\\Universidad\\Programacion\\Java\\SDGDA-GIT\\finalpoo\\finalpoo\\informacion\\encuestas.txt");
		if (!archivo.exists()) {
		    
			try {
				FileWriter archivoEncuesta = new FileWriter("C:\\Users\\user\\Documents\\Universidad\\Programacion\\Java\\SDGDA-GIT\\finalpoo\\finalpoo\\informacion\\encuestas.txt");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList<Encuesta> almacenar_encuestas(){
		
		return new ArrayList<Encuesta>();
	}
	
	public ArrayList<Encuesta> ver_encuestas(){
		
		return new ArrayList<Encuesta>();
	}
}
