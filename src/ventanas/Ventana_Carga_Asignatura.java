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

import datos.Constantes;
import mundo.Asignatura;
import mundo.Matricula;

import java.awt.Font;
import java.util.ArrayList;

public class Ventana_Carga_Asignatura extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tablaAsignaturas;
	private Controlador control;
	/**
	 * Create the dialog.
	 */
	public Ventana_Carga_Asignatura(Controlador control)
	{
		control.setVentanaMatriculaEst(this);
		setBounds(100, 100, 399, 453);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 363, 303);
		contentPanel.add(scrollPane);
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
		
		ArrayList<Matricula> lasMatriculas = control.listarMatriculasPorEstudiante();
		
		for(int cadafila = 0; cadafila < tablaAsignaturas.getRowCount(); cadafila++)
		{
			tablaAsignaturas.setValueAt(false, cadafila, 2);
			for(Matricula cadaMatricula : lasMatriculas)
			{
				if(tablaAsignaturas.getValueAt(cadafila, 1).toString().equals(cadaMatricula.getDe_la_asignatura()))
				{
					tablaAsignaturas.setValueAt(true, cadafila, 2);
				}
			}
		}
		
		JButton btnCargar = new JButton("Cargar");
		btnCargar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCargar.setBounds(126, 350, 135, 34);
		btnCargar.setActionCommand(Constantes.COMANDO_BTN_MATRICULAR_DESDE_ESTUDIANTE);
		btnCargar.addActionListener(control);
		contentPanel.add(btnCargar);
	}
	
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
