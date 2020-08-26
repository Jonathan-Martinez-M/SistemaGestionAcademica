package mundo;

import java.util.ArrayList;

import datos.GestorAsignaturas;
import datos.GestorEstudiantes;

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
	 * contraseña estudiante
	 */
	private String contrasegna;

	/**
	 * codigo estudiante
	 */
	private String codigo;

	/**
	 * Lista de las matriculas del estudiante
	 */
	private ArrayList<Matricula> matriculas ;
	
	/**
	 * Constructor de la clase Estudiante
	 */
	public Estudiante(String codigo, String contraseña, String nombre, String apellido, String ciudad, String barrio,
			ArrayList<Matricula> matriculas)
	{
		super(codigo, contraseña);
		this.nombres = nombre;
		this.apellidos = apellido;
		this.ciudad = ciudad;
		this.barrio = barrio;
		this.matriculas = matriculas;
		this.contrasegna = contraseña;
		this.codigo = codigo;
	}
	
	/**
	 * Modifica la informacion del estudiante exceptuando el codigo
	 * @return boolean
	 */
	public boolean modificar_estudiante(Estudiante v, Estudiante n) 
	{
		return  GestorEstudiantes.modificar_estudiante(v,n);
	}
	/**
	 * Matricula una asignatura 
	 * @return boolean
	 */
	public 	boolean matricular_asignatura(Asignatura p)
	{
		return GestorAsignaturas.agregar_asignatura(p);
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getBarrio() {
		return barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}
	
	public String getContrasegna() {
		return contrasegna;
	}

	public void setContrasegna(String contraseña) {
		this.contrasegna = contraseña;
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public ArrayList<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(ArrayList<Matricula> matriculas) {
		this.matriculas = matriculas;
	}
	
}
