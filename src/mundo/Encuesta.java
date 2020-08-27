package mundo;

import java.util.ArrayList;

public class Encuesta
{
	/**
	 * Lista de preguntas Cuantitativas
	 */
	private ArrayList<String> preguntas_cuantitativas;
	
	/**
	 * Lista de respuestas Cuantitativas
	 */
	private ArrayList<String> respuestas_cuantitativas;
	
	/**
	 * Pregunta abierta
	 */
	private String pregunta_abierta;
	
	/**
	 * Respuesta a la pregunta abierta
	 */
	private String respuesta_abierta;
	
	/*
	 * Identificador de la encuesta
	 */
	private int identificador;
	
	/**
	 * Constructor de la clase Encuesta
	 */
	public Encuesta(ArrayList<String> preguntas_cuantitativas, String pregunta_abierta)
	{
		this.preguntas_cuantitativas = preguntas_cuantitativas;
		this.pregunta_abierta = pregunta_abierta;
		
		this.respuestas_cuantitativas = new ArrayList<String>();
	}
	
	/**
	 * Agrega pregunta cuantitativa a la encuesta
	 */
	public void agregar_Pregunta_Cuantitativa(int posicion, String pregunta)
	{
		this.preguntas_cuantitativas.add(posicion, pregunta ) ;
	}


	public ArrayList<String> getPreguntas_cuantitativas() {
	return preguntas_cuantitativas;
	}

	public void setPreguntas_cuantitativas(ArrayList<String> preguntas_cuantitativas) {
		this.preguntas_cuantitativas = preguntas_cuantitativas;
	}
	
	public ArrayList<String> getRespuestas_cuantitativas() {
		return respuestas_cuantitativas;
	}
	
	public void agregar_Respuestas_cuantitativas(int posicion, String respuesta)
	{
		this.respuestas_cuantitativas.add(posicion, respuesta);
	}
	
	public String getPregunta_abierta() {
		return pregunta_abierta;
	}

	public void setPregunta_abierta(String pregunta_abierta) {
		this.pregunta_abierta = pregunta_abierta;
	}

	public String getRespuesta_abierta() {
		return respuesta_abierta;
	}

	public void setRespuesta_abierta(String respuesta_abierta) {
		this.respuesta_abierta = respuesta_abierta;
	}

	public int getIdentificador()
	{
		return identificador;
	}

	public void setIdentificador(int identificador)
	{
		this.identificador = identificador;
	}
	
	
}
