/**
 * 
 */
package mundo;

import java.util.ArrayList;

import datos.Constantes;
import datos.GestorAsignaturas;
import datos.GestorEstudiantes;

/**
 * @author Rubén Fúquene
 *
 */
public class Modelador
{
	Usuario usuarioLogueado;
	
	/**
	 * 
	 */
	public Modelador()
	{
		// TODO Auto-generated constructor stub
	}
	
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
	
	public boolean RegistrarAsignatura(String codigo, String nombre)
	{
		Asignatura nuevaAsignatura = new Asignatura(nombre, codigo, null);
		
		return ((Administrador) usuarioLogueado).agregar_asignatura(nuevaAsignatura);
	}
	
	public boolean RegistrarEstudiante(String codigo, String nombre, String apellidos, String ubicacion, String contrasenia)
	{
		Estudiante nuevaEstudiante = new Estudiante(codigo, contrasenia, nombre, apellidos, ubicacion, ubicacion, null);
		
		return ((Administrador) usuarioLogueado).agregar_estudiante(nuevaEstudiante);
	}
	
	public ArrayList<Asignatura> listarAsignaturas()
	{
		return GestorAsignaturas.ver_asignatura();
	}
	
	public ArrayList<Estudiante> ver_estudiantes()
	{
		return GestorEstudiantes.ver_estudiantes();
	}
}
