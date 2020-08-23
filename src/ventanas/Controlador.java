/**
 * 
 */
package ventanas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import datos.Constantes;
import datos.GestorAsignaturas;
import datos.GestorEncuestas;
import datos.GestorEstudiantes;
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
		// Inicio de sesión
		if(e.getSource().getClass().equals(new JButton().getClass()))
		{
			if(e.getActionCommand().equals(Constantes.COMANDO_BTN_INGRESAR))
			{
				if(ventanaLogin.getTxtCod().equals("") || ventanaLogin.getTxtCod().equals(""))
				{
					ventanaLogin.limpiarCampos();
					JOptionPane.showMessageDialog( ventanaLogin, Constantes.CAMPOS_VACIOS, Constantes.USUARIO_ERRONEO, JOptionPane.INFORMATION_MESSAGE );
				}else if(modelo.iniciarSesion(ventanaLogin.getTxtCod(), ventanaLogin.getTxtPass()).equals(Constantes.USUARIO_ESTUDIANTE))
				{
					ventanaLogin.dispose();
					EventQueue.invokeLater(new Runnable()
					{
						public void run()
						{
							try
							{
								Ventana_Usuario frame = new Ventana_Usuario();
								frame.setVisible(true);
							} catch (Exception e)
							{
								e.printStackTrace();
							}
						}
					});
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
			}else if(e.getActionCommand().equals(Constantes.COMANDO_BTN_CARGAR_ASIGNATURA))
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
			}else if(e.getActionCommand().equals(Constantes.COMANDO_BTN_REGISTRAR_ASIGNATURA))
			{
				
				modelo.RegistrarAsignatura(ventanaRegistroAsignatura.getTxtCodAsign(), ventanaRegistroAsignatura.getTxtNomAsign());
			}
		}
	}

	public void setVentanaLogin(Ventana_Inicial ventanaLogin)
	{
		this.ventanaLogin = ventanaLogin;
	}

	public void setVentanaRegistroAsignatura(Ventana_Carga_Asignatura_Admin ventanaRegistroAsignatura)
	{
		this.ventanaRegistroAsignatura = ventanaRegistroAsignatura;
	}

}
