package Mundo;

import java.util.ArrayList;

public class  Administrador extends Usuario {
	
	
	/**
	 * Constructor de la clase Administrador
	 */
	public Administrador(String codigo, String contraseņa) 
	{
		super(codigo, contraseņa);
	}

	/**
	 * Agrega un estudiante
	 * @return boolean
	 */
	public boolean agregar_estudiante(Estudiante p) 
	{
		return true;
	}
	
	/**
	 * Modifica un la informacion de un estudiante
	 * @return boolean
	 */
	public boolean  modificar_estudiante( Estudiante p) 
	{
		return true;
	}
	
	/**
	 * Agrega una asignatura
	 * @return boolean
	 */
	public boolean agregar_asignatura(Asignatura p) 
	{
		return true;
	}
	
	/**
	 * Modifica una asignatura
	 * @return boolean
	 */
	public boolean modificar_asignatura(Asignatura p) 
	{
		return true;
	}
	
	/**
	 * Muestra la lista de encuestas de cada asignatura
	 * @return ArrayList<Encuesta>
	 */
	public ArrayList<Encuesta> ver_encuestas()
	{
		return new ArrayList<Encuesta>();
	}
	
	/**
	 * Muestra la lista de estudiantes
	 * @return ArrayList<Estudiante>
	 */
	public ArrayList<Estudiante> ver_estudiantes()
	{
		return new ArrayList<Estudiante>();
	}
}
