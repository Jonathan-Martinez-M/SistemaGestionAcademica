package ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datos.Constantes;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Ventana_Carga_Asignatura_Admin extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodAsign;
	private JTextField txtNomAsign;
	private Controlador control;

	/**
	 * Constructor de la clase  entana_Carga_Asignatura_Admin
	 */
	public Ventana_Carga_Asignatura_Admin(Controlador control)
	{
		this.control = control;
		control.setVentanaRegistroAsignatura(this);
		setTitle("Carga de asignaturas");
		setBounds(100, 100, 390, 248);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblCod = new JLabel("C\u00F3digo");
		lblCod.setHorizontalAlignment(SwingConstants.LEFT);
		lblCod.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCod.setBounds(30, 43, 100, 30);
		contentPanel.add(lblCod);
		
		JLabel lblContrasea = new JLabel("Nombre Asignatura");
		lblContrasea.setHorizontalAlignment(SwingConstants.LEFT);
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblContrasea.setBounds(30, 93, 125, 30);
		contentPanel.add(lblContrasea);
		
		JButton btnCargaAsign = new JButton("Cargar");
		btnCargaAsign.addActionListener(control);
		btnCargaAsign.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCargaAsign.setActionCommand(Constantes.COMANDO_BTN_REGISTRAR_ASIGNATURA);
		btnCargaAsign.setBounds(135, 164, 100, 34);
		contentPanel.add(btnCargaAsign);
		
		txtCodAsign = new JTextField();
		txtCodAsign.setColumns(10);
		txtCodAsign.setBounds(189, 45, 150, 30);
		contentPanel.add(txtCodAsign);
		
		txtNomAsign = new JTextField();
		txtNomAsign.setColumns(10);
		txtNomAsign.setBounds(189, 93, 150, 30);
		contentPanel.add(txtNomAsign);
	}
	/**
	 * Metodo que devuelve lo escrito en el campos txtCodigo
	 * @return String
	 */
	public String getTxtCodAsign()
	{
		return txtCodAsign.getText();
	}
	/**
	 * Metodo que devuelve lo escrito en el campos txtNombre asignatura
	 * @return String
	 */
	public String getTxtNomAsign() {
		return txtNomAsign.getText();
	}
}
