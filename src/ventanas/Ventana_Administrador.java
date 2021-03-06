package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datos.Constantes;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana_Administrador extends JFrame
{
	private Controlador control;
	private JPanel contentPane;

	/**
	 * Constructor de la clase  Ventana_Administrador
	 */
	public Ventana_Administrador(Controlador control)
	{
		this.control = control;
		setTitle("Ventana de Administrador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 322);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel escudo = new JPanel();
		escudo.setLayout(null);
		escudo.setBounds(10, 11, 126, 104);
		contentPane.add(escudo);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Ventana_Administrador.class.getResource("/escudo_UD.jpeg")));
		lblNewLabel_1.setBounds(10, 11, 106, 82);
		escudo.add(lblNewLabel_1);
		
		JPanel subtitulo = new JPanel();
		subtitulo.setLayout(null);
		subtitulo.setBounds(146, 11, 278, 104);
		contentPane.add(subtitulo);
		
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
		
		JButton btnCargarDeEstudiante = new JButton("Cargar de Estudiante");
		btnCargarDeEstudiante.setActionCommand(Constantes.COMANDO_BTN_VTNA_CARGAR_ESTUDIANTE);
		btnCargarDeEstudiante.addActionListener(control);
		btnCargarDeEstudiante.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCargarDeEstudiante.setBounds(56, 126, 147, 34);
		contentPane.add(btnCargarDeEstudiante);
		
		JButton btnCargarAsignatura_1 = new JButton("Cargar Asignatura");
		btnCargarAsignatura_1.setActionCommand(Constantes.COMANDO_BTN_VTNA_CARGAR_ASIGNATURA);
		btnCargarAsignatura_1.addActionListener(control);
		btnCargarAsignatura_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCargarAsignatura_1.setBounds(229, 126, 147, 34);
		contentPane.add(btnCargarAsignatura_1);
		
		JButton btnListaDeAsignaturas = new JButton("Lista de Asignaturas");
		btnListaDeAsignaturas.setActionCommand(Constantes.COMANDO_BTN_VTNA_LISTA_ASIGNATURAS);
		btnListaDeAsignaturas.addActionListener(control);
		btnListaDeAsignaturas.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnListaDeAsignaturas.setBounds(10, 181, 147, 34);
		contentPane.add(btnListaDeAsignaturas);
		
		JButton btnResultados = new JButton("Resultados de encuesta");
		btnResultados.setActionCommand(Constantes.COMANDO_BTN_VTNA_VER_RESULTADOS_ENCUESTAS);
		btnResultados.addActionListener(control);
		btnResultados.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnResultados.setBounds(56, 238, 147, 34);
		contentPane.add(btnResultados);
		
		JButton btnListaDeEstudiantes = new JButton("Lista de Estudiantes");
		btnListaDeEstudiantes.setActionCommand(Constantes.COMANDO_BTN_VTNA_LISTA_ESTUDIANTES);
		btnListaDeEstudiantes.addActionListener(control);
		btnListaDeEstudiantes.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnListaDeEstudiantes.setBounds(277, 181, 147, 34);
		contentPane.add(btnListaDeEstudiantes);
		
		JButton borrarEncuestas = new JButton("Limpiar Encuestas");
		borrarEncuestas.addActionListener(control);
		borrarEncuestas.setActionCommand(Constantes.COMANDO_LIMPIAR_ENCUESTAS);
		borrarEncuestas.setFont(new Font("Tahoma", Font.PLAIN, 11));
		borrarEncuestas.setBounds(229, 238, 147, 34);
		contentPane.add(borrarEncuestas);
	}
}
