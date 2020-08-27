package ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datos.Constantes;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana_Modificar_Datos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Controlador control;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtUbicacion;
	private JTextField txtPass;

	/**
	 * Create the dialog.
	 */
	public Ventana_Modificar_Datos(Controlador control) {
		this.control = control;
		control.setVentanaModificarDatos(this);
		setTitle("Modificar Datos");
		setBounds(100, 100, 450, 347);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblIngreseNuevoNombre = new JLabel("Ingrese nuevo nombre");
		lblIngreseNuevoNombre.setHorizontalAlignment(SwingConstants.LEFT);
		lblIngreseNuevoNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIngreseNuevoNombre.setBounds(9, 21, 150, 30);
		contentPanel.add(lblIngreseNuevoNombre);
		
		JLabel lblIngreseNuevoApellido = new JLabel("Ingrese nuevo apellido");
		lblIngreseNuevoApellido.setHorizontalAlignment(SwingConstants.LEFT);
		lblIngreseNuevoApellido.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIngreseNuevoApellido.setBounds(9, 78, 150, 30);
		contentPanel.add(lblIngreseNuevoApellido);
		
		JLabel lblIngreseNuevoUbicacin = new JLabel("Ingrese nuevo ubicaci\u00F3n");
		lblIngreseNuevoUbicacin.setHorizontalAlignment(SwingConstants.LEFT);
		lblIngreseNuevoUbicacin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIngreseNuevoUbicacin.setBounds(9, 138, 158, 30);
		contentPanel.add(lblIngreseNuevoUbicacin);
		
		JLabel lblColoqueSuContrasea = new JLabel("Coloque su contrase\u00F1a");
		lblColoqueSuContrasea.setHorizontalAlignment(SwingConstants.LEFT);
		lblColoqueSuContrasea.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblColoqueSuContrasea.setBounds(9, 200, 158, 30);
		contentPanel.add(lblColoqueSuContrasea);
		
		JButton btnActualizarDatos = new JButton("Actualizar datos");
		btnActualizarDatos.setActionCommand(Constantes.COMANDO_BTN_MODIFICACION_DE_DATOS);
		btnActualizarDatos.addActionListener(control);
		btnActualizarDatos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnActualizarDatos.setBounds(133, 264, 135, 34);
		contentPanel.add(btnActualizarDatos);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(182, 23, 242, 30);
		contentPanel.add(txtNombre);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(182, 80, 242, 30);
		contentPanel.add(txtApellido);
		
		txtUbicacion = new JTextField();
		txtUbicacion.setColumns(10);
		txtUbicacion.setBounds(182, 140, 242, 30);
		contentPanel.add(txtUbicacion);
		
		txtPass = new JTextField();
		txtPass.setColumns(10);
		txtPass.setBounds(182, 202, 242, 30);
		contentPanel.add(txtPass);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}

	public String getTextNombre() {
		return txtNombre.getText();
	}

	public String getTextApellido() {
		return txtApellido.getText();
	}

	public String getTextUbicacion() {
		return txtUbicacion.getText();
	}
}
