package ventanas;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import datos.Constantes;
import mundo.Asignatura;
import mundo.Ciudad;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;

public class Ventana_Carga_de_estudiantes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtCodigo;
	private JTable tablaAsignaturas;
	private Controlador control;	
	private JTextField txtContrasenia;
		
	/**
	 * Constructor de la clase Ventana_Carga_de_estudiantes
	 */
	public Ventana_Carga_de_estudiantes(Controlador control)
	{
		this.control = control;
		control.setVentanaRegistroEstudiante(this);
		setTitle("Carga de estudiantes");
		setBounds(100, 100, 414, 636);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.NORTH);
		
		JLabel lblNombres = new JLabel("Nombres\r\n");
		lblNombres.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombres.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setHorizontalAlignment(SwingConstants.LEFT);
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblCdigo = new JLabel("C\u00F3digo\r\n");
		lblCdigo.setHorizontalAlignment(SwingConstants.LEFT);
		lblCdigo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblUbicacin = new JLabel("Ciudad");
		lblUbicacin.setHorizontalAlignment(SwingConstants.LEFT);
		lblUbicacin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		
		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		
		JLabel lblAsignatura = new JLabel("Asignatura\r\n");
		lblAsignatura.setHorizontalAlignment(SwingConstants.CENTER);
		lblAsignatura.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnCargarEstudiante = new JButton("Cargar");
		btnCargarEstudiante.setActionCommand(Constantes.COMANDO_BTN_REGISTRAR_ESTUDIANTE);
		btnCargarEstudiante.addActionListener(control);
		btnCargarEstudiante.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtContrasenia = new JTextField();
		txtContrasenia.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setHorizontalAlignment(SwingConstants.LEFT);
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JComboBox comboBox_ciudad = new JComboBox();
		ArrayList<Ciudad> ciudades = control.listarciudades();
		for(int i=0; i < ciudades.size() ; i++) {
			comboBox_ciudad.addItem(ciudades.get(i).getNombre());
		}
		
		JComboBox comboBox_barrio = new JComboBox();
		
		JLabel lblNewLabel = new JLabel("Barrio");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblNombres, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblApellidos, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(txtApellido, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCdigo, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblUbicacin, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblContrasea, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)))
							.addGap(10)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBox_ciudad, 0, 242, Short.MAX_VALUE)
								.addComponent(txtContrasenia, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGap(18)
									.addComponent(lblAsignatura, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 124, Short.MAX_VALUE))
								.addComponent(txtCodigo, GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
								.addComponent(comboBox_barrio, 0, 242, Short.MAX_VALUE))))
					.addGap(31))
				.addGroup(Alignment.LEADING, gl_contentPanel.createSequentialGroup()
					.addGap(25)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 328, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(40, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gl_contentPanel.createSequentialGroup()
					.addGap(133)
					.addComponent(btnCargarEstudiante, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
					.addGap(160))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNombres, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(16)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblApellidos, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtApellido, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCdigo, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtCodigo, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(20)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUbicacin, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_ciudad, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_barrio, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(54)
							.addComponent(lblAsignatura, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblContrasea, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtContrasenia, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))))
					.addGap(11)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnCargarEstudiante, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(27))
		);
		
		tablaAsignaturas = new JTable();
		DefaultTableModel modeloTabla = new DefaultTableModel(
			null,
			new String[] {"Asignatura", "C\u00F3digo", "Adicionar"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		
		ArrayList<Asignatura> lasAsignaturas = control.listarAsignaturas(); 
		
		String registros[] = new String[2];
		for(Asignatura cadaAsignatura : lasAsignaturas)
		{
			Checkbox nuevoCheck = new Checkbox();
			registros[0] = cadaAsignatura.getNombre();
			registros[1] = cadaAsignatura.getCodigo();
			//registros.add(nuevoCheck);
			
			modeloTabla.addRow(registros);
		}
		tablaAsignaturas.setModel(modeloTabla);
		
		TableColumn colmnaCheck = tablaAsignaturas.getColumnModel().getColumn(2);
		colmnaCheck.setCellEditor(tablaAsignaturas.getDefaultEditor(Boolean.class));
		colmnaCheck.setCellRenderer(tablaAsignaturas.getDefaultRenderer(Boolean.class));
		
		scrollPane.setViewportView(tablaAsignaturas);
		
		for(int cadafila = 0; cadafila < tablaAsignaturas.getRowCount(); cadafila++)
		{
			tablaAsignaturas.setValueAt(false, cadafila, 2);
		}
		
		contentPanel.setLayout(gl_contentPanel);
	}
	/**
	 * Metodo que devuelve lo ingresado en el campo nombre
	 * @return String
	 */
	public String getTxtNombre() {
		return txtNombre.getText();
	}
	/**
	 * Metodo que devuelve lo ingresado en el campo apellido
	 * @return String
	 */
	public String getTxtApellido() {
		return txtApellido.getText();
	}
	/**
	 * Metodo que devuelve lo ingresado en el campo codigo
	 * @return String
	 */
	public String getTxtCodigo() {
		return txtCodigo.getText();
	}
	/**
	 * Metodo que devuelve lo ingresado en el campo ubicacion
	 * @return String
	 */
	public String getTxtUbicacion() {
		return null;
	}
	/**
	 * Metodo que devuelve lo ingresado en el campo contraseña
	 * @return String
	 */
	public String getTxtContrasenia() {
		return txtContrasenia.getText();
	}
	
	/**
	 * Metodo que devuelve los codigos de las asignaturas seleccionadas
	 * @return String[]
	 */
	public String[] obtenerAsignaturasSeleccionadas()
	{
		int cantidadMatriculas = 0;
		String[] asignaturasSeleccionadas = null;
		
		for(int cadafila = 0; cadafila < tablaAsignaturas.getRowCount(); cadafila++)
		{
			if(Boolean.parseBoolean(tablaAsignaturas.getValueAt(cadafila, 2).toString()))
				cantidadMatriculas++;
		}
		
		if(cantidadMatriculas > 0)
		{
			int matriculasAsignadas = 0;
			asignaturasSeleccionadas = new String[cantidadMatriculas];
			
			for(int cadafila = 0; cadafila < tablaAsignaturas.getRowCount(); cadafila++)
			{
				if(Boolean.parseBoolean(tablaAsignaturas.getValueAt(cadafila, 2).toString()))
				{
					asignaturasSeleccionadas[matriculasAsignadas] = tablaAsignaturas.getValueAt(cadafila, 1).toString();
					matriculasAsignadas++;
				}
			}
		}
		
		return asignaturasSeleccionadas;
	}
}