package mundo;

import java.util.ArrayList;

import datos.GestorAsignaturas;
import datos.GestorEncuestas;
import datos.GestorEstudiantes;

public class  Administrador extends Usuario {

	/**
	 * Constructor de la clase Administrador
	 */
	public Administrador(String codigo, String contrasenia) 
	{
		super(codigo, contrasenia);
	}

	/**
	 * Agrega un estudiante
	 * @return boolean
	 */
	public boolean agregar_estudiante(Estudiante p) 
	{
		return GestorEstudiantes.agregar_estudiante(p);
	}
	
	/**
	* Modifica un la informacion de un estudiante
	* @return boolean
	*/
	public boolean  modificar_estudiante(Estudiante v, Estudiante n) 
	{
		return GestorEstudiantes.modificar_estudiante(v, n);
	}
	
	/**
	* Agrega una asignatura
	* @return boolean
	*/
	public boolean agregar_asignatura(Asignatura nuevaAsign) 
	{
		return GestorAsignaturas.agregar_asignatura(nuevaAsign);
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
		return null;
	}
	
	/**
	 * Muestra la lista de estudiantes
	 * @return ArrayList<Estudiante>
	 */
	public ArrayList<Estudiante> ver_estudiantes()
	{
		return  null;
	}
	
	
}
