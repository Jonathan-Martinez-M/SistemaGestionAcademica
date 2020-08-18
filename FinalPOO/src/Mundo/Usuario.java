package Mundo;

import java.util.ArrayList;

public abstract class Usuario {
	
	/**
	 * Codigo del Usuario
	 */
	protected String codigo;
	
	/**
	 * Contrase�a del Usuario
	 */
	protected String contrase�a;
	
	/**
	 * Constructor de la clase Usuario
	 */
	public Usuario(String codigo, String contrase�a)
	{
		this.codigo = codigo;
		this.contrase�a = contrase�a;
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
