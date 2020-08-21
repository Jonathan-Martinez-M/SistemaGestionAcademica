package ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Ventana_Modificar_Datos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textUbicacion;
	private JPasswordField txtContraseña;

	/**
	 * Create the dialog.
	 */
	public Ventana_Modificar_Datos() {
		setTitle("Modificar Datos");
		setBounds(100, 100, 390, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewNombre = new JLabel("Ingrese nuevo nombre");
		lblNewNombre.setBounds(10, 45, 127, 31);
		contentPanel.add(lblNewNombre);
		{
			JLabel lblNewApellido = new JLabel("Ingrese nuevo apellido");
			lblNewApellido.setBounds(10, 87, 109, 14);
			contentPanel.add(lblNewApellido);
		}
		{
			JLabel lblNewUbicacion = new JLabel("Ingrese nueva ubicaci\u00F3n");
			lblNewUbicacion.setBounds(10, 129, 127, 14);
			contentPanel.add(lblNewUbicacion);
		}
		{
			JLabel lblNewConstraseña = new JLabel("Confirme la contrase\u00F1a");
			lblNewConstraseña.setBounds(10, 169, 127, 14);
			contentPanel.add(lblNewConstraseña);
		}
		
		textNombre = new JTextField();
		textNombre.setBounds(169, 50, 199, 20);
		contentPanel.add(textNombre);
		textNombre.setColumns(10);
		
		textApellido = new JTextField();
		textApellido.setBounds(169, 84, 199, 20);
		contentPanel.add(textApellido);
		textApellido.setColumns(10);
		
		textUbicacion = new JTextField();
		textUbicacion.setBounds(169, 126, 199, 20);
		contentPanel.add(textUbicacion);
		textUbicacion.setColumns(10);
		
		txtContraseña = new JPasswordField();
		txtContraseña.setBounds(169, 166, 199, 20);
		contentPanel.add(txtContraseña);
		
		JButton btnActualizar = new JButton("Actualizar datos");
		btnActualizar.setBounds(117, 217, 118, 23);
		contentPanel.add(btnActualizar);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
}
