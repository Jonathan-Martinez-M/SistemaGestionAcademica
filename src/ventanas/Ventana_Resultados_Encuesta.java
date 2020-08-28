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
import javax.swing.table.TableColumn;

import ventanas.Render;
import mundo.Asignatura;

public class Ventana_Resultados_Encuesta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tableAsignaturas;
	private Controlador control;

	/**
	 * Constructor de la clase Ventana_Resultados_Encuesta
	 */
	public Ventana_Resultados_Encuesta(Controlador control)
	{
		this.control = control;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 239);
		contentPanel.add(scrollPane);
		
		tableAsignaturas = new JTable();
		tableAsignaturas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
		tableAsignaturas.setDefaultRenderer(Object.class, new Render());
		
		DefaultTableModel modeloTabla = new DefaultTableModel(null,
			new String[] {
					"Código", "Asignatura", "Resultados"
				}
			){
				boolean[] columnEditables = new boolean[] {
					false, false, false 
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			};
		
		ArrayList<Asignatura> lasAsignaturas = control.listarAsignaturas(); 
		JButton btn_ver = new JButton("Ver");
		btn_ver.setName("ver");
		Object registros[] = new Object[3];
		for(Asignatura cadaAsignatura : lasAsignaturas)
		{
			registros[0] = cadaAsignatura.getCodigo();
			registros[1] = cadaAsignatura.getNombre();
			registros[2] = btn_ver;
			//registros.add(nuevoCheck);
			
			modeloTabla.addRow(registros);
		}
		
		tableAsignaturas.setModel(modeloTabla);

		scrollPane.setViewportView(tableAsignaturas);
	}
	
	int clic_tabla = 0;
	
	private void tablaMouseClicked(java.awt.event.MouseEvent evt)
	{        
        clic_tabla = this.tableAsignaturas.rowAtPoint(evt.getPoint());
        
        String codigo = tableAsignaturas.getValueAt(clic_tabla, 0).toString();
        String nombre = tableAsignaturas.getValueAt(clic_tabla, 1).toString();
        
        control.verResultadosEncuestas(codigo);
    }//GEN-LAST:event_tablaMouseClicked

}
