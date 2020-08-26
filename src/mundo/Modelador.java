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
		
		return ((Administrador) usuarioLogueado).agregar_asignatura(nuevaAsignatura);
	}
	
	public boolean RegistrarEstudiante(String codigo, String nombre)
	{
		Asignatura nuevaAsignatura = new Asignatura(nombre, codigo, null);
		
		return ((Administrador) usuarioLogueado).agregar_asignatura(nuevaAsignatura);
	}
}
