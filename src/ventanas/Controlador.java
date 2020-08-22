/**
 * 
 */
package ventanas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import datos.Constantes;
import mundo.Modelador;

/**
 * @author Rubén Fúquene
 *
 */
public class Controlador implements ActionListener
{
	private Modelador modelo;
	private Ventana_Inicial ventanaLogin;
	
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
				if(modelo.iniciarSesion(ventanaLogin.getTxtCod(), ventanaLogin.getTxtPass()).equals(Constantes.USUARIO_ESTUDIANTE))
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
					EventQueue.invokeLater(new Runnable()
					{
						public void run()
						{
							try {
								Ventana_Administrador frame = new Ventana_Administrador();
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}else
				{
					ventanaLogin.limpiarCampos();
					JOptionPane.showMessageDialog( ventanaLogin, Constantes.MENSAJE_LOGIN_FALLIDO, "Ocupación del avión", JOptionPane.INFORMATION_MESSAGE );
				}
			}
		}
	}

	public void setVentanaLogin(Ventana_Inicial ventanaLogin)
	{
		this.ventanaLogin = ventanaLogin;
	}

}
