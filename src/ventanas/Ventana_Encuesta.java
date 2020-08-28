package ventanas;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultCellEditor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import datos.Constantes;
import mundo.Asignatura;
import mundo.Encuesta;
import mundo.Estudiante;
import mundo.Matricula;

import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Ventana_Encuesta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tablaEncuestas;
	private Controlador control;

	/**
	 * Constructor de la clase Ventana_Encuesta
	 */
	public Ventana_Encuesta(Controlador control)
	{
		this.control = control;
		control.setVentanaEncuestas(this);
		setTitle("Encuesta\r\n");
		setBounds(100, 100, 578, 310);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnEnviar = new JButton("Enviar\r\n");
		btnEnviar.setActionCommand(Constantes.COMANDO_BTN_REGISTRAR_ENCUESTA);
		btnEnviar.addActionListener(control);
		btnEnviar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(8)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(207)
							.addComponent(btnEnviar, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
							.addGap(202))))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
					.addGap(19)
					.addComponent(btnEnviar, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
		);
		
		tablaEncuestas = new JTable();
		
		Encuesta encuestaDummy = control.getEncuestaDummy();
		
		String titulos[] = new String[] {"ID","Asignatura", encuestaDummy.getPreguntas_cuantitativas().get(0), encuestaDummy.getPreguntas_cuantitativas().get(1),
				encuestaDummy.getPreguntas_cuantitativas().get(2), encuestaDummy.getPreguntas_cuantitativas().get(3), encuestaDummy.getPregunta_abierta()};
		
		DefaultTableModel modeloTabla = new DefaultTableModel(null, titulos){
				boolean[] columnEditables = new boolean[] {
					false, false, true, true, true, true, true  
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			};
		ArrayList<Matricula> lasMatriculas = control.listarMatriculasPorEstudiante();
		ArrayList<Asignatura> lasAsignaturasMatriculadas = new ArrayList<Asignatura>();
		
		for(Matricula cadaMatricula : lasMatriculas)
		{
			lasAsignaturasMatriculadas.add(control.buscarAsignaturaCod(cadaMatricula.getDe_la_asignatura()));
		}
		
		String registros[] = new String[2];
		
		int auxiliarAsignEnTAbla = 0;
		for(Asignatura cadaMatricula : lasAsignaturasMatriculadas)
		{
			registros[0] = lasMatriculas.get(auxiliarAsignEnTAbla).getEncuesta().getIdentificador() + "";
			registros[1] = cadaMatricula.getNombre();
			
			modeloTabla.addRow(registros);
			auxiliarAsignEnTAbla++;
		}
		
		tablaEncuestas.setModel(modeloTabla);
		
		JComboBox comboCuantitativo = new JComboBox();
		comboCuantitativo.addItem(1);
		comboCuantitativo.addItem(2);
		comboCuantitativo.addItem(3);
		comboCuantitativo.addItem(4);
		comboCuantitativo.addItem(5);
		
		TableColumn laColumna;
		for(int cadaColumna = 2; cadaColumna < Constantes.CANTIDAD_PREGUNTAS_CUANTITATIVAS + 2; cadaColumna++)
		{
			laColumna = tablaEncuestas.getColumnModel().getColumn(cadaColumna);
			laColumna.setCellEditor(new DefaultCellEditor(comboCuantitativo));
		}
		scrollPane.setViewportView(tablaEncuestas);
		contentPanel.setLayout(gl_contentPanel);
	}
	
	public String[][] obtenerResultadoEncuesta()
	{
		String[][] lasRespuestas = new String[control.listarMatriculasPorEstudiante().size()][6];
		for(int cadaFila = 0; cadaFila < tablaEncuestas.getRowCount(); cadaFila++)
		{
			lasRespuestas[cadaFila][0] = tablaEncuestas.getValueAt(cadaFila, 0).toString();
			//lasRespuestas[cadaFila][1] = tablaEncuestas.getValueAt(cadaFila, 1).toString();
			lasRespuestas[cadaFila][1] = tablaEncuestas.getValueAt(cadaFila, 2).toString();
			lasRespuestas[cadaFila][2] = tablaEncuestas.getValueAt(cadaFila, 3).toString();
			lasRespuestas[cadaFila][3] = tablaEncuestas.getValueAt(cadaFila, 4).toString();
			lasRespuestas[cadaFila][4] = tablaEncuestas.getValueAt(cadaFila, 5).toString();
			lasRespuestas[cadaFila][5] = tablaEncuestas.getValueAt(cadaFila, 6).toString();
		}
		
		return lasRespuestas;
	}
}
