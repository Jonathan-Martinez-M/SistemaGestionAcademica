package mundo;

import java.util.ArrayList;

public class Estudiante extends Usuario
{	
	/**
	 * Codigo del estudiante
	 */
	private String nombres;

	/**
	 * Apellido del estudiante
	 */
	private String apellidos;
	
	/**
	 * Ciudad del estudiante
	 */
	private String ciudad;
	
	/**
	 * Barrio del estudiante
	 */
	private String barrio;
	
	/**
	 * Lista de las matriculas del estudiante
	 */
	private ArrayList<Matricula> matriculas ;
	
	/**
	 * Constructor de la clase Estudiante
	 */
	public Estudiante(String codigo, String contrase�a, String nombre, String apellido, String ciudad, String barrio,
			ArrayList<Matricula> matriculas)
	{
		super(codigo, contrase�a);
		this.nombres = nombre;
		this.apellidos = apellido;
		this.ciudad = ciudad;
		this.barrio = barrio;
		this.matriculas = matriculas;
	}
	
	/**
	 * Modifica la informacion del estudiante exceptuando el codigo
	 * @return boolean
	 */
	public boolean modificar_estudiante(Estudiante p) 
	{
		this.gestor_Estudiantes.modificar_estudiante(p);
		return true;
	}
	/**
	 * Matricula una asignatura 
	 * @return boolean
	 */
	public 	boolean matricular_asignatura(Asignatura p)
	{
		return true;
	}
	
	
}
