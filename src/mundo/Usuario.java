package mundo;

import java.util.ArrayList;

import datos.GestorEstudiantes;

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
	
	protected GestorEstudiantes gestor_Estudiantes;
	
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
		return false;
	}
	
	/**
	 * Retorna la lista de asignatura de cada estudiante 
	 * @return ArrayList<Asignatura>
	 */
	public ArrayList<Asignatura> ver_asignaturas()
	{
		return new ArrayList<Asignatura>();
	}	

}
