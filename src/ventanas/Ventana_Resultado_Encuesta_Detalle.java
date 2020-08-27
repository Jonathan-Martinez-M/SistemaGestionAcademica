package ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Ventana_Resultado_Encuesta_Detalle extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTable table_1;

	/**
	 * Constructor de la clase Ventana_Resultado_Encuesta_Detalle
	 */
	public Ventana_Resultado_Encuesta_Detalle() {
		setTitle("Resultado de la Encuesta");
		setBounds(100, 100, 450, 401);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 54, 414, 110);
			contentPanel.add(scrollPane);
			
			table = new JTable();
			table.setModel(new DefaultTableModel(
				new Object[][] {
					{"1", null, null, null, null},
					{"2", null, null, null, null},
					{"3", null, null, null, null},
					{"4", null, null, null, null},
					{null, null, null, null, null},
				},
				new String[] {
					"/", "Pregunta 1", "Pregunta 2", "Pregunta 3", "Pregunta 4"
				}
			));
			table.getColumnModel().getColumn(0).setPreferredWidth(21);
			scrollPane.setViewportView(table);
		}
		
		JLabel lblNewLabel = new JLabel("Nombre de asignatura - C\u00F3digo");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 23, 182, 24);
		contentPanel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(113, 175, 204, 176);
		contentPanel.add(scrollPane);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
			},
			new String[] {
				"Pregunta 5"
			}
		));
		scrollPane.setViewportView(table_1);
	}

}
