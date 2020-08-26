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
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import datos.Constantes;
import mundo.Asignatura;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class Ventana_Carga_de_estudiantes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtCodigo;
	private JTextField txtUbicacion;
	private JTable tablaAsignaturas;
	private Controlador control;	
	private JTextField txtContrasenia;
		
	/**
	 * Create the dialog.
	 */
	public Ventana_Carga_de_estudiantes(Controlador control)
	{
		this.control = control;
		control.setVentanaRegistroEstudiante(this);
		setTitle("Carga de estudiantes");
		setBounds(100, 100, 414, 581);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblNombres = new JLabel("Nombres\r\n");
		lblNombres.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombres.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setHorizontalAlignment(SwingConstants.LEFT);
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblCdigo = new JLabel("C\u00F3digo\r\n");
		lblCdigo.setHorizontalAlignment(SwingConstants.LEFT);
		lblCdigo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblUbicacin = new JLabel("Ubicaci\u00F3n\r\n");
		lblUbicacin.setHorizontalAlignment(SwingConstants.LEFT);
		lblUbicacin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		
		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		
		txtUbicacion = new JTextField();
		txtUbicacion.setColumns(10);
		
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
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap(10, Short.MAX_VALUE)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 328, GroupLayout.PREFERRED_SIZE)
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
								.addComponent(lblCdigo, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
								.addGap(10)
								.addComponent(txtCodigo, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
									.addComponent(lblUbicacin, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblContrasea, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
								.addGap(10)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
									.addComponent(txtContrasenia, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE)
									.addComponent(txtUbicacion, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE)))))
					.addGap(31))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(149)
					.addComponent(btnCargarEstudiante, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
					.addGap(144))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap(148, Short.MAX_VALUE)
					.addComponent(lblAsignatura, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(145))
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
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblUbicacin, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtUbicacion, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtContrasenia, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblContrasea, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblAsignatura, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnCargarEstudiante, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
		scrollPane.setViewportView(tablaAsignaturas);
		contentPanel.setLayout(gl_contentPanel);
	}
}