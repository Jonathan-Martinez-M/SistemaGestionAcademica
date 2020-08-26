package ventanas;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import mundo.Asignatura;

public class Ventana_Lista_Asignatura_Admin extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;

	/**
	 * Create the dialog.
	 */
	public Ventana_Lista_Asignatura_Admin(Controlador control)
	{
		setTitle("Lista de asignaturas");
		setBounds(100, 100, 400, 368);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 364, 307);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		DefaultTableModel modeloTabla = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Asignatura", "C\u00F3digo"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
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
		
		table.setModel(modeloTabla);
		scrollPane.setViewportView(table);
	}
}
