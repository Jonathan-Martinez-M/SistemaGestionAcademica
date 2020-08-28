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
import mundo.Estudiante;

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
	
	private static BufferedWriter buff;
	
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
				bfwriter.write(nuevaEncuesta.getIdentificador() + "," + Constantes.PREGUNTA_CUANTITATIVA + "," + 
						nuevaEncuesta.getPreguntas_cuantitativas().get(cadaPregunta) + "," + nuevaEncuesta.getRespuestas_cuantitativas().get(cadaPregunta) + "\r\n");
			}
			
			bfwriter.write(nuevaEncuesta.getIdentificador() + "," + Constantes.PREGUNTA_ABIERTA + "," + nuevaEncuesta.getPregunta_abierta() + "," +
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
	
	/**
	* Metodo encargado de obtener el utlimo identificador en la BD
	* @return int
	*/
	public static int obtenerUltimoIdentificador()
	{
		ArrayList<Encuesta> encuestasAlmacenadas = GestorEncuestas.ver_encuestas();
		int elUltimoIndice = 1;
		
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
		} catch (IOException e)
		{
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
		
		encuesta.setRespuesta_abierta(Constantes.PREGUNTA_SIN_RESPONDER);
		
		return encuesta;
	}
	
	public static ArrayList<Encuesta> obtenerEncuestasPorUsuario(Estudiante elEstudiante)
	{
		ArrayList<Encuesta> todasLasEncuestas = GestorEncuestas.ver_encuestas();
		ArrayList<Encuesta> encuestasUsuario = new ArrayList<Encuesta>();
		
		for(Encuesta cadaEncuesta : todasLasEncuestas)
		{
			for(int cadaMatricula = 0; cadaMatricula < elEstudiante.getMatriculas().size(); cadaMatricula++)
			{
				if(cadaEncuesta.getIdentificador() == elEstudiante.getMatriculas().get(cadaMatricula).getEncuesta().getIdentificador())
				{
					
				}
			}
		}
		
		return encuestasUsuario;
	}
	
	public static Boolean modificarEncuesta(Encuesta encuestaVieja, Encuesta encuestaNueva)
	{
		String nombre = encuestaVieja.getIdentificador() + Constantes.PREGUNTA_CUANTITATIVA + "," + encuestaVieja.getPreguntas_cuantitativas().get(0)
				+ encuestaVieja.getRespuestas_cuantitativas().get(0);
		Scanner entrada = null;
		File archivo = new File(Constantes.RUTA + "\\encuestas.txt");
		int numeroLinea = 0;
		int almacenarLinea = 0;
		ArrayList<String> lineasTxt = new ArrayList<String>();
		
		try
		{
			entrada = new Scanner(archivo);
			while (entrada.hasNext())//mientras no se llegue al final del fichero
			{
                String linea = entrada.nextLine();  //se lee una línea
                lineasTxt.add(linea);
                if (linea.contains(nombre))
                {
                	almacenarLinea = numeroLinea;
                }
                numeroLinea++;
            }
			
			for (int cadaLinea = 0; cadaLinea < encuestaNueva.getPreguntas_cuantitativas().size(); cadaLinea++)
			{
				lineasTxt.remove(almacenarLinea + cadaLinea);
				lineasTxt.add(almacenarLinea + cadaLinea, encuestaNueva.getIdentificador() + Constantes.PREGUNTA_CUANTITATIVA + "," +
						encuestaNueva.getPreguntas_cuantitativas().get(cadaLinea) + encuestaNueva.getRespuestas_cuantitativas().get(cadaLinea));
			}
			
			lineasTxt.remove(almacenarLinea + 5);
			lineasTxt.add(almacenarLinea + 5, encuestaNueva.getIdentificador() + Constantes.PREGUNTA_CUANTITATIVA + "," +
					encuestaNueva.getPregunta_abierta() + encuestaNueva.getRespuesta_abierta());
			
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
	
	public static Encuesta buscarEncuestaPoId(Encuesta encuesta)
	{
		ArrayList<Encuesta> lasEncuestas = ver_encuestas();
		Encuesta encuestaEncontrada = null;
		
		for(Encuesta cadaEncuesta : lasEncuestas)
		{
			if(cadaEncuesta.getIdentificador() == encuesta.getIdentificador())
			{
				encuestaEncontrada = cadaEncuesta;
				break;
			}
		}
		
		return encuestaEncontrada;
	}
}
