package Mundo;

import java.util.ArrayList;

public abstract class Usuario {
	
	/**
	 * Codigo del Usuario
	 */
	protected String codigo;
	
	/**
	 * Contraseña del Usuario
	 */
	protected String contraseña;
	
	/**
	 * Constructor de la clase Usuario
	 */
	public Usuario(String codigo, String contraseña)
	{
		this.codigo = codigo;
		this.contraseña = contraseña;
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
