package mundo;

import java.util.ArrayList;

import datos.GestorEstudiantes;

public class  Administrador extends Usuario {
	
	
	
	private Object gestor_Encuesta;
	private Object gestor_Estudiante;

	/**
	 * Constructor de la clase Administrador
	 */
	public Administrador(String codigo, String contraseña) 
	{
		super(codigo, contraseña);
	}

	/**
	 * Agrega un estudiante
	 * @return boolean
	 */
	public boolean agregar_estudiante(Estudiante p) 
	{
		return this.gestor_Estudiantes.agregar_estudiante(p);
	}
	
	/**
	 * Modifica un la informacion de un estudiante
	 * @return boolean
	 */
	public boolean  modificar_estudiante( Estudiante p) 
	{
		return this.gestor_Estudiantes.modificar_estudiante(p);
	}
	
	/**
	 * Agrega una asignatura
	 * @return boolean
	 */
	public boolean agregar_asignatura(Asignatura p) 
	{
		return this.gestor_Asignatura.agregar_asignatura(p);
	}
	
	/**
	 * Modifica una asignatura
	 * @return boolean
	 */
	public boolean modificar_asignatura(Asignatura p) 
	{
		return this.gestor_Asignatura.modificar_asignatura(p);
	}
	
	/**
	 * Muestra la lista de encuestas de cada asignatura
	 * @return ArrayList<Encuesta>
	 */
	public ArrayList<Encuesta> ver_encuestas()
	{
		return  ((Administrador) this.gestor_Encuesta).ver_encuestas();
	}
	
	/**
	 * Muestra la lista de estudiantes
	 * @return ArrayList<Estudiante>
	 */
	public ArrayList<Estudiante> ver_estudiantes()
	{
		return  ((GestorEstudiantes) this.gestor_Estudiante).ver_estudiante();
	}
	
	
}
