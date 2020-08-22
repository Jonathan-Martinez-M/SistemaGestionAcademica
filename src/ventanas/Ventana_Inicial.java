package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datos.GestorAsignaturas;
import datos.GestorEncuestas;
import datos.GestorEstudiantes;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana_Inicial extends JFrame {

	private JPanel contentPane;
	private JTextField txtCod;
	private JPasswordField txtPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/*
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana_Inicial frame = new Ventana_Inicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
		GestorEstudiantes g = new GestorEstudiantes();
		GestorEncuestas l = new GestorEncuestas();
		GestorAsignaturas s = new GestorAsignaturas();
		
	}

	/**
	 * Create the frame.
	 */
	public Ventana_Inicial()
	{
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
		btnIngresar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(true)
				{
					dispose();
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
				}else{
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								Ventana_Administrador frame = new Ventana_Administrador();
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
				
			}
		});
		btnIngresar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnIngresar.setBounds(140, 138, 100, 34);
		contentPane.add(btnIngresar);
	}
}
