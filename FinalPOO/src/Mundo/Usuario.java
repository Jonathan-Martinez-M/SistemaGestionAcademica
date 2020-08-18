package Mundo;

import java.util.ArrayList;

public abstract class Usuario {
	
	/**
	 * Codigo del Usuario
	 */
	protected String codigo;
	
	/**
	 * Contraseņa del Usuario
	 */
	protected String contraseņa;
	
	/**
	 * Constructor de la clase Usuario
	 */
	public Usuario(String codigo, String contraseņa)
	{
		this.codigo = codigo;
		this.contraseņa = contraseņa;
	}
	
	/**
	 * Modifica los atributos de un estudiante 
	 * @return boolean 
	 */
	public boolean modificar_estudiante() 
	{
		
	}
	
	/**
	 * Retorna la lista de asignatura de cada estudiante 
	 * @return ArrayList<Asignatura>
	 */
	public ArrayList ver_asignaturas()
	{
		
	}	

}
