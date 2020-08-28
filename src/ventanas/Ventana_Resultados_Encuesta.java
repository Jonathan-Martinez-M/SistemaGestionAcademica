package ventanas;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import mundo.Asignatura;

public class Ventana_Resultados_Encuesta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tableAsignaturas;

	/**
	 * Constructor de la clase Ventana_Resultados_Encuesta
	 */
	public Ventana_Resultados_Encuesta(Controlador control)
	{
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 239);
		contentPanel.add(scrollPane);
		
		tableAsignaturas = new JTable();
		DefaultTableModel modeloTabla = new DefaultTableModel(null,
			new String[] {
					"Asignatura", "Resultados"
				}
			);
		
		ArrayList<Asignatura> lasAsignaturas = control.listarAsignaturas(); 
		
		String registros[] = new String[1];
		for(Asignatura cadaAsignatura : lasAsignaturas)
		{
			registros[0] = cadaAsignatura.getNombre();
			//registros.add(nuevoCheck);
			
			modeloTabla.addRow(registros);
		}
		
		tableAsignaturas.setModel(modeloTabla);
		scrollPane.setViewportView(tableAsignaturas);
	}

}
