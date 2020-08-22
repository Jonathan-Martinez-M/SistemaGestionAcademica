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
	public boolean  modificar_estudiante( Estudiante p) 
	{
		return GestorEstudiantes.modificar_estudiante(p);
	}
	
	/**
	 * Agrega una asignatura
	 * @return boolean
	 */
	public boolean agregar_asignatura(Asignatura p) 
	{
		return GestorAsignaturas.agregar_asignatura(p);
	}
	
	/**
	 * Modifica una asignatura
	 * @return boolean
	 */
	public boolean modificar_asignatura(Asignatura p) 
	{
		return GestorAsignaturas.modificar_asignatura(p);
	}
	
	/**
	 * Muestra la lista de encuestas de cada asignatura
	 * @return ArrayList<Encuesta>
	 */
	public ArrayList<Encuesta> ver_encuestas()
	{
		return GestorEncuestas.ver_encuestas();
	}
	
	/**
	 * Muestra la lista de estudiantes
	 * @return ArrayList<Estudiante>
	 */
	public ArrayList<Estudiante> ver_estudiantes()
	{
		return  GestorEstudiantes.ver_estudiante();
	}
	
	
}
