package mundo;

public class Encuesta
{	
	/**
	 * Lista de preguntas Cuantitativas
	 */
	private String preguntas_cuantitativas[];
	
	/**
	 * Lista de respuestas Cuantitativas
	 */
	private int respuestas_cuantitativas[];
	
	/**
	 * Pregunta abierta
	 */
	private String pregunta_abierta;
	
	/**
	 * Respuesta a la pregunta abierta
	 */
	private String respuesta_abierta;
	
	/**
	 * Constructor de la clase Encuesta
	 */
	public Encuesta(String[] preguntas_cuantitativas, int[] respuestas_cuantitativas, String pregunta_abierta,
			String respuesta_abierta) {

		this.preguntas_cuantitativas = preguntas_cuantitativas;
		this.respuestas_cuantitativas = respuestas_cuantitativas;
		this.pregunta_abierta = pregunta_abierta;
		this.respuesta_abierta = respuesta_abierta;
	}

	public String[] getPreguntas_cuantitativas() {
		return preguntas_cuantitativas;
	}

	public void setPreguntas_cuantitativas(String[] preguntas_cuantitativas) {
		this.preguntas_cuantitativas = preguntas_cuantitativas;
	}

	public int[] getRespuestas_cuantitativas() {
		return respuestas_cuantitativas;
	}

	public void setRespuestas_cuantitativas(int[] respuestas_cuantitativas) {
		this.respuestas_cuantitativas = respuestas_cuantitativas;
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
	
	
}
