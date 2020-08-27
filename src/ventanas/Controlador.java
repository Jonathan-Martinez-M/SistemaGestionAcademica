/**
 * 
 */
package ventanas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import datos.Constantes;
import datos.GestorAsignaturas;
import datos.GestorEncuestas;
import datos.GestorEstudiantes;
import mundo.Asignatura;
import mundo.Estudiante;
import mundo.Modelador;

/**
 * @author Rubén Fúquene
 * 
 * Clase encargada de recibir peticiones y enviar datos al modelador
 *
 */
public class Controlador implements ActionListener
{
	private Modelador modelo;
	private Ventana_Inicial ventanaLogin;
	private Ventana_Carga_Asignatura_Admin ventanaRegistroAsignatura;
	private Ventana_Carga_de_estudiantes ventanaRegistroEstudiante;
	private Ventana_Modificar_Datos ventanamodificardatos;
	
	/**
	 * 
	 */
	public Controlador()
	{
		// TODO Auto-generated constructor stub
		modelo = new Modelador();
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					GestorEstudiantes gEs = new GestorEstudiantes();
					GestorAsignaturas gAs = new GestorAsignaturas();
					GestorEncuestas gEn = new GestorEncuestas();
					Controlador controlador = new Controlador();
					Ventana_Inicial frame = new Ventana_Inicial(controlador);
					controlador.setVentanaLogin(frame);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});	
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{

		if(e.getSource().getClass().equals(new JButton().getClass()))
		{
			// Inicio de sesión
			if(e.getActionCommand().equals(Constantes.COMANDO_BTN_INGRESAR))
			{
				if(ventanaLogin.getTxtCod().equals("") || ventanaLogin.getTxtCod().equals(""))
				{
					ventanaLogin.limpiarCampos();
					JOptionPane.showMessageDialog( ventanaLogin, Constantes.CAMPOS_VACIOS, Constantes.USUARIO_ERRONEO, JOptionPane.INFORMATION_MESSAGE );
				}else if(modelo.iniciarSesion(ventanaLogin.getTxtCod(), ventanaLogin.getTxtPass()).equals(Constantes.USUARIO_ESTUDIANTE))
				{
					ventanaLogin.dispose();
					try
					{
						Ventana_Usuario frame = new Ventana_Usuario(this);
						frame.setVisible(true);
					} catch (Exception x)
					{
						x.printStackTrace();
					}
				}else if(modelo.iniciarSesion(ventanaLogin.getTxtCod(), ventanaLogin.getTxtPass()).equals(Constantes.USUARIO_ADMIN))
				{
					ventanaLogin.dispose();
					try
					{
						Ventana_Administrador frame = new Ventana_Administrador(this);
						frame.setVisible(true);
					} catch (Exception e3) {
						e3.printStackTrace();
					}
				}else if(modelo.iniciarSesion(ventanaLogin.getTxtCod(), ventanaLogin.getTxtPass()).equals(Constantes.USUARIO_ERRONEO))
				{
					ventanaLogin.limpiarCampos();
					JOptionPane.showMessageDialog( ventanaLogin, Constantes.MENSAJE_LOGIN_FALLIDO, Constantes.USUARIO_ERRONEO, JOptionPane.INFORMATION_MESSAGE );
				}
			}
			//Abre ventana para registrar una nueva asignatura
			else if(e.getActionCommand().equals(Constantes.COMANDO_BTN_VTNA_CARGAR_ASIGNATURA))
			{
				try 
				{
					Ventana_Carga_Asignatura_Admin dialog = new Ventana_Carga_Asignatura_Admin(this);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				}catch (Exception e2)
				{
					e2.printStackTrace();
				}
			}
			//Almacena una asignatura en BD
			else if(e.getActionCommand().equals(Constantes.COMANDO_BTN_REGISTRAR_ASIGNATURA))
			{
				if(modelo.RegistrarAsignatura(ventanaRegistroAsignatura.getTxtCodAsign(), ventanaRegistroAsignatura.getTxtNomAsign()))
				{
					this.ventanaRegistroAsignatura.dispose();
					JOptionPane.showMessageDialog(null, Constantes.CARGA_EXITOSA_ASIGNATURA);
				}
			}
			//Abre ventana para registrar un nuevo estudiante
			else if(e.getActionCommand().equals(Constantes.COMANDO_BTN_VTNA_CARGAR_ESTUDIANTE))
			{
				try
				{
					Ventana_Carga_de_estudiantes dialog = new Ventana_Carga_de_estudiantes(this);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e2)
				{
					e2.printStackTrace();
				}
			}
			//Registra a un estudiante nuevo
			else if(e.getActionCommand().equals(Constantes.COMANDO_BTN_REGISTRAR_ESTUDIANTE))
			{
				if(modelo.RegistrarEstudiante(ventanaRegistroEstudiante.getTxtCodigo(), ventanaRegistroEstudiante.getTxtNombre(),ventanaRegistroEstudiante.getTxtApellido(), ventanaRegistroEstudiante.getTxtUbicacion(), ventanaRegistroEstudiante.getTxtContrasenia()))
				{
					this.ventanaRegistroEstudiante.dispose();
					JOptionPane.showMessageDialog(null, Constantes.CARGA_EXITOSA_ESTUDIANTE);
				}
			}
			//Abre ventana para registrar un nuevo estudiante
			else if(e.getActionCommand().equals(Constantes.COMANDO_BTN_VTNA_LISTA_ASIGNATURAS))
			{
				try
				{
					Ventana_Lista_Asignatura_Admin dialog = new Ventana_Lista_Asignatura_Admin(this);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e2)
				{
					e2.printStackTrace();
				}
			}
			else if(e.getActionCommand().equals(Constantes.COMANDO_BTN_VTNA_LISTA_ESTUDIANTES)) {
				try
				{
					Lista_de_estudiantes dialog = new Lista_de_estudiantes(this);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e2)
				{
					e2.printStackTrace();
				}
			}
			else if(e.getActionCommand().equals(Constantes.COMANDO_BTN_VTNA_MODIFICACION_DE_DATOS)) {
				try
				{
					Ventana_Modificar_Datos dialog = new Ventana_Modificar_Datos(this);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			else if(e.getActionCommand().equals(Constantes.COMANDO_BTN_MODIFICACION_DE_DATOS)) {
				
				if(modelo.ModificarEstudiante(ventanamodificardatos.getTextNombre(), ventanamodificardatos.getTextApellido(), ventanamodificardatos.getTextUbicacion(), null)){
					
					this.ventanamodificardatos.dispose();
					JOptionPane.showMessageDialog(null, Constantes.MODIFICACION_EXITOSA_ESTUDIANTE);
				}
			}
		}
	}
	
	public ArrayList<Asignatura> listarAsignaturas()
	{
		return modelo.listarAsignaturas();
	}

	public ArrayList<Estudiante> listarEstudiantes()
	{
		return modelo.ver_estudiantes();
	}
	
	public void setVentanaLogin(Ventana_Inicial ventanaLogin)
	{
		this.ventanaLogin = ventanaLogin;
	}

	public void setVentanaRegistroAsignatura(Ventana_Carga_Asignatura_Admin ventanaRegistroAsignatura)
	{
		this.ventanaRegistroAsignatura = ventanaRegistroAsignatura;
	}

	public void setVentanaRegistroEstudiante(Ventana_Carga_de_estudiantes ventanaRegistroEstudiante)
	{
		this.ventanaRegistroEstudiante = ventanaRegistroEstudiante;
	}	
	
	public void setVentanaModificarDatos(Ventana_Modificar_Datos ventanaModificarDatos) 
	{
		this.ventanamodificardatos = ventanaModificarDatos;
	}
}
