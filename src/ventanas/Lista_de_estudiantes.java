package ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import mundo.Asignatura;
import mundo.Estudiante;

public class Lista_de_estudiantes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;

	/**
	 * Create the dialog.
	 */
	public Lista_de_estudiantes(Controlador control) {
		setTitle("Lista de estudiantes\r\n");
		setBounds(100, 100, 423, 355);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 304, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(22, Short.MAX_VALUE))
		);
		{
			table = new JTable();
			DefaultTableModel modeloTabla = new DefaultTableModel(
					new Object[][] {
						{null, null, null},
					},
					new String[] {
						"Nombres", "C\u00F3digo", "Cambiar datos"
					}
				);
			ArrayList<Estudiante> losEstudiantes = control.listarEstudiantes(); 
			
			String registros[] = new String[2];
			for(Estudiante cadaEstudiante : losEstudiantes)
			{
				//Checkbox nuevoCheck = new Checkbox();
				registros[0] = cadaEstudiante.getNombres();
				registros[1] = cadaEstudiante.getCodigo();
				//registros.add(nuevoCheck);
				
				modeloTabla.addRow(registros);
			}
			table.setModel(modeloTabla);
			scrollPane.setViewportView(table);
		}
		contentPanel.setLayout(gl_contentPanel);
	}

}
