package ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datos.Constantes;
import mundo.Ciudad;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Ventana_Modificar_Datos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Controlador control;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JPasswordField txtPass;
	private JComboBox comboBox_ciudad;
	private JComboBox comboBox_barrio;

	/**
	 * Constructor de la clase Ventana_Modificar_Datos
	 */
	public Ventana_Modificar_Datos(Controlador control) {
		this.control = control;
		comboBox_barrio = new JComboBox();
		control.setVentanaModificarDatos(this);
		setTitle("Modificar Datos");
		setBounds(100, 100, 450, 368);
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
		
		JLabel lblIngreseNuevoUbicacin = new JLabel("Ingrese nueva ciudad");
		lblIngreseNuevoUbicacin.setHorizontalAlignment(SwingConstants.LEFT);
		lblIngreseNuevoUbicacin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIngreseNuevoUbicacin.setBounds(9, 130, 158, 30);
		contentPanel.add(lblIngreseNuevoUbicacin);
		
		JLabel lblColoqueSuContrasea = new JLabel("Coloque su contrase\u00F1a");
		lblColoqueSuContrasea.setHorizontalAlignment(SwingConstants.LEFT);
		lblColoqueSuContrasea.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblColoqueSuContrasea.setBounds(9, 217, 158, 30);
		contentPanel.add(lblColoqueSuContrasea);
		
		JButton btnActualizarDatos = new JButton("Actualizar datos");
		btnActualizarDatos.setActionCommand(Constantes.COMANDO_BTN_MODIFICACION_DE_DATOS);
		btnActualizarDatos.addActionListener(control);
		btnActualizarDatos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnActualizarDatos.setBounds(133, 274, 135, 34);
		contentPanel.add(btnActualizarDatos);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(182, 23, 242, 30);
		contentPanel.add(txtNombre);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(182, 80, 242, 30);
		contentPanel.add(txtApellido);
		
		txtPass = new JPasswordField();
		txtPass.setColumns(10);
		txtPass.setBounds(182, 219, 242, 30);
		contentPanel.add(txtPass);
		
		JLabel lblIngreseNuevaBarrio = new JLabel("Ingrese nueva barrio");
		lblIngreseNuevaBarrio.setHorizontalAlignment(SwingConstants.LEFT);
		lblIngreseNuevaBarrio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIngreseNuevaBarrio.setBounds(9, 176, 158, 30);
		contentPanel.add(lblIngreseNuevaBarrio);
		
		comboBox_ciudad = new JComboBox();
		comboBox_ciudad.setBounds(182, 130, 242, 30);
		contentPanel.add(comboBox_ciudad);
		comboBox_ciudad.setActionCommand(Constantes.COMANDO_BTN_VTNA_LISTA_CIUDADES_MODIFICAR);
		comboBox_ciudad.addActionListener(control);
		ArrayList<Ciudad> ciudades = control.listarCiudades();
		for(int i=0; i < ciudades.size() ; i++) {
			comboBox_ciudad.addItem(ciudades.get(i).getNombre());
		}
		
		comboBox_barrio = new JComboBox();
		comboBox_barrio.setBounds(182, 176, 242, 30);
		contentPanel.add(comboBox_barrio);
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
	/**
	 * Metodo que devuelve lo ingresado en el campo nombre
	 * @return String
	 */
	public String getTextNombre() {
		return txtNombre.getText();
	}
	/**
	 * Metodo que devuelve lo ingresado en el campo apellido
	 * @return String
	 */
	public String getTextApellido() {
		return txtApellido.getText();
	}
	/**
	 * Metodo que devuelve lo ingresado en el campo ubicacion
	 * @return String
	 */
	public String getTextUbicacion() {
		
		
		return "A";
	}
	
	/*public String getTextBarrio() {
		return "";
	}*/

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
	
	public int getComboBox_ciudad() {
		return comboBox_ciudad.getSelectedIndex();
	}
	
	public JComboBox getComboBox_barrio()
	{
		return comboBox_barrio;
	}
}
