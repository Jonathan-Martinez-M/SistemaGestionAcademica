package Mundo;

import java.util.ArrayList;

public class Matricula {

	private String  pertenece_a_estudiante;
	
	/**
	 * Codigo de estudiante
	 */
	private String de_la_asignatura;
	
	/**
	 * Codigo de la asignatura
	 */
	private Encuesta encuesta;
	
	
	/**
	 * Constructor de la clase Matricula
	 */
	public Matricula(String pertenece_a_estudiante, String de_la_asignatura, Encuesta encuesta) {
		
		this.pertenece_a_estudiante = pertenece_a_estudiante;
		this.de_la_asignatura = de_la_asignatura;
		this.encuesta = encuesta;
	}
	
	/**
	 * Consigue un estudiante 
	 * @return Estudiante
	 */
	public Estudiante obtener_estudiante()
	{
		return new Estudiante("", "", "", "", "", "", new ArrayList<Matricula>());
	}
	
	/**
	 * Consigue una asignatura 
	 * @return Asignatura
	 */
	public Asignatura obtener_asignatura()
	{
		return new Asignatura("", "", new ArrayList<Matricula>());
	}
	
	/**
	 * Realiza una encuesta
	 * @return boolean
	 */
	public boolean hacer_encuesta(Encuesta p)
	{
		return true;
	}
	
	
}
