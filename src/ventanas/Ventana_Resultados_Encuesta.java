package ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Ventana_Resultados_Encuesta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;

	/**
	 * Constructor de la clase Ventana_Resultados_Encuesta
	 */
	public Ventana_Resultados_Encuesta() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 11, 414, 239);
			contentPanel.add(scrollPane);
			{
				table = new JTable();
				table.setModel(new DefaultTableModel(
					new Object[][] {
						{null, null},
					},
					new String[] {
						"Asignatura", "Resultados"
					}
				));
				scrollPane.setViewportView(table);
			}
		}
	}

}
