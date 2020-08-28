/**
 * 
 */
package mundo;

import java.util.ArrayList;
import java.util.Iterator;

import datos.Constantes;
import datos.GestorAsignaturas;
import datos.GestorEncuestas;
import datos.GestorEstudiantes;

/**
 * @author Rubén Fúquene
 *
 */
public class Modelador
{
	/**
	 * usuario logueado en el sistema
	 */
	Usuario usuarioLogueado;
	
	/**
	 * constructor clase Modelador
	 */
	public Modelador()
	{
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Inicia sesión en el sistema 
	 * @return String
	 */
	public String iniciarSesion(String codigo, String contrasenia)
	{
		if(codigo.equals(Constantes.CODIGO_ADMIN) && contrasenia.equals(Constantes.CONTRASENIA_ADMIN))
		{
			usuarioLogueado = new Administrador(codigo, contrasenia);
			return Constantes.USUARIO_ADMIN;
		}else if((GestorEstudiantes.ingresar(codigo, contrasenia)) == true)
		{
			usuarioLogueado = new Estudiante(codigo, contrasenia, null, null, null, null, null);
			return Constantes.USUARIO_ESTUDIANTE;
			//Consulta en BD
		}
		
		return Constantes.USUARIO_ERRONEO;
	}
	
	/**
	 * Registra una asignatura 
	 * @return boolean
	 */
	public boolean RegistrarAsignatura(String codigo, String nombre)
	{
		Asignatura nuevaAsignatura = new Asignatura(nombre, codigo, null);
		
		return ((Administrador) usuarioLogueado).agregar_asignatura(nuevaAsignatura);
	}
	
	/**
	 * Registra un estudiante 
	 * @return boolean
	 */
	public boolean RegistrarEstudiante(String codigo, String nombre, String apellidos, String ubicacion, String contrasenia)
	{
		Estudiante nuevaEstudiante = new Estudiante(codigo, contrasenia, nombre, apellidos, ubicacion, ubicacion, null);
		
		return ((Administrador) usuarioLogueado).agregar_estudiante(nuevaEstudiante);
	}
	
	/**
	 * Muestra la lista de asignaturas 
	 * @retunr ArrayList<Asignatura>
	 */
	public ArrayList<Asignatura> listarAsignaturas()
	{
		return GestorAsignaturas.ver_asignaturas();
	}

	/**
	 * Muestra la lista de estudiantes 
	 * @retunr ArrayList<Asignatura>
	 */
	public ArrayList<Estudiante> ver_estudiantes()
	{
		return GestorEstudiantes.ver_estudiantes();
	}
	
	/**
	 * Modifica un estudiante 
	 * @return boolean
	 */
	public boolean ModificarEstudiante(String nombre, String apellido, String ubicacion, String contrasegna) 
	{
		Estudiante nuevoEstudiante = GestorEstudiantes.buscarEstudiante(((Estudiante)usuarioLogueado).getCodigo());

		nuevoEstudiante.setNombres(nombre);
		nuevoEstudiante.setApellidos(apellido);
		nuevoEstudiante.setCiudad(ubicacion);
		nuevoEstudiante.setBarrio(ubicacion);
		nuevoEstudiante.setContrasegna(contrasegna);
		return((Estudiante)usuarioLogueado).modificar_estudiante(GestorEstudiantes.buscarEstudiante(((Estudiante)usuarioLogueado).getCodigo()), nuevoEstudiante);
	}
	
	/**
	 * matricula una asignatura a un estudiante 
	 * @return boolean
	 */
	public boolean matricular(String asignatura, String estudiante)
	{
		Encuesta laEncuesta = GestorEncuestas.nuevaEncuestaRetasVacias();
		laEncuesta.setIdentificador(GestorEncuestas.obtenerUltimoIdentificador());
		Matricula nuevaMatricula = new Matricula(asignatura, estudiante, laEncuesta);
		
		GestorEncuestas.almacenar_encuesta(laEncuesta);
		return GestorAsignaturas.almacenar_matricula(nuevaMatricula);
	}
	
	/**
	 * Muestra las matrículas del estudiante 
	 * @retunr ArrayList<Asignatura>
	 */
	public ArrayList<Matricula> obtenerMatriculasEstudiantes()
	{
		Estudiante elEstudiante = (Estudiante) usuarioLogueado;
		return GestorAsignaturas.buscarMatriculasEstudiantes(elEstudiante);
	}
	
	public Asignatura buscarAsignaturaPorCodigo(String codigo)
	{
		return GestorAsignaturas.buscarAsignaturaCod(codigo);
	}
	
	public Encuesta obtetnerEncuestaDummy()
	{
		return GestorEncuestas.nuevaEncuestaRetasVacias();
	}
	
	/**
	 * 
	 * @return
	 */
	public Boolean agregarEncuestaRespondida(String identificador, String[] respuestas, String respuestaAbiertta)
	{
		cargarEncuestasEstudiante();
		
		Boolean resppuestasModificadas = true;
		Encuesta encuestaNueva = new Encuesta(((Estudiante) usuarioLogueado).getMatriculas().get(0).getEncuesta().getPreguntas_cuantitativas(),
				((Estudiante) usuarioLogueado).getMatriculas().get(0).getEncuesta().getPregunta_abierta());
		encuestaNueva.setIdentificador(Integer.parseInt(identificador));
		encuestaNueva.setRespuesta_abierta(respuestaAbiertta);
		
		for(int cadaRta = 0; cadaRta < respuestas.length; cadaRta++)
		{
			encuestaNueva.agregar_Respuestas_cuantitativas(cadaRta, respuestas[cadaRta]);
		}
		
		for(int cadaMatricula = 0; cadaMatricula < ((Estudiante) usuarioLogueado).getMatriculas().size(); cadaMatricula++)
		{
			if(((Estudiante) usuarioLogueado).getMatriculas().get(cadaMatricula).getEncuesta().equals(encuestaNueva.getIdentificador()))
				GestorEncuestas.modificarEncuesta(((Estudiante) usuarioLogueado).getMatriculas().get(cadaMatricula).getEncuesta(), encuestaNueva);
		}
		
		return resppuestasModificadas;
	}
	
	private void cargarEncuestasEstudiante()
	{
		((Estudiante) usuarioLogueado).setMatriculas(this.obtenerMatriculasEstudiantes());
		
		for (int cadaMatricula = 0; cadaMatricula < ((Estudiante) usuarioLogueado).getMatriculas().size(); cadaMatricula++)
		{
			Encuesta unaEncuesta = ((Estudiante) usuarioLogueado).getMatriculas().get(cadaMatricula).getEncuesta();
			((Estudiante) usuarioLogueado).getMatriculas().get(cadaMatricula).setEncuesta(GestorEncuestas.buscarEncuestaPoId(unaEncuesta)); 
		}
	}

	/**
	 * Getter usuario logueado 
	 */
	public Usuario getUsuarioLogueado()
	{
		return usuarioLogueado;
	}
}
