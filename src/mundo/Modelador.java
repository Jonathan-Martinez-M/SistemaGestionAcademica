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
	public boolean RegistrarEstudiante(String codigo, String nombre, String apellidos, String ciudad,String barrio, String contrasenia)
	{
		Estudiante nuevaEstudiante = new Estudiante(codigo, contrasenia, nombre, apellidos, ciudad, barrio, null);
		
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
	public boolean modificarEstudiante(String nombre, String apellido, String ciudad,String barrio, String contrasegna) 
	{
		Estudiante nuevoEstudiante = GestorEstudiantes.buscarEstudiante(((Estudiante)usuarioLogueado).getCodigo());

		nuevoEstudiante.setNombres(nombre);
		nuevoEstudiante.setApellidos(apellido);
		nuevoEstudiante.setCiudad(ciudad);
		nuevoEstudiante.setBarrio(barrio);
		nuevoEstudiante.setContrasegna(contrasegna);
		return((Estudiante)usuarioLogueado).modificar_estudiante(GestorEstudiantes.buscarEstudiante(((Estudiante)usuarioLogueado).getCodigo()), nuevoEstudiante);
	}
	
	public boolean modificarEstudianteAdmin(String codViejo, String codNuevo, String nombre, String apellido, String ciudad,String barrio, String contrasegna)
	{
		Estudiante viejoEstudiante = GestorEstudiantes.buscarEstudiante(codViejo);
		Estudiante nuevoEstudiante = new Estudiante(codNuevo, viejoEstudiante.getContrasegna(), nombre, apellido, ciudad, barrio, null);
		
		return((Administrador)usuarioLogueado).modificar_estudiante(viejoEstudiante, nuevoEstudiante, contrasegna);
	}
	
	/**
	 * matricula una asignatura a un estudiante 
	 * @return boolean
	 */
	public boolean matricular(String asignatura, String estudiante)
	{
		System.out.println("Matruclando");
		Encuesta laEncuesta = GestorEncuestas.nuevaEncuestaRetasVacias();
		laEncuesta.setIdentificador(GestorEncuestas.obtenerUltimoIdentificador());
		Matricula nuevaMatricula = new Matricula(estudiante, asignatura, laEncuesta);
		
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
			if(((Estudiante) usuarioLogueado).getMatriculas().get(cadaMatricula).getEncuesta().getIdentificador() == encuestaNueva.getIdentificador())
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
	
	public ArrayList<Ciudad> ver_ciudades(){
		return GestorEstudiantes.ver_ciudades();
	}
	
	public ArrayList<Barrio> ver_barrios(String ciudad)
	{
		Ciudad ciudad1 = new Ciudad(ciudad, null);
		
		return GestorEstudiantes.ver_barrios_de_una_ciudad(ciudad1);
	}
	
	public ArrayList<Encuesta> obtenerEncuestaPorAsign(String codigoAsign)
	{
		Asignatura asignaturaApoyo = new Asignatura(null, codigoAsign, new ArrayList<Matricula>());
		ArrayList<Matricula> matriculasPorAsign = GestorAsignaturas.buscarMatriculasAsign(asignaturaApoyo);
		ArrayList<Encuesta> lasEncuestas = new ArrayList<Encuesta>();
		
		for(Matricula cadaMat : matriculasPorAsign)
		{
			lasEncuestas.add(GestorEncuestas.buscarEncuestaPoId(cadaMat.getEncuesta()));
		}
		
		return lasEncuestas;
	}
	
	/**
	 * Evalua sobre un ArrayList de encuestas las encuestas que ya han sido respondidas
	 * 
	 * @param lasEncuestas las encuestas a revisar
	 * @return ArrayList<Encuesta>
	 */
	public ArrayList<Encuesta> encuestasRespondidas(ArrayList<Encuesta> lasEncuestas)
	{
		ArrayList<Encuesta> respondidas = new ArrayList<Encuesta>();
		
		for(Encuesta cadaEncuesta : lasEncuestas)
		{
			if(!cadaEncuesta.getRespuesta_abierta().equals(Constantes.PREGUNTA_SIN_RESPONDER))
			{
				respondidas.add(cadaEncuesta);
			}
		}
		
		return respondidas;
	}
	
	public double[][] calcularPorcentajesEncuestas(ArrayList<Encuesta> lasEncuyestas)
	{
		double [][] porcentajes = new double[5][4];
		int cantidadEncuestas = lasEncuyestas.size();
		
		for (int cadaEncuesta = 0; cadaEncuesta < lasEncuyestas.size(); cadaEncuesta++)
		{
			for(int cadaPregunta = 0; cadaPregunta < Constantes.CANTIDAD_PREGUNTAS_CUANTITATIVAS; cadaPregunta++)
			{
				switch (lasEncuyestas.get(cadaEncuesta).getRespuestas_cuantitativas().get(cadaPregunta))
				{
				case "1":
					porcentajes[0][cadaPregunta]++;
					break;
				case "2":
					porcentajes[1][cadaPregunta]++;
					break;
				case "3":
					porcentajes[2][cadaPregunta]++;		
					break;
				case "4":
					porcentajes[3][cadaPregunta]++;
					break;
				case "5":
					porcentajes[4][cadaPregunta]++;
					break;
				default:
					break;
				}
			}
		}
		
		for (int i = 0; i < porcentajes.length; i++)
		{
			for (int j = 0; j < porcentajes[i].length; j++)
			{
				porcentajes[i][j] = (double)(porcentajes[i][j]/cantidadEncuestas) * 100;
			}
		}
		
		return porcentajes;
	}
	
	public Boolean borrarEncuestas()
	{
		Encuesta enuestaVacia = obtetnerEncuestaDummy();
		ArrayList<Encuesta> lasEncuestas = GestorEncuestas.ver_encuestas();
		ArrayList<Encuesta> lasRespondidas = encuestasRespondidas(lasEncuestas);
		ArrayList<Encuesta> lasVacias = new ArrayList<Encuesta>();
		int encuestasEncointradas = 0;
		
		for(Encuesta cadaEncuesta : lasRespondidas)
		{
			enuestaVacia.setIdentificador(cadaEncuesta.getIdentificador());
			
			GestorEncuestas.modificarEncuesta(cadaEncuesta, enuestaVacia);
			encuestasEncointradas++;
		}
		
		return true;
	}
}
