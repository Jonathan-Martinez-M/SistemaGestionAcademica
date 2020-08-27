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

import mundo.Encuesta;

/**
 * @author Andrés
 * 
 * Clase encargada de la base de datos de las encuestas
 *
 */
public class GestorEncuestas
{
	/**
	 * Atriubutos encargados de generar los archivos de texto
	 */
	private File archivo;
	
	private BufferedWriter buff;
	
	private BufferedWriter buffM;
	//objeto para leer archivos
	
	/**
	 * Constructor de la clase GestorEncuestas
	 */
	public GestorEncuestas()
	{
		archivo = new File(Constantes.RUTA + "\\encuestas.txt");
		if(archivo.exists())
		{
			
		}
		else
		{
			try
			{
				buff = new BufferedWriter(new FileWriter(archivo));
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	/**
	 * Metodo encargado de almacenar la encuesta en la BD
	 * @return boolean
	 */
	public static boolean almacenar_encuesta(Encuesta nuevaEncuesta)
	{
		FileWriter flwriter = null;
		nuevaEncuesta.setIdentificador(GestorEncuestas.obtenerUltimoIdentificador());
		try
		{
			//además de la ruta del archivo recibe un parámetro de tipo boolean, que le indican que se va añadir más registros 
			flwriter = new FileWriter(Constantes.RUTA + "\\encuestas.txt", true);
			BufferedWriter bfwriter = new BufferedWriter(flwriter);
		
			//escribe los datos en el archivo
			for(int cadaPregunta = 0; cadaPregunta < Constantes.CANTIDAD_PREGUNTAS_CUANTITATIVAS; cadaPregunta++)
			{
				bfwriter.write(Constantes.PREGUNTA_CUANTITATIVA + "," + nuevaEncuesta.getIdentificador() + "," +
						nuevaEncuesta.getPreguntas_cuantitativas().get(cadaPregunta) + "," + nuevaEncuesta.getRespuestas_cuantitativas().get(cadaPregunta) + "\r\n");
			}
			
			bfwriter.write(Constantes.PREGUNTA_ABIERTA + "," + nuevaEncuesta.getIdentificador() + "," + nuevaEncuesta.getPregunta_abierta() + "," +
					nuevaEncuesta.getRespuesta_abierta() + "\r\n");
			
			bfwriter.close();	
			return true;
		} catch (IOException e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	* Metodo encargado de crear una lista de encuestas que estan en la BD
	* @return ArrayList<Encuesta>
	*/
	public static ArrayList<Encuesta> ver_encuestas()
	{
		Scanner entrada = null;
		ArrayList<Encuesta> encuestas = new ArrayList<Encuesta>();
		boolean esPreguntaCuantitativa = true;
		int encuestaNumero = 0;
		int preguntaNumero = 0;
		Encuesta encuestaRecuperada = new Encuesta(null, null);
		
		File archivo = new File(Constantes.RUTA + "\\encuestas.txt");
		
		try
		{
			entrada = new Scanner(archivo);
			while (entrada.hasNext()) //mientras no se llegue al final del fichero
			{
                String linea = entrada.nextLine();  //se lee una línea
                Scanner delimitador = new Scanner(linea);
                delimitador.useDelimiter("\\\\s*,\\\\s*");
                
                if(preguntaNumero == 0)
                	encuestaRecuperada = new Encuesta(null, null);
                
                if(delimitador.next().equals(Constantes.PREGUNTA_CUANTITATIVA))
                {
                	encuestaRecuperada.setIdentificador(Integer.parseInt(delimitador.next()));
                	encuestaRecuperada.agregar_Pregunta_Cuantitativa(preguntaNumero, delimitador.next());
                	encuestaRecuperada.agregar_Respuestas_cuantitativas(preguntaNumero, delimitador.next());
                	
                	preguntaNumero++;
                }else if(delimitador.next().equals(Constantes.PREGUNTA_ABIERTA))
                {
                	encuestaRecuperada.setIdentificador(Integer.parseInt(delimitador.next()));
                	encuestaRecuperada.setPregunta_abierta(delimitador.next());
                	encuestaRecuperada.setRespuesta_abierta(delimitador.next());
                	
                	encuestas.add(encuestaRecuperada);
                	preguntaNumero = 0;
                }
            }
			
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return encuestas;
	}
	
<<<<<<< HEAD
	public static int obtenerUltimoIdentificador()
=======
	/**
	* Metodo encargado de obtener el utlimo identificador en la BD
	* @return int
	*/
	private static int obtenerUltimoIdentificador()
>>>>>>> c7c364b9c05b52971c868e882c206416df3b5029
	{
		ArrayList<Encuesta> encuestasAlmacenadas = GestorEncuestas.ver_encuestas();
		int elUltimoIndice = 0;
		
		for(Encuesta cadaEncuesta : encuestasAlmacenadas)
		{
			if(cadaEncuesta.getIdentificador() > elUltimoIndice)
			{
				elUltimoIndice = cadaEncuesta.getIdentificador();
			}
		}
		
		return elUltimoIndice;
	}
	public static Encuesta nuevaEncuestaRetasVacias()
	{
		Scanner entrada = null;
		
		File archivo = new File(Constantes.RUTA + "\\preguntas.txt");
		
		String preguntaAbierta;

		ArrayList<String> lineasTxt = new ArrayList<String>();
		
		try {
			entrada = new Scanner(archivo);
			while (entrada.hasNext()) { //mientras no se llegue al final del fichero
                String linea = entrada.nextLine();  //se lee una línea
                lineasTxt.add(linea);
                
            }
			entrada.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		preguntaAbierta = lineasTxt.get(lineasTxt.size()-1);
		lineasTxt.remove(lineasTxt.size()-1);
		
		Encuesta encuesta = new Encuesta(lineasTxt , preguntaAbierta);
		
		for(int cadaRespuesta = 0; cadaRespuesta < Constantes.CANTIDAD_PREGUNTAS_CUANTITATIVAS; cadaRespuesta++)
		{
			encuesta.agregar_Respuestas_cuantitativas(cadaRespuesta, Constantes.PREGUNTA_SIN_RESPONDER);
		}
		
		encuesta.setPregunta_abierta(Constantes.PREGUNTA_SIN_RESPONDER);
		
		return encuesta;
	}
}
