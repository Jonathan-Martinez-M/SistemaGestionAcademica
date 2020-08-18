package Mundo;

public abstract class  Administrador extends Usuario {
	
	
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
		
		
	}
	
	/**
	 * Modifica un la informacion de un estudiante
	 * @return boolean
	 */
	public boolean  modificar_estudiante( Estudiante p) 
	{
		
	}
	
	/**
	 * Agrega una asignatura
	 * @return boolean
	 */
	public boolean agregar_asignatura(Asignatura p) 
	{
		
		
	}
	
	/**
	 * Modifica una asignatura
	 * @return boolean
	 */
	public boolean modificar_asignatura(Asignatura p) 
	{
		
		
	}
	
	/**
	 * Muestra la lista de encuestas de cada asignatura
	 * @return ArrayList<Encuesta>
	 */
	public ArrayList<Encuesta> ver_encuestas()
	{
		
	}
	
	/**
	 * Muestra la lista de estudiantes
	 * @return ArrayList<Estudiante>
	 */
	public ArrayList<Estudiante> ver_estudiantes()
	{
		
	}
}
