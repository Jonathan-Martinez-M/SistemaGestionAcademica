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

public class VentanaListaEstudiantes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private Controlador control;

	/**
	 * Constructor de la clase  lista_de_estudiante
	 */
	public VentanaListaEstudiantes(Controlador control)
	{
		this.control = control;
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
			table.setDefaultRenderer(Object.class, new Render());
			table.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mouseClicked(java.awt.event.MouseEvent evt) {
	                tablaMouseClicked(evt);
	            }
	        });
			DefaultTableModel modeloTabla = new DefaultTableModel(null,
					new String[] {
						"Nombres", "C\u00F3digo", "Cambiar datos"
					}
				);
			ArrayList<Estudiante> losEstudiantes = control.listarEstudiantes(); 
			JButton btn_ver = new JButton("Modificar");
			btn_ver.setName("modificar");
			Object registros[] = new Object[3];
			for(Estudiante cadaEstudiante : losEstudiantes)
			{
				//Checkbox nuevoCheck = new Checkbox();
				registros[0] = cadaEstudiante.getNombres();
				registros[1] = cadaEstudiante.getCodigo();
				registros[2] = btn_ver;
				//registros.add(nuevoCheck);
				
				modeloTabla.addRow(registros);
			}
			table.setModel(modeloTabla);
			scrollPane.setViewportView(table);
		}
		contentPanel.setLayout(gl_contentPanel);
	}
	
	int clic_tabla = 0;
	private void tablaMouseClicked(java.awt.event.MouseEvent evt)
	{        
        clic_tabla = this.table.rowAtPoint(evt.getPoint());

        String codigo = table.getValueAt(clic_tabla, 1).toString();
        
        try
        {
			VentanaModificarEstudianteDesdeAdmin dialog = new VentanaModificarEstudianteDesdeAdmin(this.control, codigo);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
