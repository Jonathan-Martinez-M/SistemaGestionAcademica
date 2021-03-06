package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datos.Constantes;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Ventana_Usuario extends JFrame
{
	private JPanel contentPane;
	private Controlador control;
	/**
	 * Constructor de la clase Ventana_Usuario
	 */
	public Ventana_Usuario(Controlador control) {
		setTitle("Estudiantes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel escudo = new JPanel();
		escudo.setBounds(10, 11, 126, 104);
		contentPane.add(escudo);
		escudo.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Ventana_Usuario.class.getResource("/escudo_UD.jpeg")));
		lblNewLabel_1.setBounds(10, 11, 106, 82);
		escudo.add(lblNewLabel_1);
		
		JPanel subtitulo = new JPanel();
		subtitulo.setBounds(146, 11, 278, 104);
		contentPane.add(subtitulo);
		subtitulo.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SISTEMA DE GESTI\u00D3N");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(38, 26, 211, 25);
		subtitulo.add(lblNewLabel);
		
		JLabel lblDeAsignaturas = new JLabel("DE ASIGNATURAS");
		lblDeAsignaturas.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeAsignaturas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDeAsignaturas.setBounds(38, 54, 211, 25);
		subtitulo.add(lblDeAsignaturas);
		
		JButton btnCargarAsignatura = new JButton("Cargar Asignatura");
		btnCargarAsignatura.setActionCommand(Constantes.COMANDO_BTN_VTNA_CARGAR_ASIGNATURA_ESTUDIANTE);
		btnCargarAsignatura.addActionListener(control);
		btnCargarAsignatura.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCargarAsignatura.setBounds(10, 176, 135, 34);
		contentPane.add(btnCargarAsignatura);
		
		JButton btnModificacinDeDatos = new JButton("Modificaci\u00F3n de datos");
		btnModificacinDeDatos.setActionCommand(Constantes.COMANDO_BTN_VTNA_MODIFICACION_DE_DATOS);
		btnModificacinDeDatos.addActionListener(control);
		btnModificacinDeDatos.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnModificacinDeDatos.setBounds(289, 176, 135, 34);
		contentPane.add(btnModificacinDeDatos);
		
		JButton btnRealizarEncuestas = new JButton("Realizar Encuestas");
		btnRealizarEncuestas.setActionCommand(Constantes.COMANDO_BTN_VTNA_REALIZAR_ENCUESTAS);
		btnRealizarEncuestas.addActionListener(control);
		btnRealizarEncuestas.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnRealizarEncuestas.setBounds(150, 176, 135, 34);
		contentPane.add(btnRealizarEncuestas);
	}
}
