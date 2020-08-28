package ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datos.Constantes;
import mundo.Ciudad;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class VentanaModificarEstudianteDesdeAdmin extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPasswordField passwordField;
	private JTextField txtApellido;
	private JTextField txtNombre;
	private JTextField txtcodigo;
	private JComboBox comboBox_barrio;
	private JComboBox comboBox_ciudad;
	private String codigoViejo;
	private Controlador control;

	/**
	 * Create the dialog.
	 */
	public VentanaModificarEstudianteDesdeAdmin(Controlador control, String codViejo)
	{
		setTitle("Modificar datos");
		this.control = control;
		this.control.setVentanaModAdmin(this);
		this.codigoViejo = codViejo;
		setBounds(100, 100, 450, 361);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton btnActualizarDatos = new JButton("Actualizar datos");
		btnActualizarDatos.addActionListener(this.control);
		btnActualizarDatos.setActionCommand(Constantes.COMANDO_BTN_MODIFICAR_ESTU_DESDE_ADMIN);
		btnActualizarDatos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnActualizarDatos.setBounds(144, 284, 135, 34);
		contentPanel.add(btnActualizarDatos);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		passwordField.setBounds(183, 218, 242, 30);
		contentPanel.add(passwordField);
		
		JLabel lblColoqueSuContrasea = new JLabel("Ingrese nuevo c\u00F3digo");
		lblColoqueSuContrasea.setHorizontalAlignment(SwingConstants.LEFT);
		lblColoqueSuContrasea.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblColoqueSuContrasea.setBounds(10, 175, 158, 30);
		contentPanel.add(lblColoqueSuContrasea);
		
		JLabel lblIngreseNuevaBarrio = new JLabel("Ingrese nueva barrio");
		lblIngreseNuevaBarrio.setHorizontalAlignment(SwingConstants.LEFT);
		lblIngreseNuevaBarrio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIngreseNuevaBarrio.setBounds(10, 134, 158, 30);
		contentPanel.add(lblIngreseNuevaBarrio);
		
		comboBox_barrio = new JComboBox();
		comboBox_barrio.setBounds(183, 136, 242, 30);
		contentPanel.add(comboBox_barrio);
		
		comboBox_ciudad = new JComboBox();
		comboBox_ciudad.setActionCommand(Constantes.COMANDO_COMBO_CIUDADES_MOD_ADMIN);
		comboBox_ciudad.addActionListener(control);
		comboBox_ciudad.setBounds(183, 95, 242, 30);
		
		ArrayList<Ciudad> ciudades = control.listarCiudades();
		for(int i=0; i < ciudades.size() ; i++) {
			comboBox_ciudad.addItem(ciudades.get(i).getNombre());
		}
		
		contentPanel.add(comboBox_ciudad);
		
		JLabel lblIngreseNuevoUbicacin = new JLabel("Ingrese nueva ciudad");
		lblIngreseNuevoUbicacin.setHorizontalAlignment(SwingConstants.LEFT);
		lblIngreseNuevoUbicacin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIngreseNuevoUbicacin.setBounds(10, 93, 158, 30);
		contentPanel.add(lblIngreseNuevoUbicacin);
		
		JLabel lblIngreseNuevoApellido = new JLabel("Ingrese nuevo apellido");
		lblIngreseNuevoApellido.setHorizontalAlignment(SwingConstants.LEFT);
		lblIngreseNuevoApellido.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIngreseNuevoApellido.setBounds(10, 52, 150, 30);
		contentPanel.add(lblIngreseNuevoApellido);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(183, 54, 242, 30);
		contentPanel.add(txtApellido);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(183, 13, 242, 30);
		contentPanel.add(txtNombre);
		
		JLabel lblIngreseNuevoNombre = new JLabel("Ingrese nuevo nombre");
		lblIngreseNuevoNombre.setHorizontalAlignment(SwingConstants.LEFT);
		lblIngreseNuevoNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIngreseNuevoNombre.setBounds(10, 11, 150, 30);
		contentPanel.add(lblIngreseNuevoNombre);
		
		JLabel lblColoqueSuContrasea_1 = new JLabel("Coloque su contrase\u00F1a");
		lblColoqueSuContrasea_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblColoqueSuContrasea_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblColoqueSuContrasea_1.setBounds(10, 216, 158, 30);
		contentPanel.add(lblColoqueSuContrasea_1);
		
		txtcodigo = new JTextField();
		txtcodigo.setColumns(10);
		txtcodigo.setBounds(183, 177, 242, 30);
		contentPanel.add(txtcodigo);
	}

	public String getPasswordField()
	{
		String contrasenia = "";
		char [] contraseniaEn = passwordField.getPassword();
		for(int cadaCar = 0; cadaCar < contraseniaEn.length; cadaCar++)
		{
			contrasenia += contraseniaEn[cadaCar];
		}
		
		return contrasenia;
	}

	public String getTxtApellido()
	{
		return txtApellido.getText();
	}

	public String getTxtNombre()
	{
		return txtNombre.getText();
	}

	public String getTxtcodigo()
	{
		return txtcodigo.getText();
	}

	public String getComboBox_barrioSelccion()
	{
		return comboBox_barrio.getSelectedItem().toString();
	}

	public String getComboBox_ciudadSelccion()
	{
		return comboBox_ciudad.getSelectedItem().toString();
	}

	public String getCodigoViejo()
	{
		return codigoViejo;
	}
	
	public JComboBox getComboCiudad()
	{
		return comboBox_ciudad;
	}
	
	public JComboBox getComboBarrio()
	{
		return comboBox_barrio;
	}
}
