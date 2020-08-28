package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datos.Constantes;
import datos.GestorAsignaturas;
import datos.GestorEncuestas;
import datos.GestorEstudiantes;
import mundo.Asignatura;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaInicioSesion extends JFrame
{
	private JPanel contentPane;
	private JTextField txtCod;
	private JPasswordField txtPass;
	private Controlador control;
	
	/**
	 * Constructor de la clase Ventana_Inicial
	 */
	public VentanaInicioSesion(Controlador control)
	{
		this.control = control;
		
		setTitle("Sistema de gesti\u00F3n de clases");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 401, 222);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCod = new JLabel("C\u00F3digo");
		lblCod.setHorizontalAlignment(SwingConstants.LEFT);
		lblCod.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCod.setBounds(44, 35, 100, 30);
		contentPane.add(lblCod);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setHorizontalAlignment(SwingConstants.LEFT);
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblContrasea.setBounds(44, 91, 100, 30);
		contentPane.add(lblContrasea);
		
		txtCod = new JTextField();
		txtCod.setBounds(186, 37, 150, 30);
		contentPane.add(txtCod);
		txtCod.setColumns(10);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(186, 93, 150, 30);
		contentPane.add(txtPass);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setActionCommand(Constantes.COMANDO_BTN_INGRESAR);
		btnIngresar.addActionListener(this.control);
		btnIngresar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnIngresar.setBounds(140, 138, 100, 34);
		contentPane.add(btnIngresar);
	}
	/**
	 * Metodo que devuelve lo ingresado en el campo codigo
	 * @return String
	 */
	public String getTxtCod() {
		return txtCod.getText();
	}
	/**
	 * Metodo que devuelve lo ingresado en el campo contraseña
	 * @return String
	 */
	public String getTxtPass()
	{
		String contrasenia = "";
		char [] contraseniaEn = txtPass.getPassword();
		for(int cadaCar = 0; cadaCar < contraseniaEn.length; cadaCar++)
		{
			contrasenia += contraseniaEn[cadaCar];
		}
		
		return contrasenia;
	}
	/**
	 * Metodo que limpia los campos txt
	 */
	public void limpiarCampos()
	{
		txtCod.setText("");
		txtPass.setText("");
	}
}
