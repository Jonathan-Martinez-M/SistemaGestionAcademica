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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import mundo.Asignatura;

import java.awt.Font;
import java.util.ArrayList;

public class Ventana_Carga_Asignatura extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private Controlador control;
	/**
	 * Create the dialog.
	 */
	public Ventana_Carga_Asignatura(Controlador control)
	{
		setBounds(100, 100, 399, 453);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 11, 363, 303);
			contentPanel.add(scrollPane);
			table = new JTable();
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
			
			table.setModel(modeloTabla);
			
			TableColumn colmnaCheck = table.getColumnModel().getColumn(2);
			colmnaCheck.setCellEditor(table.getDefaultEditor(Boolean.class));
			colmnaCheck.setCellRenderer(table.getDefaultRenderer(Boolean.class));
			
			scrollPane.setViewportView(table);
			
		
		JButton btnCargar = new JButton("Cargar");
		btnCargar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCargar.setBounds(126, 350, 135, 34);
		contentPanel.add(btnCargar);
	}
}
