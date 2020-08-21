package mundo;

import java.util.ArrayList;

import datos.GestorAsignaturas;
import datos.GestorEncuestas;
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
	
	protected GestorEstudiantes gestor_Estudiantes;
	
	protected GestorAsignaturas gestor_Asignatura;
	
	protected GestorEncuestas gestor_Encuestas;
	
	/**
	 * Constructor de la clase Usuario
	 */
	
	
	
	public Usuario(String codigo, String contraseña)
	{
		this.codigo = codigo;
		this.contraseña = contraseña;
		gestor_Estudiantes = new GestorEstudiantes();
		gestor_Asignatura = new GestorAsignaturas();
		gestor_Encuestas = new GestorEncuestas();
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
