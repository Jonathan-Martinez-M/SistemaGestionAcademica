package mundo;

import java.util.ArrayList;

public  class Asignatura  {
	
	/**
	 * Nombre de la asignatura
	 */
	private String nombre;
	
	/**
	 * Codigo de la asignatura
	 */
	private String codigo;
	
	/**
	 * Lista de matriculas de la asignatura
	 */
	private ArrayList<Matricula> matriculas;
	
	/**
	 * Constructor de la clase Asignatura
	 */	
	
	public Asignatura(String nombre, String codigo, ArrayList<Matricula> matriculas) {
		this.nombre = nombre;
		this.codigo = codigo;
		this.matriculas = matriculas;
	}

	/**
	 * Muestra los estudiantes matriculados en la asignatura
	 * @retunr ArrayList<Estudiantes>
	 */
	public ArrayList<Estudiante> ver_matriculados()
	{
		return new ArrayList<Estudiante>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
