/**
 * 
 */
package mundo;

import datos.Constantes;

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
		}else
		{
			//Consulta en BD
		}
		
		return Constantes.USUARIO_ERRONEO;
	}
	
	public boolean RegistrarAsignatura(String codigo, String nombre)
	{
		Asignatura nuevaAsignatura = new Asignatura(nombre, codigo, null);
		
		((Administrador) usuarioLogueado).agregar_asignatura(nuevaAsignatura);
		
		return true;
	}
	
	public boolean RegistrarEstudiante(String nombres, String apellidos, String codigo, String ciudad, String barrio) {
		
		Estudiante nuevoEstudiante = new Estudiante(codigo, contraseña, nombres, apellidos, ciudad, barrio, materias);
		
		((Administrador) usuarioLogueado).agregar_estudiante(nuevoEstudiante);
		
		return true;
	}
}		
